package com.sdk.tms.disifang.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Address
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class Address implements Serializable {
    /**
     * 名/姓名
     */
    @NotNull(message = "姓名不能为空")
    @JSONField(name = "first_name")
    private String first_name;
    /**
     * 姓
     */
    @JSONField(name = "last_name")
    private String last_name;
    /**
     * 公司名
     */
    @JSONField(name = "company")
    private String company;
    /**
     * 18166668888	电话（必填）
     * 是
     */
    @NotNull(message = "电话不能为空")
    @JSONField(name = "phone")
    private String phone;
    /**
     * 0755-6600888	电话2
     */
    @JSONField(name = "phone2")
    private String phone2;
    /**
     * xxxxxx@4px.com	邮箱
     */
    @JSONField(name = "email")
    private String email;
    /**
     * 邮编
     * 是
     */
    @JSONField(name = "post_code")
    private String post_code;
    /**
     * CN	国家（国际二字码 标准ISO 3166-2 ）
     * 是
     */
    @NotNull(message = "国家不能为空")
    @JSONField(name = "country")
    private String country;

    /**
     * 广东省	州/省
     */
    @JSONField(name = "state")
    private String state;
    /**
     * 深圳市	城市
     * 是
     */
    @NotNull(message = "城市不能为空")
    @JSONField(name = "city")
    private String city;
    /**
     * 南山区	区、县
     */
    @JSONField(name = "district")
    private String district;
    /**
     * 南山街道南山路南山X座1001	街道/详细地址
     * 是
     */
    @NotNull(message = "详细地址不能为空")
    @JSONField(name = "street")
    private String street;
    /**
     * 1001	门牌号
     */
    @JSONField(name = "house_number")
    private String house_number;

    /**
     * 证件信息
     */
    @JSONField(name = "certificate_info")
    private CertificateInfo certificate_info;
}
