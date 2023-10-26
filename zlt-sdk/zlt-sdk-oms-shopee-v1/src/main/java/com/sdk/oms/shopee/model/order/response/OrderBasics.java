package com.sdk.oms.shopee.model.order.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.common.ListResult;
import com.sdk.oms.shopee.model.common.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class OrderBasics implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    /**
     * Enumerated type that defines the current status of the order.
     */
    @JsonProperty("order_status")
    private OrderStatus status;

    /**
     * Update time for the note.
     */
    @JsonProperty("update_time")
    private String updateTime;

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class OrderBasicsList extends ListResult<OrderBasics> {

        public static final long serialVersionUID = 1L;

        private List<OrderBasics> orders;

        private boolean more;

        @Override
        protected List<OrderBasics> value() {
            return orders;
        }

        @Override
        public boolean hasMore() {
            return more;
        }
    }


}
