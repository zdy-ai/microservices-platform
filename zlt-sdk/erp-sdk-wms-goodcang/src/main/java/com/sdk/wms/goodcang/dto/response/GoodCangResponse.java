package com.sdk.wms.goodcang.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor
public class GoodCangResponse<T> implements Serializable {

    //Success 表示成功。
    private String ask;

    //0 表示成功。
    private Integer code;

    private String message;

    //总数
    private Integer count;

    private T data;

    //入库单状态
    @JSONField(name = "receiving_status")
    private Integer receivingStatus;

    //入库单类型
    @JSONField(name = "transit_type")
    private Integer transitType;

    //订单号
    @JSONField(name = "order_code")
    private String orderCode;

    //取消状态
    @JSONField(name = "cancel_status")
    private Integer cancelStatus;
}
