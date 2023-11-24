package com.sdk.oms.walmart.dto.walmart.ship;

import com.google.gson.annotations.SerializedName;

public class OrderLineStatusBean {
    /**
     * status : Shipped
     * statusQuantity : {"unitOfMeasurement":"EACH","amount":"1"}
     * trackingInfo : {"shipDateTime":1580821866000,"carrierName":{"carrier":"UPS"},"methodCode":"Standard","trackingNumber":"22344","trackingURL":"http://walmart/tracking/ups?&type=MP&seller_id=12345&promise_date=03/02/2020&dzip=92840&tracking_numbers=92345"}
     * returnCenterAddress : {"name":"walmart","address1":"walmart store 2","city":"Huntsville","state":"AL","postalCode":"35805","country":"USA","dayPhone":"12344","emailId":"walmart@walmart.com"}
     */

    @SerializedName("status")
    private String status;
    @SerializedName("statusQuantity")
    private StatusQuantityBean statusQuantity;
    @SerializedName("trackingInfo")
    private TrackingInfoBean trackingInfo;
    @SerializedName("returnCenterAddress")
    private ReturnCenterAddressBean returnCenterAddress;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StatusQuantityBean getStatusQuantity() {
        return statusQuantity;
    }

    public void setStatusQuantity(StatusQuantityBean statusQuantity) {
        this.statusQuantity = statusQuantity;
    }

    public TrackingInfoBean getTrackingInfo() {
        return trackingInfo;
    }

    public void setTrackingInfo(TrackingInfoBean trackingInfo) {
        this.trackingInfo = trackingInfo;
    }

    public ReturnCenterAddressBean getReturnCenterAddress() {
        return returnCenterAddress;
    }

    public void setReturnCenterAddress(ReturnCenterAddressBean returnCenterAddress) {
        this.returnCenterAddress = returnCenterAddress;
    }
}
