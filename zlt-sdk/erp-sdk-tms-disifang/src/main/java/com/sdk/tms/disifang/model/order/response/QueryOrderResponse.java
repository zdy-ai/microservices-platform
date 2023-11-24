package com.sdk.tms.disifang.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName QueryOrderResponse
 * @description: TODO
 * @date 2023年11月08日
 * @version: 1.0
 */
@Data
public class QueryOrderResponse implements Serializable {
    /**
     * 直发委托单号
     */
    @JSONField(name = "consignment_info")
    private ConsignmentInfo consignmentInfo;
    /**
     * 直发委托单号
     */
    @JSONField(name = "parcel_confirm_info")
    private ParcelConfirmInfo parcelConfirmInfo;
    /**
     * 包裹列表
     */
    @JSONField(name = "parcel_list_confirm_info")
    private List<ParcelConfirmDetail> parcelConfirmDetails;
}
