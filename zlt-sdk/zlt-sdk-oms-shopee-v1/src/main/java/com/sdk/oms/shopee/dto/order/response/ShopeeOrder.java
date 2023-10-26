package com.sdk.oms.shopee.dto.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ShopeeOrder
 * @description: TODO
 * @date 2023年10月20日
 * @version: 1.0
 */
@Data
public class ShopeeOrder implements Serializable {

    @JsonProperty("order_sn")
    private String orderSn;

    @JsonProperty("order_status")
    private String orderStatus;
}
