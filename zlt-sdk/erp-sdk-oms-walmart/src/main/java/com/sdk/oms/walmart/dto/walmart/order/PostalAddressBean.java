package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class PostalAddressBean {
    /**
     * name : Zedi online Adil Waseem
     * address1 : 17715 149th Road
     * address2 : null
     * city : Jamaica
     * state : NY
     * postalCode : 11434
     * country : USA
     * addressType : OFFICE
     */

    @SerializedName("name")
    private String name;
    @SerializedName("address1")
    private String address1;
    @SerializedName("address2")
    private Object address2;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("postalCode")
    private String postalCode;
    @SerializedName("country")
    private String country;
    @SerializedName("addressType")
    private String addressType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public Object getAddress2() {
        return address2;
    }

    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
