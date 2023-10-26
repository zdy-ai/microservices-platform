package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class Logistics implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * The identity of logistic channel
     */
    @JSONField(name = "logistic_id")
    private Long id;

    /**
     * The name of logistic channel
     */
    @JSONField(name = "logistic_name")
    private String name;

    /**
     * Whether this logistic channel is enabled on shop level.
     */
    @JSONField(name = "enabled")
    private boolean enabled;

    /**
     * Only needed when logistics fee_type = CUSTOM_PRICE.
     */
    @JSONField(name = "shipping_fee")
    private float shippingFee;

    /**
     * If specify logistic fee_type is SIZE_SELECTION size_id is required.
     */
    @JSONField(name = "size_id")
    private Long sizeId;
    /**
     * when seller chooses this option, the shipping fee of this channel on item will be set to 0. Default value is False.
     */
    @JSONField(name = "is_free")
    private boolean isFree;

    @JSONField(name = "estimated_shipping_fee")
    private float estimatedShippingFee;
}
