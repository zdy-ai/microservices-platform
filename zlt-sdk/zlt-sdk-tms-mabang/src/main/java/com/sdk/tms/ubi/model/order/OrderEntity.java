package com.sdk.tms.ubi.model.order;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderEntity extends CleanBaseDTO {

    private String _id;
    /**
     * 订单编号
     */
    private String platformOrderId;
    /**
     * 平台交易号
     */
    private String salesRecordNumber;
    /**
     * 订单状态 2.配货中 3.已发货 4.已完成 5.已作废
     */
    private Integer orderStatus;
    /**
     * 物流渠道编号
     */
    private Integer myLogisticsChannelId;
    /**
     * 物流单号
     */
    private String trackNumber;
    /**
     * 内部单号
     */
    private String trackNumber1;
    /**
     * 虚拟单号
     */
    private String trackNumber2;
    /**
     * 订单重量
     */
    private String orderWeight;
    /**
     * 采买家账号
     */
    private String buyerUserId;
    /**
     * 采购员名称
     */
    private String buyerName;
    /**
     * 店铺编号
     */
    private String shopId;
    /**
     * 企业编号
     */
    private String companyId;
    /**
     * 国家二字码
     */
    private String countryCode;
    /**
     * 订单成本价
     */
    private BigDecimal orderCost;
    /**
     * 默认1 ，10.cod订单(shopee,后面还有其他平台) 11.wisd的WE标识 12:既是cod又是wed
     */
    private String codFlag;
    /**
     * 1:加急；2:不加急
     */
    private String isUrgent;
    /**
     * 交运时间
     */
    private String transportTime;
    /**
     * 转wms发货时间
     */
    private String quickPickTime;
    /**
     * 待审核订单 1.否 2.是
     */
    private Integer canSend;
    /**
     * 订单同步ERP时间
     */
    private String createDate;
    /**
     * 1.退货 2.非退货
     */
    private Integer isReturned;
    /**
     * 1.退款 2.非退款
     */
    private Integer isRefund;
    /**
     * 订单付款时间
     */
    private String paidTime;
    /**
     * 订单金额
     */
    private BigDecimal orderFee;
    /**
     * 来源平台
     */
    private String platformId;
    /**
     * expressTime
     */
    private String expressTime;
    /**
     * 1.合并订单 2.非合并订单
     */
    private Integer isUnion;
    /**
     * 1.拆分订单 2.非拆分订单
     */
    private Integer isSplit;
    /**
     * 1.重发订单 2.非重发订单
     */
    private Integer isResend;
    /**
     * 缺货订单 0 正在计算是否缺货 、 1有货、2缺货、3 已补货
     */
    private Integer hasGoods;
    /**
     * 是否含电池 1.是 2否
     */
    private String hasBattery;
    /**
     * 交运结果描述
     */
    private String isSyncLogisticsDescr;
    /**
     * paypalId
     */
    private String paypalId;
    /**
     * 交运状态：0未调用; 1 开始调用;2 正在调用;3 交运成功;98 交运失败;99 验证失败
     */
    private String isSyncLogistics;
    /**
     * 是否同步到电商平台 1未同步 2等待交运 6不需要同步 7同步失败 9同步成功
     */
    private String isSyncPlatform;
    /**
     * 同步结果
     */
    private String isSyncPlatformDescr;
    /**
     * 所属区域
     */
    private String district;
    /**
     * 收款账号
     */
    private String paypalEmail;
    /**
     * 交易关闭时间
     */
    private String closeDate;
    /**
     * 买家地址1
     */
    private String street1;
    /**
     * 买家地址2
     */
    private String street2;
    /**
     * 虚假发货订单 1.是 2.否
     */
    private String isVirtual;
    /**
     * 买家城市
     */
    private String city;
    /**
     * 买家省份
     */
    private String province;
    /**
     * 买家邮编
     */
    private String postCode;
    /**
     * 买家电话1
     */
    private String phone1;
    /**
     * 买家电话2
     */
    private String phone2;
    /**
     * 买家邮箱
     */
    private String email;
    /**
     * 1.待处理订单 2.配货中订单
     */
    private String isNewOrder;
    /**
     * 买家门牌号
     */
    private String doorcode;
    /**
     * 是否平台发货订单 1.非 2.是
     */
    private Integer fbaFlag;
    /**
     * Fba开始配送时间
     */
    private String fbaStartDateTime;
    /**
     * Fba配送结束时间
     */
    private String fbaEndDateTime;
    /**
     * "Fba承运人
     */
    private String CarrierCode;
    /**
     * 操作时间
     */
    private String operTime;
    /**
     * 买家自选物流
     */
    private String shippingService;
    /**
     * 包材重量
     */
    private String packageWeight;
    /**
     * 平台的订单状态，没有具体枚举值，根据平台的来
     */
    private String platformOrderStatus;
    /**
     * 是否含磁 1含 2不含
     */
    private String hasMagnetic;
    /**
     * 是否含粉末 1含 2不含
     */
    private String hasPowder;
    /**
     * 是否侵权1含2不含
     */
    private String hasTort;
    /**
     * 订单备注
     */
    private String remark;
    /**
     * 平台备注
     */
    private String sellerMessage;
    /**
     * 币种
     */
    private String currencyId;
    /**
     * 汇率
     */
    private BigDecimal currencyRate;
    /**
     * 商品总售价
     */
    private BigDecimal itemTotal;
    /**
     * 运费收入
     */
    private BigDecimal shippingFee;
    /**
     * 平台费
     */
    private BigDecimal platformFee;
    /**
     * 原始运费收入
     */
    private BigDecimal shippingTotalOrigin;
    /**
     * 商品原始总售价
     */
    private BigDecimal itemTotalOrigin;
    /**
     * 退款原始金额
     */
    private String refundFeeOrigin;
    /**
     * 退款金额币种
     */
    private String refundFeeCurrencyId;
    /**
     * 原始税费
     */
    private String originFax;
    /**
     * 作废前状态，参考orderStatus字段
     */
    private String beforeStatus;
    private String otherExpend;
    private String otherIncome;
    /**
     * 保险费
     */
    private String insuranceFee;
    /**
     * 原始保险费
     */
    private String insuranceFeeOrigin;
    /**
     * Paypal转账费
     */
    private String paypalFee;
    /**
     * 原始Paypal转账费
     */
    private String paypalFeeOrigin;
    /**
     * 商品总成本
     */
    private BigDecimal itemTotalCost;
    /**
     * 真实运费
     */
    private String shippingCost;
    /**
     * 预估运费
     */
    private String shippingPreCost;
    /**
     * 包材费
     */
    private String packageFee;
    /**
     * FBA每笔订单配送服务费
     */
    private String fbaPerOrderFulfillmentFee;
    /**
     * 亚马逊平台佣金
     */
    private String fbaCommission;
    /**
     * 折扣RMB金额
     */
    private String promotionAmount;
    /**
     * 原始联盟佣金
     */
    private String allianceFeeOrigin;
    /**
     * 原始优惠券
     */
    private String voucherPriceOrigin;
    /**
     * 原始补贴金额
     */
    private String subsidyAmountOrigin;
    /**
     * fba货到付款金额
     */
    private String CODCharge;
    /**
     * 联盟佣金
     */
    private String allianceFee;
    /**
     *
     */
    private String ShippingChargeback;
    /**
     * 亚马逊物流基础服务费
     */
    private String fbaPerUnitFulfillmentFee;
    /**
     * fba亚马逊物流配送费
     */
    private String fbaWeightBasedFee;
    /**
     * 原始平台费
     */
    private String platformFeeOrigin;
    /**
     * 优惠券
     */
    private String voucherPrice;
    /**
     * 补贴金额
     */
    private BigDecimal subsidyAmount;
    /**
     * 1.wms 2.非wms
     */
    private String isWms;
    /**
     * 付款方式
     */
    private String payType;
    /**
     * VendorID
     */
    private String VendorID;
    /**
     * 税号
     */
    private String abnnumber;
    /**
     * 国家英文名称
     */
    private String countryNameEN;
    /**
     * 国家中文名称
     */
    private String countryNameCN;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 物流渠道名称
     */
    private String myLogisticsChannelName;
    /**
     * 物流公司编号
     */
    private String myLogisticsId;
    /**
     * 物流公司名称
     */
    private String myLogisticsName;
    /**
     * 经度
     */
    private Object orderTypeNew;
    /**
     * ERP系统订单编号
     */
    private String erpOrderId;
    /**
     * 物流称重
     */
    private String shippingWeight;
    /**
     * 详情列表
     */
    private List<OrderItemEntity> orderItem;
    /**
     * 拓展属性
     */
    private Object extendAttr;
    /**
     * 清洗到发货订单 0 未清洗 1 清洗中 2 清洗完成
     */
    private Integer cleanToDelivery;
    /**
     * 上次推送Delivery时间
     */
    private LocalDateTime lastPushDeliveryTime;


    @Override
    public String toString() {
        return "OrderEntity{" +
                "platformOrderId='" + platformOrderId + '\'' +
                ", salesRecordNumber='" + salesRecordNumber + '\'' +
                ", orderStatus=" + orderStatus +
                ", myLogisticsChannelId=" + myLogisticsChannelId +
                ", trackNumber='" + trackNumber + '\'' +
                ", trackNumber1='" + trackNumber1 + '\'' +
                ", trackNumber2='" + trackNumber2 + '\'' +
                ", orderWeight='" + orderWeight + '\'' +
                ", buyerUserId='" + buyerUserId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", shopId='" + shopId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", orderCost=" + orderCost +
                ", transportTime='" + transportTime + '\'' +
                ", quickPickTime='" + quickPickTime + '\'' +
                ", canSend=" + canSend +
                ", createDate='" + createDate + '\'' +
                ", isReturned=" + isReturned +
                ", isRefund=" + isRefund +
                ", paidTime='" + paidTime + '\'' +
                ", orderFee=" + orderFee +
                ", platformId='" + platformId + '\'' +
                ", expressTime='" + expressTime + '\'' +
                ", isUnion=" + isUnion +
                ", isSplit=" + isSplit +
                ", isResend=" + isResend +
                ", hasGoods=" + hasGoods +
                ", hasBattery='" + hasBattery + '\'' +
                ", isSyncLogisticsDescr='" + isSyncLogisticsDescr + '\'' +
                ", paypalId='" + paypalId + '\'' +
                ", isSyncLogistics='" + isSyncLogistics + '\'' +
                ", isSyncPlatform='" + isSyncPlatform + '\'' +
                ", isSyncPlatformDescr='" + isSyncPlatformDescr + '\'' +
                ", district='" + district + '\'' +
                ", paypalEmail='" + paypalEmail + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", isVirtual='" + isVirtual + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postCode='" + postCode + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                ", isNewOrder='" + isNewOrder + '\'' +
                ", doorcode='" + doorcode + '\'' +
                ", fbaFlag=" + fbaFlag +
                ", fbaStartDateTime='" + fbaStartDateTime + '\'' +
                ", fbaEndDateTime='" + fbaEndDateTime + '\'' +
                ", CarrierCode='" + CarrierCode + '\'' +
                ", operTime='" + operTime + '\'' +
                ", shippingService='" + shippingService + '\'' +
                ", packageWeight='" + packageWeight + '\'' +
                ", platformOrderStatus='" + platformOrderStatus + '\'' +
                ", hasMagnetic='" + hasMagnetic + '\'' +
                ", hasPowder='" + hasPowder + '\'' +
                ", hasTort='" + hasTort + '\'' +
                ", remark='" + remark + '\'' +
                ", sellerMessage='" + sellerMessage + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", currencyRate=" + currencyRate +
                ", itemTotal=" + itemTotal +
                ", shippingFee=" + shippingFee +
                ", platformFee=" + platformFee +
                ", shippingTotalOrigin=" + shippingTotalOrigin +
                ", itemTotalOrigin=" + itemTotalOrigin +
                ", refundFeeOrigin='" + refundFeeOrigin + '\'' +
                ", refundFeeCurrencyId='" + refundFeeCurrencyId + '\'' +
                ", originFax='" + originFax + '\'' +
                ", beforeStatus='" + beforeStatus + '\'' +
                ", otherExpend='" + otherExpend + '\'' +
                ", otherIncome='" + otherIncome + '\'' +
                ", insuranceFee='" + insuranceFee + '\'' +
                ", insuranceFeeOrigin='" + insuranceFeeOrigin + '\'' +
                ", paypalFee='" + paypalFee + '\'' +
                ", paypalFeeOrigin='" + paypalFeeOrigin + '\'' +
                ", itemTotalCost=" + itemTotalCost +
                ", shippingCost='" + shippingCost + '\'' +
                ", shippingPreCost='" + shippingPreCost + '\'' +
                ", packageFee='" + packageFee + '\'' +
                ", fbaPerOrderFulfillmentFee='" + fbaPerOrderFulfillmentFee + '\'' +
                ", fbaCommission='" + fbaCommission + '\'' +
                ", promotionAmount='" + promotionAmount + '\'' +
                ", allianceFeeOrigin='" + allianceFeeOrigin + '\'' +
                ", voucherPriceOrigin='" + voucherPriceOrigin + '\'' +
                ", subsidyAmountOrigin='" + subsidyAmountOrigin + '\'' +
                ", CODCharge='" + CODCharge + '\'' +
                ", allianceFee='" + allianceFee + '\'' +
                ", ShippingChargeback='" + ShippingChargeback + '\'' +
                ", fbaPerUnitFulfillmentFee='" + fbaPerUnitFulfillmentFee + '\'' +
                ", fbaWeightBasedFee='" + fbaWeightBasedFee + '\'' +
                ", platformFeeOrigin='" + platformFeeOrigin + '\'' +
                ", voucherPrice='" + voucherPrice + '\'' +
                ", subsidyAmount=" + subsidyAmount +
                ", isWms='" + isWms + '\'' +
                ", payType='" + payType + '\'' +
                ", VendorID='" + VendorID + '\'' +
                ", abnnumber='" + abnnumber + '\'' +
                ", countryNameEN='" + countryNameEN + '\'' +
                ", countryNameCN='" + countryNameCN + '\'' +
                ", shopName='" + shopName + '\'' +
                ", myLogisticsChannelName='" + myLogisticsChannelName + '\'' +
                ", myLogisticsId='" + myLogisticsId + '\'' +
                ", myLogisticsName='" + myLogisticsName + '\'' +
                ", orderTypeNew='" + orderTypeNew + '\'' +
                ", erpOrderId='" + erpOrderId + '\'' +
                ", shippingWeight='" + shippingWeight + '\'' +
                ", orderItem=" + orderItem +
                ", extendAttr='" + extendAttr + '\'' +
                '}';
    }

    /**
     * 从收获地址设置国家信息
     */
    public void setCountryInfo(JSONObject jsonObject) {
        JSONObject receiverAddressInfoObj = jsonObject.getJSONObject("receiver_address_info");
        if (null == receiverAddressInfoObj){
            return;
        }
        String receiverCountryNameCN = receiverAddressInfoObj.getString("countryNameCN");
        String receiverCountryNameEN = receiverAddressInfoObj.getString("countryNameEN");
        if (StringUtils.isNotBlank(receiverCountryNameCN)){
            this.setCountryNameCN(receiverCountryNameCN);
        }
        if (StringUtils.isNotBlank(receiverCountryNameEN)){
            this.setCountryNameEN(receiverCountryNameEN);
        }
    }
}
