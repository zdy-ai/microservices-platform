package com.sdk.tms.track123.service;

import com.central.common.utils.OkHttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName TrackShipperService
 * @description: 物流商对接服务
 * @date 2023年10月31日
 * @version: 1.0
 */
@Slf4j
@Component
public class TrackShipperService {
    String url = "https://api.track123.com/gateway/open-api/tk/v2/track/query";
    String token = "61be2f7d071441a483841be3b97e7373";

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        getCourierList();

//        String message = "Hello, World!";
//        String secretKey = "mySecretKey";
//
//        try {
//            byte[] hmacSha256Bytes = calculateHmacSHA256(message, secretKey);
//            String hmacSha256Hex = bytesToHex(hmacSha256Bytes);
//            System.out.println("HmacSHA256: " + hmacSha256Hex);
//        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 获取快递物流商列表
     */
    public static void getCourierList() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String token = "7fe88dd10c0747dab41653ac878d3d84";
        long timestamp = System.currentTimeMillis();
        byte[] hmacSha256Bytes = calculateHmacSHA256(token, String.valueOf(timestamp));
        String signature = bytesToHex(hmacSha256Bytes);
        String url = "https://api.track123.com/gateway/open-api/tk/v2/courier/list";
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Content-Type", "application/json;charset=utf-8");
        headers.put("Track123-Api-Secret", "61be2f7d071441a483841be3b97e7373");
        headers.put("signature", signature);
        headers.put("timestamp", String.valueOf(timestamp));

        String string = OkHttpUtils.doGet(url, new LinkedHashMap<>(), new LinkedHashMap<>());
        System.out.println(string);
    }

    public void getTrack() {

    }


    private static byte[] calculateHmacSHA256(String message, String secretKey)
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        mac.init(secretKeySpec);
        return mac.doFinal(message.getBytes("UTF-8"));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
