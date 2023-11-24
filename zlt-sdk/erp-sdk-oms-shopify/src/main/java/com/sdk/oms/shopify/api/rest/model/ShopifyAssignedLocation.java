package com.sdk.oms.shopify.api.rest.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
public class ShopifyAssignedLocation {

	private String address1;
	private String address2;
	private String city;
	@XmlElement(name = "country_code")
	private String countryCode;
	@XmlElement(name = "location_id")
	private String locationId;
	private String name;
	private String phone;
	private String province;
	private String zip;
}
