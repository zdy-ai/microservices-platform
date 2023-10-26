package com.sdk.oms.shopee.model.shopcategory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.ErrorResponse;
import com.sdk.oms.shopee.model.common.ShopCategoryStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ShopCategory extends ErrorResponse implements ModelEntity {


    public static final long serialVersionUID = 1L;
    /**
     * ShopCategory's name.
     */
    private String name;

    /**
     * ShopCategory's sort weight.
     */
    @JsonProperty("sort_weight")
    private Long sortWeight;

    /**
     * ShopCategory's unique identifier.
     */
    @JsonProperty("shop_category_id")
    private Long shopCategoryId;

    /**
     * ShopCategory's status. Applicable values: NORMAL, INACTIVE, DELETED.
     */
    private ShopCategoryStatus status;

}
