package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class ShipNodeBean {
    /**
     * type : SellerFulfilled
     */

    @SerializedName("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
