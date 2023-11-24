package com.sdk.oms.walmart.dto.walmart.ship;

import com.google.gson.annotations.SerializedName;

public class OrderLineBean {
    /**
     * lineNumber : 1
     * intentToCancelOverride : false
     * sellerOrderId : 92344
     * orderLineStatuses : {"orderLineStatus":[{"status":"Shipped","statusQuantity":{"unitOfMeasurement":"EACH","amount":"1"},"trackingInfo":{"shipDateTime":1580821866000,"carrierName":{"carrier":"UPS"},"methodCode":"Standard","trackingNumber":"22344","trackingURL":"http://walmart/tracking/ups?&type=MP&seller_id=12345&promise_date=03/02/2020&dzip=92840&tracking_numbers=92345"},"returnCenterAddress":{"name":"walmart","address1":"walmart store 2","city":"Huntsville","state":"AL","postalCode":"35805","country":"USA","dayPhone":"12344","emailId":"walmart@walmart.com"}}]}
     */

    @SerializedName("lineNumber")
    private String lineNumber;
    @SerializedName("intentToCancelOverride")
    private boolean intentToCancelOverride;
    @SerializedName("sellerOrderId")
    private String sellerOrderId;
    @SerializedName("orderLineStatuses")
    private OrderLineStatusesBean orderLineStatuses;

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public boolean isIntentToCancelOverride() {
        return intentToCancelOverride;
    }

    public void setIntentToCancelOverride(boolean intentToCancelOverride) {
        this.intentToCancelOverride = intentToCancelOverride;
    }

    public String getSellerOrderId() {
        return sellerOrderId;
    }

    public void setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
    }

    public OrderLineStatusesBean getOrderLineStatuses() {
        return orderLineStatuses;
    }

    public void setOrderLineStatuses(OrderLineStatusesBean orderLineStatuses) {
        this.orderLineStatuses = orderLineStatuses;
    }
}
