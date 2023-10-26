package com.sdk.oms.shopee.model.discount.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.ErrorResponse;
import lombok.Data;

@Data
public class DiscountActionResult extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonProperty("discount_id")
    private Long discountId;

    /**
     * The number of items that add successfully.
     */
    private Long count;

    /**
     * The time when discount is updated.
     */
    @JsonProperty("modify_time")
    private Long modifyTime;

}
