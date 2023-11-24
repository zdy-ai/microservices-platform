package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class TaxBean {
    /**
     * taxName : Tax1
     * taxAmount : {"currency":"USD","amount":3.11}
     */

    @SerializedName("taxName")
    private String taxName;
    @SerializedName("taxAmount")
    private TaxAmountBean taxAmount;

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public TaxAmountBean getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(TaxAmountBean taxAmount) {
        this.taxAmount = taxAmount;
    }
}
