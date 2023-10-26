package com.sdk.oms.shopee.service.domain;

import com.sdk.oms.shopee.api.domain.ShopCategoryService;
import com.sdk.oms.shopee.constants.PathConstants;
import com.sdk.oms.shopee.core.service.BaseRestClientService;
import com.sdk.oms.shopee.model.PaginationBaseRequest;
import com.sdk.oms.shopee.model.shopcategory.ShopCategory;
import com.sdk.oms.shopee.model.shopcategory.request.CategoryItems;
import com.sdk.oms.shopee.model.shopcategory.request.ShopCategoryIdRequest;
import com.sdk.oms.shopee.model.shopcategory.request.ShopCategoryRequest;
import com.sdk.oms.shopee.model.shopcategory.response.CategoryItemId;
import com.sdk.oms.shopee.model.shopcategory.response.CategoryItemsAdded;
import com.sdk.oms.shopee.model.shopcategory.response.ShopCategories;
import com.sdk.oms.shopee.model.shopcategory.response.ShopCategoryIdEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.sdk.oms.shopee.model.shopcategory.response.CategoryItemId.CategoryItemIds;
@Service
public class ShopCategoryServiceImpl extends BaseRestClientService implements ShopCategoryService {

    @Override
    public CategoryItemsAdded addCategoryItems(CategoryItems categoryItems) {
        checkNotNull(categoryItems);
        return post(CategoryItemsAdded.class, uri(PathConstants.SHOP_CATEGORY_ADD_ITEMS_RELATEIVE_PATH)).entity(categoryItems).executeWithErrorResponse();
    }

    @Override
    public List<CategoryItemId> getCategoryItems(ShopCategoryIdRequest shopCategoryRequest) {
        checkNotNull(shopCategoryRequest);
        return post(CategoryItemIds.class, uri(PathConstants.SHOP_CATEGORY_GET_ITEMS_RELATEIVE_PATH)).entity(shopCategoryRequest).executeWithErrorResponse().getList();
    }

    @Override
    public ShopCategoryIdEntity addShopCategory(ShopCategoryRequest shopCategoryRequest) {
        checkNotNull(shopCategoryRequest);
        return post(ShopCategoryIdEntity.class, uri(PathConstants.SHOP_CATEGORY_ADD_RELATEIVE_PATH)).entity(shopCategoryRequest).executeWithErrorResponse();
    }

    @Override
    public ShopCategory updateShopCategory(ShopCategoryRequest shopCategoryRequest) {
        checkNotNull(shopCategoryRequest);
        return post(ShopCategory.class, uri(PathConstants.SHOP_CATEGORY_UPDATE_RELATEIVE_PATH)).entity(shopCategoryRequest).executeWithErrorResponse();
    }

    @Override
    public ShopCategories getShopCategories(PaginationBaseRequest paginationRequest) {
        checkNotNull(paginationRequest);
        return post(ShopCategories.class, uri(PathConstants.SHOP_CATEGORY_GET_RELATEIVE_PATH)).entity(paginationRequest).executeWithErrorResponse();
    }

    @Override
    public ShopCategoryIdEntity deleteShopCategory(ShopCategoryIdRequest shopCategoryRequest) {
        checkNotNull(shopCategoryRequest);
        return post(ShopCategoryIdEntity.class, uri(PathConstants.SHOP_CATEGORY_DELETE_RELATEIVE_PATH)).entity(shopCategoryRequest).executeWithErrorResponse();
    }
}
