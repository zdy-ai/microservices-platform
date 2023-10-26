package com.sdk.oms.shopee.service.domain;

import com.central.common.utils.OkHttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zdy
 * @ClassName GlobalProductServiceImpl
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Component
@Slf4j
public class ProductServiceImpl {
    static String host = "https://openplatform.shopee.cn";
    static long partner_id = 2006582;
    static long shop_id = 497438607;
    static long main_account_id = 863141;
    static long merchant_id = 1315427;
    static String code = "596d704f61436b46785a4c494b686363";
    static String tmp_partner_key = "436568524178574244445975595377664f574e6b536d786b7256744158715974";
    static String access_token = "757a4644475556494d4d6c706870594a";
    static String refresh_token = "4e776c4e494949424e464d664379436c";
    static String shop_refresh_token = "76664c79667351544b754a7a7a775646";
    static String shop_access_token = "754962484b67424e4973754466786366";
    static String merchant_access_token = "666a465647424a544e694c7043564a6e";
    static String merchant_refresh_token = "58424b515850524b7562476965644f44";
    public static void main(String[] args) {
        String host = "https://partner.test-stable.shopeemobile.com";
        String path = "/api/v2/product/get_item_list";
        long partner_id = 1070627;
        String tmp_partner_key ="5975757847654870727869546f436e696f4b454d466a74586f46696555466348";
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.getProductList(host,path, partner_id, tmp_partner_key);

    }


    public String getProductList(String host, String path,long partner_id, String tmp_partner_key){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("timestamp", new Long(System.currentTimeMillis() / 1000).toString());
        paramMap.put("sign",getPublicSign(path, partner_id,tmp_partner_key));
        paramMap.put("shop_id",94070);
        paramMap.put("partner_id",partner_id);
        paramMap.put("access_token","474d6b4b6675586b4a5762616e756b63");
        paramMap.put("offset",0);
        paramMap.put("page_size",10);
        paramMap.put("update_time_from",1611311600);
        paramMap.put("update_time_to",1611311631);
        paramMap.put("item_status","NORMAL");
        String s = sendGet(host+path, paramMap);
        System.out.println(s);
        return s;
    }

    private static String buildUrl(String apiUrl, String... params) {
        StringBuilder urlBuilder = new StringBuilder(apiUrl);
        for (String param : params) {
            if (urlBuilder.toString().endsWith("&")){}
            urlBuilder.append("&").append(param);
        }
        return urlBuilder.toString();
    }
    /**
     * GET 请求
     *
     * @param baseUrl
     * @param paramMap
     * @return
     */
    public String sendGet(String baseUrl, HashMap<String, Object> paramMap) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Connection", "keep-alive");
        String bodyStr = OkHttpUtils.doGet(baseUrl, paramMap, headers);
        return bodyStr;
    }

    /**
     * 发送请求到沃尔玛获取令牌token
     *
     * @param baseUrl 接口地址
     * @param params
     * @return java.lang.String
     */
    public String sendPost(String baseUrl, Map<String, Object> params) {
        String consumerId = UUID.randomUUID().toString();
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        String bodyStr = OkHttpUtils.doPost(baseUrl, params, headers);
        return bodyStr;
    }

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
        System.out.println(sign);
        System.out.println(timest);
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

}
