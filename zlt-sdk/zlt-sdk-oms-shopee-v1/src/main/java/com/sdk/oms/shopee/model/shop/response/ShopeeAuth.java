package com.sdk.oms.shopee.model.shop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.ErrorResponse;
import lombok.*;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ShopeeAuth extends ErrorResponse implements ModelEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Name of the shop.
     */
    @JsonProperty("access_token")
    protected String accessToken;

    /**
     * Description of the shop.
     */
    @JsonProperty("refresh_token")
    protected String refreshToken;

    /**
     * List of videos URLs of the shop.
     */
    @JsonProperty("merchant_id_list")
    @Singular
    protected List<Long> merchantIdList;

    /**
     * List of images URLs of the shop.
     */
    @JsonProperty("shop_id_list")

    @Singular
    protected List<Long> shopIdList;

    /**
     * Allow negotiations or not, 1: don't allow, 0: allow.
     */
    @JsonProperty("expire_in")
    protected long expireIn;
}
