package com.central.common.annotation;


import com.central.common.enums.PlatformCategoryEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 平台类型注解
 *
 * @Author Cloud
 * @Date 2023/8/28 10:44
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PlatformCategoryType {
    PlatformCategoryEnum value();
}
