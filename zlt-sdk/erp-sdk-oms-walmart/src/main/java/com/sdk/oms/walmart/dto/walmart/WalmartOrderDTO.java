package com.sdk.oms.walmart.dto.walmart;

import com.google.gson.annotations.SerializedName;
import com.sdk.oms.walmart.dto.walmart.order.ListBean;

public class WalmartOrderDTO {

    @SerializedName("list")
    private ListBean list;

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }
}
