package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class TaxAmountBean {
    /**
     * currency : USD
     * amount : 3.11
     */

    @SerializedName("currency")
    private String currency;
    @SerializedName("amount")
    private double amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
