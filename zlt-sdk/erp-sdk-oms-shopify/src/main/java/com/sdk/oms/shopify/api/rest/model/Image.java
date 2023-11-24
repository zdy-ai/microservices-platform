package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.EscapedStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
public class Image {
	private String id;
	@JsonProperty("product_id")
	private String productId;
	@JsonSerialize(using = EscapedStringSerializer.class)
	private String name;
	private int position;
	@JsonProperty("src")
	private String source;
	@JsonProperty("variant_ids")
	private List<String> variantIds = new LinkedList<>();
	private List<Metafield> metafields = new LinkedList<>();


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
