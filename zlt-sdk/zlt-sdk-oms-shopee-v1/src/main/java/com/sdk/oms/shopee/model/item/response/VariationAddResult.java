package com.sdk.oms.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.ErrorResponse;
import com.sdk.oms.shopee.model.item.Variation;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString(callSuper = true)
public class VariationAddResult extends ErrorResponse {

	private static final long serialVersionUID = 1L;
    /**
     * Unique identifier for an item.
     */
    @JsonProperty("item_id")
    private Long itemId;

    /**
     * The time when stock of the variation is updated.
     */
    @JsonProperty("modified_time")
    private Long modifiedTime;

    /**
     * The variation list of item
     */
    private List<Variation> variations;

}
