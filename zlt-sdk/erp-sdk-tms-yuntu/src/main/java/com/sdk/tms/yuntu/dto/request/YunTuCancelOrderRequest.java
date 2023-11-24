package com.sdk.tms.yuntu.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liuruipeng
 */
@Data
@Builder
public class YunTuCancelOrderRequest {

    //单号类型：1-云途单号,2-客户订单号,3-跟踪号
    @NotNull(message = "单号类型不能为空")
    private Integer orderType;

    //单号
    @NotBlank(message = "单号不能为空")
    private String orderNumber;

}
