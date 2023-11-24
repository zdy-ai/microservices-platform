package com.sdk.tms.shopee.model.logistics.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Weight
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class Weight implements Serializable {
    @JSONField(name = "item_max_weight")
    private Float itemMaxWeight;

    @JSONField(name = "item_min_weight")
    private Float itemMinWeight;
}
