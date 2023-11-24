package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName PickUpInfo
 * @description: 揽收地址信息
 * @date 2023年11月02日
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PickUpInfo implements Serializable {
    /**
     *联系人名称
     * 是
     */
    @JSONField(name = "name")
    private String name;
    /**
     *联系人电话
     * 是
     */
    @JSONField(name = "phone")
    private String phone;
    /**
     *联系人国家
     * 是
     */
    @JSONField(name = "country")
    private String country;
    /**
     *联系人省
     * 是
     */
    @JSONField(name = "province")
    private String province;
    /**
     *联系人城市
     * 是
     */
    @JSONField(name = "city")
    private String city;
    /**
     *联系人区
     * 是
     */
    @JSONField(name = "district")
    private String district;
    /**
     *街道
     */
    @JSONField(name = "street")
    private String street;
    /**
     *详细地址
     * 是
     */
    @JSONField(name = "detail_address")
    private String detailAddress;
    /**
     *联系人邮编
     * 否
     */
    @JSONField(name = "zip_code")
    private String zipCode;
}
