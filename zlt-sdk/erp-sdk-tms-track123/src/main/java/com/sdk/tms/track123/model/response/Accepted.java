package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Accepted
 * @description: TODO
 * @date 2023年11月21日
 * @version: 1.0
 */
@Data
public class Accepted implements Serializable {
    private String trackNo;
    private String courierCode;
    private String orderNo;
    private String country;
    private String shipTime;
    private String customerEmail;
    private String remark;

}
