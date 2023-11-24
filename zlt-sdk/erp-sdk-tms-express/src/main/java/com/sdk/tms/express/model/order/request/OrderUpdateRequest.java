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
public class OrderUpdateRequest implements Serializable {
    /**
     * 客户订单号
     * 是
     */
    @NotBlank(message = "客户订单号不能为空")
    private String orderId;
    /**
     * 客户订单操作标识：1：确认2：取消
     */
    private Integer dealType;
    /**
     * 顺丰运单号
     */
    private List<WaybillNoInfo> waybillNoInfoList;
    /**
     * 报关批次
     */
    private String customsBatchs;
    /**
     * 揽收员工号
     */
    private String collectEmpCode;
    /**
     * 头程运单号
     */
    private String inProcessWaybillNo;
    /**
     * 原寄地网点代码
     */
    private String sourceZoneCode;
    /**
     * 目的地网点代码
     */
    private String destZoneCode;
    /**
     * 订单货物总重量，包含子母件，单位千克，精确到小数点后3位，如果提供此值，必须>0。
     */
    private String totalWeight;
    /**
     * 订单货物总体积，单位立方厘米，精确到小数点后3 位，会用于计抛（是否计抛具体商务沟通中双方约定）。
     */
    private String totalVolume;
    /**
     * 快件产品类别，支持附录《快件产品类别表》的产品编码值，仅可使用与顺丰销售约定的快件产品。
     */
    private String expressTypeId;
    /**
     * 扩展属性
     */
    private List<ExtraInfo> extraInfoList;
    /**
     * 客户订单货物总长，单位厘米，精确到小数点后3 位，包含子母件。
     */
    private String totalLength;
    /**
     * 客户订单货物总宽，单位厘米，精确到小数点后3 位，包含子母件。
     */
    private String totalWidth;
    /**
     * 客户订单货物总高，单位厘米，精确到小数点后5 位，包含子母件。
     */
    private String totalHeight;
    /**
     * 增值服务信息
     */
    private List<Service> serviceList;
}
