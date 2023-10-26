package com.sdk.oms.shopee.model.logistics.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.IRequestBase;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class LogisticsIdsRequest implements IRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    @Singular
    @JsonProperty("ordersn_list")
    private List<String> ordersns;

    /**
     * Option to get batch airway bills in single file. Default value is false.
     */
    @JsonProperty("is_batch")
    private boolean batch;

    /**
     * partner Id field that must be included in all request body
     * This is the assigned to partner upon registration
     */
    @JsonProperty("partner_id")
    private long partnerId;

    /**
     * shopid field that must be included in all request body
     * One partner might have multiple associated shopids, please use the correct shopid.
     */
    @JsonProperty("shopid")
    private long shopId;

    /**
     * timestamp field that must be included in all request body
     *
     * Please put the current UNIX timestamp when making a request
     */
    private long timestamp;
}

