package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.EscapedStringSerializer;
import com.sdk.oms.shopify.api.rest.model.serializer.EscapedStringsSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
public class Option {

	public String id;
	@JsonProperty("product_id")
	public String productId;
	@JsonSerialize(using = EscapedStringSerializer.class)
	public String name;
	public int position;
	@JsonSerialize(using = EscapedStringsSerializer.class)
	public List<String> values;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
