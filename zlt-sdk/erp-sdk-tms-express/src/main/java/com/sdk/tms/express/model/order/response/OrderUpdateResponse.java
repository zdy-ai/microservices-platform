package com.sdk.tms.express.model.order.response;

import com.sdk.tms.express.model.order.request.ExtraInfo;
import com.sdk.tms.express.model.order.request.WaybillNoInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderUpdateResponse
 * @description: TODO
 * @date 2023年10月31日
 * @version: 1.0
 */
@Data
public class OrderUpdateResponse implements Serializable {
    /**
     * 客户订单号
     */
    private String orderId;
    /**
     * 顺丰运单号
     */
    private List<WaybillNoInfo> waybillNoInfoList;

    /**
     * 备注1：客户订单号与顺丰运单不匹配2 ：操作成功
     */
    private Integer resStatus;
    /**
     * 扩展属性
     */
    private List<ExtraInfo> extraInfoList;
}
