package com.sdk.oms.shopee.enums;

public enum OrderStatusEnum {

    UNPAID("UNPAID",  "未付款"),
    READY_TO_SHIP("READY_TO_SHIP",  "准备发货"),
    PROCESSED("PROCESSED",  "已处理"),
    SHIPPED("SHIPPED",  "已发货"),
    COMPLETED("COMPLETED",  "已完成"),
    IN_CANCEL("IN_CANCEL",  "取消中"),
    CANCELLED("CANCELLED",  "已取消"),
    INVOICE_PENDING("INVOICE_PENDING",  "已开票"),
    ;


    private String code;
    private String name;


    OrderStatusEnum(String code, String name) {

        this.code = code;
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
