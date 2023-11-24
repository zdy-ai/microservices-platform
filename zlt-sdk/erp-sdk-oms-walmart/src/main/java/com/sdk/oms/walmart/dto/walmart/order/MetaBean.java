package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class MetaBean {
    /**
     * totalCount : 309
     * limit : 200
     * nextCursor : ?limit=200&hasMoreElements=true&soIndex=309&poIndex=200&partnerId=10001115597&sellerId=101096235&createdStartDate=2022-01-01T00:00:00&createdEndDate=2024-10-07T00:00:00&lastModifiedStartDate=2022-01-01T00:00:00&lastModifiedEndDate=2024-10-07T00:00:00&productInfo=true&shipNodeType=SellerFulfilled
     */

    @SerializedName("totalCount")
    private int totalCount;
    @SerializedName("limit")
    private int limit;
    @SerializedName("nextCursor")
    private String nextCursor;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }
}
