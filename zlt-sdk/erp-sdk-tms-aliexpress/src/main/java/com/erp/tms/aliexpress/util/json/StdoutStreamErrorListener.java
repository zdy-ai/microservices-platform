package com.erp.tms.aliexpress.util.json;

/**
 * @author zdy
 * @ClassName StdoutStreamErrorListener
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class StdoutStreamErrorListener extends BufferErrorListener{
    public void end() {
        System.out.print(this.buffer.toString());
    }
}
