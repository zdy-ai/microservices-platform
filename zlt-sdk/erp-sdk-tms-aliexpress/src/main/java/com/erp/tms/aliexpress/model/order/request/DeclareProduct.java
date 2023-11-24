package com.erp.tms.aliexpress.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName DeclareProduct
 * @description: 产品描述
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class DeclareProduct implements Serializable {
    /**
     * 判断是否属于非液体化妆品
     */
    @JSONField(name = "aneroid_markup")
    private Boolean aneroid_markup;

    /**
     * 是否易碎
     */
    @JSONField(name = "breakable")
    private Boolean breakable;
    /**
     * 类目中文名称
     */
    @JSONField(name = "category_cn_desc")
    private String category_cn_desc;
    /**
     * 类目英文名称
     */
    @JSONField(name = "category_en_desc")
    private String category_en_desc;
    /**
     * 是否包含电池
     */
    @JSONField(name = "contains_battery")
    private Boolean contains_battery;
    /**
     * 海关编码
     */
    @JSONField(name = "hs_code")
    private String hs_code;
    /**
     * 是否纯电池
     */
    @JSONField(name = "only_battery")
    private Boolean only_battery;
    /**
     * 产品申报金额
     */
    @JSONField(name = "product_declare_amount")
    private String product_declare_amount;
    /**
     * 商品ID
     */
    @JSONField(name = "product_id")
    private Long product_id;
    /**
     * 产品数量
     */
    @JSONField(name = "product_num")
    private Integer product_num;
    /**
     * 产品重量
     */
    @JSONField(name = "product_weight")
    private String product_weight;
    /**
     * scItem code
     */
    @JSONField(name = "sc_item_code")
    private String sc_item_code;
    /**
     * scItem id
     */
    @JSONField(name = "sc_item_id")
    private Long sc_item_id;
    /**
     * scItem name
     */
    @JSONField(name = "sc_item_name")
    private String sc_item_name;
    /**
     * sku code
     */
    @JSONField(name = "sku_code")
    private String sku_code;
    /**
     * sku value
     */
    @JSONField(name = "sku_value")
    private String sku_value;

    /**
     *是否特货
     */
    @JSONField(name = "contains_special_goods")
    private Boolean contains_special_goods;

    /**
     *交易子单号
     */
    @JSONField(name = "child_order_id")
    private Long child_order_id;
}
