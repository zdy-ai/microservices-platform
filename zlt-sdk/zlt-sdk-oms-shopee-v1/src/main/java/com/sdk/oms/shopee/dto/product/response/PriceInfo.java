package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName PriceInfo
 * @description: If the item has models, price_info will not be returned. Please get the price of each model through the get_model_list api.
 *
 * For SG/MY/BR/MX/PL/ES/AR seller: Sellers can set the price with two decimal place, other regions can only set the price as an integer.
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class PriceInfo implements Serializable {

    private String currency;
    @JSONField(name = "original_price")
    private float originalPrice;
    @JSONField(name = "current_price")
    private float currentPrice;
    @JSONField(name = "inflated_price_of_original_price")
    private float inflatedPriceOfOriginalPrice;
    @JSONField(name = "inflated_price_of_current_price")
    private float inflatedPriceOfCurrentPrice;
    @JSONField(name = "sip_item_price")
    private float sipItemPrice;
    @JSONField(name = "sip_item_price_source")
    private String sipItemPriceSource;
    @JSONField(name = "sip_item_price_currency")
    private String sipItemPriceCurrency;
}
