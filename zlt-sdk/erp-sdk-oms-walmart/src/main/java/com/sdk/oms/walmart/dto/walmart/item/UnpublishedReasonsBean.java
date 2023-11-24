package com.sdk.oms.walmart.dto.walmart.item;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UnpublishedReasonsBean {
    @SerializedName("reason")
    private List<String> reason;

    public List<String> getReason() {
        return reason;
    }

    public void setReason(List<String> reason) {
        this.reason = reason;
    }
}
