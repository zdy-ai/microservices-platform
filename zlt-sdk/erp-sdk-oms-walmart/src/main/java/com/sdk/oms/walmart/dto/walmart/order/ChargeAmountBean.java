package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class ChargeAmountBean {
    /**
     * currency : USD
     * amount : 34.99
     */

    @SerializedName("currency")
    private String currency;
    @SerializedName("amount")
    private BigDecimal amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
