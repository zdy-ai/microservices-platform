package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName OrderCollectRequest
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCollectRequest implements Serializable {
    /**
     * 预约时间，格式为：yyyy-MM-dd
     */
    @JSONField(name = "reserve_time")
    private String reserveTime;
    /**
     * 揽收地址信息
     */
    @JSONField(name = "pickup_info")
    private PickUpInfo pickupInfo;
}
