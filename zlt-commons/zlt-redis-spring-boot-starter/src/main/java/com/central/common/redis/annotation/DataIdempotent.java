package com.central.common.redis.annotation;


import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 数据幂等性注解 支持参数标记
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataIdempotent {
    /**
     * 时间单位,默认为秒
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 间隔时间,默认为5秒
     */
    int interval() default 10;
    /**
     * 入参主键id的名称
     */
    String keyIdName() default "";

    /**
     * 业务类型
     *
     * @return
     */
    String businessType() default "";
}
