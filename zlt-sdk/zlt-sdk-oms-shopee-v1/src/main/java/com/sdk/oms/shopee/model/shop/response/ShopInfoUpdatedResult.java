package com.sdk.oms.shopee.model.shop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.common.Country;
import com.sdk.oms.shopee.model.common.ResponseError;
import com.sdk.oms.shopee.model.shop.ShopInfoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopInfoUpdatedResult extends ShopInfoBase {

	private static final long serialVersionUID = 1L;
	
    private String msg;

    private ResponseError error;

    /**
     * Shopee's unique identifier for a shop.
     */
    @JsonProperty("shopid")
    private long shopId;

    /**
     * Warning message if parts of image/video uploads failed.
     */
    private String warning;

    /**
     * The two-digit code representing the country where the order was made.
     */
    private Country country;

}
