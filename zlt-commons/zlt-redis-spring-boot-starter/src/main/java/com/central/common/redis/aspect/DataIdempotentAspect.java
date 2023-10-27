package com.central.common.redis.aspect;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.central.common.exception.BusinessException;
import com.central.common.redis.annotation.DataIdempotent;
import com.central.common.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

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
    private RedissonClient redissonClient;

    private static final ThreadLocal<List<RLock>> LOCK_THREAD = new ThreadLocal<>();

    @Pointcut("@annotation(com.central.common.redis.annotation.DataIdempotent)")
    public void dataPointCut() {
    }

    @Around("dataPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = currentMethod(proceedingJoinPoint);
        //获取到方法的注解对象
        DataIdempotent idempotent = method.getAnnotation(DataIdempotent.class);
        //单位 秒
        long lockTime = idempotent.lockTime();
        long tryTime = idempotent.tryTime();
        String businessType = idempotent.businessType();
        //获取传参
        Object obj = proceedingJoinPoint.getArgs()[0];

        List<Object> objList = new ArrayList<>();
        if (StringUtils.isNotBlank(idempotent.keyIdName())) {
            if (obj instanceof String || obj instanceof Long || obj instanceof Integer) {
                objList.add(String.valueOf(obj));
            } else if (obj instanceof Map) {
                Map map = JSONObject.parseObject(JSONObject.toJSONString(obj), Map.class);
                Object object = map.get(idempotent.keyIdName());
                //单个参数 或 list
                if (object instanceof String || object instanceof Long || object instanceof Integer) {
                    objList.add(String.valueOf(object));
                } else if (object instanceof String[]) {
                    objList = Arrays.asList((String[]) object);
                } else if (object instanceof List) {
                    objList = (List<Object>) object;
                }
            } else if (obj instanceof List) {
                objList = (List<Object>) obj;
            } else if (obj instanceof String[]) {
                objList = Arrays.asList((String[]) obj);
            }
        }
        if (CollectionUtil.isNotEmpty(objList)) {
            List<RLock> rLocks = new ArrayList<>();
            objList.forEach(o -> {
                try {
                    String submitKey = "BUSINESS:" + o + "_" + businessType;
                    log.info("分布式锁上锁，key：{}，lockTime：{}", submitKey, lockTime);
                    RLock clientLock = redissonClient.getLock(submitKey);
                    boolean locked = clientLock.tryLock(tryTime, lockTime, TimeUnit.SECONDS);
                    if (!locked) {
                        log.error("{}上锁失败", submitKey);
                        //存在不能上锁情况时 释放已上锁对象
                        if (CollectionUtil.isNotEmpty(rLocks)) {
                            // 无需判断锁是否存在，直接调用 unlock
                            rLocks.forEach(Lock::unlock);
                        }
                        throw new BusinessException(StrUtil.format("{}上锁失败", submitKey));
                    }
                    clientLock.lock(lockTime, TimeUnit.SECONDS);
                    log.info("分布式锁上锁成功，key：{}，lockTime：{}", submitKey, lockTime);
                    rLocks.add(clientLock);
                } catch (Exception e) {
                    //存在不能上锁情况时 释放已上锁对象
                    if (CollectionUtil.isNotEmpty(rLocks)) {
                        // 无需判断锁是否存在，直接调用 unlock
                        rLocks.forEach(Lock::unlock);
                    }
                    throw new BusinessException("上锁失败");
                }
            });
            if (CollectionUtil.isNotEmpty(rLocks)) {
                LOCK_THREAD.set(rLocks);
            }
        }
        // 调用目标方法
        return proceedingJoinPoint.proceed();
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

    /*** 处理完请求后执行
     *  @param joinPoint 切点
     */
    @AfterReturning(value = "dataPointCut()", returning = "apiResult")
    public void doAfterReturning(JoinPoint joinPoint, Object apiResult) {
        handleData();
    }

    /*** 拦截异常操作
     * ** @param joinPoint 切点
     * * @param e         异常
     * */
    @AfterThrowing(value = "dataPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handleData();
    }

    private void handleData() {
        List<RLock> rLocks = LOCK_THREAD.get();
        if (CollectionUtil.isNotEmpty(rLocks)) {
            try {
                rLocks.forEach(rLock -> {
                    log.info("任务执行完成，当前锁状态：{}", rLock.isLocked());
                    // 无需判断锁是否存在，直接调用 unlock
                    rLock.unlock();
                });
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                LOCK_THREAD.remove();
            }
        }
    }
}
