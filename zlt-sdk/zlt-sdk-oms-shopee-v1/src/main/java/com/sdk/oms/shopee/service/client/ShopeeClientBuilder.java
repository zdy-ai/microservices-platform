package com.sdk.oms.shopee.service.client;


import com.sdk.oms.shopee.api.IShopeeClientBuilder;
import com.sdk.oms.shopee.api.ShopeeClient;
import com.sdk.oms.shopee.core.api.exceptions.AuthenticationException;
import com.sdk.oms.shopee.core.service.BaseRestClientBuilder;
import com.sdk.oms.shopee.model.common.Credentials;

/**
 * Builder to create a client
 *
 */
public class ShopeeClientBuilder extends BaseRestClientBuilder<ShopeeClient, IShopeeClientBuilder> implements IShopeeClientBuilder {

    private long partnerId;
    private String partnerKey;
    private long shopId;

    @Override
    public IShopeeClientBuilder partnerId(long partnerId) {
        this.partnerId = partnerId;
        return this;
    }

    @Override
    public IShopeeClientBuilder partnerKey(String key) {
        this.partnerKey = key;
        return this;
    }

    @Override
    public IShopeeClientBuilder shopId(long shopId) {
        this.shopId = shopId;
        return this;
    }

    @Override
    public ShopeeClient authenticate() throws AuthenticationException {
        return ShopeeClientSession.createSession(endpoint, new Credentials(partnerId, partnerKey, shopId), config);
    }
}
