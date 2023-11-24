package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class ShippingInfoBean {
    /**
     * phone : 8591225014
     * estimatedDeliveryDate : 1698692400000
     * estimatedShipDate : 1697781600000
     * methodCode : Value
     * postalAddress : {"name":"Zedi online Adil Waseem","address1":"17715 149th Road","address2":null,"city":"Jamaica","state":"NY","postalCode":"11434","country":"USA","addressType":"OFFICE"}
     */

    @SerializedName("phone")
    private String phone;
    @SerializedName("estimatedDeliveryDate")
    private long estimatedDeliveryDate;
    @SerializedName("estimatedShipDate")
    private long estimatedShipDate;
    @SerializedName("methodCode")
    private String methodCode;
    @SerializedName("postalAddress")
    private PostalAddressBean postalAddress;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(long estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public long getEstimatedShipDate() {
        return estimatedShipDate;
    }

    public void setEstimatedShipDate(long estimatedShipDate) {
        this.estimatedShipDate = estimatedShipDate;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public PostalAddressBean getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddressBean postalAddress) {
        this.postalAddress = postalAddress;
    }
}
