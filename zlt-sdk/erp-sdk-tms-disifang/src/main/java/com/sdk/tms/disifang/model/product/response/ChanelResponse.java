package com.sdk.tms.disifang.model.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ChanelResponse
 * @description: 	物流产品
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class ChanelResponse implements Serializable {
    /**
     * 物流产品代码
     */
    @JSONField(name = "logistics_product_code")
    private String logistics_product_code;
    /**
     * 物流产品中文名称
     */
    @JSONField(name = "logistics_product_name_cn")
    private String logistics_product_name_cn;
    /**
     * 物流产品英文名称
     */
    @JSONField(name = "logistics_product_name_en")
    private String logistics_product_name_en;
    /**
     * 运输方式：2 国际快递；3 国际小包；4 专线；5 联邮通；6 其他；
     */
    @JSONField(name = "transport_mode")
    private String transport_mode;
    /**
     * 起运地-国家二字码。此查询条件暂不可用
     */
    @JSONField(name = "source_country_code")
    private String source_country_code;
    /**
     * 是否可带电（Y：可带电；N：不可带电）
     */
    @JSONField(name = "with_battery")
    private String with_battery;
    /**
     * 是否可跟踪（Y：可跟踪；N：不可跟踪）
     */
    @JSONField(name = "order_track")
    private String order_track;
    /**
     * 体积重参与计费（Y：参加；N：不参与）
     */
    @JSONField(name = "billing_volume_weight")
    private String billing_volume_weight;
    /**
     * 是否是平邮（Y：平邮；N：非平邮）
     */
    @JSONField(name = "surface_mail")
    private String surface_mail;
}
