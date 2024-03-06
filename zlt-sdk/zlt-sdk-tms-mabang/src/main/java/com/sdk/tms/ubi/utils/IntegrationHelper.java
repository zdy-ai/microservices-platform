package com.sdk.tms.ubi.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zdy
 * @ClassName IntegrationHelper
 * @description: TODO
 * @date 2023年10月26日
 * @version: 1.0
 */
public class IntegrationHelper {

    private static final char NEW_LINE = (char) 0x000A;

    private static final String HEADERS_AUTHORIZATION_PREFIX = "WallTech ";

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    private static String calculate(String secretAccessKey, String data) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(secretAccessKey.getBytes("UTF-8"), HMAC_SHA1_ALGORITHM);

            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
            return new String(Base64.getEncoder().encode(rawHmac), "UTF-8");
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    /**
     *
     * @param method should be POST,GET...(upperCase)
     * @param url   fully url (eg.:http://qa.etowertech.com/services/shipper/orders)
     * @param token
     * @param secret
     * @return
     */
    public static Map<String, String> buildHeader(String method, String url, String token, String secret) {
        Map<String, String> headers = new HashMap<String, String>();
        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateStr = format.format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append(method).append(NEW_LINE);
        sb.append(dateStr).append(NEW_LINE);
        sb.append(url);
        String authorization = MessageFormat.format(HEADERS_AUTHORIZATION_PREFIX + "{0}:{1}", token, calculate(secret, sb.toString()));

        headers.put("X-WallTech-Date", dateStr);
        headers.put("Authorization", authorization);
        return headers;
    }
}
