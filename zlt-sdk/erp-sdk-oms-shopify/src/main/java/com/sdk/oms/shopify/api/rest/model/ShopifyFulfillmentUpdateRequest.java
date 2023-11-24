package com.sdk.oms.shopify.api.rest.model;

import lombok.Getter;

import java.util.List;

@Getter
public class ShopifyFulfillmentUpdateRequest {

	/**
	 * -- GETTER --
	 *
	 * @return ShopifyFulfillment
	 */
	private final ShopifyFulfillment request;

	public static interface CurrentShopifyFulfillmentStep {
		public TrackingCompanyStep withCurrentShopifyFulfillment(final ShopifyFulfillment shopifyFulfillment);
	}

	public static interface TrackingCompanyStep {
		TrackingNumberStep withTrackingCompany(final String trackingCompany);
	}

	public static interface TrackingNumberStep {
		NotifyCustomerStep withTrackingNumber(final String trackingNumber);
	}

	public static interface NotifyCustomerStep {
		LineItemsStep withNotifyCustomer(final boolean notifyCustomer);
	}

	public static interface LineItemsStep {
		LocationIdStep withLineItems(final List<ShopifyLineItem> lineItems);
	}

	public static interface LocationIdStep {
		TrackingUrlsStep withLocationId(final String locationId);
	}

	public static interface TrackingUrlsStep {
		BuildStep withTrackingUrls(final List<String> trackingUrls);
	}

	public static interface BuildStep {
		ShopifyFulfillmentUpdateRequest build();
	}


	/**
	 * @return CurrentShopifyFulfillmentStep
	 */
	public static CurrentShopifyFulfillmentStep newBuilder() {
		return new Steps();
	}


	private ShopifyFulfillmentUpdateRequest(final ShopifyFulfillment request) {
		this.request = request;
	}

	private static class Steps implements CurrentShopifyFulfillmentStep, TrackingCompanyStep, TrackingNumberStep, NotifyCustomerStep, LineItemsStep,
			LocationIdStep, TrackingUrlsStep, BuildStep {

		private ShopifyFulfillment request;

		@Override
		public ShopifyFulfillmentUpdateRequest build() {
			return new ShopifyFulfillmentUpdateRequest(request);
		}

		@Override
		public LocationIdStep withLineItems(final List<ShopifyLineItem> lineItems) {
			request.setLineItems(lineItems);
			return this;
		}

		@Override
		public NotifyCustomerStep withTrackingNumber(final String trackingNumber) {
			request.setTrackingNumber(trackingNumber);
			return this;
		}

		@Override
		public TrackingNumberStep withTrackingCompany(final String trackingCompany) {
			request.setTrackingCompany(trackingCompany);
			return this;
		}

		@Override
		public TrackingCompanyStep withCurrentShopifyFulfillment(final ShopifyFulfillment shopifyFulfillment) {
			request = shopifyFulfillment;
			return this;
		}

		@Override
		public LineItemsStep withNotifyCustomer(final boolean notifyCustomer) {
			request.setNotifyCustomer(notifyCustomer);
			return this;
		}

		@Override
		public TrackingUrlsStep withLocationId(final String locationId) {
			request.setLocationId(locationId);
			return this;
		}

		@Override
		public BuildStep withTrackingUrls(final List<String> trackingUrls) {
			request.setTrackingUrls(trackingUrls);
			return this;
		}

	}

}
