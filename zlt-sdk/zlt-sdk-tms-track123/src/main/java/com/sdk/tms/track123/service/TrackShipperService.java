package com.sdk.tms.track123.service;

import com.central.common.utils.OkHttpUtils;
import com.sdk.tms.track123.model.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
//        getCourierList();
        getTrack();
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
//        byte[] hmacSha256Bytes = calculateHmacSHA256(token, String.valueOf(timestamp));
//        String signature = bytesToHex(hmacSha256Bytes);
        String url = "https://api.track123.com/gateway/open-api/tk/v2/courier/list";
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Content-Type", "application/json;charset=utf-8");
        headers.put("Track123-Api-Secret", "265ef29963a94be1bae6ad955bc9c400");
//        headers.put("signature", signature);
        headers.put("timestamp", String.valueOf(timestamp));
        System.out.println(url);
        String string = OkHttpUtils.doGet(url, new LinkedHashMap<>(), headers);
        System.out.println(string);
    }

    public static void getTrack() {
        long timestamp = System.currentTimeMillis();
//        byte[] hmacSha256Bytes = calculateHmacSHA256(token, String.valueOf(timestamp));
//        String signature = bytesToHex(hmacSha256Bytes);
        String url = "https://api.track123.com/gateway/open-api/tk/v2/track/query";
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Content-Type", "application/json;charset=utf-8");
        headers.put("Track123-Api-Secret", "265ef29963a94be1bae6ad955bc9c400");
//        headers.put("signature", signature);
        headers.put("timestamp", String.valueOf(timestamp));
        List<String> trackNos = new ArrayList<>();
        trackNos.add("304071414818");
        trackNos.add("620372231752");

        OrderRequest orderRequest = OrderRequest.builder()
                .trackNos(trackNos)
                .createTimeStart("2021-08-01 00:00:00")
                .createTimeEnd("2021-09-28 00:00:00")
                .cursor("")
                .queryPageSize(100)
                .build();

        System.out.println(url);
        String string = OkHttpUtils.doPostJsonObject(url, orderRequest, headers);
        System.out.println(string);
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
