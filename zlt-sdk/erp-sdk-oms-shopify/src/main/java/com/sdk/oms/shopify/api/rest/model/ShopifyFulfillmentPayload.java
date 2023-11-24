package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class ShopifyFulfillmentPayload {

	private String message;
	@JsonProperty("notify_customer")
	private boolean notifyCustomer;
	@JsonProperty("tracking_info")
	private ShopifyTrackingInfo trackingInfo;
	@JsonProperty("line_items_by_fulfillment_order")
	private List<ShopifyLineItemsByFulfillmentOrder> lineItemsByFulfillmentOrder = new LinkedList<>();
	
}
