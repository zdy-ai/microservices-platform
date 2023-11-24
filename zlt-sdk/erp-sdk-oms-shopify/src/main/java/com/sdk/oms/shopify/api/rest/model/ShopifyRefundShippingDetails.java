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
public class ShopifyRefundShippingDetails {

	private BigDecimal amount;
	private BigDecimal tax;
	@JsonProperty("maximum_refundable")
	private BigDecimal maximumRefundable;
	@JsonProperty("full_refund")
	private boolean fullRefund;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
