package com.erp.oms.aliexpress.util.json;

/**
 * @author zdy
 * @ClassName JSONErrorListener
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public interface JSONErrorListener {
    void start(String paramString);

    void error(String paramString, int paramInt);

    void end();
}
