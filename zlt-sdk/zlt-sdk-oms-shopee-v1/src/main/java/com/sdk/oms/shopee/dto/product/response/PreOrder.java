package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName PreOrder
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class PreOrder implements Serializable {
    @JSONField(name = "is_pre_order")
    private boolean isPreOrder;
    @JSONField(name = "days_to_ship")
    private Long daysToShip;
}
