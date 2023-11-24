package com.sdk.tms.shopee.model.logistics.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ItemDimension
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class ItemDimension implements Serializable {
    private float height;
    private float width;
    private float length;
    private String unit;
    @JSONField(name = "dimension_sum")
    private float dimensionSum;
}
