package com.sdk.oms.shopee.dto.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ShopBaseEntity
 * @description: 响应实体
 * @date 2023年10月20日
 * @version: 1.0
 */
@Data
public class ShopeeTokenAuth implements Serializable {
    private static final long serialVersionUID = 1L;
    private String error;
    private String message;
    private String request_id;
    private String warning;
    private String refresh_token;
    private String access_token;
    private Long merchant_id;
    private Long partner_id;
    private Long expire_in;
    private Long shop_id;
}
