package com.erp.tms.aliexpress.util.json;

/**
 * @author zdy
 * @ClassName ExceptionErrorListener
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class ExceptionErrorListener extends BufferErrorListener {
    public void error(String type, int col) {
        super.error(type, col);
        throw new IllegalArgumentException(this.buffer.toString());
    }
}
