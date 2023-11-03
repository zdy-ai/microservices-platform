package com.central.common.annotation;

import com.central.common.enums.PlatformDictEnum;

import java.lang.annotation.*;

/**
 * 物流商注解
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logistics {
    PlatformDictEnum method();
}
