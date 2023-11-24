package com.sdk.tms.express.model.order.response;

import com.sdk.tms.express.model.order.request.ExtraInfo;
import com.sdk.tms.express.model.order.request.Service;
import com.sdk.tms.express.model.order.request.WaybillNoInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderResponse
 * @description: TODO
 * @date 2023年10月31日
 * @version: 1.0
 */
@Data
public class OrderResponse implements Serializable {
    /**
     * 客户订单号
     */
    private String orderId;
    /**
     * 原寄地区域代码，可用于顺丰电子运单标签打印。
     */
    private String originCode;
    /**
     * 目的地区域代码，可用于顺丰电子运单标签打印。
     */
    private String destCode;
    /**
     * 筛单结果：1：人工确认2：可收派3：不可以收派
     */
    private String filterResult;
    /**
     * 如果filter_result=3时为必填，不可以收派的原因代码：1：收方超范围2：派方超范围3-：其它原因高峰管控提示信息【数字】：【高峰管控提示信息】(如4：温馨提示，1：春运延时)
     */
    private String remark;
    /**
     * 二维码URL（用于CX退货操作的URL）
     */
    private String url;
    /**
     * 用于第三方支付运费的URL
     */
    private String paymentLink;
    /**
     * 是否送货上楼1:是
     */
    private String isUpstairs;
    /**
     * true 包含特殊仓库增值服务
     */
    private String isSpecialWarehouseService;
    /**
     * 下单补充的增值服务信息
     */
    private List<Service> serviceList;
    /**
     * 返回信息扩展属性
     */
    private List<ExtraInfo> returnExtraInfoList;
    /**
     * 顺丰运单号
     */
    private List<WaybillNoInfo> waybillNoInfoList;
    /**
     * 路由标签
     */
    private List<RlsResultRespDto> routeLabelInfo;
}
