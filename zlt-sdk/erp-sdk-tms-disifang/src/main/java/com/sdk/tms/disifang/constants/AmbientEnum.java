package com.sdk.tms.disifang.constants;

public enum AmbientEnum {
    TEST_ADDRESS("sandbox"),
    FORMAT_ADDRESS("format");

    private String evncValue;

    AmbientEnum(String evncValue) {
        this.evncValue = evncValue;
    }
}
