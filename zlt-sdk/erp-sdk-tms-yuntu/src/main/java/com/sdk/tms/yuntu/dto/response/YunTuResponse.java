package com.sdk.tms.yuntu.dto.response;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class YunTuResponse<T> implements Serializable {
    private String code;
    private String message;
    private String requestId;
    private String timeStamp;

    @Getter(value= AccessLevel.NONE)
    private T item;

    @Getter(value=AccessLevel.NONE)
    private T items;

    //获取对象
    private T data;

    public T getData() {
        if(item != null){
            return item;
        }
        return items;
    }
}
