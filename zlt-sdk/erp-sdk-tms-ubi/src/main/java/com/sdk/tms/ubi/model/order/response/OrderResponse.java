package com.sdk.tms.ubi.model.order.response;

import cn.hutool.json.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderResponse
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class OrderResponse implements Serializable {
    private String status;
    private String errors;
    private String warnings;
    private String orderId;
    private String referenceNo;
    private String trackingNo;
    private String connoteId;
    private List<OrderResponse> piecesResult;
    private JSONObject extraProperty;
}
