package com.central.common.redis.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zdy
 * @ClassName MD5Util
 * @description: 字符串加密方式
 * @date 2023年10月25日
 * @version: 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MD5Util {
    public static String toMD5(String plainText) {
        String value = "";
        if (plainText == null){
            plainText = "";
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0){
                    i += 256;
                }
                if (i < 16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            value = buf.toString();

            // 24));// 16位的加密
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return value;
    }
}
