package com.sdk.tms.weishi.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liuruipeng
 */
@Data
@Builder
public class WeiShiGetLabelUrlRequest {

    //客户参考号
    @JSONField(name = "reference_no")
    @NotNull(message = "客户参考号不能为空")
    private String referenceNo;

    //PDF标签尺寸类型：1：10 * 10 标签 2：A4纸 3：10 * 15标签
    @JSONField(name = "lable_type")
    private String lableType;

}
