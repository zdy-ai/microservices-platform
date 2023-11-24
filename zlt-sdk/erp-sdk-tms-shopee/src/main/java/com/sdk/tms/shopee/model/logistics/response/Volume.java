package com.sdk.tms.shopee.model.logistics.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Volume
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class Volume implements Serializable {
    @JSONField(name = "item_max_volume")
    private Float itemMaxVolume;
    @JSONField(name = "item_min_volume")
    private Float itemMinVolume;
}
