package com.central.common.redis.aspect;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.central.common.redis.annotation.Idempotent;
import com.central.common.redis.utils.MD5Util;
import com.central.common.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

/**
 * @author zdy
 * @ClassName IdempotentAspect
 * @description: 幂等性功能实现
 * @date 2023年10月25日
 * @version: 1.0
 */
@Slf4j
@Aspect
@Component
public class IdempotentAspect {
    @Resource
    private RedisUtil redisUtil;

    @Pointcut("@annotation(com.central.common.redis.annotation.Idempotent)")
    public void idempotentPointCut() {
    }

    @Around("idempotentPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = currentMethod(proceedingJoinPoint);
        //获取到方法的注解对象
        Idempotent idempotent = method.getAnnotation(Idempotent.class);
        //单位 秒
        long interval = 60;
        if (idempotent.interval() > 0) {
            interval = idempotent.timeUnit().toSeconds(idempotent.interval());
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            request = attributes.getRequest();
        }
        String params = argsToString(proceedingJoinPoint.getArgs());
        String url = null;
        String token = null;
        if (request != null) {
            // 请求地址（作为存放cache的key值）
            url = request.getRequestURI();
            // 用户的唯一标识
            token = request.getHeader("Authorization");
        }
        // 唯一标识（url +  token  + params）
        String submitKey = "INTERFACE:" + MD5Util.toMD5(url + "_" + token + ":" + params);
        boolean flag = false;
        //判断缓存中是否有此key
        if (redisUtil.hasKey(submitKey)) {
            log.info("key={},interval={},重复提交", submitKey, interval);
        } else {
            //如果没有表示不是重复提交并设置key存活的缓存时间
            redisUtil.set(submitKey, "", interval);
            flag = true;
            System.out.println("非重复提交");
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
            throw new Exception("重复提交");
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
