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
public class TongYouInterceptOrderRequest {

    //客户参考号
    @JSONField(name = "reference_no")
    @NotNull(message = "客户单号，注：只有预报、已入库状态支持拦截。")
    private String referenceNo;

}
