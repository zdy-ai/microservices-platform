package com.sdk.oms.shopee.dto.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
public class RecipientAddress implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * Recipient's name for the address.
     */
    private String name;
    /**
     * Recipient's phone number input when order was placed.
     */
    private String phone;
    private String town;
    private String district;
    private String city;
    private String state;
    private String region;
    private String zipcode;

    @JSONField(name = "full_address")
    private String fullAddress;


}
