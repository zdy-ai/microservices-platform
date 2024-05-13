package com.example.workdemo.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * @author zdy
 * @ClassName UrlUtil
 * @description: TODO
 * @date 2024年03月19日
 * @version: 1.0
 */
public class UrlUtil {
    public static void main(String[] args) {
        String str = "http://172.16.230.180/2024%20%E7%94%B5%E6%B1%A0%E8%BF%90%E8%BE%93%E8%AE%A4%E8%AF%81/rar/2287 1672 2215 2346 2985 2062 2057 2810 VL49+VL49RGB.zip";
//        try {
//            String encodedUrl = str.replace("/rar/2287 1672 2215 2346 2985 2062 2057 2810 VL49+VL49RGB.zip", URLEncoder.encode(str, "UTF-8"));
//            System.out.println(encodedUrl);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        try {
//            String encodedStr = "http://172.16.230.180/2024%20%E7%94%B5%E6%B1%A0%E8%BF%90%E8%BE%93%E8%AE%A4%E8%AF%81http%3A%2F%2F172.16.230.180%2F2024%2520%25E7%2594%25B5%25E6%25B1%25A0%25E8%25BF%2590%25E8%25BE%2593%25E8%25AE%25A4%25E8%25AF%2581%2Frar%2F2287+1672+2215+2346+2985+2062+2057+2810+VL49%2BVL49RGB.zip"; // 假设这是从URL中获取的编码字符串
//            String decodedStr = URLDecoder.decode(str, "UTF-8");
//            System.out.println("decodedStr:"+decodedStr); // 输出: hello world
//            String str1 = "http://172.16.230.180/2024 电池运输认证/rar/2287 1672 2215 2346 2985 2062 2057 2810 VL49 VL49RGB.zip";
            String encodedString = URLEncoder.encode(str, "UTF-8");
//            String encodedUrl = str.replace(decodedStr, URLEncoder.encode(str, "UTF-8"));
            System.out.println("encodedString"+encodedString);
            String decodedUrl = URLDecoder.decode(encodedString, "UTF-8");
            System.out.println("decodedUrl:"+decodedUrl);
            URL url = new URL(decodedUrl);
            URLConnection urlConnection = url.openConnection();
            URL url1 = urlConnection.getURL();
            System.out.println(url1);
            BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
