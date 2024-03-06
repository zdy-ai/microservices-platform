package com.central.common.annotation;


import com.central.common.enums.PannoEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Panno {
    PannoEnum[] findType() default {PannoEnum.EQ};

    String field() default "";
}

