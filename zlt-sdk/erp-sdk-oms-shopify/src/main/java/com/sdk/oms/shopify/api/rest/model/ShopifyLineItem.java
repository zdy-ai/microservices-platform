package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyLineItem {

	private String id;
	@JsonProperty("variant_id")
	private String variantId;
	private String title;
	private Long quantity;
	private BigDecimal price;
	private Long grams;
	private String sku;
	@JsonProperty("variant_title")
	private String variantTitle;
	private String vendor;
	@JsonProperty("product_id")
	private String productId;
	@JsonProperty("requires_shipping")
	private boolean requiresShipping;
	private boolean taxable;
	@JsonProperty("gift_card")
	private boolean giftCard;
	private String name;
	@JsonProperty("variant_inventory_management")
	private String variantInventoryManagement;
	@JsonProperty("fulfillable_quantity")
	private Long fulfillableQuantity;
	@JsonProperty("total_discount")
	private BigDecimal totalDiscount;
	@JsonProperty("fulfillment_status")
	private String fulfillmentStatus;
	@JsonProperty("fulfillment_service")
	private String fulfillmentService;
	@JsonProperty("tax_lines")
	private List<ShopifyTaxLine> taxLines = new LinkedList<>();


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
