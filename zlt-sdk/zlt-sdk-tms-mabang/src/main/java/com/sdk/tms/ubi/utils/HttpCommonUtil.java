package com.sdk.tms.ubi.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Http公共接口
 */
@Slf4j
public class HttpCommonUtil {

    /**
     * http公共接口，parameters和map只能传一个，parameters 为json格式
     *
     * @param url        请求路径
     * @param parameters 请求参数
     * @param map        请求参数
     * @param header     请求头
     * @param method     请求方式（GET、POST）
     * @return
     * @throws Exception
     */
    public static JSONObject sendOkhttp(String url, String parameters, Map<String, Object> map,
                                        Map<String, String> header, RequestMethod method) {

        Response response = null;
        Long start = System.currentTimeMillis();
        String responseString = "";
        Request.Builder requestBuilder = new Request.Builder();
        if (header != null && header.size() > 0) {
            header.entrySet().forEach(res -> {
                requestBuilder.header(res.getKey(), res.getValue());
            });
        }

        requestBuilder.header("Connection", "close");
        if (RequestMethod.POST.equals(method)) {
            if (map != null && map.size() > 0) {
                FormBody.Builder builder = new FormBody.Builder();
                Set<Map.Entry<String, Object>> entrySet = map.entrySet();
                entrySet.stream().forEachOrdered(e -> builder.add(e.getKey(), String.valueOf(e.getValue())));
                requestBuilder.post(builder.build());
            }

            if (!ObjectUtils.isEmpty(parameters)) {
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                requestBuilder.post(RequestBody.create(mediaType, parameters));
            }

            if ((map == null || map.size() == 0) && ObjectUtils.isEmpty(parameters)) {
                FormBody.Builder builder = new FormBody.Builder();
                requestBuilder.post(builder.build());
            }

        }

        if (RequestMethod.GET.equals(method)) {
            if (map != null && map.size() > 0) {
                url = buildUrl(url, map);
            }

            if (!ObjectUtils.isEmpty(parameters)) {
                Map map1 = JSONObject.parseObject(parameters, Map.class);
                url = buildUrl(url, map1);
            }
            requestBuilder.get();
        }
        requestBuilder.url(url);

        try {
            response = doSend(requestBuilder);
            responseString = response.body().string();
            return JSONObject.parseObject(responseString);
        } catch (Exception e) {
            JSONObject result = new JSONObject();
            if (e.getMessage().contains("connect timed out")) {
                result.put("code", 411);
            } else {
                result.put("code", 500);
            }
            result.put("msg", e.getMessage());

//            log.info(String.format("::::: sendHttp ::::: 请求地址 => %s, 请求方式 => %s, 请求参数 => %s, 返回参数 => %s, 错误信息 => %s ",
//                    url, method, parameters, responseString, e));
            return result;
        } finally {

            Long end = System.currentTimeMillis();
            log.info(String.format("::::: sendHttp ::::: 请求地址 => %s, 请求方式 => %s, 请求参数 => %s, 开始时间 => %s, " +
                            "结束时间 => %s, 执行时间 => %s, 返回参数 => %s ", url, method, parameters, start, end, end - start,
                    responseString));
            if (response != null) {
                response.close();
            }
        }
    }

    private static Response doSend(Request.Builder request) throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //设置连接超时时间
                .connectTimeout(60, TimeUnit.SECONDS)
                //设置读取超时时间
                .readTimeout(300, TimeUnit.SECONDS)
                .build();
        Response response = okHttpClient.newCall(request.build()).execute();
        return response;
    }

    private static String buildUrl(String url, Map parameters) {
        StringBuilder builder = new StringBuilder(url).append("?");
        Set<Map.Entry<String, Object>> entrySet = parameters.entrySet();
        entrySet.stream().forEachOrdered(e -> builder.append(e.getKey()).append("=").append(e.getValue()).append("&"));
        return builder.toString().substring(0, builder.toString().length() - 1).trim();
    }
}
