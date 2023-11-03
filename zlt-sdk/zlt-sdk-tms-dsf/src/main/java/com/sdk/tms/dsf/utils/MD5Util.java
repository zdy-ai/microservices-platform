package com.sdk.tms.dsf.utils;

import java.security.MessageDigest;
/**
 * @author zdy
 * @ClassName MD5Util
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
public class MD5Util {
    public static final int FOUR_BIT = 4;

    public static final int FF = 15;

    public static final String doMd5(String s) {
        char[] hexDigits = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes("UTF-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xF];
                str[k++] = hexDigits[byte0 & 0xF];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
