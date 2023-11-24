package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShopifyMerchandRequest {

	public enum Kind {
		FULFILLMENT_REQUEST("fulfillment_request"),
		CANCELLATION_REQUEST("cancellation_request"),
		LEGACY_FULFILL_REQUEST("legacy_fulfill_request");

		static final String NO_MATCHING_ENUMS_ERROR_MESSAGE = "No matching enum found for status: %s";
		private final String value;

		private Kind(final String value) {
			this.value = value;
		}

		public static Kind toEnum(final String value) {
			if (FULFILLMENT_REQUEST.toString().equals(value)) {
				return Kind.FULFILLMENT_REQUEST;
			} else if (CANCELLATION_REQUEST.toString().equals(value)) {
				return Kind.CANCELLATION_REQUEST;
			} else if (LEGACY_FULFILL_REQUEST.toString().equals(value)) {
				return Kind.LEGACY_FULFILL_REQUEST;
			}

			throw new IllegalArgumentException(String.format(NO_MATCHING_ENUMS_ERROR_MESSAGE, value));
		}

		@Override
		public String toString() {
			return value;
		}
	}

	private String message;
	@JsonProperty("request_options")
	private String requestOptions;
	private String kind;

}
