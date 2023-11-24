package com.erp.sdk.oms.amz.spapi.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 亚马逊SP-API FBA货件查询类型
 * <a href="https://developer-docs.amazon.com/sp-api/docs/fulfillment-inbound-api-v0-reference#querytype-subgroup-2">来源链接</a>
 *
 * @author Jim
 * @date 2023/11/1
 */
@Getter
@AllArgsConstructor
public enum AmazonFbaQueryTypeEnum {

    SHIPMENT("SHIPMENT", "按货件信息查询"),
    DATE_RANGE("DATE_RANGE", "时间范围查询"),
    NEXT_TOKEN("NEXT_TOKEN", "按nextToken查询"),
    ;


    /**
     * 商城编号
     */
    @EnumValue
    @JsonValue
    private final String code;

    /**
     * 名称
     */
    private final String name;

}
