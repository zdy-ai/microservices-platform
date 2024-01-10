package com.example.workdemo.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author yl
 * @Classname Md5Util MD5 工具

 * @Date 2022-07-06 11:51
 */
public class Md5Util {

    /**
     * 简单MD5
     *
     * @param str
     * @return
     */
    public static String md5(String str) {

        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] array = md.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    /**
     * 简单MD5
     *
     * @param str
     * @return
     */
    public static String md5UpperCase(String str) {

        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] array = md.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    public static String getMd5(String plainText){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //可以填UTF-8或GBK
            md.update(plainText.getBytes("UTF-8"));
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException|UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
