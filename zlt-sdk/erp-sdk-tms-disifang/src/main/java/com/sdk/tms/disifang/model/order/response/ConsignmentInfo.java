package com.sdk.tms.disifang.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ConsignmentInfo
 * @description: 委托单信息
 * @date 2023年11月08日
 * @version: 1.0
 */
@Data
public class ConsignmentInfo implements Serializable {
    /**
     * 直发委托单号
     */
    @JSONField(name = "ds_consignment_no")
    private String ds_consignment_no;
    /**
     * 4PX跟踪号
     */
    @JSONField(name = "4px_tracking_no")
    private String trackingNo;
    /**
     * 客户单号/客户参考号
     */
    @JSONField(name = "ref_no")
    private String ref_no;
    /**
     * 获取末端服务商单号的方式(创建订单时取号：C；仓库作业时取号：U)
     */
    @JSONField(name = "get_no_mode")
    private String get_no_mode;
    /**
     * 末端服务商单号（(若此字段为空：①表示系统在异步取号中--再次查询即可获取；②取号失败--此时字段get_no_exmsg会返回相应的报错内容)）
     */
    @JSONField(name = "logistics_channel_no")
    private String logistics_channel_no;
    /**
     * 获取服务商单号抛的异常信息（若取号失败/取号异常，此字段将服务商的报错内容，同时logistics_channel_no字段将为空）
     */
    @JSONField(name = "get_no_exmsg")
    private String get_no_exmsg;
    /**
     * 运输方式代码
     */
    @JSONField(name = "logistics_product_code")
    private String logistics_product_code;
    /**
     * 运输方式名称
     */
    @JSONField(name = "logistics_product_name")
    private String logistics_product_name;
    /**
     * 委托单状态（草稿：D；已预报：P；已交接/已交货：V；库内作业中：H；已出库：C；已关闭：X；）
     */
    @JSONField(name = "consignment_status")
    private String consignment_status;
    /**
     * 投保状态（Y 已投保；N 未投保）
     */
    @JSONField(name = "insure_status")
    private String insure_status;
    /**
     * 投保类型
     */
    @JSONField(name = "insure_type")
    private String insure_type;
    /**
     * 是否进行ODA校验（Y：表示已经校验过；N：表示尚未校验）
     */
    @JSONField(name = "has_check_oda")
    private String has_check_oda;
    /**
     * ODA标识(偏远地址：Y ；非偏远地址：N)
     */
    @JSONField(name = "oda_result_sign")
    private String oda_result_sign;
    /**
     * 拦截标识（申请拦截：Y ；拦截成功：S； 放行：N ）
     */
    @JSONField(name = "is_hold_sign")
    private String is_hold_sign;
    /**
     * 创建委托单时间（*注：时间格式的传入值需要转换为long类型格式。）
     */
    @JSONField(name = "consignment_create_date")
    private Long consignment_create_date;
    /**
     * 4PX收货时间（*注：时间格式的传入值需要转换为long类型格式。）
     */
    @JSONField(name = "4px_inbound_date")
    private Long px4_inbound_date;
    /**
     * 4PX出库时间（*注：时间格式的传入值需要转换为long类型格式。）
     */
    @JSONField(name = "4px_outbound_date")
    private Long px4_outbound_date;
}
