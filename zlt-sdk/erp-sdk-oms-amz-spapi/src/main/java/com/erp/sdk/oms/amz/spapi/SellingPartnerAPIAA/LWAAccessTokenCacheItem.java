package com.erp.sdk.oms.amz.spapi.SellingPartnerAPIAA;

import lombok.Data;

@Data
class LWAAccessTokenCacheItem {

    private String accessToken;
    private long accessTokenExpiredTime;

}
