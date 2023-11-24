package com.erp.oms.aliexpress.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName IopHashMap
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class IopHashMap extends HashMap<String, String> {
    private static final long serialVersionUID = -1277791390393392630L;

    public IopHashMap() {}

    public IopHashMap(Map<? extends String, ? extends String> m) {
        super(m);
    }

    public String put(String key, Object value) {
        String strValue;
        if (value == null) {
            strValue = null;
        } else if (value instanceof String) {
            strValue = (String)value;
        } else if (value instanceof Integer) {
            strValue = ((Integer)value).toString();
        } else if (value instanceof Long) {
            strValue = ((Long)value).toString();
        } else if (value instanceof Float) {
            strValue = ((Float)value).toString();
        } else if (value instanceof Double) {
            strValue = ((Double)value).toString();
        } else if (value instanceof Boolean) {
            strValue = ((Boolean)value).toString();
        } else if (value instanceof Date) {
            strValue = String.valueOf(((Date)value).getTime());
        } else {
            strValue = value.toString();
        }
        return put(key, strValue);
    }

    public String put(String key, String value) {
        if (IopUtils.areNotEmpty(new String[] { key, value }))
            return super.put(key, value);
        return null;
    }
}
