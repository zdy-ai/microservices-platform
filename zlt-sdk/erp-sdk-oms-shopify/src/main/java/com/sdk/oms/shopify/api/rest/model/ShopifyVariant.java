package com.sdk.oms.shopify.api.rest.model;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyVariant {

	public String id;

	@JsonProperty("product_id")
	public String productId;

	@JsonSerialize(using = EscapedStringSerializer.class)
	public String title;
	public BigDecimal price;
	public String sku;
	public int position;

	@JsonProperty("inventory_policy")
	@JsonSerialize(using = InventoryPolicySerializer.class)
	@JsonDeserialize(using = InventoryPolicyDeserializer.class)
	public InventoryPolicy inventoryPolicy;

	@JsonProperty("compare_at_price")
	public BigDecimal compareAtPrice;
	@JsonProperty("fulfillment_service")
	public String fulfillmentService;
	@JsonProperty("inventory_management")
	public String inventoryManagement;
	@JsonSerialize(using = EscapedStringSerializer.class)
	public String option1;
	@JsonSerialize(using = EscapedStringSerializer.class)
	public String option2;
	@JsonSerialize(using = EscapedStringSerializer.class)
	public String option3;
	@JsonProperty("created_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createdAt;
	@JsonProperty("updated_at")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updatedAt;
	public boolean taxable;
	public String barcode;
	public Long grams;
	@JsonProperty("image_id")
	public String imageId;
	public String weight;
	@JsonProperty("weight_unit")
	public String weightUnit;
	@JsonProperty("inventory_item_id")
	public Object inventoryItemId;
	@JsonProperty("inventory_quantity")
	public Long inventoryQuantity;
	@JsonProperty("old_inventory_quantity")
	public int oldInventoryQuantity;
	@JsonProperty("requires_shipping")
	public boolean requiresShipping;
	@JsonProperty("admin_graphql_api_id")
	public String adminGraphqlApiId;
	public long available;


	/**
	 * @param name
	 * @param value
	 */
	@JsonAnySetter
	public void ignored(String name, Object value) {
		log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
	}


	private static final String OPTION_DESC = "{}:{}\n";

	/**
	 * 检查和获取规则信息
	 */
	public String checkAndGetOptions(List<Option> options) {
		String resultOption= "";
		if (StringUtils.isNotBlank(this.option1)){
			Option option1 = options.stream().findFirst().orElse(null);
			if (null != option1){
				resultOption = resultOption.concat(StrUtil.format(OPTION_DESC, option1.getName(), this.option1));
			}
		}
		if (StringUtils.isNotBlank(this.option2)){
			Option option2 = options.get(1);
			if (null != option2){
				resultOption = resultOption.concat(StrUtil.format(OPTION_DESC, option2.getName(), this.option2));
			}
		}
		if (StringUtils.isNotBlank(this.option3)){
			Option option3 = options.get(2);
			if (null != option3){
				resultOption = resultOption.concat(StrUtil.format(OPTION_DESC, option3.getName(), this.option3));
			}
		}
		return resultOption;
	}

}
