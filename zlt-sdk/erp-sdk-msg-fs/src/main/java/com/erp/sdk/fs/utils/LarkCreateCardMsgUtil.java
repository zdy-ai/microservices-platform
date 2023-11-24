package com.erp.sdk.fs.utils;

import java.util.*;

/**
 * 飞书创造消息工具类
 *
 * @author Lambda
 * @Classname LarkCreateCardMsgUtil

 * @Date 2023-04-28 15:08
 * @Created by yl
 */
public class LarkCreateCardMsgUtil {


    /**
     * 获取到质检单飞书卡片消息 map
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author yl
     * @date 2023-04-28 15:12
     */
    public static Map<String, Object> getQcResultMsg(String headerMessage, String messageContent) {
        Map<String, Object> cardMap = new LinkedHashMap<>();
        Map<String, Object> configMap = new HashMap<>();
        configMap.put("wide_screen_mode", true);
        cardMap.put("config", configMap);

        List<Map> elements = new LinkedList<>();
        Map<String, Object> fieldsMap = new HashMap<>();
        Map<String, Object> fieldMap = new HashMap<>();
        Map<String, Object> textMap = new HashMap<>();
        textMap.put("content", messageContent);
        textMap.put("tag", "lark_md");
        fieldMap.put("is_short", true);
        fieldMap.put("text", textMap);
        List<Map> fieldList = new LinkedList<>();
        fieldList.add(fieldMap);
        fieldsMap.put("fields", fieldList);
        fieldsMap.put("tag", "div");
        elements.add(fieldsMap);
        cardMap.put("elements", elements);

        Map<String, Object> headerMap = new HashMap<>();

        Map<String, Object> titleMap = new HashMap<>();
        titleMap.put("content", headerMessage);
        titleMap.put("tag", "plain_text");
        headerMap.put("title", titleMap);
        cardMap.put("header", headerMap);
        return cardMap;
    }



}
