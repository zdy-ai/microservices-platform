package com.sdk.tms.yuntu.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liuruipeng
 */
@Data
@Builder
public class YunTuGetTrackingNumRequest {

    //客户订单号,多个以逗号分开
    @NotBlank(message = "客户订单号不能为空")
    private String customerOrderNumber;

}
