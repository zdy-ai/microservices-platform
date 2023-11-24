package com.sdk.oms.walmart.dto.walmart.ship;

import com.google.gson.annotations.SerializedName;

public class CarrierNameBean {
    /**
     * carrier : UPS
     */

    @SerializedName("carrier")
    private String carrier;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}
