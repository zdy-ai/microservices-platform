package com.sdk.tms.yanwen.utils;

import com.alibaba.fastjson.JSONObject;
import com.common.business.constant.ThirdConstants;
import com.common.core.utils.Md5Util;
import com.common.core.utils.OkHttpUtils;
import com.sdk.tms.yanwen.constants.YanWenConstants;

import java.util.HashMap;
import java.util.Map;

public class YanWenUtils {

    public static String getSign(String data ,String method,long timestamp,String userId,String apiToken){
        return Md5Util.md5(apiToken+ userId+data+ YanWenConstants.FORMAT+method+timestamp+ YanWenConstants.VERSION+ apiToken);
    }

    public static String sendPost(String method,Map<String, Object> paramsMap,String userId,String apiToken){
        long timestamp = System.currentTimeMillis();;
        String sign = getSign(JSONObject.toJSONString(paramsMap),method,timestamp,userId,apiToken);
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", ThirdConstants.CONTENT_TYPE);
        String url = YanWenConstants.BASE_URL +
                YanWenConstants.BASE_URL_SUFFIX +
                "?user_id=" +
                userId +
                "&method=" +
                method +
                "&format=" +
                YanWenConstants.FORMAT +
                "&timestamp=" +
                timestamp +
                "&sign=" +
                sign +
                "&version=" +
                YanWenConstants.VERSION;
        return OkHttpUtils.doPostJson(url, paramsMap, headerMap);
    }

}
