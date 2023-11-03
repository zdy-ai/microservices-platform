package com.sdk.tms.dsf.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName OrderRequest
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
@Data
public class OrderRequest implements Serializable {
    /**
     * 预约时间，格式为：yyyy-MM-dd
     */
    @JSONField(name = "reserve_time")
    private String reserveTime;
    /**
     * 揽收地址信息
     */
    @JSONField(name = "pickup_info")
    private PickupInfo pickupInfo;
}
