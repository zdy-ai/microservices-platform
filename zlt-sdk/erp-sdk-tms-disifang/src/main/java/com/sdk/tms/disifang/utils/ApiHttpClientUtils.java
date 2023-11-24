package com.sdk.tms.disifang.utils;

import com.alibaba.fastjson.JSONObject;
import com.sdk.tms.disifang.constants.AmbientEnum;
import com.sdk.tms.disifang.constants.EnvironOption;
import com.sdk.tms.disifang.model.base.AffterentParam;
import com.sdk.tms.disifang.model.base.ResponseMsg;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author zdy
 * @ClassName ApiHttpClientUtils
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
public class ApiHttpClientUtils extends HttpClientUtils {
    public static String apiGet(AffterentParam param, Map<String, Object> paramMap, AmbientEnum ambient) {
        if (!checkParam(param))
            return ResponseMsg.fial("参数缺失").toString();
        String jsonStr = getBodyJson(paramMap);
        String urlProfiles = getAddress(ambient);
        StringBuilder urlStr = new StringBuilder(urlProfiles);
        urlStr.append(EnvironOption.OPEN_API_ROUTER);
        Long timestamp = Long.valueOf((new Date()).getTime());
        String sign = SignUtil.getSingByParam(param, jsonStr, timestamp);
        StringBuilder url = getRequestUrl(param, urlStr, timestamp, sign);
        if (MapUtils.isNotEmpty(paramMap))
            for (Map.Entry<String, Object> entry : paramMap.entrySet())
                url.append("&" + (String) entry.getKey() + "=" + entry.getValue());
        String response = null;
        try {
            response = get(url.toString());
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String apiJsonPost(AffterentParam param, String bodyJsonStr, AmbientEnum ambient) {
        if (!checkParam(param))
            return ResponseMsg.fial("参数缺失").toString();
        String urlProfiles = getAddress(ambient);
        StringBuilder urlStr = new StringBuilder(urlProfiles);
        urlStr.append(EnvironOption.OPEN_API_ROUTER);
        Long timestamp = new Date().getTime();
        String sign = SignUtil.getSingByParam(param, bodyJsonStr, timestamp);
        StringBuilder url = getRequestUrl(param, urlStr, timestamp, sign);
        String response = null;
        try {
            response = post(url.toString(), bodyJsonStr);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String apiJsongPost(AffterentParam param, Map<String, Object> paramMap, AmbientEnum ambient) {
        if (!checkParam(param))
            return ResponseMsg.fial("参数缺失").toString();
        String bodyJsonStr = getBodyJson(paramMap);
        String urlProfiles = getAddress(ambient);
        StringBuilder urlStr = new StringBuilder(urlProfiles);
        urlStr.append(EnvironOption.OPEN_API_ROUTER);
        Long timestamp = new Date().getTime();
        String sign = SignUtil.getSingByParam(param, bodyJsonStr, timestamp);
        StringBuilder url = getRequestUrl(param, urlStr, timestamp, sign);
        String response = null;
        try {
            response = post(url.toString(), bodyJsonStr);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static StringBuilder getRequestUrl(AffterentParam param, StringBuilder urlStr, Long timestamp, String sign) {
        urlStr.append("?method=" + param.getMethod());
        urlStr.append("&app_key=" + param.getAppKey());
        urlStr.append("&v=" + param.getVersion());
        urlStr.append("&timestamp=" + timestamp);
        urlStr.append("&format=" + param.getFormat());
        urlStr.append("&access_token=" + param.getAccessToken());
        urlStr.append("&sign=" + sign);
        urlStr.append("&language=" + param.getLanguage());
        return urlStr;
    }

    private static String getBodyJson(Map<String, Object> paramMap) {
        JSONObject jsonObject = new JSONObject(paramMap);
        return jsonObject.toString();
    }

    private static boolean checkParam(AffterentParam param) {
        if (StringUtils.isBlank(param.getAppKey()) || StringUtils.isBlank(param.getVersion()) || StringUtils.isBlank(param.getMethod()) ||
                StringUtils.isBlank(param.getVersion()) || StringUtils.isBlank(param.getFormat()) || StringUtils.isBlank(param.getLanguage()) ||
                StringUtils.isBlank(param.getAppSecret()))
            return false;
        return true;
    }
}
