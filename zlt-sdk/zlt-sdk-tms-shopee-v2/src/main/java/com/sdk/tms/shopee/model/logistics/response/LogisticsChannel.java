package com.sdk.tms.shopee.model.logistics.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName LogisticsChannel
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class LogisticsChannel implements Serializable {
    @JSONField(name = "logistics_channel_id")
    private Long logisticsChannelId;
    @JSONField(name = "preferred")
    private Boolean preferred;
    @JSONField(name = "logistics_channel_name")
    private String logisticsChannelName;
    @JSONField(name = "cod_enabled")
    private Boolean codEnabled;
    @JSONField(name = "enabled")
    private Boolean enabled;
    @JSONField(name = "fee_type")
    private String feeType;
    @JSONField(name = "logistics_description")
    private String logisticsDescription;
    @JSONField(name = "force_enable")
    private Boolean forceEnable;
    @JSONField(name = "mask_channel_id")
    private Long maskChannelId;
    @JSONField(name = "size_list")
    private List<Size> sizeList;

    @JSONField(name = "weight_limit")
    private Weight weight;

    @JSONField(name = "item_max_dimension")
    private ItemDimension itemDimension;

    @JSONField(name = "volume_limit")
    private Volume volume;
}
