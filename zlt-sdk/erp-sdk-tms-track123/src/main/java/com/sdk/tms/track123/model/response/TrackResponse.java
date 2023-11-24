package com.sdk.tms.track123.model.response;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName TrackResponse
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class TrackResponse<T> implements Serializable {
    private String code;
    private ResponseData data;
    private String msg;
}
