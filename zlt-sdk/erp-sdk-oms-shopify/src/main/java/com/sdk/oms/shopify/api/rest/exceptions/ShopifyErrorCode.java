package com.sdk.oms.shopify.api.rest.exceptions;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ShopifyErrorCode implements Serializable {

	private static final long serialVersionUID = -3870975240510101019L;

	public enum Type {
		SHIPPING_ADDRESS, UNKNOWN
	}

	/**
	 * -- GETTER --
	 *
	 * @return Type
	 */
	private final Type type;
	/**
	 * -- GETTER --
	 *
	 * @return String
	 */
	private final String message;

	public ShopifyErrorCode(final Type type, final String message) {
		this.type = type;
		this.message = message;
	}


}
