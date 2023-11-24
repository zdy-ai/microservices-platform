package com.sdk.oms.walmart.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 沃尔玛店铺信息
 * @Author Luo_WG
 * @Date 2023/10/18 14:02
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class WalmartShopInfoDTO {

    /**
     * 店铺ID
     */
    private String id;

    /**
     * 访问token
     */
    private String accessToken;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 区域id
     */
    private String dictAreaCode;

    /**
     * 国家id
     */
    private String dictCountryCode;

    /**
     * 负责人id
     */
    private String chargeId;

    /**
     * 店铺全域名
     */
    private String shopDomain;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 客户端secret
     */
    private String clientSecret;
}
