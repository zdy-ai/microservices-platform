package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.sdk.tms.disifang.model.base.Address;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName PickUp
 * @description: 上门揽收信息
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class PickUp implements Serializable {
    /**
     * 期望提货最早时间（*注：时间格式的传入值需要转换为long类型格式。）
     */
    @JSONField(name = "expect_pick_up_earliest_time")
    private Long expect_pick_up_earliest_time;
    /**
     * 期望提货最迟时间（*注：时间格式的传入值需要转换为long类型格式。）
     */
    @JSONField(name = "expect_pick_up_latest_time")
    private Long expect_pick_up_latest_time;
    /**
     * 	收货地址
     */
    @JSONField(name = "pick_up_address_info")
    private Address pick_up_address_info;
}
