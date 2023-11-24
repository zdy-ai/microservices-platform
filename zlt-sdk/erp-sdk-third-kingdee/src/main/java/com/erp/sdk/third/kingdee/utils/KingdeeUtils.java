package com.erp.sdk.third.kingdee.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KingdeeUtils {


    public static final String SO_CHANGE_URL="Kingdee.K3.SCM.WebApi.ServicesStub.SaveXSaleOrderWebApi.SaveXSaleOrder";





    /**
     * 列名称转换成map并赋值
     *
     * @param fieldKeys
     * @param list
     */
    public static Map<String, String> keySetValByLinked(String fieldKeys, List<?> list) {
        String[] split = fieldKeys.split(",");
        Map<String, String> map = new LinkedHashMap();
        for (String val : split) {
            map.put(StrUtil.trim(val), null);
        }
        Integer indexSign = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            next.setValue(String.valueOf(list.get(indexSign)));
            indexSign++;
        }
        return map;
    }

    public static Map<String, Object> getApiDataForMap(String fieldKeys, List<?> dataObjects) {
        Map<String, Object> map = new LinkedHashMap();

        String[] fieldKeyArray = fieldKeys.split(",");
        for (String val : fieldKeyArray) {
            map.put(StrUtil.trim(val), null);
        }
        Integer indexSign = 0;
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            next.setValue(String.valueOf(dataObjects.get(indexSign)));
            indexSign++;
        }
        return map;
    }

    public static JSONObject makeFieldJson(JSONObject jsonRoot, String pathStr, String splitStr, Object value) {
        if (null == jsonRoot) {
            jsonRoot = new JSONObject();
        }

        String[] fieldArr = pathStr.replace(splitStr, "||").split("\\|\\|");
        JSONObject curNode = jsonRoot;
        for (int i = 0; i < fieldArr.length; i++) {
            String field = fieldArr[i];
            if (i < fieldArr.length - 1) {
                curNode.putIfAbsent(field, new JSONObject());
                curNode = curNode.getJSONObject(field);
            } else {
                curNode.putIfAbsent(fieldArr[fieldArr.length - 1], value);
            }
        }

        return jsonRoot;
    }
}
