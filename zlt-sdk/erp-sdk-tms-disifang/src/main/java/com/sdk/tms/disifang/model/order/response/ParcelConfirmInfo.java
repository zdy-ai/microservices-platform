package com.sdk.tms.disifang.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ParcelConfirmInfo
 * @description: 订单信息
 * @date 2023年11月08日
 * @version: 1.0
 */
@Data
public class ParcelConfirmInfo implements Serializable {
    /**
     * 订单的实际包裹数
     */
    @JSONField(name = "confirm_parcel_qty")
    private String confirm_parcel_qty;
    /**
     * 订单实重（默认g）
     */
    @JSONField(name = "confirm_parcel_weight")
    private Integer confirm_parcel_weight;
    /**
     * 订单体积重/材积重（默认g，若有才返回）
     */
    @JSONField(name = "confirm_parcel_volume_weight")
    private Integer confirm_parcel_volume_weight;
    /**
     * 订单计费重（默认g）
     */
    @JSONField(name = "confirm_parcel_charge_weight")
    private Integer confirm_parcel_charge_weight;
}
