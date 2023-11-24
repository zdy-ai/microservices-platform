package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChargesBean {
    @SerializedName("charge")
    private List<ChargeBean> charge;

    public List<ChargeBean> getCharge() {
        return charge;
    }

    public void setCharge(List<ChargeBean> charge) {
        this.charge = charge;
    }
}
