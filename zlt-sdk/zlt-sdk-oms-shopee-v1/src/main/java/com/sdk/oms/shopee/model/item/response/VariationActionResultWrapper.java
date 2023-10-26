package com.sdk.oms.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.ObjectResult;
import lombok.Data;


@Data
public class VariationActionResultWrapper extends ObjectResult<VariationActionResult> {

    private static final long serialVersionUID = 1L;

    /**
     * Result
     */
    @JsonProperty("item")
    private VariationActionResult item;

    @Override
    protected VariationActionResult value() {
        return item;
    }
}
