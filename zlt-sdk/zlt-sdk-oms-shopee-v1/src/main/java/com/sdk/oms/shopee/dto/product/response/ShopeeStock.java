package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ShopeeStock
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class ShopeeStock implements Serializable {
    @JSONField(name = "location_id")
    private String locationId;
    @JSONField(name = "stock")
    private Integer stock;
}
