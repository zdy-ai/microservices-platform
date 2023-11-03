package com.central.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.central.common.constant.EnumMessage;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 平台类型
 *
 * @Author Cloud
 * @Date 2023/8/28 10:47
 **/
@Getter
@AllArgsConstructor
public enum BusinessTypeEnum implements EnumMessage {
    // 销售订单
    ORDER("order","销售订单", SourceTypeEnum.SO_B2C),
    // TODO 补充来源类型
    REFUND("refund","退款单", null),
    PRODUCT("product","商品", SourceTypeEnum.LISTING_INFO),
    // TODO 补充来源类型
    RETURN("return","退货单", null),
    // TODO 补充来源类型
    DELIVERY("delivery","发货单", null),
    AUTH("auth","授权", null),
    REFRESH_TOKEN("refresh_token","刷新token",null),
    LOGISTICS("logistics","物流",null),
    ;

    @JsonValue
    @EnumValue
    private String code;

    private String name;

    private SourceTypeEnum sourceType;



    public static BusinessTypeEnum getByCode(String code) {
        for (BusinessTypeEnum state : BusinessTypeEnum.values()) {
            if (code.equals(state.getCode())) {
                return state;
            }
        }
        return null;
    }
}
