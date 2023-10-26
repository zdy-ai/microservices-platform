package com.sdk.oms.shopee.model.shopcategory.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.BaseRequest;
import com.sdk.oms.shopee.model.common.ShopCategoryStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ShopCategoryRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
    /**
     * ShopCategory's name.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    /**
     * ShopCategory's sort weight.
     */
    @JsonProperty("sort_weight")
    private Long sortWeight;

    /**
     * ShopCategory's unique identifier.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("shop_category_id")
    private Long shopCategoryId;

    /**
     * ShopCategory's status. Applicable values: NORMAL, INACTIVE, DELETED.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ShopCategoryStatus status;
}
