package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.core.anno.StateEnumValue;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zdy
 * @ClassName Parcel
 * @description: 包裹列表
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class Parcel implements Serializable {
    /**
     *预报重量（g）
     * 是
     */
    @NotNull(message = "预报重量不能为空")
    @JSONField(name = "weight")
    private Integer weight;
    /**
     *包裹长（cm）
     */
    @JSONField(name = "length")
    private BigDecimal length;
    /**
     *包裹宽（cm）
     */
    @JSONField(name = "width")
    private BigDecimal width;
    /**
     *包裹高（cm）
     */
    @JSONField(name = "height")
    private BigDecimal height;
    /**
     *包裹申报价值（最多4位小数）
     */
    @NotNull(message = "包裹申报价值不能为空")
    @JSONField(name = "parcel_value")
    private BigDecimal parcel_value;
    /**
     *包裹申报价值币别（按照ISO标准三字码；支持的币种，根据物流产品+收件人国家配置；币种需和进出口国申报币种一致）
     */
    @StateEnumValue(strValues = {"USD", "EUR","GBP","CNY","AUD","CAD"}, message = "包裹申报价值币别代码有误")
    @JSONField(name = "currency")
    private String currency;
    /**
     *是否含电池（Y/N）
     */
    @NotNull(message = "是否含电池不能为空")
    @JSONField(name = "include_battery")
    private String include_battery;
    /**
     *带电类型(具体产品可支持的带电类型请咨询销售）
     */
    @JSONField(name = "battery_type")
    private String battery_type;
    /**
     *	[@即将废弃]投保物品信息（投保、查验、货物丢失作为参考依据）
     */
    @JSONField(name = "product_list")
    private BigDecimal product_list;
    /**
     *海关申报信息(每个包裹的申报信息，方式1：填写申报产品代码和申报数量；方式2：填写其他详细申报信息)
     */
    @JSONField(name = "declare_product_info")
    private List<DeclareProductInfo> declare_product_info;

}
