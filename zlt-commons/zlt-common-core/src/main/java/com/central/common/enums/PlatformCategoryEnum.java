package com.central.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.central.common.constant.EnumMessage;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 平台类型
 *
 * @Author Cloud
 * @Date 2023/8/28 10:47
 **/
public enum PlatformCategoryEnum implements EnumMessage {
    // 订单管理系统
    OMS("OMS","订单管理系统"),
    // 运输管理系统
    TMS("TMS","运输管理系统"),
    // 仓库管理系
    WMS("WMS","仓库管理系"),
    THIRD_SYSTEM("third_system","第三方系统");

    @EnumValue
    @JsonValue
    private String code;

    private String name;

    PlatformCategoryEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static PlatformCategoryEnum getByCode(String code) {
        for (PlatformCategoryEnum state : PlatformCategoryEnum.values()) {
            if (code.equals(state.getCode())) {
                return state;
            }
        }
        return null;
    }
}
