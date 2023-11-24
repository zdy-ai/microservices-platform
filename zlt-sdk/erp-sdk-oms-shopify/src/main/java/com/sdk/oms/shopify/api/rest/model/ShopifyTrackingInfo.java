package com.sdk.oms.shopify.api.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShopifyTrackingInfo {

	private String number;
	private String url;
	private String company;

}
