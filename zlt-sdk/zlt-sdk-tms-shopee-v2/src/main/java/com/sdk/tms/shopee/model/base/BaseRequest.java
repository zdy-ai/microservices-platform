package com.sdk.tms.shopee.model.base;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName BaseRequest
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class BaseRequest implements Serializable {
    private Long partnerId;
    private Long timestamp;
    private String accessToken;
    private Long shopId;
    private String sign;
    private String path;
    private String host;
    private String partnerKey;
    private Integer pageSize;
    private String cursor;
}
