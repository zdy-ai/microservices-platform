package com.central.common.redis.annotation;


import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 接口幂等性注解
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Idempotent {

    /**
     * 时间单位,默认为秒
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 间隔时间,默认为5秒
     */
    int interval() default 5;
}
