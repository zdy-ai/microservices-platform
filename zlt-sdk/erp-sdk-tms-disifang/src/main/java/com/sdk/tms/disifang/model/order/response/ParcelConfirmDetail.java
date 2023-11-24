package com.sdk.tms.disifang.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ParcelConfirmDetail
 * @description: TODO
 * @date 2023年11月08日
 * @version: 1.0
 */
@Data
public class ParcelConfirmDetail implements Serializable {
    /**
     * 核实重量（默认g）
     */
    @JSONField(name = "confirm_weight")
    private Integer confirm_weight;
    /**
     * 包裹体积重（默认g）
     */
    @JSONField(name = "confirm_volume_weight")
    private Integer confirm_volume_weight;
    /**
     * 核实包裹长（cm，只有库内进行了测量，才有值）
     */
    @JSONField(name = "confirm_length")
    private String confirm_length;
    /**
     * 核实包裹宽（cm，只有库内进行了测量，才有值）
     */
    @JSONField(name = "confirm_width")
    private String confirm_width;
    /**
     * 核实包裹高（cm，只有库内进行了测量，才有值）
     */
    @JSONField(name = "confirm_high")
    private String confirm_high;
    /**
     * 包裹计费重（默认g）
     */
    @JSONField(name = "confirm_charge_weight")
    private String confirm_charge_weight;
    /**
     * 核实是否含电池（Y/N）
     */
    @JSONField(name = "confirm_include_battery")
    private String confirm_include_battery;
    /**
     * 核实带电类型（内置电池966：1；配套电池967：2）
     */
    @JSONField(name = "confirm_battery_type")
    private String confirm_battery_type;
    /**
     * 核实包裹价值
     */
    @JSONField(name = "parcel_total_value_confirm")
    private String parcel_total_value_confirm;
    /**
     * 币别（按照ISO标准，目前只支持USD）
     */
    @JSONField(name = "currency_code")
    private String currency_code;

}
