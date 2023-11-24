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

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyCustomCollection {

	private String id;
	private String title;
	private String handle;
	private boolean published;

	@JsonProperty("body_html")
	private String bodyHtml;

	@JsonProperty("published_scope")
	private String publishedScope;

	@JsonProperty("sort_order")
	private String sortOrder;

	@JsonProperty("template_suffix")
	private String templateSuffix;

	@JsonProperty("published_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime publishedAt;

	@JsonProperty("updated_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updatedAt;

	@JsonProperty("admin_graphql_api_id")
	private String adminGraphqlApiId;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}

}
