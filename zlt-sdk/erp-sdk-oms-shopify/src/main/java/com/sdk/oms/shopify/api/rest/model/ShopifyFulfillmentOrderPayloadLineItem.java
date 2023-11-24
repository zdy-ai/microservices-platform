package com.sdk.oms.shopify.api.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopifyFulfillmentOrderPayloadLineItem {
	private String id;
	private long quantity;


}