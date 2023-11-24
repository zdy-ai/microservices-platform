package com.sdk.tms.express.model.order.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderSearchRespDto
 * @description: TODO
 * @date 2023年11月10日
 * @version: 1.0
 */
@Data
public class OrderSearchRespDto implements Serializable {
    /**
     * 客户订单号
     */
    private String orderId;
    /**
     * 原寄地区域代码，可用 于顺丰电子运单标签打印
     */
    private String origincode;
    /**
     * 目的地区域代码，可用 于顺丰电子运单标签打印
     */
    private String destcode;
    /**
     * 筛单结果： 1：人工确认 2：可收派 3：不可以收派
     */
    private String filterResult;
    /**
     * 返回信息扩展属性
     */
    private List<ReturnExtraInfoList> returnExtraInfoList;
    /**
     * 顺丰运单号
     */
    private List<WaybillNoInfoList> waybillNoInfoList;
    /**
     * 	路由标签数据
     */
    private List<RouteLabelInfo> routeLabelInfo;
}
