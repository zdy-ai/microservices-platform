package com.sdk.tms.yanwen.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liuruipeng
 * @date 2023年10月30日 11:44
 */
@Data
@Builder
public class YanWenCancelOrderRequest {

    //运单号
    @NotBlank(message = "运单号不能为空")
    private String waybillNumber;

    //取消原因
    private String note;

}
