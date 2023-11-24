package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderLinesBean {
    @SerializedName("orderLine")
    private List<OrderLineBean> orderLine;

    public List<OrderLineBean> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLineBean> orderLine) {
        this.orderLine = orderLine;
    }
}
