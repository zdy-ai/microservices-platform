package com.erp.tms.aliexpress.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName BaseResult
 * @description: TODO
 * @date 2023年11月22日
 * @version: 1.0
 */
@Data
public class BaseResult implements Serializable {
    private String result;
    @JSONField(name = "request_id")
    private String requestId;
}
