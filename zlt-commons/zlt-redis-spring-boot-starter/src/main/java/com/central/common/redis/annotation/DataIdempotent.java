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
     * 入参主键id的名称
     */
    String keyIdName() default "";

    /*** 上锁时长，默认设置时间 30秒
     *** @return
     **/
    long lockTime() default 30;

    /***
     * 尝试时间，设置时间内通过自旋一致尝试获取锁，
     * 默认 10秒
     * 通常时间要小于lockTime时间**
     * @return
     * */
    long tryTime() default 10;

    /**
     * 业务类型
     *
     * @return
     */
    String businessType() default "";
}
