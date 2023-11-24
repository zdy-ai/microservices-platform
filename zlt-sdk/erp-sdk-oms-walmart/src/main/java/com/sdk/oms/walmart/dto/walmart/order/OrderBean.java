package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class OrderBean {
    /**
     * purchaseOrderId : 108829272810783
     * customerOrderId : 200011419023224
     * customerEmailId : 4B20D3A3D3F848788AC97C39FBDF85C2@relay.walmart.com
     * orderDate : 1697626717652
     * shippingInfo : {"phone":"8591225014","estimatedDeliveryDate":1698692400000,"estimatedShipDate":1697781600000,"methodCode":"Value","postalAddress":{"name":"Zedi online Adil Waseem","address1":"17715 149th Road","address2":null,"city":"Jamaica","state":"NY","postalCode":"11434","country":"USA","addressType":"OFFICE"}}
     * orderLines : {"orderLine":[{"lineNumber":"1","item":{"productName":"Protective Vlog Cage for Action 2 - Metal Frame Housing Cage Vlogging Accessories Magnetic Case for DJI Action 2 Power Combo or Dual-Screen Combo","sku":"2872-WM01","imageUrl":"https://i5.walmartimages.com/asr/8a14dd43-262f-4fd0-96c9-0b1bc07a785a.a382d1098548c68f71ffe966d07af095.jpeg"},"charges":{"charge":[{"chargeType":"PRODUCT","chargeName":"ItemPrice","chargeAmount":{"currency":"USD","amount":34.99},"tax":{"taxName":"Tax1","taxAmount":{"currency":"USD","amount":3.11}}}]},"orderLineQuantity":{"unitOfMeasurement":"EACH","amount":"1"},"statusDate":1697628517427,"orderLineStatuses":{"orderLineStatus":[{"status":"Created","subSellerId":null,"statusQuantity":{"unitOfMeasurement":"EACH","amount":"1"},"cancellationReason":null,"trackingInfo":null,"returnCenterAddress":null}]},"refund":null,"fulfillment":{"fulfillmentOption":"DELIVERY","shipMethod":"VALUE","storeId":null,"pickUpDateTime":1698692400000,"pickUpBy":null,"shippingProgramType":null}}]}
     * shipNode : {"type":"SellerFulfilled"}
     */

    @SerializedName("purchaseOrderId")
    private String purchaseOrderId;
    @SerializedName("customerOrderId")
    private String customerOrderId;
    @SerializedName("customerEmailId")
    private String customerEmailId;
    @SerializedName("orderDate")
    private long orderDate;
    @SerializedName("shippingInfo")
    private ShippingInfoBean shippingInfo;
    @SerializedName("orderLines")
    private OrderLinesBean orderLines;
    @SerializedName("shipNode")
    private ShipNodeBean shipNode;

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public ShippingInfoBean getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfoBean shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public OrderLinesBean getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(OrderLinesBean orderLines) {
        this.orderLines = orderLines;
    }

    public ShipNodeBean getShipNode() {
        return shipNode;
    }

    public void setShipNode(ShipNodeBean shipNode) {
        this.shipNode = shipNode;
    }
}
