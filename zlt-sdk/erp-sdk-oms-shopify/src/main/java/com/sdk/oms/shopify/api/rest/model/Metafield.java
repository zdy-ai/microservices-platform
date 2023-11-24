package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeSerializer;
import com.sdk.oms.shopify.api.rest.model.serializer.MetafieldValueTypeDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.MetafieldValueTypeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Data
@NoArgsConstructor
public class Metafield {
	private String id;
	private String key;
	private String value;
	@JsonProperty("value_type")
	@JsonSerialize(using = MetafieldValueTypeSerializer.class)
	@JsonDeserialize(using = MetafieldValueTypeDeserializer.class)
	private MetafieldValueType valueType;
	private String namespace;
	@JsonProperty("owner_id")
	private String ownerId;
	@JsonProperty("owner_resource")
	private String ownerResource;
	@JsonProperty("created_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createdAt;
	@JsonProperty("updated_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updatedAt;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
