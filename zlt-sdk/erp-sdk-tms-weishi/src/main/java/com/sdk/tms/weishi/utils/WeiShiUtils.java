package com.sdk.tms.weishi.utils;

import com.common.business.constant.ThirdConstants;
import com.common.core.utils.OkHttpUtils;
import com.sdk.tms.weishi.constants.WeiShiConstants;

import java.util.HashMap;
import java.util.Map;

public class WeiShiUtils {

    public static String sendPost(String method,String paramsJson,String appToken,String appKey){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("paramsJson",paramsJson);
        paramsMap.put("appToken", appToken);
        paramsMap.put("service", method);
        paramsMap.put("appKey", appKey);
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", ThirdConstants.CONTENT_TYPE);
        return OkHttpUtils.doPostJson(WeiShiConstants.BASE_URL, paramsMap, headerMap);
    }

}
