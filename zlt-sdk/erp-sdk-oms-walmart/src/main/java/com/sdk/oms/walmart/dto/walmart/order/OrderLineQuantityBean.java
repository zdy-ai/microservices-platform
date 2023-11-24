package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class OrderLineQuantityBean {
    /**
     * unitOfMeasurement : EACH
     * amount : 1
     */

    @SerializedName("unitOfMeasurement")
    private String unitOfMeasurement;
    @SerializedName("amount")
    private Integer amount;

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
