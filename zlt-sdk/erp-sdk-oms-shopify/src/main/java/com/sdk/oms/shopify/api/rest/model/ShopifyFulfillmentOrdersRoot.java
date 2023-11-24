package com.sdk.oms.shopify.api.rest.model;

import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class ShopifyFulfillmentOrdersRoot {

	@JsonProperty("fulfillment_orders")
	private List<ShopifyFulfillmentOrder> fulfillmentOrders = new LinkedList<>();

}
