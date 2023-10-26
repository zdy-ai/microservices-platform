package com.sdk.oms.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.ObjectResult;
import lombok.Data;


@Data
public class ItemActionResultWrapper extends ObjectResult<ItemUpdateActionResult> {

    private static final long serialVersionUID = 1L;

    /**
     * Result
     */
    @JsonProperty("item")
    private ItemUpdateActionResult item;

    @Override
    protected ItemUpdateActionResult value() {
        return item;
    }
}
