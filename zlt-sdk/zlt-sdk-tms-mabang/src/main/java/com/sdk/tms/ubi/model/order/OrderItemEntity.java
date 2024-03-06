package com.sdk.tms.ubi.model.order;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
public class OrderItemEntity {
    /**
     * 商品成本价
     */
    private BigDecimal costPrice;
    /**
     * 缺货订单 0 正在计算是否缺货 、 1有货、2缺货、3 已补货
     */
    private Integer hasGoods;
    /**
     * 订单平台商品编号
     */
    private String orderItemId;
    /**
     * 是否是组合商品 1.组合 2非组合
     */
    private Integer isCombo;
    /**
     * 是否是赠品 1是 2否
     */
    private Integer isGift;
    /**
     * 是否是重复商品 1是 2否
     */
    private String isRepeatItem;
    /**
     * 是否为膏体 1：是2：不是
     */
    private String ispaste;
    /**
     * 平台itemId
     */
    private String itemId;
    /**
     * 订单商品备注
     */
    private String itemRemark;
    /**
     * 0:非液体,2:液体(化妆品),1:非液体(化妆品),3:液体(非化妆品)
     */
    private String noLiquidCosmetic;
    /**
     * ERP系统关联订单编号，对应订单信息中的erpOrderId
     */
    private String originOrderId;
    /**
     * 电商平台商品图片
     */
    private String originalPictureUrl;
    /**
     * 商品图片
     */
    private String pictureUrl;
    /**
     * 平台费用
     */
    private String platformFee;
    /**
     * 平台原始费用
     */
    private String platformFeeOrigin;
    /**
     * 平台原始sku数量
     */
    private Integer platformQuantity;
    /**
     * 平台sku
     */
    private String platformSku;
    /**
     * 平台单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private Integer quantity;
    /**
     * 商品售价
     */
    private BigDecimal sellPrice;
    /**
     * 商品原始售价
     */
    private BigDecimal sellPriceOrigin;
    /**
     * 商品规格
     */
    private String specifics;
    /**
     * 商品状态 1：未付款  2：未发货  3：已发货  4：已作废
     */
    private Integer status;
    /**
     * 商品仓位
     */
    private String stockGrid;
    /**
     * 库存sku
     */
    private String stockSku;
    /**
     * 状态：1.自动创建2.待开发3.正常4.清仓5.停止销售
     */
    private Integer stockStatus;
    /**
     * 商品仓库编号
     */
    private String stockWarehouseId;
    /**
     * 商品仓库名称
     */
    private String storageSku;
    /**
     * 商品标题（最大1000个字符）
     */
    private String title;
    /**
     * 平台transactionId
     */
    private String transactionId;
    /**
     * 商品单品重量
     */
    private String unitWeight;
    /**
     * 商品仓库名称
     */
    private String stockWarehouseName;
    /**
     * 订单马帮商品编号
     */
    private String erpOrderItemId;
}
