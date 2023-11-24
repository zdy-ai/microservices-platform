package com.sdk.oms.shopee.dto.product.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ProductBaseRequest
 * @description: TODO
 * @date 2023年10月23日
 * @version: 1.0
 */
@Data
public class ProductBaseRequest implements Serializable {

    String host;
    String token;
    long shopId;
    long partner_id;
    String tmp_partner_key;
    String itemIdList;
}
