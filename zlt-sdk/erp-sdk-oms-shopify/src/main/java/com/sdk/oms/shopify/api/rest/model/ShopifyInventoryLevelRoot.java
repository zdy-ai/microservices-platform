package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShopifyInventoryLevelRoot {

	@JsonProperty("inventory_level")
	private ShopifyInventoryLevel inventoryLevel;

}
