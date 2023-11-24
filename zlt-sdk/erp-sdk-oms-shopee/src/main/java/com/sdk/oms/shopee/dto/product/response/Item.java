package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Image
 * @description: TODO
 * @date 2023年10月20日
 * @version: 1.0
 */
@Data
public class Item implements Serializable {
    @JSONField(name = "item_id")
    private Long itemId;
    @JSONField(name = "item_status")
    private String itemStatus;
    @JSONField(name = "update_time")
    private Long updateTime;
}
