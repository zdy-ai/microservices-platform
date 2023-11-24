package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName LocalLogisticsInfo
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class LocalLogisticsInfo implements Serializable {
    private String courierCode;
    private String courierNameCN;
    private String courierNameEN;
    private String courierHomePage;
    private List<TrackingDetail> trackingDetails;
}
