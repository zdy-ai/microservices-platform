package com.sdk.tms.express.model.order.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName PrintFile
 * @description: TODO
 * @date 2023年11月10日
 * @version: 1.0
 */
@Data
public class PrintFile implements Serializable {
    /*
     * pdf文件的url下载地址,使用 GET 协议
     */
    private String url;
    /*
     * 下载文件时需要的token,设置在请求头的 X-Auth-token 字段，有效期 24h
     */
    private String token;
    /*
     * 顺丰运单号（子母单为子单号）
     */
    private String waybillNo;
    /*
     * 面单序号（批量打印场景，为documents的序号）
     */
    private String seqNo;
    /*
     * 联编号（大客户面单为固定值：1）
     */
    private String areaNo;
    /*
     * 每联的页号(大客户面单为固定值：1)
     */
    private String pageNo;
    /*
     * 文件的页数
     */
    private String pageCount;

}
