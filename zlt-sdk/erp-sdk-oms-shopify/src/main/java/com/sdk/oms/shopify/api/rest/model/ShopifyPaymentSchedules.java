package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyPaymentSchedules {

	private String amount;
	private String currency;
	@JsonProperty("issued_at")
	private LocalDateTime issued_at;
	@JsonProperty("due_at")
	private LocalDateTime dueAt;
	@JsonProperty("completed_at")
	private LocalDateTime completedAt;
	@JsonProperty("expected_payment_method")
	private String expectedPaymentMethod;

	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
