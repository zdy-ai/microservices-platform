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
public class TongYouCallBackOrderRequest {

    //物流编码
    @NotNull(message = "物流编码不能为空")
    private String logisticsId;

    //订单编号
    @NotNull(message = "订单编号不能为空")
    private String orderNo;

}
