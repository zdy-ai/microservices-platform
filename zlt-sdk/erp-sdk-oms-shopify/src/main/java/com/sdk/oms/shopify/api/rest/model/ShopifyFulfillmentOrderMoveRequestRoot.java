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
public class ShopifyFulfillmentOrderMoveRequestRoot {

	@JsonProperty("fulfillment_order")
	private ShopifyFulfillmentOrderMoveLocationPayload fulfillmentOrder;

}