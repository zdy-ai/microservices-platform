package com.sdk.oms.shopee.service.client;

import com.sdk.oms.shopee.api.IShopeeClientBuilder;
import com.sdk.oms.shopee.api.ShopeeClient;
import com.sdk.oms.shopee.core.transport.Config;

/**
 * Factory Helper class to instantiate new ShopeeClient
 */
public class ShopeeClientFactory {
	//Default Endpoint
    private static final String DEFAULT_ENDPOINT = "https://partner.shopeemobile.com";
    
    /**
     * Get Client Builder to instantiate client
     *
     * @return Builder
     */
    public static IShopeeClientBuilder builder() {
        return new ShopeeClientBuilder();
    }
    
    /**
     * Get New Client with merchantId & token
     *
     * @param partnerId  partnerId
     * @param partnerKey partnerKey
     * @return client
     */
    public static ShopeeClient newClient(long partnerId, String partnerKey) {
        return newClient(partnerId, partnerKey, null, DEFAULT_ENDPOINT);
    }
    
    /**
     * Get New Client with merchantId & token
     *
     * @param partnerId  partnerId
     * @param partnerKey partnerKey
     * @param shopId	 shopId
     * @return client
     */
    public static ShopeeClient newClient(long partnerId, String partnerKey, Long shopId) {
        return newClient(partnerId, partnerKey, shopId, DEFAULT_ENDPOINT);
    }

    /**
     * Get New Client with partnerId, partnerKey, shopId & endpoint, this should be
     * the most common way to instantiate a client
     *
     * @param partnerId  partnerId
     * @param partnerKey partnerKey
     * @param shopId	 shopId
     * @param endpoint   endpoint
     * @return client
     */
    public static ShopeeClient newClient(long partnerId, String partnerKey, Long shopId, String endpoint) {
        return newClient(partnerId, partnerKey, shopId, endpoint, Config.DEFAULT);
    }

    /**
     * Get New Client with partnerId, partnerKey, shopId, endpoint and customized config
     *
     * @param partnerId  partnerId
     * @param partnerKey partnerKey
     * @param shopId	 shopId
     * @param endpoint   endpoint
     * @param config     config
     * @return client
     */
    public static ShopeeClient newClient(long partnerId, String partnerKey, Long shopId, String endpoint, Config config) {

        return builder().partnerId(partnerId)
                .partnerKey(partnerKey)
                .shopId(shopId)
                .endpoint(endpoint)
                .withConfig(config)
                .authenticate();
    }

}
