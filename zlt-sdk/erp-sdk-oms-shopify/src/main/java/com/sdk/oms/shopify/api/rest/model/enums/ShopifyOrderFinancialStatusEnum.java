package com.sdk.oms.shopify.api.rest.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author Jim
 */
@Getter
@AllArgsConstructor
public enum ShopifyOrderFinancialStatusEnum {

    AUTHORIZED("authorized", "Show only authorized orders"),
    PENDING("pending", "Show only pending orders"),
    PAID("paid", "Show only paid orders"),
    PARTIALLY_PAID("partially_paid", "Show only partially paid orders"),
    REFUNDED("refunded", "Show only refunded orders"),
    VOIDED("voided", "Show only voided orders"),
    PARTIALLY_REFUNDED("partially_refunded", "Show only partially refunded orders"),
    ANY("any", "Show orders of any financial status."),
    UNPAID("unpaid", "Show authorized and partially paid orders."),
    ;
    /**
     * 类型
     */
    @EnumValue
    @JsonValue
    private final String code;

    /**
     * 名称
     */
    private final String name;

    /**
     * 通过code查询
     */
    public static ShopifyOrderFinancialStatusEnum getByCode(String code){
        return Arrays.stream(ShopifyOrderFinancialStatusEnum.values())
                .filter(e-> e.code.equals(code))
                .findFirst().orElse(null);
    }

}
