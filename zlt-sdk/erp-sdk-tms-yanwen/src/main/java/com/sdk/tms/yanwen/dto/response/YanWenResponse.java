package com.sdk.tms.yanwen.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class YanWenResponse<T> implements Serializable {
    private Boolean success;
    private String code;
    private String message;
    private T data;

    public static <T> YanWenResponse<T> error(String code,String error) {
        YanWenResponse<T> apiResult = new YanWenResponse<>();
        apiResult.setSuccess(Boolean.FALSE);
        apiResult.setCode(code);
        apiResult.setMessage(error);
        return apiResult;
    }
}
