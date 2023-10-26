package com.sdk.oms.shopee.dto.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.sdk.oms.shopee.dto.base.AddressBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecipientAddress extends AddressBase {

    public static final long serialVersionUID = 1L;

    /**
     * Recipient's phone number input when order was placed.
     */
    private String phone;

    @JSONField(name = "full_address")
    private String fullAddress;


}
