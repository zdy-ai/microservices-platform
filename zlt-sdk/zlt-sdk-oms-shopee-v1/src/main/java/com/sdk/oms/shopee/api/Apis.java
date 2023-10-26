package com.sdk.oms.shopee.api;

import com.sdk.oms.shopee.api.domain.*;
import com.sdk.oms.shopee.core.api.APIProvider;
import com.sdk.oms.shopee.service.provider.DefaultAPIProvider;
import org.springframework.stereotype.Component;

/**
 * Provides access to the APIs and Buildables
 */
@Component
//@Configuration
public class Apis {


    private static final APIProvider provider = new DefaultAPIProvider();

    /**
     * Gets the API implementation based on Type
     *
     * @param <T> the API type
     * @param api the API implementation
     * @return the API implementation
     */
    public static <T> T get(Class<T> api) {
        return provider.get(api);
    }

    /**
     * @return orders META-INF
     */
    public static ShopService getShopService() {

        return get(ShopService.class);
    }

    /**
     * @return shop category META-INF
     */
    public static ShopCategoryService shopCategoryService() {
        return get(ShopCategoryService.class);
    }

    /**
     * Get Item Service
     *
     * @return item META-INF
     */
    public static ItemService itemService() {
        return get(ItemService.class);
    }

    /**
     * Get Image Service
     *
     * @return image META-INF
     */
    public static ImageService imageService() {
        return get(ImageService.class);
    }

    /**
     * Get Discount Service
     *
     * @return discount META-INF
     */
    public static DiscountService discountService() {
        return get(DiscountService.class);
    }

    /**
     * Get Order Service
     *
     * @return Order META-INF
     */
    public static OrderService orderService() {
        return get(OrderService.class);
    }

    /**
     * Get Logistics Service
     *
     * @return Logistics META-INF
     */
    public static LogisticsService logisticsService() {
        return get(LogisticsService.class);
    }

    /**
     * Get Returns Service
     *
     * @return Returns META-INF
     */
    public static ReturnsService returnsService() {
        return get(ReturnsService.class);
    }

    /**
     * Initialize API Provider
     *
     * @return api providers in path
     */
//    @PostConstruct
//    private static APIProvider initializeProvider() {
//        // No need to check for emptiness as there is default implementation registered
//        APIProvider p = ServiceLoader.load(APIProvider.class, Apis.class.getClassLoader()).iterator().next();
//        p.initialize();
//        return p;
//    }
}
