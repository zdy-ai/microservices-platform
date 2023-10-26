package com.sdk.oms.shopee.model.logistics.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ParameterForInit extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Could contain 'address_id' and 'pickup_time_id'.
     */
    private List<String> pickup;

    /**
     * Could contain 'branch_id', 'sender_real_name' or 'tracking_no'.
     */
    private List<String> dropoff;

    /**
     * Could contain 'tracking_no'. If it contains 'tracking_no',
     * should manually input these values in Init API.
     */
    @JsonProperty("non_integrated")
    private List<String> nonIntegrated;
}
