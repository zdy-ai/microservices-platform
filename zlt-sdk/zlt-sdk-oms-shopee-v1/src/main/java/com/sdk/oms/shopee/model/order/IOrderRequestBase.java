package com.sdk.oms.shopee.model.order;

import com.sdk.oms.shopee.model.IRequestBase;

public interface IOrderRequestBase extends IRequestBase {

    /**
     * Get Order Unique Identifier
     *
     * @return order sn
     */
    String getOrdersn();
}
