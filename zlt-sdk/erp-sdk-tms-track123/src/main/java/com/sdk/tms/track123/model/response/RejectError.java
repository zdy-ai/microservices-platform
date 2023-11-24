package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName RejectError
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
@Data
public class RejectError implements Serializable {
    private String code;
    private String msg;
}
