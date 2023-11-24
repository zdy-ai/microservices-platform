package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ElementsBean {
    @SerializedName("order")
    private List<OrderBean> order;

    public List<OrderBean> getOrder() {
        return order;
    }

    public void setOrder(List<OrderBean> order) {
        this.order = order;
    }
}
