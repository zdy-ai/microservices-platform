package com.sdk.oms.shopee.api;

import com.sdk.oms.shopee.api.domain.*;
import com.sdk.oms.shopee.core.api.AbstractRestClient;
import com.sdk.oms.shopee.model.BaseRequest;


/**
 *
 * Shopee Client to expose all operations
 *
 */
public interface ShopeeClient extends AbstractRestClient<ShopeeClient> {

	/**
	 * Get Base Request That required by all requests
	 * 
	 * @return base request
	 */
	BaseRequest baseRequest();
    /**
     * Shops Service API
     *
     * @return Shop META-INF
     */
    ShopService shops();

	/**
	 * Shop Category
	 *
	 * @return shop category META-INF
	 */
	ShopCategoryService shopCategory();

	/**
	 * Shop Item
	 *
	 * @return shop item META-INF
	 */
	ItemService item();

	/**
	 * Image
	 *
	 * @return image META-INF
	 */
	ImageService image();

    /**
     * Discount
     *
     * @return discount META-INF
     */
	DiscountService discount();

    /**
     * Order
     *
     * @return order META-INF
     */
	OrderService order();

	/**
	 * Logistics
	 *
	 * @return Logistics META-INF
	 */
	LogisticsService logistics();

    /**
     * Returns
     *
     * @return returns META-INF
     */
	ReturnsService returns();
}
