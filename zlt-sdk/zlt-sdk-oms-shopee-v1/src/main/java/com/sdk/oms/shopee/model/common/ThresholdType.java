package com.sdk.oms.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ThresholdType {
    UNRECOGNIZED,
    LT,
    GT,
    LTE,
    GTE;

    @JsonCreator
    public static ThresholdType value(String v)
    {
        if (v == null) return UNRECOGNIZED;
        try {
            return valueOf(v.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNRECOGNIZED;
        }
    }

    @JsonValue
    public String value() {
        return name().toLowerCase();
    }
}
