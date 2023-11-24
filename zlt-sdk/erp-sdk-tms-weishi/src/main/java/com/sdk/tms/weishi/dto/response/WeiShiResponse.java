package com.sdk.tms.weishi.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class WeiShiResponse<T> implements Serializable {

    //响应标志，Success表示成功，Failure表示失败
    private String ask;

    //消息提示
    private String message;

    //消息提示
    private String messageEng;

    private Error error;

    private T data;

    public static WeiShiResponse error(String code, String error) {
        WeiShiResponse apiResult = new WeiShiResponse();
        apiResult.setAsk("Failure");
        apiResult.setMessage(error);
        return apiResult;
    }

    @Data
    public static class Error {

        private String errMessage;

        private String errCode;
    }
}
