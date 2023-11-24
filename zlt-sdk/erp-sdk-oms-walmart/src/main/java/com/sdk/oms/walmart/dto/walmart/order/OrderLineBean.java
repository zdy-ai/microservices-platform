package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class OrderLineBean {
    /**
     * lineNumber : 1
     * item : {"productName":"Protective Vlog Cage for Action 2 - Metal Frame Housing Cage Vlogging Accessories Magnetic Case for DJI Action 2 Power Combo or Dual-Screen Combo","sku":"2872-WM01","imageUrl":"https://i5.walmartimages.com/asr/8a14dd43-262f-4fd0-96c9-0b1bc07a785a.a382d1098548c68f71ffe966d07af095.jpeg"}
     * charges : {"charge":[{"chargeType":"PRODUCT","chargeName":"ItemPrice","chargeAmount":{"currency":"USD","amount":34.99},"tax":{"taxName":"Tax1","taxAmount":{"currency":"USD","amount":3.11}}}]}
     * orderLineQuantity : {"unitOfMeasurement":"EACH","amount":"1"}
     * statusDate : 1697628517427
     * orderLineStatuses : {"orderLineStatus":[{"status":"Created","subSellerId":null,"statusQuantity":{"unitOfMeasurement":"EACH","amount":"1"},"cancellationReason":null,"trackingInfo":null,"returnCenterAddress":null}]}
     * refund : null
     * fulfillment : {"fulfillmentOption":"DELIVERY","shipMethod":"VALUE","storeId":null,"pickUpDateTime":1698692400000,"pickUpBy":null,"shippingProgramType":null}
     */

    @SerializedName("lineNumber")
    private String lineNumber;
    @SerializedName("item")
    private ItemBean item;
    @SerializedName("charges")
    private ChargesBean charges;
    @SerializedName("orderLineQuantity")
    private OrderLineQuantityBean orderLineQuantity;
    @SerializedName("statusDate")
    private long statusDate;
    @SerializedName("orderLineStatuses")
    private OrderLineStatusesBean orderLineStatuses;
    @SerializedName("refund")
    private Object refund;
    @SerializedName("fulfillment")
    private FulfillmentBean fulfillment;

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public ItemBean getItem() {
        return item;
    }

    public void setItem(ItemBean item) {
        this.item = item;
    }

    public ChargesBean getCharges() {
        return charges;
    }

    public void setCharges(ChargesBean charges) {
        this.charges = charges;
    }

    public OrderLineQuantityBean getOrderLineQuantity() {
        return orderLineQuantity;
    }

    public void setOrderLineQuantity(OrderLineQuantityBean orderLineQuantity) {
        this.orderLineQuantity = orderLineQuantity;
    }

    public long getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(long statusDate) {
        this.statusDate = statusDate;
    }

    public OrderLineStatusesBean getOrderLineStatuses() {
        return orderLineStatuses;
    }

    public void setOrderLineStatuses(OrderLineStatusesBean orderLineStatuses) {
        this.orderLineStatuses = orderLineStatuses;
    }

    public Object getRefund() {
        return refund;
    }

    public void setRefund(Object refund) {
        this.refund = refund;
    }

    public FulfillmentBean getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(FulfillmentBean fulfillment) {
        this.fulfillment = fulfillment;
    }
}
