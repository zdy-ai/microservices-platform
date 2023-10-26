package com.sdk.oms.shopee.core.model;

/**
 * This interface should be implemented by responses that with error base
 */
public interface ErrorBaseResponse {

    /**
     * Get Error Message
     *
     * @return error message
     */
    String getMessage();

    /**
     * Get Error Code
     *
     * @return response error code
     */
    Error getError();
}
