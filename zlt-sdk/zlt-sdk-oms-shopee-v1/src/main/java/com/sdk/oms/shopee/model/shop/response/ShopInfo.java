package com.sdk.oms.shopee.model.shop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.common.Country;
import com.sdk.oms.shopee.model.shop.ShopInfoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopInfo extends ShopInfoBase {

    private static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a shop.
     */
    @JsonProperty("shop_id")
    private long shopId;

    /**
     * The two-digit code representing the country where the order was made.
     */
    private Country country;

    /**
     * Listing limitation of item for the shop.
     */
    @JsonProperty("item_limit")
    private long itemLimit;
}
