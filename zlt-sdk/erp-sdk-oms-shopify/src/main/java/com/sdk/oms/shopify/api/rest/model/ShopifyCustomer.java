package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;

import java.math.BigDecimal;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyCustomer {

	private String id;
	private String email;
	@JsonProperty("accepts_marketing")
	private boolean acceptsMarketing;
	@JsonProperty("created_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createdAt;
	@JsonProperty("updated_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updatedAt;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastname;
	private String phone;
	@JsonProperty("orders_count")
	private long ordersCount;
	private String state;
	@JsonProperty("total_spent")
	private BigDecimal totalSpent;
	private String note;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
