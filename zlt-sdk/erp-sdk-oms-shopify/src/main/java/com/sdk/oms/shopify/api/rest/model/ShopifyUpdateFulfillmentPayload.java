package com.sdk.oms.shopify.api.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
public class ShopifyUpdateFulfillmentPayload {

	private String message;
	@XmlElement(name = "notify_customer")
	private boolean notifyCustomer;
	@XmlElement(name = "tracking_info")
	private ShopifyTrackingInfo trackingInfo;
}
