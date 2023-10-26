package com.sdk.oms.shopee.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WholeSale implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The min count of this tier wholesale.
     */
    private long min;

    /**
     * The max count of this tier wholesale.
     */
    private long max;

    /**
     * The current price of the wholesale in the listing currency.
     */
    @JsonProperty("unit_price")
    private float unitPrice;
}
