package com.sdk.oms.shopee.model.order.response;

import com.sdk.oms.shopee.model.ObjectResult;
import lombok.Data;

@Data
public class EscrowDetails extends ObjectResult<EscrowDetail> {

    public static final long serialVersionUID = 1L;

    /**
     * Order Detail Information
     */
    private EscrowDetail order;

    @Override
    protected EscrowDetail value() {
        return order;
    }
}
