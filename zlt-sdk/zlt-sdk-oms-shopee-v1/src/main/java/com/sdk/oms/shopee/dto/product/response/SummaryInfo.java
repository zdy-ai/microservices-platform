package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName SummaryInfo
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class SummaryInfo implements Serializable {
    @JSONField(name = "total_reserved_stock")
    private Integer totalReservedStock;
    @JSONField(name = "total_available_stock")
    private Integer totalAvailableStock;
}
