package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyRefundLineItem {

	private String id;
	private long quantity;
	@JsonProperty("line_item_id")
	private String lineItemId;
	@JsonProperty("location_id")
	private String locationId;
	@JsonProperty("restock_type")
	private String restockType;
	private BigDecimal subtotal;
	@JsonProperty("total_tax")
	private BigDecimal totalTax;
	@JsonProperty("line_item")
	private ShopifyLineItem lineItem;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
