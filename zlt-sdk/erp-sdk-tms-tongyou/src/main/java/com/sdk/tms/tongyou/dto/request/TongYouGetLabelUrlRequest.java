package com.sdk.tms.tongyou.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liuruipeng
 */
@Data
@Builder
public class TongYouGetLabelUrlRequest {

    //客户参考号
    @JSONField(name = "reference_no")
    @NotNull(message = "客户参考号不能为空")
    private String referenceNo;

    //PDF标签尺寸类型：1：10 * 10 标签 2：A4纸 3：10 * 15标签
    @JSONField(name = "lable_type")
    private String lableType;

}
