package com.erp.tms.aliexpress.model.label.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.erp.tms.aliexpress.model.channel.response.ChannelResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName LabelResult
 * @description: TODO
 * @date 2023年11月22日
 * @version: 1.0
 */
@Data
public class LabelResult implements Serializable {
    @JSONField(name = "result_success")
    private Boolean resultSuccess;
    @JSONField(name = "request_id")
    private String requestId;
    @JSONField(name = "result")
    private String result;
}
