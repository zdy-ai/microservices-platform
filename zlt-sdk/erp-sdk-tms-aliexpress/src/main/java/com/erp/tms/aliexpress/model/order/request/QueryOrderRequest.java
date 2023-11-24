package com.erp.tms.aliexpress.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName QueryOrderRequest
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryOrderRequest implements Serializable {
    /**
     *
     *
     * 当前页
     */
    @JSONField(name = "current_page")
    private Integer current_page;
    /**
     *
     * 国内运单号
     */
    @JSONField(name = "domestic_logistics_num")
    private String domestic_logistics_num;
    /**
     *
     * 起始创建时间
     */
    @JSONField(name = "gmt_create_end_str")
    private String gmt_create_end_str;
    /**
     *
     * 截止创建时间
     */
    @JSONField(name = "gmt_create_start_str")
    private String gmt_create_start_str;
    /**
     *
     * 国际运单号
     */
    @JSONField(name = "international_logistics_num")
    private String international_logistics_num;
    /**
     *
     * 订单状态
     */
    @JSONField(name = "logistics_status")
    private String logistics_status;
    /**
     *
     * 页面大小
     */
    @JSONField(name = "page_size")
    private Integer page_size;
    /**
     *
     * 交易订单号
     * 是
     */
    @NotBlank(message = "交易订单号不能为空")
    @JSONField(name = "trade_order_id")
    private String trade_order_id;
    /**
     *
     * 物流服务编码
     */
    @JSONField(name = "warehouse_carrier_service")
    private String warehouse_carrier_service;
}
