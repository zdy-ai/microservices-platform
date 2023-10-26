package com.sdk.oms.shopee.service;

import com.sdk.oms.shopee.dto.base.ShopeeAuth;
import com.sdk.oms.shopee.dto.base.ShopeeTokenAuth;
import com.sdk.oms.shopee.dto.base.request.AuthRequest;
import com.sdk.oms.shopee.utils.ShopeeApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static com.sdk.oms.shopee.constants.ShopeeConstants.*;

/**
 * @author zdy
 * @ClassName ShopeeAuthService
 * @description: 授权接口
 * @date 2023年10月20日
 * @version: 1.0
 */
@Component
@Slf4j
public class ShopeeAuthService {

    public static void main(String[] args) {
        ShopeeAuthService shopeeAuthService = new ShopeeAuthService();
        AuthRequest authRequest = AuthRequest.builder()
                .host(host)
                .refreshToken(shop_refresh_token)
                .partnerId(partner_id)
                .tmpPartnerKey(tmp_partner_key)
                .shopId(shop_id)
                .build();
        shopeeAuthService.refreshShopToken(authRequest);
//        shopeeAuthService.refreshMerchantToken(host,merchant_refresh_token,partner_id,tmp_partner_key, merchant_id);

    }

    public String getCodeUrl(AuthRequest authRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        String path = "/api/v2/shop/auth_partner";
        paramMap.put("partner_id", authRequest.getPartnerId());
        paramMap.put("timestamp", System.currentTimeMillis() / 1000L);
        paramMap.put("sign", ShopeeApiUtils.getPublicSign(path, authRequest.getPartnerId(), authRequest.getTmpPartnerKey()));
        paramMap.put("redirect", authRequest.getRedirect());
        return ShopeeApiUtils.buildUrl(authRequest.getHost() + path, paramMap);
    }

    /**
     * 获取主账号后，刷新所有店铺refresh_token
     *
     * @param authRequest
     * @return
     */
    public ShopeeAuth getMainAccountToken(AuthRequest authRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        String path = "/api/v2/auth/token/get";
        long timestamp = System.currentTimeMillis() / 1000L;
        paramMap.put("partner_id", authRequest.getPartnerId());
        paramMap.put("timestamp", timestamp);
        paramMap.put("sign", ShopeeApiUtils.getPublicSign(path, authRequest.getPartnerId(), authRequest.getTmpPartnerKey()));
        HashMap<String, Object> bodyParam = new HashMap<>();
        bodyParam.put("code", authRequest.getCode());
        bodyParam.put("main_account_id", authRequest.getMainAccountId());
        bodyParam.put("partner_id", authRequest.getPartnerId());
        return ShopeeApiUtils.sendAuthPost(authRequest.getHost() + path, paramMap, bodyParam);
    }

    /**
     * 获取店铺授权
     *
     * @param authRequest
     * @return
     */
    public ShopeeAuth getShopAccountToken(AuthRequest authRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        String path = "/api/v2/auth/token/get";
        long timestamp = System.currentTimeMillis() / 1000L;
        paramMap.put("partner_id", authRequest.getPartnerId());
        paramMap.put("timestamp", timestamp);
        paramMap.put("sign", ShopeeApiUtils.getPublicSign(path, authRequest.getPartnerId(), authRequest.getTmpPartnerKey()));
        HashMap<String, Object> bodyParam = new HashMap<>();
        bodyParam.put("code", authRequest.getCode());
        bodyParam.put("shop_id", authRequest.getShopId());
        bodyParam.put("partner_id", authRequest.getPartnerId());
        return ShopeeApiUtils.sendAuthPost(authRequest.getHost() + path, paramMap, bodyParam);
    }

    /**
     * 刷新店铺token
     *
     * @param authRequest
     * @return
     */
    public ShopeeTokenAuth refreshShopToken(AuthRequest authRequest) {
        HashMap<String, Object> urlParam = new HashMap<>();
        String path = "/api/v2/auth/access_token/get";
        authRequest.setPath(path);
        urlParam.put("timestamp", new Long(System.currentTimeMillis() / 1000).toString());
        urlParam.put("sign", ShopeeApiUtils.getPublicSign(path, authRequest.getPartnerId(), authRequest.getTmpPartnerKey()));
        urlParam.put("partner_id", authRequest.getPartnerId());
        HashMap<String, Object> bodyParam = new HashMap<>();
        bodyParam.put("refresh_token", authRequest.getRefreshToken());
        bodyParam.put("shop_id", authRequest.getShopId());
        bodyParam.put("partner_id", authRequest.getPartnerId());
        return ShopeeApiUtils.sendRefreshPost(authRequest.getHost() + path, urlParam, bodyParam);
    }

    /**
     * 刷新merchantToken
     *
     * @param authRequest
     * @return
     */
    public ShopeeTokenAuth refreshMerchantToken(AuthRequest authRequest) {
        HashMap<String, Object> urlParam = new HashMap<>();
        String path = "/api/v2/auth/access_token/get";
        urlParam.put("timestamp", new Long(System.currentTimeMillis() / 1000).toString());
        urlParam.put("sign", ShopeeApiUtils.getPublicSign(path, authRequest.getPartnerId(), authRequest.getTmpPartnerKey()));
        urlParam.put("partner_id", authRequest.getPartnerId());
        HashMap<String, Object> bodyParam = new HashMap<>();
        bodyParam.put("refresh_token", authRequest.getRefreshToken());
        bodyParam.put("merchant_id", authRequest.getMerchantId());
        bodyParam.put("partner_id", authRequest.getPartnerId());
        return ShopeeApiUtils.sendRefreshPost(authRequest.getHost() + path, urlParam, bodyParam);
    }
}
