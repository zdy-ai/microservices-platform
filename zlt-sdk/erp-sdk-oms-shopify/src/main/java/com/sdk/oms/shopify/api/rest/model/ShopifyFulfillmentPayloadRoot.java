package com.sdk.oms.shopify.api.rest.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
public class ShopifyFulfillmentPayloadRoot {

	private ShopifyFulfillmentPayload fulfillment;
}
