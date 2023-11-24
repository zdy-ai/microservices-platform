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
public class ShopifyAdjustment {

	private String id;
	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("refund_id")
	private String refundId;
	private BigDecimal amount;
	@JsonProperty("tax_amount")
	private BigDecimal taxAmount;
	private String kind;
	private String reason;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
