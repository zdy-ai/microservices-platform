package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Rejected
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
@Data
public class Rejected implements Serializable {
    private Integer index;
    private String trackNo;
    private String courierCode;
    private RejectError error;
}
