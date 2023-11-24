package com.sdk.tms.tongyou.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author liuruipeng
 */
@Data
@Builder
@ToString
public class TongYouGetOrderRequest {

    //订单号
    @NotNull(message = "订单编号不能为空")
    private String orderNo;

    //追踪条码（订单号与追踪条码必填一个）
    private String trackNo;

}
