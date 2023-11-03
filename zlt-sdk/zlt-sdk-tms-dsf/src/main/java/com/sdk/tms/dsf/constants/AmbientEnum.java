package com.sdk.tms.dsf.constants;

public enum AmbientEnum {
    SANDBOX_ADDRESS("sandbox"),
    FORMAT_ADDRESS("format");

    private String evncValue;

    AmbientEnum(String evncValue) {
        this.evncValue = evncValue;
    }
}
