package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShopifyDestination {

	private String id;
	private String address1;
	private String address2;
	private String city;
	private String company;
	private String country;
	private String email;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	private String phone;
	private String province;
	private String zip;
}
