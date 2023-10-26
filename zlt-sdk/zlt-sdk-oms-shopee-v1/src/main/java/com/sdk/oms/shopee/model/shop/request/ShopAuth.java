package com.sdk.oms.shopee.model.shop.request;

import com.sdk.oms.shopee.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopAuth implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * partner id.
     */
    protected long id;

    /**
     * partner key
     */
    protected String key;
    /**
     * Token Generation Rule:
     *
     * Hashing.sha256(@id + @redirectUrl) For example:
     *
     * 9b754aba01a5d719cc70c57782941ae6ff90fcc687282908ee480a364901d181https://www.google.com
     *
     *
     */
    protected String token;

    /**
     * redirect url after authorization finished.
     */
    protected String redirectUrl;
}
