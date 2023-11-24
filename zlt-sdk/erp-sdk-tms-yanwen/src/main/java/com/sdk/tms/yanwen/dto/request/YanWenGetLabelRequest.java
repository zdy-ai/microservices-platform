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
public class YanWenGetLabelRequest {

    //运单号
    @NotBlank(message = "运单号不能为空")
    private String waybillNumber;

    //打印拣货单 1:是; 0:否(不传默认为否)
    private Integer printRemark;

}
