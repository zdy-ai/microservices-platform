package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName TrackDetail
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class TrackDetail implements Serializable {
    private String id;
    private String trackNo;
    private String createTime;
    private String nextUpdateTime;
    private String orderNo;
    private String customerEmail;
    private String shipFrom;
    private String shipTo;
    private String trackingStatus;
    private String transitStatus;
    private String transitSubStatus;
    private String shipTime;
    private String orderTime;
    private String receiptTime;
    private String deliveredTime;
    private String lastTrackingTime;
    private Integer transitDays;
    private Integer stayDays;
    private Integer deliveredDays;
    private String remark;
    //当地物流
    private LocalLogisticsInfo localLogisticsInfo;
    private String expectedDelivery;
    private String shipmentType;
    //最后一公里
    private LastMileInfo lastMileInfo;
}
