package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName SelfSendTo4px
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class SelfSendTo4px implements Serializable {
    /**
     * 预约送仓最早时间（*注：时间格式的传入值需要转换为long类型格式。）
     */
    @JSONField(name = "booking_earliest_time")
    private Long booking_earliest_time;
    /**
     * 预约送仓最晚时间（*注：时间格式的传入值需要转换为long类型格式。）
     */
    @JSONField(name = "booking_latest_time")
    private Long booking_latest_time;
}
