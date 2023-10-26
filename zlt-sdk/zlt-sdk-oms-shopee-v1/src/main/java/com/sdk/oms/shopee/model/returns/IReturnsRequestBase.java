package com.sdk.oms.shopee.model.returns;

import com.sdk.oms.shopee.model.IRequestBase;

public interface IReturnsRequestBase extends IRequestBase {

    /**
     * Get Order Unique Identifier
     *
     * @return order sn
     */
    String getReturnsn();
}
