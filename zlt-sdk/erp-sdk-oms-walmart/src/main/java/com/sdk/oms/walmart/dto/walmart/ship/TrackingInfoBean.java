package com.sdk.oms.walmart.dto.walmart.ship;

import com.google.gson.annotations.SerializedName;

public class TrackingInfoBean {
    /**
     * shipDateTime : 1580821866000
     * carrierName : {"carrier":"UPS"}
     * methodCode : Standard
     * trackingNumber : 22344
     * trackingURL : http://walmart/tracking/ups?&type=MP&seller_id=12345&promise_date=03/02/2020&dzip=92840&tracking_numbers=92345
     */

    @SerializedName("shipDateTime")
    private long shipDateTime;
    @SerializedName("carrierName")
    private CarrierNameBean carrierName;
    @SerializedName("methodCode")
    private String methodCode;
    @SerializedName("trackingNumber")
    private String trackingNumber;
    @SerializedName("trackingURL")
    private String trackingURL;

    public long getShipDateTime() {
        return shipDateTime;
    }

    public void setShipDateTime(long shipDateTime) {
        this.shipDateTime = shipDateTime;
    }

    public CarrierNameBean getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(CarrierNameBean carrierName) {
        this.carrierName = carrierName;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingURL() {
        return trackingURL;
    }

    public void setTrackingURL(String trackingURL) {
        this.trackingURL = trackingURL;
    }
}
