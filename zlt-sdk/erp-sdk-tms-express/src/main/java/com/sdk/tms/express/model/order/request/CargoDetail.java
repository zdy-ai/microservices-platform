package com.sdk.tms.express.model.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zdy
 * @ClassName CargoDetail
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoDetail implements Serializable {
    /**
     * 货物名称，如果需要生成电子运单，则为必填。
     * 是
     */
    @NotBlank(message = "货物名称不能为空")
    private String name;
    /**
     * 货物数量跨境件报关需要填写
     */
    private BigDecimal count;
    /**
     * 货物单位，如：个、台、本，跨境件报关需要填写。
     */
    private String unit;
    /**
     * 订单货物单位重量，包含子母件，单位千克，精确到小数点后3位跨境件报关需要填写。
     */
    private BigDecimal weight;
    /**
     * 货物单价，精确到小数点后3位，跨境件报关需要填写。
     */
    private BigDecimal amount;
    /**
     * 货物单价的币别：参照附录币别代码附件
     */
    private String currency;
    /**
     * 原产地国别，跨境件报关需要填写。
     */
    private String sourceArea;
    /**
     * 货物产品国检备案编号
     */
    private String productRecordNo;
    /**
     * 商品海关备案号
     */
    private String goodPrepardNo;
    /**
     * 商品行邮税号
     */
    private String taxNo;
    /**
     * 海关编码
     */
    private String hsCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 货物品牌
     */
    private String brand;
    /**
     * 货物规格型号
     */
    private String specifications;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 托寄物毛重
     */
    private Double shipmentWeight;
    /**
     * 托寄物长
     */
    private Double length;
    /**
     * 托寄物宽
     */
    private Double width;
    /**
     * 托寄物高
     */
    private Double height;
    /**
     * 托寄物体积
     */
    private Double volume;
    /**
     * 托寄物声明价值
     */
    private Double cargoDeclaredValue;
    /**
     * 托寄物声明价值币别
     */
    private String declaredValueDeclaredCurrency;
    /**
     * 货物id（逆向物流）
     */
    private String cargoId;
    /**
     * 智能验货标识(1-是,0-否)（逆向物流）
     */
    private String intelligentInspection;
    /**
     * 货物标识码（逆向物流）
     */
    private String snCode;
    /**
     * 国条码
     */
    private String stateBarCode;
}
