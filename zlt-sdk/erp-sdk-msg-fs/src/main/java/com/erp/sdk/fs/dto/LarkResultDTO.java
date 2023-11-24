package com.erp.sdk.fs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 飞书返回结果接收类
 *
 * @Author Cloud
 * @Date 2023/3/9 14:29
 **/

@Data
@NoArgsConstructor
public class LarkResultDTO<T> {

    private Integer code;

    private String msg;

    private T data;
}
