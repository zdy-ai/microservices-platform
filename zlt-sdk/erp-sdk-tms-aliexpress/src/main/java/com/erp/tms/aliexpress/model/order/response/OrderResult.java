package com.erp.tms.aliexpress.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.erp.tms.aliexpress.model.channel.response.ChannelResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderResult
 * @description: TODO
 * @date 2023年11月22日
 * @version: 1.0
 */
@Data
public class OrderResult implements Serializable {
    @JSONField(name = "result_success")
    private Boolean resultSuccess;
    @JSONField(name = "request_id")
    private String requestId;
    @JSONField(name = "error_desc")
    private String errorDesc;
    @JSONField(name = "error_code")
    private String errorCode;
    @JSONField(name = "result")
    private OrderResponse result;
    @JSONField(name = "error_response")
    private ErrorResponse errorResponse;
}
