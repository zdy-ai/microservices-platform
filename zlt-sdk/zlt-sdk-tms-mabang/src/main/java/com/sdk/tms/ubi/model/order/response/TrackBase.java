package com.sdk.tms.ubi.model.order.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName TrackBase
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class TrackBase implements Serializable {
    private String status;
    private String errors;
    private String warnings;
    private String orderId;
    private Integer relabelStatus;
    private String trackingNo;
    private String lastMileCarrier;
}
