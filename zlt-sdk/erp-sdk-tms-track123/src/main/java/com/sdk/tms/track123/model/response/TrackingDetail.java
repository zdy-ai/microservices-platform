package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zdy
 * @ClassName TrackingDetail
 * @description: 轨迹明细
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class TrackingDetail implements Serializable {
    private String address;
    private String eventTime;
    private LocalDateTime eventTimeZeroUTC;
    private String timezone;
    private String eventDetail;
    private String transitSubStatus;
}
