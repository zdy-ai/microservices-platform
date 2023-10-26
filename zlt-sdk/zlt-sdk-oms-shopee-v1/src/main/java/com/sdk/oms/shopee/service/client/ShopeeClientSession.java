package com.sdk.oms.shopee.service.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sdk.oms.shopee.api.Apis;
import com.sdk.oms.shopee.api.Builders;
import com.sdk.oms.shopee.api.ShopeeClient;
import com.sdk.oms.shopee.api.domain.*;
import com.sdk.oms.shopee.core.constants.ClientConstants;
import com.sdk.oms.shopee.core.service.BaseClientSession;
import com.sdk.oms.shopee.core.transport.Config;
import com.sdk.oms.shopee.core.transport.HttpRequest;
import com.sdk.oms.shopee.core.transport.ObjectMapperSingleton;
import com.sdk.oms.shopee.model.BaseRequest;
import com.sdk.oms.shopee.model.common.Credentials;
import com.sdk.oms.shopee.utils.HashingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ShopeeClientSession extends BaseClientSession<ShopeeClientSession, ShopeeClient> implements ShopeeClient {

    private static final Logger log = LoggerFactory.getLogger(ShopeeClientSession.class);

    private Credentials credentials;
    private String endpoint;


    private ShopeeClientSession(String endpoint, Credentials credentials, Config config) {
        this.endpoint = endpoint;
        this.credentials = credentials;
        this.config = config;
        sessions.set(this);
    }

    public static ShopeeClientSession createSession(String endpoint, Credentials credentials, Config config) {
        ShopeeClientSession session = new ShopeeClientSession(endpoint, credentials, config);
        session.header(ClientConstants.HEADER_CONTENT_TYPE, ClientConstants.CONTENT_TYPE_JSON);
        return session;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }

    @Override
    public String getTokenId() {
        return null;
    }

    //https://open.shopee.com/documents?module=63&type=2&id=53
    @Override
    public <T> String getTokenId(HttpRequest<T> httpRequest) {

        String url = httpRequest.getEndpoint() + httpRequest.getPath();
        String requestAsJson = "";
        if (httpRequest.getEntity() != null) {
            try {
                requestAsJson = ObjectMapperSingleton.getContext(this.getClass()).writer().writeValueAsString(httpRequest.getEntity());
            } catch (JsonProcessingException e) {
                log.error("Exception while convert request to JSON: {}", e.toString());
            }
        }
        String authKey = HashingUtils.hmacSHA256Digest(String.format("%s|%s", url, requestAsJson), credentials.getPartnerKey());
        log.debug("signature base string: {}|{}, key: {}, signature:{}", url, requestAsJson, credentials.getPartnerKey(), authKey);
        return authKey;
    }

    @Override
    public String getAuthHeaderName() {
        return ClientConstants.HEADER_AUTHORIZATION;
    }

    @Override
    public BaseRequest baseRequest() {
        return Builders.baseRequest().partnerId(this.credentials.getPartnerId()).shopId(this.credentials.getShopId()).timestamp(System.currentTimeMillis() / 1000).build();
    }

    @Override
    public ShopService shops() {
        return Apis.getShopService();
    }

    @Override
    public ShopCategoryService shopCategory() {
        return Apis.shopCategoryService();
    }

    @Override
    public ItemService item() {
        return Apis.itemService();
    }

    @Override
    public ImageService image() {
        return Apis.imageService();
    }

    @Override
    public DiscountService discount() { return Apis.discountService(); }

    @Override
    public OrderService order() { return Apis.orderService(); }

    @Override
    public LogisticsService logistics() { return Apis.logisticsService(); }

    @Override
    public ReturnsService returns() {
        return Apis.returnsService();
    }
}
