package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class FulfillmentBean {
    /**
     * fulfillmentOption : DELIVERY
     * shipMethod : VALUE
     * storeId : null
     * pickUpDateTime : 1698692400000
     * pickUpBy : null
     * shippingProgramType : null
     */

    @SerializedName("fulfillmentOption")
    private String fulfillmentOption;
    @SerializedName("shipMethod")
    private String shipMethod;
    @SerializedName("storeId")
    private Object storeId;
    @SerializedName("pickUpDateTime")
    private long pickUpDateTime;
    @SerializedName("pickUpBy")
    private Object pickUpBy;
    @SerializedName("shippingProgramType")
    private Object shippingProgramType;

    public String getFulfillmentOption() {
        return fulfillmentOption;
    }

    public void setFulfillmentOption(String fulfillmentOption) {
        this.fulfillmentOption = fulfillmentOption;
    }

    public String getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }

    public Object getStoreId() {
        return storeId;
    }

    public void setStoreId(Object storeId) {
        this.storeId = storeId;
    }

    public long getPickUpDateTime() {
        return pickUpDateTime;
    }

    public void setPickUpDateTime(long pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    public Object getPickUpBy() {
        return pickUpBy;
    }

    public void setPickUpBy(Object pickUpBy) {
        this.pickUpBy = pickUpBy;
    }

    public Object getShippingProgramType() {
        return shippingProgramType;
    }

    public void setShippingProgramType(Object shippingProgramType) {
        this.shippingProgramType = shippingProgramType;
    }
}
