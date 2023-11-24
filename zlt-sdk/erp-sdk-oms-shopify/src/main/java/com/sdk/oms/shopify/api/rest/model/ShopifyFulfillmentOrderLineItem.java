package com.sdk.oms.shopify.api.rest.model;

import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
public class ShopifyFulfillmentOrderLineItem {

	private String id;
	@JsonProperty("shop_id")
	private String shopId;
	@JsonProperty("fulfillment_order_id")
	private String fulfillmentOrderId;
	private long quantity;
	@JsonProperty("line_item_id")
	private String lineItemId;
	@JsonProperty("inventory_item_id")
	private String inventoryItemId;
	@JsonProperty("fulfillable_quantity")
	private long fulfillableQuantity;
	@JsonProperty("variant_id")
	private String variantId;
}
