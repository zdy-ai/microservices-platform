package com.sdk.oms.shopee.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdk.oms.shopee.constants.ShopeeConstants;
import org.springframework.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName ShopeeUtils
 * @description: TODO
 * @date 2023年10月18日
 * @version: 1.0
 */
//@Component
public class ShopeeUtils {
    public static void main(String[] args) throws ParseException, IOException {

//        shop_auth();
//        get_token_shop_level(ShopeeConstants.code, ShopeeConstants.partner_id, ShopeeConstants.tmp_partner_key, ShopeeConstants.shop_id);
//        get_token_account_level(ShopeeConstants.code, ShopeeConstants.partner_id, ShopeeConstants.tmp_partner_key, ShopeeConstants.main_account_id);
//        get_global_item_list(ShopeeConstants.access_token, ShopeeConstants.partner_id, ShopeeConstants.tmp_partner_key, ShopeeConstants.merchant_id, ShopeeConstants.offset, ShopeeConstants.page_size);
//        get_order_list(ShopeeConstants.access_token, ShopeeConstants.partner_id, ShopeeConstants.tmp_partner_key, ShopeeConstants.shop_id, ShopeeConstants.offset, ShopeeConstants.page_size);
        refresh_access_token(ShopeeConstants.refresh_token, ShopeeConstants.partner_id, ShopeeConstants.shop_id, null);
    }

    //generate auth url
    public static void shop_auth() {
        long timest = System.currentTimeMillis() / 1000L;
//        String host = "https://partner.shopeemobile.com";
        String path = "/api/v2/shop/auth_partner";
//        String redirect_url = "https://www.baidu.com/";
//        long partner_id = 123456L;
        String tmp_base_string = String.format("%s%s%s", ShopeeConstants.partner_id, path, timest);
        byte[] partner_key;
        byte[] base_string;
        String sign = "";
        try {
            base_string = tmp_base_string.getBytes("UTF-8");
            partner_key = ShopeeConstants.tmp_partner_key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partner_key, "HmacSHA256");
            mac.init(secret_key);
            sign = String.format("%064x", new BigInteger(1, mac.doFinal(base_string)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = ShopeeConstants.host + path + String.format("?partner_id=%s&timestamp=%s&sign=%s&redirect=%s", ShopeeConstants.partner_id, timest, sign, ShopeeConstants.redirect_url);
        System.out.println("url: " + url);
    }

    //shop request for access token for the first time
    public static String[] get_token_shop_level(String code, long partner_id, String tmp_partner_key, long shop_id) throws ParseException, IOException {
        String[] res = new String[2];
        long timest = System.currentTimeMillis() / 1000L;
//        String host = "https://partner.shopeemobile.com";
        String path = "/api/v2/auth/token/get";
        String tmp_base_string = String.format("%s%s%s", partner_id, path, timest);
        byte[] partner_key;
        byte[] base_string;
        BigInteger sign = null;
        String result = "";
        try {
            base_string = tmp_base_string.getBytes("UTF-8");
            partner_key = tmp_partner_key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partner_key, "HmacSHA256");
            mac.init(secret_key);
            sign = new BigInteger(1, mac.doFinal(base_string));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tmp_url = ShopeeConstants.host + path + String.format("?partner_id=%s&timestamp=%s&sign=%s", partner_id, timest, String.format("%032x", sign));
        URL url = new URL(tmp_url);
        HttpURLConnection conn = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/4.76");
            Map<String, Object> map = new HashMap<>();
            map.put("code", code);
            map.put("shop_id", shop_id);
            map.put("partner_id", partner_id);
            String json = JSON.toJSONString(map);
            conn.connect();
            out = new PrintWriter(conn.getOutputStream());
            out.print(json);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject);
            res[0] = (String) jsonObject.get("access_token");
            res[1] = (String) jsonObject.get("refresh_token");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return res;
    }

    private String getBaseStr(long partner_id, String path, long timest) {
        String tmp_base_string = String.format("%s%s%s", partner_id, path, timest);
        return tmp_base_string;
    }

    //main account request for the access token for the first time
    public static String[] get_token_account_level(String code, long partner_id, String tmp_partner_key, long main_account_id) throws ParseException, IOException {
        String[] res = new String[2];
        long timest = System.currentTimeMillis() / 1000L;
//        String host = "https://partner.test.shopeemobile.com";
        String path = "/api/v2/auth/token/get";
        String tmp_base_string = String.format("%s%s%s", partner_id, path, timest);
        byte[] partner_key;
        byte[] base_string;
        BigInteger sign = null;
        String result = "";
        try {
            base_string = tmp_base_string.getBytes("UTF-8");
            partner_key = tmp_partner_key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partner_key, "HmacSHA256");
            mac.init(secret_key);
            sign = new BigInteger(1, mac.doFinal(base_string));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tmp_url = ShopeeConstants.host + path + String.format("?partner_id=%s&timestamp=%s&sign=%s", partner_id, timest, String.format("%032x", sign));
        URL url = new URL(tmp_url);
        HttpURLConnection conn = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            Map<String, Object> map = new HashMap<>();
            map.put("code", code);
            map.put("main_account_id", main_account_id);
            map.put("partner_id", partner_id);
            String json = JSON.toJSONString(map);
            conn.connect();
            out = new PrintWriter(conn.getOutputStream());
            out.print(json);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject);
            res[0] = (String) jsonObject.get("access_token");
            res[1] = (String) jsonObject.get("refresh_token");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
//        {"access_token":"7a586452756a4a4c7278524c514b6861","refresh_token":"754f566563717459656e656d634c5754","merchant_id_list":[],"shop_id_list":[497438607,497435491,497440222,497437542,954277234,954280155,954283475],"expire_in":14200,"error":"","message":"","request_id":"a434457dae5b0fddcfe061901af12021"}
        return res;
    }

    ///api/v2/global_product/get_global_item_list
    public static String[] get_global_item_list(String access_token, long partner_id, String tmp_partner_key, long merchant_id,
                                                String offset, int page_size) throws ParseException, IOException {
        String[] res = new String[2];
        long timest = System.currentTimeMillis() / 1000L;
        Long update_time_from = System.currentTimeMillis() - (3600 * 24);
        Long update_time_to = System.currentTimeMillis();
//        String host = "https://partner.test.shopeemobile.com";
        String path = "/api/v2/global_product/get_global_item_list";
        String tmp_base_string = String.format("%s%s%s%s%s", partner_id, path, timest, access_token, merchant_id);
        byte[] partner_key;
        byte[] base_string;
        BigInteger sign = null;
        String result = "";
        try {
            base_string = tmp_base_string.getBytes("UTF-8");
            partner_key = tmp_partner_key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partner_key, "HmacSHA256");
            mac.init(secret_key);
            sign = new BigInteger(1, mac.doFinal(base_string));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tmp_url = ShopeeConstants.host + path + String.format("?partner_id=%s&timestamp=%s&sign=%s&merchant_id=%s&access_token=%s&offset=%s&page_size=%s&update_time_from=%s&update_time_to=%s",
                partner_id, timest, String.format("%032x", sign), merchant_id, access_token, offset, page_size, update_time_from, update_time_to);
        System.out.println(tmp_url);
        URL url = new URL(tmp_url);
        HttpURLConnection conn = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("Accept", "application/json, text/plain, */*");
            conn.connect();
            out = new PrintWriter(conn.getOutputStream());
//            out.print(json);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject);
//            res[0] = (String) jsonObject.get("access_token");
//            res[1] = (String) jsonObject.get("refresh_token");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return res;
    }

    ///api/v2/order/get_order_list
    public static String[] get_order_list(String access_token, long partner_id, String tmp_partner_key, long shop_id,
                                          String time_range_field, int page_size) throws ParseException, IOException {
        String[] res = new String[2];
        long timest = System.currentTimeMillis() / 1000L;
        Long time_from = System.currentTimeMillis() - (3600 * 24);
        Long time_to = System.currentTimeMillis();
        String cursor = "";
        String order_status = "READY_TO_SHIP";
        String response_optional_fields = "order_status";
        boolean request_order_status_pending = true;
//        String host = "https://partner.test.shopeemobile.com";
        String path = "/api/v2/order/get_order_list";
        String tmp_base_string = String.format("%s%s%s%s%s", partner_id, path, timest, access_token, shop_id);
        byte[] partner_key;
        byte[] base_string;
        BigInteger sign = null;
        String result = "";
        try {
            base_string = tmp_base_string.getBytes("UTF-8");
            partner_key = tmp_partner_key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partner_key, "HmacSHA256");
            mac.init(secret_key);
            sign = new BigInteger(1, mac.doFinal(base_string));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tmp_url = ShopeeConstants.host + path + String.format("?partner_id=%s&timestamp=%s&sign=%s&shop_id=%s&" +
                        "access_token=%s&time_range_field=%s&page_size=%s&time_from=%s&time_to=%s&cursor=%s&order_status=%s&response_optional_fields=%s&request_order_status_pending=%s",
                partner_id, timest, String.format("%032x", sign), shop_id, access_token, time_range_field, page_size,
                time_from, time_to, cursor, order_status, response_optional_fields, request_order_status_pending);
        System.out.println(tmp_url);
        URL url = new URL(tmp_url);
        HttpURLConnection conn = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("Accept", "application/json, text/plain, */*");
            conn.connect();
            out = new PrintWriter(conn.getOutputStream());
//            out.print(json);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject);
//            res[0] = (String) jsonObject.get("access_token");
//            res[1] = (String) jsonObject.get("refresh_token");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return res;
    }

    //main account request for the access token for the first time
    public static String[] refresh_access_token(String refresh_token, long partner_id, Long shop_id, Long merchant_id) throws ParseException, IOException {
        String[] res = new String[2];
        long timest = System.currentTimeMillis() / 1000L;
//        String host = "https://partner.test.shopeemobile.com";
        String path = "/api/v2/auth/access_token/get";
        String result = "";
        String tmp_url = ShopeeConstants.host + path;
        URL url = new URL(tmp_url);
        HttpURLConnection conn = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            Map<String, Object> map = new HashMap<>();
            if (!StringUtils.isEmpty(shop_id)) {
                map.put("shop_id", shop_id);
            } else if (!StringUtils.isEmpty(merchant_id)) {
                map.put("merchant_id", merchant_id);
            }
            map.put("refresh_token", refresh_token);
            map.put("partner_id", partner_id);
            String json = JSON.toJSONString(map);
            conn.connect();
            out = new PrintWriter(conn.getOutputStream());
            out.print(json);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
//        {"access_token":"7a586452756a4a4c7278524c514b6861","refresh_token":"754f566563717459656e656d634c5754","merchant_id_list":[],"shop_id_list":[497438607,497435491,497440222,497437542,954277234,954280155,954283475],"expire_in":14200,"error":"","message":"","request_id":"a434457dae5b0fddcfe061901af12021"}
        return res;
    }
}


