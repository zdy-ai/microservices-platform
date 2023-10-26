package com.central.common.redis.aspect;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.central.common.redis.annotation.DataIdempotent;
import com.central.common.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author zdy
 * @ClassName IdempotentAspect
 * @description: 数据幂等实现
 * @date 2023年10月25日
 * @version: 1.0
 */
@Slf4j
@Aspect
@Component
public class DataIdempotentAspect {
    @Resource
    private RedisUtil redisUtil;

    @Pointcut("@annotation(com.central.common.redis.annotation.DataIdempotent)")
    public void dataPointCut() {
    }

    @Around("dataPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = currentMethod(proceedingJoinPoint);
        //获取到方法的注解对象
        DataIdempotent idempotent = method.getAnnotation(DataIdempotent.class);
        //单位 秒
        long interval = 60;
        if (idempotent.interval() > 0) {
            interval = idempotent.timeUnit().toSeconds(idempotent.interval());
        }
        String businessType = idempotent.businessType();
        //获取传参
        Object obj = proceedingJoinPoint.getArgs()[0];
        String id = "";
        if (StringUtils.isNotBlank(idempotent.keyIdName())) {
            if (obj instanceof String || obj instanceof Long || obj instanceof Integer) {
                id = String.valueOf(obj);
            } else if (Objects.nonNull(obj)) {
                Map map = JSONObject.parseObject(JSONObject.toJSONString(obj), Map.class);
                id = String.valueOf(map.get(idempotent.keyIdName()));
            }
        }
        String submitKey = "BUSINESS:" + id + "_" + businessType;
        boolean flag = false;
        //判断缓存中是否有此key
        if (redisUtil.hasKey(submitKey)) {
            log.info("key={},interval={},记录占用中", submitKey, interval);
        } else {
            //如果没有表示不是重复提交并设置key存活的缓存时间
            redisUtil.set(submitKey, "", interval);
            flag = true;
            System.out.println("记录未操作");
        }
        if (flag) {
            Object result;
            try {
                result = proceedingJoinPoint.proceed();
            } catch (Throwable e) {
                /*异常通知方法*/
                log.error("异常通知方法>目标方法名{},异常为：{}", method.getName(), e);
                throw e;
            } finally {
                redisUtil.del(submitKey);
            }
            return result;
        } else {
            throw new Exception(StrUtil.format("记录【{}】操作中", id));
        }
    }

    /**
     * 根据切入点获取执行的方法
     */
    private Method currentMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        //获取目标类的所有方法，找到当前要执行的方法
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }

    /**
     * 参数拼装
     */
    private String argsToString(Object[] paramsArray) {
        StringBuilder params = new StringBuilder();
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (!ObjectUtils.isEmpty(o) && !isFilterObject(o)) {
                    try {
                        params.append(JSONObject.toJSONString(o)).append(" ");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return params.toString().trim();
    }

    /**
     * 判断是否是需要过滤的对象
     */
    @SuppressWarnings("rawtypes")
    public boolean isFilterObject(final Object o) {
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            Collection collection = (Collection) o;
            for (Object value : collection) {
                return value instanceof MultipartFile;
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()) {
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse
                || o instanceof BindingResult;
    }
}
