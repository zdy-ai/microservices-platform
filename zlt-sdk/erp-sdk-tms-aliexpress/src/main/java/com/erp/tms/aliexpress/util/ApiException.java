package com.erp.tms.aliexpress.util;

import lombok.Data;

/**
 * @author zdy
 * @ClassName ApiException
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class ApiException extends Exception{
    private static final long serialVersionUID = -238091758285157331L;

    private String errorCode;

    private String errorMessage;

    public ApiException() {}

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String errorCode, String errorMessage) {
        super(errorCode + ":" + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
