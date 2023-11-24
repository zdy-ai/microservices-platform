package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class StatusQuantityBean {
    /**
     * unitOfMeasurement : EACH
     * amount : 1
     */

    @SerializedName("unitOfMeasurement")
    private String unitOfMeasurement;
    @SerializedName("amount")
    private String amount;

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
