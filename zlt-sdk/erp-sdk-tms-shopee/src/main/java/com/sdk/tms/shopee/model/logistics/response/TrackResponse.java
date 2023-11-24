package com.sdk.tms.shopee.model.logistics.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName TrackResponse
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class TrackResponse implements Serializable {
    @JSONField(name = "tracking_number")
    private String trackingNumber;
    @JSONField(name = "plp_number")
    private String plpNumber;
    @JSONField(name = "first_mile_tracking_number")
    private String firstMileTrackingNumber;
    @JSONField(name = "last_mile_tracking_number")
    private String lastMileTrackingNumber;
    @JSONField(name = "hint")
    private String hint;

}
