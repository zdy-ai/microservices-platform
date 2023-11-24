package com.erp.sdk.third.kingdee.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.webservice.SoapClient;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

/**
 * 谷仓OPENAPI封装
 *
 * @Author Cloud
 * @Date 2023/3/29 10:30
 **/
@Slf4j
@Component
public class ImlApiUtils {
    public static String APP_KEY = "fa0c90d7dbb434fa2160209756db677c";

    public static String APP_TOKEN = "44ac3ae1211d416a080858e57833cc14";

    public static String URL = "http://oms.imlb2c.com/default/svc/web-service";
    @Value("${openApi.iml.appKey}")
    public void setAppKey(String appKey){
        ImlApiUtils.APP_KEY = appKey;
    }
    @Value("${openApi.iml.appToken}")
    public void setSecretKey(String secretKey) {
        ImlApiUtils.APP_TOKEN = secretKey;
    }
    @Value("${openApi.iml.url}")
    public void setSessionKey(String url) {
        ImlApiUtils.URL = url;
    }



    public static JSONObject queryList(String method, String paramsJsonStr) {
        // 构建client
        SoapClient client = SoapClient.create(URL)
                .setMethod("callService","http://www.example.org/Ec/");
        SOAPElement callService = client.getMethodEle();
        // 设置标签参数
        try {
            callService.addChildElement("service").setValue(method);
            callService.addChildElement("appKey").setValue(APP_KEY);
            callService.addChildElement("appToken").setValue(APP_TOKEN);
            callService.addChildElement("paramsJson").setValue(JSONUtil.toJsonStr(paramsJsonStr));
            // 打印构建后的xml
            log.debug("ImlApiUtils>>>queryList>>>client xml=[{}]",client.getMsgStr(true));
            // 发送请求
            String responseXml = client.send();
            // 打印返回数据
            log.debug("SOAP Response: {}", responseXml);
            // Parse SOAP response and extract data
            JSONObject responseJson = JSONUtil.parseFromXml(responseXml)
                    .getJSONObject("SOAP-ENV:Envelope")
                    .getJSONObject("SOAP-ENV:Body")
                    .getJSONObject("ns1:callServiceResponse")
                    .getJSONObject("response");
            if (!responseJson.getStr("ask").equals("Success")) {
                log.error("ImlApiUtils>>>queryList>>>responseJson=[{}]", responseJson);
                throw new RuntimeException(StrUtil.format("ImlApiUtils>>>queryList>>>responseJson=[{}]", responseJson));
            }
            return responseJson;
        } catch (SOAPException e) {
            log.error("ImlApiUtils>>>queryList>>>请求出现异常", e);
            throw new RuntimeException(e);
        }
    }

}
