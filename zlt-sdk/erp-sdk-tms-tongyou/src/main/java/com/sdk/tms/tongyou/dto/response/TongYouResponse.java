package com.sdk.tms.tongyou.dto.response;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class TongYouResponse<T> implements Serializable {

    private Boolean success;

    //消息提示
    private String code;

    //消息提示
    private String msg;

    private String detail;

    private T data;

    @Getter(value= AccessLevel.NONE)
    private T channelInfos;

    public T getData() {
        if(channelInfos != null){
            return channelInfos;
        }
        return data;
    }

}
