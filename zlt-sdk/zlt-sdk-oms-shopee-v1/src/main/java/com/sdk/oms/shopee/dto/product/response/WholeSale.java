package com.sdk.oms.shopee.dto.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WholeSale implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * The min count of this tier wholesale.
     */
    @JsonProperty("min_count")
    private int min;

    /**
     * The max count of this tier wholesale.
     */
    @JsonProperty("max_count")
    private int max;

    /**
     * The current price of the wholesale in the listing currency.
     */
    @JsonProperty("unit_price")
    private float unitPrice;
    /**
     * The current price of the wholesale in the listing currency.
     */
    @JsonProperty("inflated_price_of_unit_price")
    private float inflatedPriceOfUnitPrice;
}
