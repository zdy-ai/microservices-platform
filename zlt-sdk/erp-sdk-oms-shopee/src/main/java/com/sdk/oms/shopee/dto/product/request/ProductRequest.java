package com.sdk.oms.shopee.dto.product.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ProductRequest
 * @description: TODO
 * @date 2023年10月23日
 * @version: 1.0
 */
@Data
@Builder
public class ProductRequest implements Serializable {
    String host;
    String path;
    String token;
    long shopId;
    long partnerId;
    String tmpPartnerKey;
    Integer offset;
    Long timeFrom;
    Long timeTo;
    String itemIdList;
}
