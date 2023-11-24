package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class OrderLineStatusBean {
    /**
     * status : Created
     * subSellerId : null
     * statusQuantity : {"unitOfMeasurement":"EACH","amount":"1"}
     * cancellationReason : null
     * trackingInfo : null
     * returnCenterAddress : null
     */

    @SerializedName("status")
    private String status;
    @SerializedName("subSellerId")
    private Object subSellerId;
    @SerializedName("statusQuantity")
    private StatusQuantityBean statusQuantity;
    @SerializedName("cancellationReason")
    private Object cancellationReason;
    @SerializedName("trackingInfo")
    private Object trackingInfo;
    @SerializedName("returnCenterAddress")
    private Object returnCenterAddress;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getSubSellerId() {
        return subSellerId;
    }

    public void setSubSellerId(Object subSellerId) {
        this.subSellerId = subSellerId;
    }

    public StatusQuantityBean getStatusQuantity() {
        return statusQuantity;
    }

    public void setStatusQuantity(StatusQuantityBean statusQuantity) {
        this.statusQuantity = statusQuantity;
    }

    public Object getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(Object cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public Object getTrackingInfo() {
        return trackingInfo;
    }

    public void setTrackingInfo(Object trackingInfo) {
        this.trackingInfo = trackingInfo;
    }

    public Object getReturnCenterAddress() {
        return returnCenterAddress;
    }

    public void setReturnCenterAddress(Object returnCenterAddress) {
        this.returnCenterAddress = returnCenterAddress;
    }
}
