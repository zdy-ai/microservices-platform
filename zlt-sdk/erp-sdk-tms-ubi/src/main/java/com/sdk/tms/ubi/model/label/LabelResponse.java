package com.sdk.tms.ubi.model.label;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName LabelResponse
 * @description: TODO
 * @date 2023年11月09日
 * @version: 1.0
 */
@Data
public class LabelResponse implements Serializable {
    private String status;
    private String errors;
    private String labelContent;
    private String orderId;
    private String trackingNo;
    private String labelContents;
    private String lastMileCarrier;
    private String masterRefno;
    private String connoteId;
}
