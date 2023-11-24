package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class ChargeBean {
    /**
     * chargeType : PRODUCT
     * chargeName : ItemPrice
     * chargeAmount : {"currency":"USD","amount":34.99}
     * tax : {"taxName":"Tax1","taxAmount":{"currency":"USD","amount":3.11}}
     */

    @SerializedName("chargeType")
    private String chargeType;
    @SerializedName("chargeName")
    private String chargeName;
    @SerializedName("chargeAmount")
    private ChargeAmountBean chargeAmount;
    @SerializedName("tax")
    private TaxBean tax;

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public ChargeAmountBean getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(ChargeAmountBean chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public TaxBean getTax() {
        return tax;
    }

    public void setTax(TaxBean tax) {
        this.tax = tax;
    }
}
