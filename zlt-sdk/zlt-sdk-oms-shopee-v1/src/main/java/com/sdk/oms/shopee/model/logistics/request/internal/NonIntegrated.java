package com.sdk.oms.shopee.model.logistics.request.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NonIntegrated implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The tracking number assigned by the shipping carrier for item shipment.
     */
    @JsonProperty("tracking_no")
    private String trackingNo;
}
