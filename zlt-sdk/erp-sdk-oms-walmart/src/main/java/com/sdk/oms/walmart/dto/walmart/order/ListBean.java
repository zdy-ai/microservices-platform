package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class ListBean {

    @SerializedName("meta")
    private MetaBean meta;
    @SerializedName("elements")
    private ElementsBean elements;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public ElementsBean getElements() {
        return elements;
    }

    public void setElements(ElementsBean elements) {
        this.elements = elements;
    }
}
