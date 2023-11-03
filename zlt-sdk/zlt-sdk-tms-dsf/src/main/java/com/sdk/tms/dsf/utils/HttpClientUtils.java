package com.sdk.tms.dsf.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sdk.tms.dsf.constants.AmbientEnum;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author zdy
 * @ClassName HttpClientUtils
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
public class HttpClientUtils {
    public static String get(String url) throws IOException {
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            response = HttpClients.createDefault().execute((HttpUriRequest)httpGet);
            if (response.getStatusLine().getStatusCode() == 200)
                return EntityUtils.toString(response.getEntity());
            JSONObject errorObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
            System.out.println(errorObject);
            String errorMsg = errorObject.getString("message");
            throw new IOException("HTTP ERROR: " + response.getStatusLine().getStatusCode() + "," + errorMsg);
        } finally {
            if (response != null)
                response.close();
        }
    }

    public static String postJson(String url, Object object) throws IOException {
        String jsonData = JSON.toJSONString(object);
        return post(url, jsonData);
    }

    public static String post(String url, String jsonData) throws IOException {
        CloseableHttpResponse response = null;
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json");
        if (StringUtils.isNotEmpty(jsonData))
            post.setEntity((HttpEntity)new StringEntity(jsonData, Charset.forName("UTF-8")));
        try {
            response = HttpClients.createDefault().execute((HttpUriRequest)post);
            if (response.getStatusLine().getStatusCode() != 200) {
                JSONObject errorObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
                System.out.println(errorObject);
                String errorMsg = errorObject.getString("message");
                throw new IOException("HTTP ERROR: " + response.getStatusLine().getStatusCode() + "," + errorMsg);
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage(), e);
        }
        return EntityUtils.toString(response.getEntity());
    }

    public static String post(String url, Map<String, Object> params) throws IOException {
        CloseableHttpResponse response = null;
        try {
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type", "application/x-www-form-urlencoded");
            if (MapUtils.isNotEmpty(params)) {
                List<NameValuePair> nvps = new ArrayList<>();
                for (Map.Entry<String, Object> entry : params.entrySet())
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                post.setEntity((HttpEntity)new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
            }
            response = HttpClients.createDefault().execute((HttpUriRequest)post);
            if (response.getStatusLine().getStatusCode() == 200)
                return EntityUtils.toString(response.getEntity());
            throw new IOException("HTTP Error:" + response.getStatusLine().getStatusCode());
        } finally {
            if (response != null)
                response.close();
        }
    }

    public static String getAddress(AmbientEnum ambient) {
        String urlProfiels = AmbientEnum.SANDBOX_ADDRESS.equals(ambient) ? "http://open.sandbox.4px.com" : "http://open.4px.com";
        return urlProfiels;
    }
}
