package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.sdk.tms.disifang.model.base.Address;
import lombok.Data;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderRequest
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest implements Serializable {
    /**
     * 4PX跟踪号（预分配号段的客户可传此值）
     */
    @JSONField(name = "4px_tracking_no")
    private String trackNo;

    /**
     * 参考号（客户自有系统的单号，如客户单号）
     * 是
     */
    @NotBlank(message = "客户单号不能为空")
    @JSONField(name = "ref_no")
    private String refNo;
    /**
     * 面单条码（预分配号段的客户可传此值）
     */
    @JSONField(name = "label_barcode")
    private String labelBarcode;
    /**
     * 业务类型(4PX内部调度所需，如需对接传值将说明，默认值：BDS。)
     * 是
     */
    @NotBlank(message = "业务类型不能为空")
    @JSONField(name = "business_type")
    private String businessType;
    /**
     * 税费费用承担方式(可选值：U、P); U：DDU由收件人支付关税; P：DDP 由寄件方支付关税 （如果物流产品只提供其中一种，则以4PX提供的为准）
     * 是
     */
    @NotBlank(message = "税费费用承担方式不能为空")
    @JSONField(name = "duty_type")
    private String dutyType;
    /**
     * 货物类型（1：礼品;2：文件;3：商品货样;5：其它；默认值：5）
     */
    @JSONField(name = "cargo_type")
    private String cargoType;
    /**
     * VAT税号(数字或字母)；欧盟国家(含英国)使用的增值税号；
     */
    @JSONField(name = "vat_no")
    private String vatNo;
    /**
     * EORI号码(数字或字母)；欧盟入关时需要EORI号码，用于商品货物的清关
     */
    @JSONField(name = "eori_no")
    private String eoriNo;
    /**
     * IOSS号码
     */
    @JSONField(name = "ioss_no")
    private String iossNo;
    /**
     * 买家ID(数字或字母)
     */
    @JSONField(name = "buyer_id")
    private String buyerId;
    /**
     * 销售平台（点击查看详情）
     */
    @JSONField(name = "sales_platform")
    private String salesPlatform;
    /**
     * 交易号ID(数字或字母)
     */
    @JSONField(name = "trade_id")
    private String tradeId;
    /**
     * 卖家ID(数字或字母)
     */
    @JSONField(name = "seller_id")
    private String sellerId;

    /**
     * 能否提供商业发票（Y/N） Y：能提供商业发票(则系统不会生成形式发票)；N：不能提供商业发票(则系统会生成形式发票)； 默认为N；DHL产品必填，如产品代码A1/A5；
     */
    @JSONField(name = "is_commercial_invoice")
    private String isCommercialInvoice = "N";
    /**
     * 包裹件数（一个订单有多少件包裹，就填写多少件数，请如实填写包裹件数，否则DHL无法返回准确的子单号数和子单号标签；DHL产品必填，如产品代码A1/A5；）
     */
    @JSONField(name = "parcel_qty")
    private String parcel_qty;
    /**
     * 运费(客户填写自己估算的运输费用；支持的币种，根据物流产品+收件人国家配置)
     */
    @JSONField(name = "freight_charges")
    private String freight_charges;
    /**
     * 运费币种(按照ISO标准三字码；支持的币种，根据物流产品+收件人国家配置)
     */
    @JSONField(name = "currency_freight")
    private String currency_freight;
    /**
     * 申报保险费（是否必填，根据物流产品+目的国配置；根据欧盟IOSS政策，货值/运费/保险费可单独申报）支持小数点后2位
     */
    @JSONField(name = "declare_insurance")
    private String declare_insurance;
    /**
     * 申报保险费币种（按照ISO标准，币种需和进出口国申报币种一致）
     */
    @JSONField(name = "currency_declare_insurance")
    private String currency_declare_insurance;
    /**
     * 物流服务信息
     */
    @JSONField(name = "logistics_service_info")
    private LogisticsServiceInfo logisticsServiceInfo;
    /**
     * 退件信息
     */
    @JSONField(name = "return_info")
    private ReturnInfo returnInfo;
    /**
     * 包裹列表
     */
    @JSONField(name = "parcel_list")
    private List<Parcel> parcelList;
    /**
     *是否投保(Y、N)
     */
    @NotNull(message = "是否投保不能为空")
    @JSONField(name = "is_insure")
    private String is_insure;
    /**
     *保险信息（投保时必须填写）
     */
    @JSONField(name = "insurance_info")
    private InsuranceInfo insuranceInfo;
    /**
     *发件人信息
     */
    @JSONField(name = "sender")
    private Address sender;
    /**
     *收件人信息
     */
    @JSONField(name = "recipient_info")
    private Address recipientInfo;
    /**
     *货物到仓方式信息
     */
    @JSONField(name = "deliver_type_info")
    private DeliverTypeInfo deliverTypeInfo;
    /**
     *投递信息
     */
    @JSONField(name = "deliver_to_recipient_info")
    private DeliverToRecipientInfo deliverToRecipientInfo;
    /**
     * 	扩展字段
     */
    private String ext;
    /**
     * 	分拣分区
     */
    @JSONField(name = "sort_code")
    private String sortCode;
    /**
     * 	订单附件列表
     */
    @JSONField(name = "order_attachment_info")
    private List<OrderAttachmentInfo> orderAttachmentInfos;
}
