package com.sdk.tms.shopee.utils;

import com.alibaba.fastjson.JSONObject;
import com.central.common.utils.OkHttpUtils;
import com.sdk.tms.shopee.model.base.BaseResponse;
import com.sdk.tms.shopee.model.base.ShopeeAuth;
import com.sdk.tms.shopee.model.base.ShopeeTokenAuth;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName ShopeeBaseService
 * @description: TODO
 * @date 2023年10月20日
 * @version: 1.0
 */
@Slf4j
public class ShopeeApiUtils {


    public static String getPublicSign(String path, long partner_id, String tmp_partner_key) {
        long timest = System.currentTimeMillis() / 1000L;
        String tmp_base_string = String.format("%s%s%s", partner_id, path, timest);
        byte[] partner_key;
        byte[] base_string;
        String sign = "";
        try {
            base_string = tmp_base_string.getBytes("UTF-8");
            partner_key = tmp_partner_key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partner_key, "HmacSHA256");
            mac.init(secret_key);
            sign = String.format("%064x", new BigInteger(1, mac.doFinal(base_string)));
            System.out.println(sign);
            System.out.println(timest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }

    public static String getOrderSign(String path, String access_token, long partner_id, String tmp_partner_key, long shop_id) {
        long timest = System.currentTimeMillis() / 1000L;
        String tmp_base_string = String.format("%s%s%s%s%s", partner_id, path, timest, access_token, shop_id);
        byte[] partner_key;
        byte[] base_string;
        String sign = null;
        try {
            base_string = tmp_base_string.getBytes("UTF-8");
            partner_key = tmp_partner_key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partner_key, "HmacSHA256");
            mac.init(secret_key);
            sign = String.format("%064x", new BigInteger(1, mac.doFinal(base_string)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("sign:" + sign);
        System.out.println("timest:" + timest);
        return sign;
    }

    public static String getMerchantSign(String path, String access_token, long partner_id, String tmp_partner_key, long merchant_id) {
        long timest = System.currentTimeMillis() / 1000L;
        String tmp_base_string = String.format("%s%s%s%s%s", partner_id, path, timest, access_token, merchant_id);
        byte[] partner_key;
        byte[] base_string;
        String sign = null;
        try {
            base_string = tmp_base_string.getBytes("UTF-8");
            partner_key = tmp_partner_key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partner_key, "HmacSHA256");
            mac.init(secret_key);
            sign = String.format("%064x", new BigInteger(1, mac.doFinal(base_string)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sign);
        System.out.println(timest);
        return sign;
    }

    /**
     * GET 请求
     *
     * @param baseUrl
     * @param paramMap
     * @return
     */
    public static BaseResponse sendGet(String baseUrl, HashMap<String, Object> paramMap) {
        BaseResponse resultMap = null;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Connection", "keep-alive");
        System.out.println("baseUrl:" + baseUrl);
        try {
            String bodyStr = OkHttpUtils.doGet(baseUrl, paramMap, headers);
            System.out.println("bodyStr:" + bodyStr);
            resultMap = JSONObject.parseObject(bodyStr, BaseResponse.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return resultMap;
    }

    /**
     * 发送请求到沃尔玛获取令牌token
     *
     * @param baseUrl 接口地址
     * @param params
     * @return java.lang.String
     */
    public static ShopeeAuth sendAuthPost(String baseUrl, Map<String, Object> urlParams, Map<String, Object> params) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        String url = buildUrl(baseUrl, urlParams);
        System.out.println("url:" + url);
        String bodyStr = OkHttpUtils.doPostJson(url, params, headers);
        System.out.println("bodyStr:" + bodyStr);
        ShopeeAuth resultMap = JSONObject.parseObject(bodyStr, ShopeeAuth.class);
        return resultMap;
    }

    /**
     * 发送请求到沃尔玛获取令牌token
     *
     * @param baseUrl 接口地址
     * @param params
     * @return java.lang.String
     */
    public static BaseResponse sendPost(String baseUrl, Map<String, Object> urlParams, Map<String, Object> params) {
        BaseResponse resultMap = null;
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        String url = buildUrl(baseUrl, urlParams);
        System.out.println("url:" + url);

        try {
            String bodyStr = OkHttpUtils.doPostJson(url, params, headers);
            System.out.println("bodyStr:" + bodyStr);
            resultMap = JSONObject.parseObject(bodyStr, BaseResponse.class);
        } catch (Exception e) {
            log.error("请求异常：{}", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 发送请求到沃尔玛获取令牌token
     *
     * @param baseUrl 接口地址
     * @param params
     * @return java.lang.String
     */
    public static ShopeeTokenAuth sendRefreshPost(String baseUrl, Map<String, Object> urlParams, Map<String, Object> params) {
        ShopeeTokenAuth resultMap = null;
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        String url = buildUrl(baseUrl, urlParams);
        System.out.println("url:" + url);
        try {
            String bodyStr = OkHttpUtils.doPostJson(url, params, headers);
            System.out.println("bodyStr:" + bodyStr);
            resultMap = JSONObject.parseObject(bodyStr, ShopeeTokenAuth.class);
        } catch (Exception e) {
            log.error("请求异常：{}", e.getMessage());
        }

        return resultMap;
    }

    public static String buildUrl(String url, Map<String, Object> urlParams) {
        StringBuilder urlBuilder = new StringBuilder(url);
        if (urlParams != null && urlParams.size() > 0) {
            int i = 1;
            for (Map.Entry<String, Object> entry : urlParams.entrySet()) {
                if (1 == i) {
                    urlBuilder.append("?" + entry.getKey() + "=" + entry.getValue());
                    i += 1;
                } else {
                    urlBuilder.append("&" + entry.getKey() + "=" + entry.getValue());
                }

            }
        }
        return urlBuilder.toString();
    }
}
