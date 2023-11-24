package com.sdk.tms.disifang.model.label.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName LabelErrorResponse
 * @description: TODO
 * @date 2023年11月08日
 * @version: 1.0
 */
@Data
public class LabelErrorResponse implements Serializable {
    private String error_code;
    private String error_msg;
    private String error_data;
    private String reference_code;
}
