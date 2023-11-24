package com.sdk.oms.walmart.dto.walmart.item;

import com.google.gson.annotations.SerializedName;

public class GroupingAttributesBean {
    /**
     * name : size
     * value : Anamorphic Lens
     */

    @SerializedName("name")
    private String name;
    @SerializedName("value")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
