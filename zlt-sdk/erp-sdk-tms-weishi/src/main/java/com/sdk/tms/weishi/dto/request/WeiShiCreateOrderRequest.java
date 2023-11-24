package com.sdk.tms.weishi.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author liuruipeng
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeiShiCreateOrderRequest {

    //客户参考号
    @JSONField(name = "reference_no")
    @NotNull(message = "客户参考号不能为空")
    private String referenceNo;

    //配送方式(渠道code)
    @JSONField(name = "shipping_method")
    @NotNull(message = "配送方式不能为空")
    private String shippingMethod;

    //收件人国家二字码
    @JSONField(name = "country_code")
    @NotNull(message = "收件人国家二字码不能为空")
    private String countryCode;

    //订单重量，单位KG
    @JSONField(name = "order_weight")
    @NotNull(message = "订单重量不能为空")
    private Number orderWeight;

    //外包装件数,默认1
    @JSONField(name = "order_pieces")
    private Integer orderPieces;

    //投保金额，默认RMB
    @JSONField(name = "insurance_value")
    private Number insuranceValue;

    //包裹申报种类1:Gif礼品2:CommercialSample,商品货样3:Document,文件4:Other,其他 默认4
    @JSONField(name = "mail_cargo_type")
    private String mailCargoType;

    //收件人信息
    @Valid
    @NotNull(message = "收件人信息不能为空")
    private Consignee consignee;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Consignee {

        //收件人公司名
        @JSONField(name = "consignee_company")
        private String consigneeCompany;

        //收件人省
        @JSONField(name = "consignee_province")
        @NotNull(message = "收件人省不能为空")
        private String consigneeProvince;

        //收件人城市
        @JSONField(name = "consignee_city")
        @NotNull(message = "收件人城市不能为空")
        private String consigneeCity;

        //收件人地址1
        @JSONField(name = "consignee_street")
        @NotNull(message = "收件人地址不能为空")
        private String consigneeStreet;

        //收件人地址2
        @JSONField(name = "consignee_street2")
        private String consigneeStreet2;

        //收件人地址3
        @JSONField(name = "consignee_street3")
        private String consigneeStreet3;

        //收件人邮编
        @JSONField(name = "consignee_postcode")
        @NotNull(message = "收件人邮编不能为空")
        private String consigneePostcode;

        //收件人姓名
        @JSONField(name = "consignee_name")
        @NotNull(message = "收件人姓名不能为空")
        private String consigneeName;

        //收件人电话
        @JSONField(name = "consignee_telephone")
        private String consigneeTelephone;

        //收件人手机
        @JSONField(name = "consignee_mobile")
        @NotNull(message = "收件人手机不能为空")
        private String consigneeMobile;

        //收件人邮箱
        @JSONField(name = "consignee_email")
        private String consigneeEmail;

        //证件类型 ID:身份证 PP:护照
        @JSONField(name = "consignee_certificatetype")
        private String consigneeCertificatetype;

        //买家ID
        @JSONField(name = "buyer_id")
        private String buyerId;

        //收件人税号
        @JSONField(name = "consignee_taxno")
        private String consigneeTaxno;
    }

    //发件人信息
    @Valid
    @NotNull(message = "发件人信息不能为空")
    private Shipper shipper;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Shipper {

        //发件人公司名
        @JSONField(name = "shipper_company")
        private String shipperCompany;

        //发件人国家二字码
        @JSONField(name = "shipper_countrycode")
        @NotNull(message = "发件人国家二字码不能为空")
        private String shipperCountrycode;

        //发件人省
        @JSONField(name = "shipper_province")
        @NotNull(message = "发件人省不能为空")
        private String shipperProvince;

        //发件人城市
        @JSONField(name = "shipper_city")
        @NotNull(message = "发件人城市不能为空")
        private String shipperCity;

        //发件人地址
        @JSONField(name = "shipper_street")
        @NotNull(message = "发件人地址不能为空")
        private String shipperStreet;

        //发件人邮编
        @JSONField(name = "shipper_postcode")
        @NotNull(message = "发件人邮编不能为空")
        private String shipperPostcode;

        //区域代码
        @JSONField(name = "shipper_areacode")
        private String shipperAreacode;

        //发件人姓名
        @JSONField(name = "shipper_name")
        @NotNull(message = "发件人姓名不能为空")
        private String shipperName;

        //发件人电话
        @JSONField(name = "shipper_telephone")
        @NotNull(message = "发件人电话不能为空")
        private String shipperTelephone;

        //发件人手机
        @JSONField(name = "shipper_mobile")
        @NotNull(message = "发件人手机不能为空")
        private String shipperMobile;

        //发件人邮箱
        @JSONField(name = "shipper_email")
        private String shipperEmail;

        //发件人传真
        @JSONField(name = "shipper_fax")
        private String shipperFax;

        //订单备注
        @JSONField(name = "order_note")
        private String orderNote;
    }

    //发件人信息
    @Valid
    @NotNull(message = "海关申报信息不能为空")
    private List<ItemArr> itemArr;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ItemArr {
        //海关申报品名
        @JSONField(name = "invoice_enname")
        @NotNull(message = "海关申报品名不能为空")
        private String invoiceEnname;

        //中文海关申报品名
        @JSONField(name = "invoice_cnname")
        private String invoiceCnname;

        //单个产品申报重量，单位KG, 精确到三位小数。
        @JSONField(name = "invoice_weight")
        @NotNull(message = "申报重量不能为空")
        private Number invoiceWeight;

        //数量
        @JSONField(name = "invoice_quantity")
        @NotNull(message = "数量不能为空")
        private Integer invoiceQuantity;

        //单位(MTR(米), PCE(件), SET(套)),默认PCE
        @JSONField(name = "unit_code")
        private String unitCode;

        //单价
        @JSONField(name = "invoice_unitcharge")
        @NotNull(message = "单价不能为空")
        private Float invoiceUnitcharge;

        //申报币种，默认为USD(美元)
        @JSONField(name = "invoice_currencycode")
        private String invoiceCurrencycode;

        //海关协制编号
        @JSONField(name = "hs_code")
        private String hsCode;

        //配货信息
        @JSONField(name = "invoice_note")
        private String invoiceNote;

        //销售地址
        @JSONField(name = "invoice_url")
        private String invoiceUrl;

        //产品SKU编码
        @JSONField(name = "sku")
        private String sku;

    }
}
