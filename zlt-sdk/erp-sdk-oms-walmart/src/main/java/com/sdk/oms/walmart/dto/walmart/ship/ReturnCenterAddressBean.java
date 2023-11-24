package com.sdk.oms.walmart.dto.walmart.ship;

import com.google.gson.annotations.SerializedName;

public class ReturnCenterAddressBean {
    /**
     * name : walmart
     * address1 : walmart store 2
     * city : Huntsville
     * state : AL
     * postalCode : 35805
     * country : USA
     * dayPhone : 12344
     * emailId : walmart@walmart.com
     */

    @SerializedName("name")
    private String name;
    @SerializedName("address1")
    private String address1;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("postalCode")
    private String postalCode;
    @SerializedName("country")
    private String country;
    @SerializedName("dayPhone")
    private String dayPhone;
    @SerializedName("emailId")
    private String emailId;

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

    public String getDayPhone() {
        return dayPhone;
    }

    public void setDayPhone(String dayPhone) {
        this.dayPhone = dayPhone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
