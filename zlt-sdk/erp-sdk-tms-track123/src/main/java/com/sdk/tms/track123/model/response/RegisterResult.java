package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName RegisterResult
 * @description: TODO
 * @date 2023年11月21日
 * @version: 1.0
 */
@Data
public class RegisterResult implements Serializable {
    private String code;
    private RegisterResponse data;
    private String msg;
}
