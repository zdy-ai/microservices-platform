package com.sdk.oms.shopee.api.domain;

import com.sdk.oms.shopee.core.common.RestService;
import com.sdk.oms.shopee.model.PaginationBaseRequest;
import com.sdk.oms.shopee.model.shopcategory.ShopCategory;
import com.sdk.oms.shopee.model.shopcategory.request.CategoryItems;
import com.sdk.oms.shopee.model.shopcategory.request.ShopCategoryIdRequest;
import com.sdk.oms.shopee.model.shopcategory.request.ShopCategoryRequest;
import com.sdk.oms.shopee.model.shopcategory.response.CategoryItemId;
import com.sdk.oms.shopee.model.shopcategory.response.CategoryItemsAdded;
import com.sdk.oms.shopee.model.shopcategory.response.ShopCategories;
import com.sdk.oms.shopee.model.shopcategory.response.ShopCategoryIdEntity;

import java.util.List;

public interface ShopCategoryService extends RestService {

    /**
     * Add Category Items
     *
     * @param categoryItems category item to add
     * @return category item added result
     */
    CategoryItemsAdded addCategoryItems(CategoryItems categoryItems);

    /**
     * Get Category Item Ids
     *
     * @param shopCategoryRequest shop category request
     * @return retrieved category item ids
     */
    List<CategoryItemId> getCategoryItems(ShopCategoryIdRequest shopCategoryRequest);

    /**
     * Add Shop Category
     *
     * @param shopCategoryRequest shop category request
     * @return shop category id
     */
    ShopCategoryIdEntity addShopCategory(ShopCategoryRequest shopCategoryRequest);

    /**
     * Update Shop Category
     *
     * @param shopCategoryRequest shop category request
     * @return shop category
     */
    ShopCategory updateShopCategory(ShopCategoryRequest shopCategoryRequest);

    /**
     * Get Shop Categories
     *
     * @param paginationRequest request with pagination info
     * @return ShopCategories
     */
    ShopCategories getShopCategories(PaginationBaseRequest paginationRequest);

    /**
     * Delete Shop Category
     *
     * @param shopCategoryRequest shop category request
     * @return ShopCategoryIdEntity
     */
    ShopCategoryIdEntity deleteShopCategory(ShopCategoryIdRequest shopCategoryRequest);


}
