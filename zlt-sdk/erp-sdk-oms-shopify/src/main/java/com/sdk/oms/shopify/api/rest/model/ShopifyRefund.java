package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.CurrencyDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.CurrencySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;

import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyRefund {

	private String id;
	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("created_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createdAt;
	private String note;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("processed_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime processedAt;
	@JsonProperty("refund_line_items")
	private List<ShopifyRefundLineItem> refundLineItems;
	private ShopifyRefundShippingDetails shipping;
	private List<ShopifyTransaction> transactions = new LinkedList<>();
	@JsonProperty("order_adjustments")
	private List<ShopifyAdjustment> adjustments = new LinkedList<>();
	@JsonSerialize(using = CurrencySerializer.class)
	@JsonDeserialize(using = CurrencyDeserializer.class)
	private Currency currency;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
