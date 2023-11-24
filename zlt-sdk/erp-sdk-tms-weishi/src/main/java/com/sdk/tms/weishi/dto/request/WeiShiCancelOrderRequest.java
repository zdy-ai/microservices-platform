package com.sdk.tms.weishi.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liuruipeng
 */
@Data
@Builder
public class WeiShiCancelOrderRequest {

    //客户参考号
    @JSONField(name = "reference_no")
    @NotNull(message = "客户单号，注：只有草稿、已预报状态支持取消。")
    private String referenceNo;

}
