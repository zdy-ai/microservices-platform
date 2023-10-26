package com.sdk.oms.shopee.dto.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ShopeeAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Name of the shop.
     */
    @JSONField(name = "access_token")
    protected String accessToken;

    /**
     * Description of the shop.
     */
    @JSONField(name = "refresh_token")
    protected String refreshToken;

    /**
     * List of videos URLs of the shop.
     */
    @JSONField(name = "merchant_id_list")
    @Singular
    protected List<Long> merchantIdList;

    /**
     * List of images URLs of the shop.
     */
    @JSONField(name = "shop_id_list")
    @Singular
    protected List<Long> shopIdList;
    /**
     * Allow negotiations or not, 1: don't allow, 0: allow.
     */
    @JSONField(name = "expire_in")
    protected long expireIn;

    private String message;

    private String error;

    /**
     * The identifier for an API request for error tracking which is used by every request
     */
    @JSONField(name = "request_id")
    private String requestId;
}
