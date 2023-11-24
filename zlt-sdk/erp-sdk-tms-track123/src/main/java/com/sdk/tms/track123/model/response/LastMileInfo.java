package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName LastMileInfo
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class LastMileInfo implements Serializable {
    private String lmTrackNo;
    private LocalLogisticsInfo openApiWayBillInfo;
}
