package com.erp.tms.aliexpress.model.channel.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName ChannelResult
 * @description: TODO
 * @date 2023年11月21日
 * @version: 1.0
 */
@Data
public class ChannelResult implements Serializable {
    @JSONField(name = "result_success")
    private Boolean resultSuccess;
    @JSONField(name = "request_id")
    private String requestId;
    @JSONField(name = "error_desc")
    private String errorDesc;
    @JSONField(name = "result_list")
    private List<ChannelResponse> resultList;
}
