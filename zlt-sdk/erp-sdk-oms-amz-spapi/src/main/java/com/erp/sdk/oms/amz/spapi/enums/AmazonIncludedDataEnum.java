package com.erp.sdk.oms.amz.spapi.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 亚马逊SP-API商品其他信息自动
 * <a href="https://developer-docs.amazon.com/sp-api/docs/catalog-items-api-v2022-04-01-reference#includeddata">来源链接</a>
 * @author Jim
 * @date 2023/10/17 10:13
 */
@Getter
@AllArgsConstructor
public enum AmazonIncludedDataEnum {

    ATTRIBUTES("attributes",	"商品属性"),
    DIMENSIONS("dimensions",	"Amazon目录中商品的尺寸"),
    IDENTIFIERS("identifiers",	"与Amazon目录中的商品相关的标识符，如UPC和EAN标识符。"),
    IMAGES("images",	"图片"),
    PRODUCT_TYPES("productTypes",	"产品类型"),
    RELATIONSHIPS("relationships",	"目录商品的关系详细信息"),
    SALES_RANKS("salesRanks",	"商品的销售排名"),
    SUMMARIES("summaries",	"商品的摘要详细信息"),
    // 暂无权限
    VENDOR_DETAILS("vendorDetails",	"商品相关的供应商详细信息"),

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


    /**
     * 获取除供应商以外的信息
     */
    public static List<String> getAllWithoutVendor(){
        return Stream.of(AmazonIncludedDataEnum.values())
                .filter(e-> !VENDOR_DETAILS.equals(e))
                .map(AmazonIncludedDataEnum::getCode)
                .collect(Collectors.toList());
    }
}
