package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyShippingLine {

	private String id;
	private String title;
	private BigDecimal price;
	private String code;
	private String source;


	public BigDecimal getPrice() {
		if (null == price){
			return BigDecimal.ZERO;
		}
		return price;
	}

	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}
}
