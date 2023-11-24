package com.sdk.oms.walmart.service;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.common.business.constant.RedisCacheConstants;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.utils.RedisUtil;
import com.common.core.utils.OkHttpUtils;
import com.common.core.utils.UUID;
import com.sdk.oms.walmart.api.WalmartStaticKey;
import com.sdk.oms.walmart.dto.WalmartShopInfoDTO;
import com.sdk.oms.walmart.dto.walmart.WalmartTokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 沃尔玛服务
 * @Author Luo_WG
 * @Date 2023/10/16 14:50
 **/
@Slf4j
@Component
public class WalmartSdkClientService {

    public static void main(String[] args) {
        String baseUrl = "https://marketplace.walmartapis.com/v3/";
        String clientId = "2434a35c-7c42-4420-9618-0c179b68a8c2";
        String clientSecret = "AMW5lbVFqG2DMP4DuLezhSkbk4u0JLGUjdFlsrl_p0sagsBkYPPiQhRbEvkE4a6k6KXNKhB--RGlqPKIfhUoV28";
        //获取令牌
        baseUrl = WalmartStaticKey.baseUrl + "token";


        WalmartSdkClientService walmartSdkClientService = new WalmartSdkClientService();
        WalmartTokenDTO walmartTokenDTO = walmartSdkClientService.sendWalmartPostToken(baseUrl, clientId, clientSecret);
        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        Integer pageSize = 200;
        paramMap.put("limit", pageSize);
        paramMap.put("lastModifiedStartDate", "2023-09-01T00:00:00");
        paramMap.put("lastModifiedEndDate", "2023-10-27T00:00:00");
        paramMap.put("createdStartDate", "2023-09-01T00:00:00");
        paramMap.put("createdEndDate", "2023-10-27T00:00:00");
        paramMap.put("status", "Acknowledged,Shipped,Delivered,Cancelled");
        paramMap.put("productInfo", "true");
//        WalmartTokenDTO s = walmartSdkClientService.sendWalmartPostToken(baseUrl, clientId, clientSecret);
        baseUrl = WalmartStaticKey.baseUrl + "orders";
        String s = walmartSdkClientService.sendWalmartGet(baseUrl, clientId, clientSecret, walmartTokenDTO.getAccessToken(), paramMap);
        System.out.println(s);
    }

    private static RedisUtil redisUtil;

    @Resource
    public void setRedisUtil(RedisUtil redisUtil){
        this.redisUtil = redisUtil;
    }

    /**
     * 发送请求到沃尔玛获取令牌token
     * @param baseUrl 接口地址
     * @param clientId 账户id
     * @param clientSecret 账户秘钥
     * @return java.lang.String
     */
    public WalmartTokenDTO sendWalmartPostToken(String baseUrl, String clientId, String clientSecret) {
        String consumerId = UUID.randomUUID().toString();
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", WalmartStaticKey.accept_application);
        headers.put("WM_SVC.NAME", WalmartStaticKey.WM_SVC_NAME);
        headers.put("WM_QOS.CORRELATION_ID", consumerId);
        headers.put("Accept", WalmartStaticKey.accept_json);
        headers.put("WM_SVC.VERSION", "1.0.0");
        headers.put("Authorization", "Basic "+ Base64.encodeBase64String(getclient(clientId, clientSecret).getBytes()));
        Map<String, Object> param = new HashMap();
        param.put("grant_type", "client_credentials");
        String bodyStr = OkHttpUtils.doPost(baseUrl, param, headers);
        WalmartTokenDTO tokenDTO = JSONUtil.toBean(bodyStr, WalmartTokenDTO.class);
        return tokenDTO;
    }

    /**
     * 发送Get请求到沃尔玛
     * @param baseUrl 接口地址
     * @param clientId 账户id
     * @param clientSecret 账户秘钥
     * @param accessToken 短令牌
     * @param paramMap 查询参数
     * @return java.lang.String
     */
    public String sendWalmartGet(String baseUrl, String clientId,String clientSecret, String accessToken, HashMap<String, Object> paramMap) {
        Map<String, String> headers = new HashMap<String, String>();
        String consumerId = UUID.randomUUID().toString();
        headers.put("Content-Type", WalmartStaticKey.accept_json);
        headers.put("WM_SVC.NAME", WalmartStaticKey.WM_SVC_NAME);
        headers.put("WM_QOS.CORRELATION_ID", consumerId);
        headers.put("Accept", WalmartStaticKey.accept_json);
        headers.put("Authorization", "Basic "+Base64.encodeBase64String(getclient(clientId, clientSecret).getBytes()));
        headers.put("WM_SEC.ACCESS_TOKEN", accessToken);
        String bodyStr = OkHttpUtils.doGet(baseUrl, paramMap, headers);
        return bodyStr;
    }

    /**
     * 发送Post请求到沃尔玛
     * @param baseUrl 接口地址
     * @param clientId 账户id
     * @param clientSecret 账户秘钥
     * @param accessToken 短令牌
     * @param paramMap 查询参数
     * @return java.lang.String
     */
    public String sendWalmartPost(String baseUrl, String clientId,String clientSecret, String accessToken, HashMap<String, Object> paramMap) {
        Map<String, String> headers = new HashMap<String, String>();
        String consumerId = UUID.randomUUID().toString();
        headers.put("Content-Type", WalmartStaticKey.accept_json);
        headers.put("WM_SVC.NAME", WalmartStaticKey.WM_SVC_NAME);
        headers.put("WM_QOS.CORRELATION_ID", consumerId);
        headers.put("Accept", WalmartStaticKey.accept_json);
        headers.put("Authorization", "Basic "+Base64.encodeBase64String(getclient(clientId, clientSecret).getBytes()));
        headers.put("WM_SEC.ACCESS_TOKEN", accessToken);
        String bodyStr = OkHttpUtils.doPost(baseUrl, paramMap, headers);
        return bodyStr;
    }


    /**
     * 获取Token
     */
    public static WalmartShopInfoDTO getTokenByShopId(String shopId) {
        // platform-token:平台名称:店铺ID
        String tokenKey = StrUtil.format(RedisCacheConstants.REDIS_PLATFORM_TOKEN, PlatformDictEnum.WALMART.getCode(), shopId);
        // 缓存获取
        Object tokenObj = redisUtil.get(tokenKey);
        if (null != tokenObj) {
            if (tokenObj instanceof WalmartShopInfoDTO) {
                return (WalmartShopInfoDTO) tokenObj;
            }
        }
        return null;
    }


    private String getclient(String clientId, String clientSecret) {
        StringBuffer sb = new StringBuffer();
        sb.append(clientId);
        sb.append(":");
        sb.append(clientSecret);
        String str = sb.toString();
        return str;
    }

}
