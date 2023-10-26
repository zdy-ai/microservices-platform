package com.sdk.oms.shopee.model.globalProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName StockInfo
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class StockInfo implements Serializable {

    @JsonProperty("stock_type")
    private int stockType;

    @JsonProperty("stock_location_id")
    private int stockLocationId;

    @JsonProperty("normal_stock")
    private int normalStock;

    @JsonProperty("reserved_stock")
    private int reservedStock;
}
