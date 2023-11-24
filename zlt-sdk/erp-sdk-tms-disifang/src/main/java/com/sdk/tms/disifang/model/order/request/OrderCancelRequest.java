package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.sdk.tms.disifang.model.base.Address;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderRequest
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
@Builder
public class OrderCancelRequest implements Serializable {
    /**
     * 请求单号
     * 是
     */
    @NotBlank(message = "请求单号不能为空")
    @JSONField(name = "request_no")
    private String request_no;

    /**
     * 取消原因
     * 是
     */
    @JSONField(name = "cancel_reason")
    private String cancel_reason;
}
