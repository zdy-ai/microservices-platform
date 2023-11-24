package com.sdk.oms.shopee.dto.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName Package
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class Package implements Serializable {

    @JSONField(name = "package_number")
    private String packageNumber;

    @JSONField(name = "logistics_status")
    private String logisticsStatus;

    @JSONField(name = "shipping_carrier")
    private String shippingCarrier;
    @JSONField(name = "item_list")
    private List<OrderItemSimple> itemSimpleList;

    @JSONField(name = "parcel_chargeable_weight_graml")
    private Long parcelChargeableWeightGraml;
}
