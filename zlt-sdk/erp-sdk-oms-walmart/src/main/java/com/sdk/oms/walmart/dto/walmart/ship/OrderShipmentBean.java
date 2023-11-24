package com.sdk.oms.walmart.dto.walmart.ship;

import com.google.gson.annotations.SerializedName;

public class OrderShipmentBean {
    /**
     * orderLines : {"orderLine":[{"lineNumber":"1","intentToCancelOverride":false,"sellerOrderId":"92344","orderLineStatuses":{"orderLineStatus":[{"status":"Shipped","statusQuantity":{"unitOfMeasurement":"EACH","amount":"1"},"trackingInfo":{"shipDateTime":1580821866000,"carrierName":{"carrier":"UPS"},"methodCode":"Standard","trackingNumber":"22344","trackingURL":"http://walmart/tracking/ups?&type=MP&seller_id=12345&promise_date=03/02/2020&dzip=92840&tracking_numbers=92345"},"returnCenterAddress":{"name":"walmart","address1":"walmart store 2","city":"Huntsville","state":"AL","postalCode":"35805","country":"USA","dayPhone":"12344","emailId":"walmart@walmart.com"}}]}},{"lineNumber":"2","sellerOrderId":"92344","orderLineStatuses":{"orderLineStatus":[{"status":"Shipped","statusQuantity":{"unitOfMeasurement":"EACH","amount":"1"},"trackingInfo":{"shipDateTime":1580821866000,"carrierName":{"carrier":"FedEx"},"methodCode":"Express","trackingNumber":"22344","trackingURL":"http://walmart/tracking/fedEx?&type=MP&seller_id=12345&promise_date=03/02/2020&dzip=92840&tracking_numbers=92344"},"returnCenterAddress":{"name":"walmart","address1":"walmart store 2","city":"Huntsville","state":"AL","postalCode":"35805","country":"USA","dayPhone":"12344","emailId":"walmart@walmart.com"}}]}}]}
     */

    @SerializedName("orderLines")
    private OrderLinesBean orderLines;

    public OrderLinesBean getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(OrderLinesBean orderLines) {
        this.orderLines = orderLines;
    }
}
