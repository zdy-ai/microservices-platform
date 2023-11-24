package com.sdk.tms.express.model.order.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderUpdateRequest
 * @description: TODO
 * @date 2023年10月31日
 * @version: 1.0
 */
@Data
@Builder
public class OrderQueryRequest implements Serializable {
    /**
     * 客户订单号
     * 是
     */
    @NotBlank(message = "客户订单号不能为空")
    private String orderId;
    /**
     * 查询类型：1正向单 2退货单
     */
    private Integer searchType;
    /**
     * 响应报文的语言， 缺省值为zh-CN，目前支持以下值zh-CN 表示中文简体， zh-TW或zh-HK或 zh-MO表示中文繁体， en表示英文
     */
    private String language;
}
