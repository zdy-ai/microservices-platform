package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class ShopifyLineItemsByFulfillmentOrder {

	@JsonProperty("fulfillment_order_id")
	private String fulfillmentOrderId;
	@JsonProperty("fulfillment_order_line_items")
	private List<ShopifyFulfillmentOrderPayloadLineItem> fulfillmentOrderLineItems = new LinkedList<>();


}
