package com.sdk.oms.shopee.model.shopcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.ErrorResponse;
import com.sdk.oms.shopee.model.shopcategory.ShopCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ShopCategories extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Returned shop category list
     */
    @JsonProperty("shop_categorys")
    private List<ShopCategory> shopCategories;

    /**
     * This is to indicate whether the shop categorys list is more than one page.
     * If this value is true, you may want to continue to check next page to
     * retrieve the rest of shop categorys.
     */
    private boolean more;
}
