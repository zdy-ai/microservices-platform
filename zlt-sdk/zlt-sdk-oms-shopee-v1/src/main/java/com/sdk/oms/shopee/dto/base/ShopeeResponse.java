package com.sdk.oms.shopee.dto.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ShopBaseEntity
 * @description: 响应实体
 * @date 2023年10月20日
 * @version: 1.0
 */
@Data
public class ShopeeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String error;
    private String message;
    @JSONField(name = "request_id")
    private String requestId;
    private String warning;
    private JSONObject response;
}
