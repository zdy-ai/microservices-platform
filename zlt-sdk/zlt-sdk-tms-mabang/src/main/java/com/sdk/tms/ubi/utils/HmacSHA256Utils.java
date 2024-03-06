package com.sdk.tms.ubi.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA256Utils {
    /**
     * HmacSHA256加密
     * @Author Luo_WG
     * @Date 2022/11/1 18:47
     * @param1 jsonString 请求参数的json字符串
     * @param2 secret 秘钥
     * @return java.lang.String
     **/
    public static String hmacSHA256(String jsonString, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes("utf-8"), "HmacSHA256");
            sha256_HMAC.init(secretKey);
            byte[] hash = sha256_HMAC.doFinal(jsonString.getBytes("utf-8"));
            //String encodeStr = Base64.encodeBase64String(hash);
            return byte2Hex(hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 十六进制编码
     * @Author Luo_WG
     * @Date 2022/11/14 10:25
     * @param bytes bytes
     * @return java.lang.String
     **/
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
