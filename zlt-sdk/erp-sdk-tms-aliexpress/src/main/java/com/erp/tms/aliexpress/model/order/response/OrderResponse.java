package com.erp.tms.aliexpress.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName OrderResponse
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class OrderResponse implements Serializable {
    /**
     * LP单号
     */
    @JSONField(name = "out_order_code")
    private String outOrderCode;
    /**
     * 创建时错误码(1表示无错误)
     */
    @JSONField(name = "error_code")
    private String errorCode;
    /**
     * 创建时错误信息
     */
    @JSONField(name = "error_desc")
    private String errorDesc;
    /**
     * 国际运单号
     */
    @JSONField(name = "intl_tracking_no")
    private String intlTrackingNo;
    /**
     * 外部订单号
     */
    @JSONField(name = "out_order_id")
    private String outOrderId;
    /**
     *
     * 创建订单是否成功
     */
    @JSONField(name = "success")
    private Boolean success;
    /**
     * 订单来源
     */
    @JSONField(name = "trade_order_from")
    private String tradeOrderFrom;
    /**
     * 交易订单号
     */
    @JSONField(name = "trade_order_id")
    private String tradeOrderId;
    /**
     * 物流订单号
     */
    @JSONField(name = "warehouse_order_id")
    private String warehouseOrderId;

}
