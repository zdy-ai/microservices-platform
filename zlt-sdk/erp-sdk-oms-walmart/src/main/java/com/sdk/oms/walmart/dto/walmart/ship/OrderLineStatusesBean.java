package com.sdk.oms.walmart.dto.walmart.ship;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderLineStatusesBean {
    @SerializedName("orderLineStatus")
    private List<OrderLineStatusBean> orderLineStatus;

    public List<OrderLineStatusBean> getOrderLineStatus() {
        return orderLineStatus;
    }

    public void setOrderLineStatus(List<OrderLineStatusBean> orderLineStatus) {
        this.orderLineStatus = orderLineStatus;
    }
}
