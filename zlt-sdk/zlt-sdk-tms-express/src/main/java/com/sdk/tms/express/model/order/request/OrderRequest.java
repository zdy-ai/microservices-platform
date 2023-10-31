package com.sdk.tms.express.model.order.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderRequest
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class OrderRequest implements Serializable {
    /**
     * 响应报文的语言，缺省值为zh-CN，目前支持以下值zh-CN表示中文简体，zh-TW或zh-HK或zh-MO表示中文繁体，en 表示英文
     * 是
     */
    private String language;
    /**
     * 客户订单号
     * 是
     */
    private String orderId;
    /**
     * 顺丰运单号
     */
    private List<WaybillNoInfo> waybillNoInfoList;
    /**
     * 报关信息
     */
    private CustomsInfo customsInfo;
    /**
     * 拖寄物信息
     * 是
     */
    private List<CargoDetail> cargoDetails;
    /**
     * 拖寄物类型描述,如：文件，电子产品，衣服等
     */
    private String cargoDesc;

    /**
     * 扩展属性
     */
    private List<ExtraInfo> extraInfoList;
    /**
     * 增值服务信息
     */
    private List<Service> serviceList;
    /**
     * 收寄双方信息
     */
    private List<ContactInfo> contactInfoList;
    /**
     * 顺丰月结卡号
     */
    private Long monthlyCard;
    /*
     *付款方式，支持以下值：1:寄方付2:收方付3:第三方付
     */
    private Integer payMethod;
    /**
     * 快件产品类别，支持附录《快件产品类别表》的产品编码值，仅可使用与顺丰销售约定的快件产品。
     */
    private Long expressTypeId;
    /**
     * 包裹数，一个包裹对应一个运单号；若包裹数大于1，则返回一个母运单号和N-1 个子运单号。
     */
    private Long parcelQty;
    /**
     * 客户订单货物总长，单位厘米，精确到小数点后3 位，包含子母件。
     */
    private BigDecimal totalLength;
    /**
     * 客户订单货物总宽，单位厘米，精确到小数点后3 位，包含子母件。
     */
    private BigDecimal totalWidth;

    /**
     * 客户订单货物总高，单位厘米，精确到小数点后5 位，包含子母件。
     */
    private BigDecimal totalHeight;

    /**
     * 订单货物总体积，单位立方厘米，精确到小数点后3 位，会用于计抛（是否计抛具体商务沟通中双方约定）。
     */
    private BigDecimal volume;

    /**
     * 订单货物总重量，包含子母件，单位千克，精确到小数点后3位，如果提供此值，必须>0 。
     */
    private BigDecimal totalWeight;

    /**
     * 商品总净重
     */
    private BigDecimal totalNetWeight;

    /**
     * 接收到报
     * 文的时间
     * 要求上门取件开始时间，格式：YYYY-MM-DDHH24:MM:SS，示例：2012-7-30 09:30:00。
     */
    private Date sendStartTm;
    /**
     * 是否通过手持终端通知顺丰收派员上门收件，支持以下值：1：要求0：不要求
     */
    private Integer isDocall;
    /**
     * 是否返回签回单（签单返还）的运单号，支持以下值：1：要求0：不要求
     */
    private Integer isSignBack;
    /**
     * 客户参考编码：如客户原始订单号
     */
    private String custReferenceNo;
    /**
     * 温度范围类型，当express_type为12 医药温控件时必填，支持以下值：1:冷藏3：冷冻
     */
    private Integer temperatureRange;
    /**
     * 订单平台类型（对于平台类客户，如果需要在订单中区分订单来源，则可使用此字段）天猫：tmall，拼多多：pinduoduo，京东: jd等平台类型编码
     */
    private String orderSource;
    /**
     * 业务配置代码，业务配置代码指BSP针对客户业务需求配置的一套接口处理逻辑，一个接入编码可对应多个业务配置代码。
     */
    private String bizTemplateCode;
    /**
     * 备注
     */
    private String remark;
    /**
     * 快件自取，支持以下值：1：客户同意快件自取0：客户不同意快件自取
     */
    private Integer isOneselfPickup;

    /**
     * 筛单特殊字段用来人工筛单
     */
    private String filterField;

    /**
     * 是否返回用来退货业务的二维码URL，支持以下值：1：返回二维码0：不返回二维码
     */
    private Integer isReturnQRCode;

    /**
     * 特殊派送类型代码1:身份验证
     */
    private String specialDeliveryTypeCode;

    /**
     * 特殊派件具体表述证件类型:证件后8位 如：1:09296231（1表示身份证，暂不支持其他证件）
     */
    private String specialDeliveryValue;
    /**
     * 寄件实名认证流水号
     */
    private String realnameNum;
    /**
     * 商户支付订单号
     */
    private String merchantPayOrderNo;
    /**
     * 是否返回签回单路由标签：默认0，1：返回路由标签，0：不返回
     */
    private String isReturnSignBackRoutelabe;
    /**
     * 是否返回路由标签：默认0，1：返回路由标签，0：不返回
     */
    private String isReturnRoutelabel;
    /**
     * 是否使用国家统一面单号1：是，0：否（默认）
     */
    private String isUnifiedWaybillNo;
    /**
     * 签单返还范本地址
     */
    private String podModelAddress;
    /**
     * 揽收员工号
     */
    private String collectEmpCode;
    /**
     * 头程运单号
     */
    private String inProcessWaybillNo;
}
