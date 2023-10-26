package com.sdk.oms.shopee.core.common;


import com.sdk.oms.shopee.core.model.ModelEntity;

/**
 * Possible Auth Types
 *
 */
public interface Auth extends ModelEntity {

    public enum Type { CREDENTIALS, TOKEN, RAX_APIKEY, TOKENLESS, OAUTH2 }

}
