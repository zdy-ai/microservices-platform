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
public class ShopifyGiftCard {

	private String id;
	private String note;
	@JsonProperty("api_client_id")
	private String apiClientId;
	private BigDecimal balance;
	@JsonProperty("created_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createdAt;
	@JsonProperty("initial_value")
	private BigDecimal initialValue;
	private String currency;
	@JsonProperty("customer_id")
	private String customerId;
	private String code;
	@JsonProperty("disabled_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime disabledAt;
	@JsonProperty("expires_on")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime expiresOn;
	@JsonProperty("updated_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updatedAt;
	@JsonProperty("last_characters")
	private String lastCharacters;
	@JsonProperty("line_item_id")
	private String lineItemId;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("template_suffix")
	private String templateSuffix;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}

}
