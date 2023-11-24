package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName OrderRequest
 * @description: 申请|取消拦截订单
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
@Builder
public class OrderInterceptRequest implements Serializable {
    /**
     * 请求单号
     * 是
     */
    @NotBlank(message = "请求单号不能为空")
    @JSONField(name = "request_no")
    private String request_no;
    /**
     * 拦截指令（可选值，拦截：Y；取消拦截：N）
     * 是
     */
    @JSONField(name = "request_no")
    private String is_hold;
    /**
     * 拦截原因
     * 是
     */
    @JSONField(name = "hold_reason")
    private String holdReason;

}
