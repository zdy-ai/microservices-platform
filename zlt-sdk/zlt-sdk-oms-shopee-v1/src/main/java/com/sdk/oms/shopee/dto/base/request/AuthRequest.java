package com.sdk.oms.shopee.dto.base.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName AuthRequest
 * @description: TODO
 * @date 2023年10月23日
 * @version: 1.0
 */
@Data
@Builder
public class AuthRequest implements Serializable {
    String code;
    String path;
    String host;
    String refreshToken;
    String accessToken;
    long partnerId;
    String tmpPartnerKey;
    long shopId;
    long merchantId;
    long mainAccountId;
    String redirect;
}
