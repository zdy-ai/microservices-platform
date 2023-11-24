package com.erp.sdk.third.kingdee.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 谷仓OPENAPI封装
 *
 * @Author Cloud
 * @Date 2023/3/29 10:30
 **/
@Slf4j
@Component
public class GoodCangApiUtils {
    public static String APP_KEY;

    public static String APP_TOKEN;

    public static String URL;
    @Value("${openApi.goodcang.appKey}")
    public void setAppKey(String appKey){
        GoodCangApiUtils.APP_KEY = appKey;
    }
    @Value("${openApi.goodcang.appToken}")
    public void setSecretKey(String secretKey) {
        GoodCangApiUtils.APP_TOKEN = secretKey;
    }
    @Value("${openApi.goodcang.url}")
    public void setSessionKey(String url) {
        GoodCangApiUtils.URL = url;
    }




}
