package com.central.common.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Classname OkHttpUtils

 * @Date 2022-07-13 17:33
 * @Created by yl
 */
public class OkHttpUtils {


    private static final OkHttpClient client =
            new OkHttpClient.Builder()
                    .readTimeout(5, TimeUnit.SECONDS)       // 设置超时时间
                    .build();

    /**
     * 获取delete 请求
     *
     * @param
     * @return java.lang.String
     * @author yl
     * @date 2022-07-13 18:09
     */
    public static String doDelete(String url, Map<String, Object> params, Map<String, String> headers) {
        Call call = createDeleteCall(url, params, headers);
        return execute(call);
    }

    /**
     * 获取post 请求
     *
     * @param
     * @return java.lang.String
     * @author yl
     * @date 2022-07-13 18:09
     */
    public static String doPost(String url, Map<String, Object> params, Map<String, String> headers) {
        Call call = createPostCall(url, params, headers);
        return execute(call);
    }

    /**
     * 获取post 请求 以json
     *
     * @param
     * @return java.lang.String
     * @author yl
     * @date 2022-07-13 18:09
     */
    public static String doPostJson(String url, Map<String, Object> params, Map<String, String> headers) {
        Call call = createPostJsonCall(url, params, headers);
        return execute(call);
    }

    /**
     * 获取get 请求
     *
     * @param
     * @param headers
     * @return java.lang.String
     * @author yl
     * @date 2022-07-13 18:09
     */
    public static String doGet(String url, Map<String, Object> params, Map<String, String> headers) {
        Call call = createGetCall(url, params, headers);
        return execute(call);
    }

    /**
     * 生成get call
     *
     * @param url
     * @param params  body
     * @param headers 头部
     * @return okhttp3.Call
     * @author yl
     * @date 2022-07-13 18:17
     */
    private static Call createGetCall(String url, Map<String, Object> params, Map<String, String> headers) {

        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).build();
        // 设置参数
        HttpUrl httpUrl = createHttpUrl(request, params, headers);
        builder.url(httpUrl).build();
        builder.headers(createHeaders(headers));
        return client.newCall(builder.build());

    }


    /**
     * 执行 http 请求
     *
     * @param call
     * @return java.lang.String
     * @author yl
     * @date 2022-07-13 18:11
     */

    private static String execute(Call call) {
        String respStr = "";
        try {
            ResponseBody body = call.execute().body();
            if (body != null) {
                respStr = body.string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respStr;

    }

    private static HttpUrl createHttpUrl(Request request, Map<String, Object> params, Map<String, String> headers) {
        HttpUrl.Builder urlBuilder = request.url().newBuilder();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }

        return urlBuilder.build();
    }

    /**
     * 创建 delete 请求
     *
     * @param url params 参数 Headers 头部
     * @return
     * @author yl
     * @date 2022-07-13 17:54
     */

    public static Call createDeleteCall(String url, Map<String, Object> params, Map<String, String> headers) {
        Request request = new Request.Builder()
                .delete(createFormBody(params))
                .headers(createHeaders(headers))
                .url(url)
                .build();
        return client.newCall(request);
    }
    /**
     * 创建 post 请求
     *
     * @param url params 参数 Headers 头部
     * @return
     * @author yl
     * @date 2022-07-13 17:54
     */

    public static Call createPostCall(String url, Map<String, Object> params, Map<String, String> headers) {
        Request request = new Request.Builder()
                .post(createFormBody(params))
                .headers(createHeaders(headers))
                .url(url)
                .build();
        return client.newCall(request);
    }

    public static Call createPostJsonCall(String url, Map<String, Object> params, Map<String, String> headers) {
        MediaType json = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(json, JSONObject.toJSONString(params));
        Request request = new Request.Builder()
                .post(requestBody)
                .headers(createHeaders(headers))
                .url(url)
                .build();
        return client.newCall(request);
    }


    private static FormBody createFormBody(Map<String, Object> params) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                builder.add(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return builder.build();
    }

    private static Headers createHeaders(Map<String, String> Headers) {
        Headers.Builder builder = new Headers.Builder();
        if (Headers != null && Headers.size() > 0) {
            for (Map.Entry<String, String> entry : Headers.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }





}
