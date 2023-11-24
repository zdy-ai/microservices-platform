package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.CurrencyDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.CurrencySerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Currency;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyTransaction {

	private String id;
	@JsonProperty("order_id")
	private String orderId;
	private String kind;
	private String gateway;
	@JsonProperty("parent_id")
	private String parentId;
	private String status;
	private String message;
	private BigDecimal amount;
	@JsonSerialize(using = CurrencySerializer.class)
	@JsonDeserialize(using = CurrencyDeserializer.class)
	private Currency currency;
	@JsonProperty("maximum_refundable")
	private BigDecimal maximumRefundable;
	private ShopifyTransactionReceipt receipt;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
