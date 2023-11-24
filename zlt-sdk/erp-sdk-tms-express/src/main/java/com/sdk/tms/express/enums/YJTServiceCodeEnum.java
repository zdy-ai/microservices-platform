package com.sdk.tms.express.enums;

import com.sdk.tms.express.service.IServiceCodeStandard;
import com.sf.csim.express.service.PrePathEnum;

/**
 * @Description: 医寄通serviceCode
 * @Date: 2021/10/18 14:07
 * @Version: 1.0
 */
public enum YJTServiceCodeEnum implements IServiceCodeStandard {

    /*------医寄通接口------*/
    COM_RECE_MRDS_FREIGHT_QUERY("COM_RECE_MRDS_FREIGHT_QUERY", "YJT.1.COM_RECE_MRDS_FREIGHT_QUERY.json"),
    COM_RECE_MRDS_SUPPORT_VALUE("COM_RECE_MRDS_SUPPORT_VALUE", "YJT.2.COM_RECE_MRDS_SUPPORT_VALUE.json"),
    COM_RECE_MRDS_SIEVE_ORDER("COM_RECE_MRDS_SIEVE_ORDER", "YJT.3.COM_RECE_MRDS_SIEVE_ORDER.json"),
    COM_RECE_MRDS_ADD_ORDER("COM_RECE_MRDS_ADD_ORDER", "YJT.4.COM_RECE_MRDS_ADD_ORDER.json"),
    COM_RECE_MRDS_CANCEL_ORDER("COM_RECE_MRDS_CANCEL_ORDER", "YJT.5.COM_RECE_MRDS_CANCEL_ORDER.json"),
    COM_RECE_MRDS_LIST_PRINT_INFO("COM_RECE_MRDS_LIST_PRINT_INFO", "YJT.6.COM_RECE_MRDS_LIST_PRINT_INFO.json"),
    COM_RECE_MRDS_WANTED_ORDER("COM_RECE_MRDS_WANTED_ORDER", "YJT.7.COM_RECE_MRDS_WANTED_ORDER.json"),
    COM_RECE_MRDS_SFWAYBILL("COM_RECE_MRDS_SFWAYBILL", "YJT.8.COM_RECE_MRDS_SFWAYBILL.json"),
    COM_RECE_MRDS_ROUTE("COM_RECE_MRDS_ROUTE", "YJT.9.COM_RECE_MRDS_ROUTE.json"),
    COM_RECE_MRDS_ORDER_DETAIL("COM_RECE_MRDS_ORDER_DETAIL", "YJT.10.COM_RECE_MRDS_ORDER_DETAIL.json"),
    COM_RECE_MRDS_TEMPERATURE("COM_RECE_MRDS_TEMPERATURE", "YJT.11.COM_RECE_MRDS_TEMPERATURE.json"),
    COM_RECE_MRDS_HUMITURE("COM_RECE_MRDS_HUMITURE", "YJT.12.COM_RECE_MRDS_HUMITURE.json"),
    COM_RECE_MRDS_WP_TASK_RESULT("COM_RECE_MRDS_WP_TASK_RESULT", "YJT.13.COM_RECE_MRDS_WP_TASK_RESULT.json"),
//    COM_PUSH_MRDS_ROUTE("COM_PUSH_MRDS_ROUTE", "YJT.14.COM_PUSH_MRDS_ROUTE.json"),
//    COM_PUSH_MRDS_ORDER_STATUS("COM_PUSH_MRDS_ORDER_STATUS", "YJT.15.COM_PUSH_MRDS_ORDER_STATUS.json"),
//    COM_PUSH_MRDS_WP_STATUS("COM_PUSH_MRDS_WP_STATUS", "YJT.16.COM_PUSH_MRDS_WP_STATUS.json"),
    ;


    YJTServiceCodeEnum(String code, String path) {
        this.code = code;
        this.path = path;

    }

    private String path;
    private String code;



    @Override
    public String getPath() {
        return PrePathEnum.YJT_PATH.getPath() + this.path;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}
