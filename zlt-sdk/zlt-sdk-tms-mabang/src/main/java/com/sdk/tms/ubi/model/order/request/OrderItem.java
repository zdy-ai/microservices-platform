package com.sdk.tms.ubi.model.order.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName OrderItem
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 2801814838883246461L;
    //Item编号
    private String itemNo;
    //SKU
    private String sku;
    //英文品名
    //如果值为空，设置成订单级别的description
    //1. 不能包含设置的违禁品关键词
    //2. 必须是英文和法文字符或数字
    private String description;
    //中文品名
    private String nativeDescription;
    //HS Code
    private String hsCode;
    //	国家二字代码，三字代码或名称
    private String originCountry;
    //件数，>0
    private String itemCount;
    //单价，>0
    private Double unitValue;
    //截取前50个字符
    private String warehouseNo;
    //产品链接
    private String productURL;
    //Item重量，转换成KG
    private Double weight;
    //商品用途
    private String use;
    //商品材质
    private String material;
}
