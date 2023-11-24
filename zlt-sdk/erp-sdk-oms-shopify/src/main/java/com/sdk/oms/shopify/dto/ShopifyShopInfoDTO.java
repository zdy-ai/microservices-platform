package com.sdk.oms.shopify.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 平台Shopify 店铺 DTO
 *
 * @Author Jim
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ShopifyShopInfoDTO {

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
     * SHOP_NAME.myshopify.com
     */
    private String shopDomain;


}
