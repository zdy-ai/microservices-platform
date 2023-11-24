package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zdy
 * @ClassName InsuranceInfo
 * @description: 保险信息（投保时必须填写）
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class InsuranceInfo implements Serializable {
    /**
     * 保险类型（XY:4PX保价；XP:第三方保险） 5Y, 5元每票 8Y, 8元每票 6P, 0.6%保费
     */
    @JSONField(name = "insure_type")
    private String insure_type;
    /**
     * 保险价值
     */
    @JSONField(name = "insure_value")
    private BigDecimal insure_value;
    /**
     * 保险币别（按照ISO标准，目前只支持USD）
     */
    @JSONField(name = "currency")
    private String currency;
    /**
     * 投保人/公司
     */
    @JSONField(name = "insure_person")
    private String insure_person;
    /**
     * 投保人证件类型（暂时只支持身份证，类型为：ID）
     */
    @JSONField(name = "certificate_type")
    private String certificate_type;
    /**
     * 投保人证件号码
     */
    @JSONField(name = "certificate_no")
    private String certificate_no;
    /**
     * 保险类目ID（保险的类目，暂时不填，默认取第一个类目）
     */
    @JSONField(name = "category_code")
    private String category_code;
    /**
     * 投保货物名称
     */
    @JSONField(name = "insure_product_name")
    private String insure_product_name;
    /**
     * 投保包装及数量
     */
    @JSONField(name = "package_qty")
    private String package_qty;
}
