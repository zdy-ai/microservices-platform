package com.sdk.tms.express.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
/**
 * @author zdy
 * @ClassName VerifyCodeUtil
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
public class VerifyCodeUtil {
    public static String loadFile(String fileName) {
        try {
            InputStream fis = new FileInputStream(fileName);
            byte[] bs = new byte[fis.available()];
            fis.read(bs);
            String res = new String(bs);
            fis.close();
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5EncryptAndBase64(String str) {
        return encodeBase64(md5Encrypt(str));
    }

    private static byte[] md5Encrypt(String encryptStr) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(encryptStr.getBytes("utf8"));
            return md5.digest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String encodeBase64(byte[] b) {
        String str = (new Base64()).encodeAsString(b);
        return str;
    }
}
