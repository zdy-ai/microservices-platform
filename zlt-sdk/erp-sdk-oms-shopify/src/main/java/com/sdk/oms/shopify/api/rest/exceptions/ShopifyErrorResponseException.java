package com.sdk.oms.shopify.api.rest.exceptions;

import com.sdk.oms.shopify.api.rest.mappers.ResponseEntityToStringMapper;
import lombok.Getter;

import javax.ws.rs.core.Response;
import java.util.List;

@Getter
public class ShopifyErrorResponseException extends RuntimeException {

	static final String MESSAGE = "Received unexpected Response Status Code of %d\nResponse Headers of:\n%s\nResponse Body of:\n%s";
	/**
	 * -- GETTER --
	 *
	 * @return int
	 */
	private final int statusCode;
	private static final long serialVersionUID = 5646635633348617058L;
	/**
	 * -- GETTER --
	 *
	 * @return String
	 */
	private final String responseBody;
	/**
	 * -- GETTER --
	 *
	 * @return List<ShopifyErrorCode>
	 */
	private final List<ShopifyErrorCode> shopifyErrorCodes;

	public ShopifyErrorResponseException(final Response response) {
		super(buildMessage(response));
		this.responseBody = ResponseEntityToStringMapper.map(response);
		this.shopifyErrorCodes = ShopifyErrorCodeFactory.create(responseBody);
		this.statusCode = response.getStatus();
	}


	/**
	 * @param response
	 * @return String
	 */
	private static String buildMessage(final Response response) {
		final String readEntity = ResponseEntityToStringMapper.map(response);
		return String.format(MESSAGE, response.getStatus(), response.getStringHeaders(), readEntity);
	}


}
