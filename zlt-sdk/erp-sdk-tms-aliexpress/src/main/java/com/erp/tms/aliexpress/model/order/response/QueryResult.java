package com.erp.tms.aliexpress.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName QueryResult
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class QueryResult implements Serializable {

    /**
     *
     * 物流单超时关单时间（1.从物流单创建时间起，30天内可以查询到该字段； 2. 仅支持4PL线上创建的物流单查询超时关单时间）
     */
    @JSONField(name = "close_time")
    private Long close_time;

    /**
     *渠道编码
     *
     */
    @JSONField(name = "channel_code")
    private String channel_code;
    /**
     *
     *gmtCreate
     */
    @JSONField(name = "gmt_create")
    private String gmt_create;
    /**
     *
     *国际运单号
     */
    @JSONField(name = "international_logistics_num")
    private String international_logistics_num;
    /**
     *物流服务编码
     *
     */
    @JSONField(name = "international_logistics_type")
    private String international_logistics_type;

    /**
     *
     *运费
     */
    @JSONField(name = "logistics_fee")
    private LogisticsFee logistics_fee;
    /**
     *
     *物流订单号
     */
    @JSONField(name = "logistics_order_id")
    private String logistics_order_id;

    /**
     *物流订单状态
     *
     */
    @JSONField(name = "logistics_status")
    private String logistics_status;
    /**
     *
     *tradeOrderId
     */
    @JSONField(name = "trade_order_id")
    private String trade_order_id;
    /**
     *
     *outOrderCode(Lpnumber)
     */
    @JSONField(name = "out_order_code")
    private String out_order_code;
    /**
     *batchId
     *
     */
    @JSONField(name = "batch_id")
    private String batch_id;
    /**
     *物流服务列表
     *
     */
    @JSONField(name = "logistics_service_list")
    private List<LogisticsServiceInfo> logistics_service_list;
    /**
     *
     *解决方案code
     */
    @JSONField(name = "solution_code")
    private String solution_code;
    /**
     *多币种运费list
     *
     */
    @JSONField(name = "logistics_fee_list")
    private List<LogisticsFee> logistics_fee_list;
}
