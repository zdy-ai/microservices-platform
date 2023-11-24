package com.sdk.oms.walmart.dto.walmart.item;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VariantGroupInfoBean {
    /**
     * isPrimary : false
     * groupingAttributes : [{"name":"size","value":"Anamorphic Lens"}]
     */

    @SerializedName("isPrimary")
    private boolean isPrimary;
    @SerializedName("groupingAttributes")
    private List<GroupingAttributesBean> groupingAttributes;

    public boolean isIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public List<GroupingAttributesBean> getGroupingAttributes() {
        return groupingAttributes;
    }

    public void setGroupingAttributes(List<GroupingAttributesBean> groupingAttributes) {
        this.groupingAttributes = groupingAttributes;
    }
}
