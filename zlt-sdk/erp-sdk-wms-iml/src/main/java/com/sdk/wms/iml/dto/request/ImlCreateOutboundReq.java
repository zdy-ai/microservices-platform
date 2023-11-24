package com.sdk.wms.iml.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImlCreateOutboundReq {

    //订单参考号(建议使用平台单号)
    @JSONField(name = "reference_no")
    private String referenceNo;

    //平台订单号(例如速卖通平台订单号)
    @JSONField(name = "aliexpress_order_no")
    private String aliexpressOrderNo;

    //平台， ALIEXPRESS, AMAZON, B2C, EBAY, OTHER 默认OTHER
    @JSONField(name = "platform")
    private String platform;

    //自动分仓:0无,1自动分仓
    @JSONField(name = "allocated_auto")
    private String allocatedAuto;

    //配送方式，参考getShippingMethod
    @JSONField(name = "shipping_method")
    private String shippingMethod;

    //配送仓库，参考getWarehouse
    @JSONField(name = "warehouse_code")
    private String warehouseCode;

    //收件人国家，参考getCountry
    @JSONField(name = "country_code")
    private String countryCode;

    //省
    @JSONField(name = "province")
    private String province;

    //城市
    @JSONField(name = "city")
    private String city;

    //地址1 (length:30)
    @JSONField(name = "address1")
    private String address1;

    //地址2 (length:30)
    @JSONField(name = "address2")
    private String address2;

    //地址3 (length:30)
    @JSONField(name = "address3")
    private String address3;

    //邮编
    @JSONField(name = "zipcode")
    private String zipcode;

    //门牌号
    @JSONField(name = "doorplate")
    private String doorplate;

    //公司名
    @JSONField(name = "company")
    private String company;

    //收件人姓名
    @JSONField(name = "name")
    private String name;

    //收件人联系方式
    @JSONField(name = "phone")
    private String phone;

    //收件人联系方式2
    @JSONField(name = "cell_phone")
    private String cellPhone;

    //收件人邮箱
    @JSONField(name = "email")
    private String email;

    //平台店铺
    @JSONField(name = "platform_shop")
    private String platformShop;

    //COD订单：0:否 1:是
    @JSONField(name = "is_order_cod")
    private Integer isOrderCod;

    //COD Value
    @JSONField(name = "order_cod_price")
    private Float orderCodPrice;

    //币种
    @JSONField(name = "order_cod_currency")
    private String orderCodCurrency;

    //年龄: 0:无 1:16岁-18岁 2:18岁以上
    @JSONField(name = "order_age_limit")
    private Integer orderAgeLimit;

    //签名服务: 0:否 1:是
    @JSONField(name = "is_signature")
    private Integer isSignature;

    //保险服务: 0:否 1:是
    @JSONField(name = "is_insurance")
    private Integer isInsurance;

    //投保金额
    @JSONField(name = "insurance_value")
    private Integer insuranceValue;

    //订单说明
    @JSONField(name = "order_desc")
    private String orderDesc;

    //保税:订单模式(bbc/b2c)
    @JSONField(name = "order_business_type")
    private String orderBusinessType;

    //保税:收货人证件类型
    @JSONField(name = "receiver_id_type_code")
    private String receiverIdTypeCode;

    //保税:收货人身份证
    @JSONField(name = "receiver_id_number")
    private String receiverIdNumber;

    //保税:支付人(订购人)编码
    @JSONField(name = "pay_no")
    private String payNo;

    //保税:支付人(订购人)姓名,也即订购人
    @JSONField(name = "payer_name")
    private String payerName;

    //保税:支付人证件类型(1身份证)
    @JSONField(name = "id_type_code")
    private String idTypeCode;

    //保税:证件号码
    @JSONField(name = "id_number")
    private String idNumber;

    //保税:支付人电话
    @JSONField(name = "payer_phone")
    private String payerPhone;

    //保税:税费，没有填0
    @JSONField(name = "tax")
    private String tax;

    //保税:抵扣费用，没有填0
    @JSONField(name = "other_payment")
    private String otherPayment;

    //保税:优惠金额，没有填0
    @JSONField(name = "pro_amount")
    private String proAmount;

    //保税:运费，没有填0
    @JSONField(name = "transport_fee")
    private String transportFee;

    //保税:保价费，没有填0
    @JSONField(name = "valuation_fee")
    private String valuationFee;

    //保税:运输方式编号
    @JSONField(name = "trans_type_id")
    private String transTypeId;

    //保税:运输工具编号
    @JSONField(name = "trans_tool_id")
    private String transToolId;

    //保税:航班航次号
    @JSONField(name = "voyages")
    private String voyages;

    //保税:包装种类编号
    @JSONField(name = "pack_type_id")
    private String packTypeId;

    //保税:货运总单号
    @JSONField(name = "trans_sum_no")
    private String transSumNo;

    //保税:提单号
    @JSONField(name = "lading_bill_no")
    private String ladingBillNo;

    //是否审核,0新建不审核(草稿状态)，1新建并审核， 默认为0， 审核通过之后，不可编辑
    @JSONField(name = "verify")
    private Integer verify;

    //是否强制审核(如欠费，缺货时是否审核到仓配系统), 0不强制，1强制， 默认为0 当verify==1时生效
    @JSONField(name = "forceVerify")
    private Integer forceVerify;

    //订单明细
    @JSONField(name = "items")
    private List<Item> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Item {

        //SKU
        @JSONField(name = "product_sku")
        private String productSku;

        //中文申报名称
        @JSONField(name = "product_name")
        private String productName;

        //英文申报名称
        @JSONField(name = "product_name_en")
        private String productNameEn;

        //申报价值
        @JSONField(name = "product_declared_value")
        private BigDecimal productDeclaredValue;

        //数量
        @JSONField(name = "quantity")
        private Integer quantity;
    }

    //跟踪号
    @JSONField(name = "tracking_no")
    private String trackingNo;

    //标签信息
    @JSONField(name = "label")
    private Label label;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Label {

        //普通类型(pdf/png/gif/jpg)  特殊类型(cainiao)
        @JSONField(name = "file_type")
        private String fileType;

        //尺寸(格式如100x100，以小写x字母分隔)
        @JSONField(name = "file_size")
        private String fileSize;

        //base64编码 / 数组 (多个标签: 数组格式[base64编码, ..])
        //注：菜鸟标签 file_type=>'cainiao', file_data=>菜鸟标签,如 [{"encryptedData":"AES:sqZph..", "signature": "MD:jcPOk..", "templateURL": "http://cloudprint.cainiao.com.."}]
        @JSONField(name = "file_data")
        private String fileData;
    }

    //装箱服务: 0:否 1:是
    @JSONField(name = "is_pack_box")
    private Integer isPackBox;

    //菜鸟lp单号（非必填，不填默认为空）
    @JSONField(name = "lp_code")
    private String lpCode;

}
