package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;


import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyGetCustomersRequest {
	private int limit;
	private List<String> ids;
	private String sinceId;
	private String pageInfo;
	private LocalDateTime createdAtMin;
	private LocalDateTime createdAtMax;

	public static interface OptionalsStep {

		OptionalsStep withPageInfo(final String pageInfo);

		OptionalsStep withLimit(int limit);

		OptionalsStep withIds(List<String> ids);

		OptionalsStep withSinceId(String sinceId);

		OptionalsStep withCreatedAtMin(LocalDateTime createdAtMin);

		OptionalsStep withCreatedAtMax(LocalDateTime createdAtMax);

		ShopifyGetCustomersRequest build();
	}


	/**
	 * @return OptionalsStep
	 */
	public static OptionalsStep newBuilder() {
		return new Steps();
	}

	protected ShopifyGetCustomersRequest(final Steps steps) {
		this.limit = steps.limit;
		this.ids = steps.ids;
		this.sinceId = steps.sinceId;
		this.createdAtMin = steps.createdAtMin;
		this.createdAtMax = steps.createdAtMax;
		this.pageInfo = steps.pageInfo;
	}

	protected static class Steps implements OptionalsStep {
		private int limit;
		private String pageInfo;
		private List<String> ids;
		private String sinceId;
		private LocalDateTime createdAtMin;
		private LocalDateTime createdAtMax;

		@Override
		public ShopifyGetCustomersRequest build() {
			return new ShopifyGetCustomersRequest(this);
		}

		@Override
		public OptionalsStep withLimit(final int limit) {
			this.limit = limit;
			return this;
		}

		@Override
		public OptionalsStep withIds(final List<String> ids) {
			this.ids = ids;
			return this;
		}

		@Override
		public OptionalsStep withSinceId(final String sinceId) {
			this.sinceId = sinceId;
			return this;
		}

		@Override
		public OptionalsStep withCreatedAtMin(final LocalDateTime createdAtMin) {
			this.createdAtMin = createdAtMin;
			return this;
		}

		@Override
		public OptionalsStep withCreatedAtMax(final LocalDateTime createdAtMax) {
			this.createdAtMax = createdAtMax;
			return this;
		}

		@Override
		public OptionalsStep withPageInfo(final String pageInfo) {
			this.pageInfo = pageInfo;
			return this;
		}
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
