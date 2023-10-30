package com.sdk.tms.ubi.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName BaseResult
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = -1L;
    private String status;
    private String errors;
    private String warnings;
    private T data;
}
