package com.sdk.tms.shopee.model.logistics.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName TrackNumber
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class TrackNumber implements Serializable {
    @JSONField(name = "first_mile_tracking_number")
    private String firstMileTrackingNumber;
    private String status;
    @JSONField(name = "declare_date")
    private String declareDate;
}
