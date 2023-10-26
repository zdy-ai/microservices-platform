package com.sdk.oms.shopee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.Error;
import com.sdk.oms.shopee.core.model.ErrorBaseResponse;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.common.ResponseError;
import lombok.Data;

@Data
public class ErrorResponse implements ErrorBaseResponse, ModelEntity {

    public static final long serialVersionUID = 1L;

    private String message;

    private ResponseError error;

    /**
     * The identifier for an API request for error tracking which is used by every request
     */
    @JsonProperty("request_id")
    private String requestId;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Error getError() {
        return error;
    }
}
