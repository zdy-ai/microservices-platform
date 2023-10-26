package com.sdk.oms.shopee.model.shopcategory.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CategoryItemsAdded extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;

    @JsonProperty("invalid_item_id")
    private List<Long> invalidItemIds;

    /**
     * ShopCategory's unique identifier.
     */
    @JsonProperty("shop_category_id")
    private Long shopCategoryId;

    /**
     * Number of item in the shop category.
     */
    private long count;
}
