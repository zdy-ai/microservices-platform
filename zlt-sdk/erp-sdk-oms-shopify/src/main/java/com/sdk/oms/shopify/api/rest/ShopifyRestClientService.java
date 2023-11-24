package com.sdk.oms.shopify.api.rest;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*
 * This class is a Spring Service component which generates Shopify REST client instances with the given shop name and access token, using the API
 * version configured in shopify.api.rest.version property.
 */
@Slf4j
@Service
@Data
public class ShopifyRestClientService {

    /**
     * Shopify接口版本：默认2023-07
     */
    @Value("${shopify.api.rest.version:2023-07}")
    private String apiVersion;


    /**
     * @return ShopifyRestClient
     */
    public ShopifyRestClient getShopifyRestClient(final String shopName, final String accessToken) {
        log.debug("getShopifyRestClient called with shopName: {}", shopName);
        log.debug("getShopifyRestClient called with accessToken: {}", accessToken);
        return ShopifyRestClient.newBuilder().withSubdomain(shopName).withAccessToken(accessToken).withApiVersion(apiVersion).build();
    }

}
