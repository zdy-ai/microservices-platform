package com.sdk.oms.shopee.service.provider;

import com.google.common.collect.Maps;
import com.sdk.oms.shopee.api.domain.*;
import com.sdk.oms.shopee.core.api.APIProvider;
import com.sdk.oms.shopee.core.api.exceptions.ApiNotFoundException;
import com.sdk.oms.shopee.service.domain.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;


/**
 *
 * Simple API Provider which keeps internally Maps interface implementations as singletons
 *
 */
@Component
public class DefaultAPIProvider implements APIProvider {

    private static final Map<Class<?>, Class<?>> bindings = Maps.newHashMap();
    private static final Map<Class<?>, Object> instances = Maps.newConcurrentMap();

    @PostConstruct
    @Override
    public void initialize() {

        bind(ShopService.class, ShopServiceImpl.class);
        bind(ShopCategoryService.class, ShopCategoryServiceImpl.class);
        bind(ItemService.class, ItemServiceImpl.class);
        bind(ImageService.class, ImageServiceImpl.class);
        bind(DiscountService.class, DiscountServiceImpl.class);
        bind(OrderService.class, OrderServiceImpl.class);
        bind(LogisticsService.class, LogisticsServiceImpl.class);
        bind(ReturnsService.class, ReturnsServiceImpl.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Class<T> api) {
        if (instances.containsKey(api))
            return (T) instances.get(api);

        if (bindings.containsKey(api)) {
            try {
                T impl = (T) bindings.get(api).newInstance();
                instances.put(api, impl);
                return impl;
            } catch (Exception e) {
                throw new ApiNotFoundException("API Not found for: " + api.getName(), e);
            }
        }
        throw new ApiNotFoundException("API Not found for: " + api.getName());
    }

    private void bind(Class<?> api, Class<?> impl) {
        bindings.put(api, impl);
    }
}
