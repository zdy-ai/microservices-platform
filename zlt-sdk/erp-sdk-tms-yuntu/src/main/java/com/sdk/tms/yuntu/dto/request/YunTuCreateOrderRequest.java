package com.sdk.tms.yuntu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
public class YunTuCreateOrderRequest {

    //客户订单号,不能重复
    @NotBlank(message = "客户订单号不能为空")
    private String customerOrderNumber;

    //运输方式代码
    @NotBlank(message = "运输方式代码不能为空")
    private String shippingMethodCode;

    //包裹跟踪号，可以不填写
    private String trackingNumber;

    //平台交易号（wish 邮）
    private String transactionNumber;

    //增值税号，巴西国家必填 CPF 或 CNPJ，CPF 码格式为 000.000.000-00,CNPJ码格式为 00.000.000/0000-00，其它国家非必填，英国税号格式为：前缀GB+9位纯数字 或者前缀GB+12位纯数字
    private String taxNumber;

    //欧盟税号，非必填，格式为：前缀GB+9位纯数字+后缀000 或者 前缀GB+12位纯数字+后缀000
    private String eoriNumber;

    //税号所属国家
    private String taxCountryCode;

    //进口商名称
    private String importerName;

    //进口商地址
    private String importerAddress;

    //税号证明
    private String taxProve;

    //税号备注
    private String taxRemark;

    //仓库代码
    private String warehouseAddressCode;

    //预估包裹单边长，单位cm，非必填，默认1
    private Integer length;

    //预估包裹单边宽，单位cm，非必填，默认1
    private Integer width;

    //预估包裹单边高，单位cm，非必填，默认1
    private Integer height;

    //运单包裹的件数，必须大于 0 的整数
    @NotNull(message = "运单包裹的件数不能为空")
    private Integer packageCount;

    //预估包裹总重量，单位 kg,最多 3 位小数
    @NotNull(message = "预估包裹总重量不能为空")
    private Number weight;

    //申 报 类 型 , 用 于 打 印 CN22 ，1-Gift,2-Sameple,3-Documents,4-Others, 默认 4-Other
    private Integer applicationType;

    //是否退回,包裹无人签收时是否退回，1-退回，0-不退回，默认 0
    private Boolean returnOption;

    //关税预付服务费，1-参加关税预付，0-不参加关税预付，默认 0 (渠道需开通关税预付服务)
    private Boolean tariffPrepay;

    //包裹投保类型，0-不参保，1-按件，2-按比例，默认 0，表示不参加运输保险，具体参考包裹运输
    private Integer insuranceOption;

    //保险的最高额度，单位 RMB
    private Number coverage;

    //包裹中特殊货品类型，可调用货品类型查询服务查询，可以不填写，表示普通货品
    private Integer sensitiveTypeID;

    //订单来源代码
    private String sourceCode;

    //IOSS备案识别码或IOSS号；走欧盟税改IOSS流程的订单， IossCode或OrderExtra必须二者填一
    private String iossCode;

    //收件人信息
    @Valid
    @NotNull(message = "收件人信息不能为空")
    private Receiver receiver;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Receiver {

        //收件人所在国家，填写国际通用标准 2 位简码，可通过国家查询服务查询
        @NotBlank(message = "收件人所在国家不能为空")
        private String countryCode;

        //收件人姓
        @NotBlank(message = "收件人姓不能为空")
        private String firstName;

        //收件人名字
        private String lastName;

        //收件人公司名称
        private String company;

        //收件人详细地址
        @NotBlank(message = "收件人详细地址不能为空")
        private String street;

        //收件人详细地址 1
        private String streetAddress1;

        //收件人详细地址 2
        private String streetAddress2;

        //收件人所在城市
        @NotBlank(message = "收件人所在城市不能为空")
        private String city;

        //收件人省/州
        private String state;

        //邮编
        private String zip;

        //收件人电话
        private String phone;

        //收件人街道地址门牌号
        private String houseNumber;

        //收件人电子邮箱
        private String email;

        //收件人手机号
        private String mobileNumber;

        //收件人ID，中东专线-约旦国家必填，10位数字
        private String certificateCode;
    }

    //发件人信息
    @Valid
    private Sender sender;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sender {

        //发件人所在国家，填写国际通用标准 2 位简码，可通过国家查询服务查询
        private String countryCode;

        //发件人姓
        private String firstName;

        //发件人名
        private String lastName;

        //发件人公司名称
        private String company;

        //发件人详细地址 FBA 必填
        private String street;

        //发件人州(省)
        private String state;

        //发件人城市
        private String city;

        //发件人邮编
        private String zip;

        //发件人电话
        private String phone;
    }

    //申报信息
    @Valid
    @NotNull(message = "申报信息不能为空")
    private List<Parcels> parcels;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Parcels {

        //包裹申报名称(英文)必填
        @NotNull(message = "包裹申报名称(英文)不能为空")
        private String eName;

        //包裹申报名称(中文)
        private String cName;

        //海关编码
        private String hsCode;

        //申报数量
        @NotNull(message = "申报数量不能为空")
        private Integer quantity;

        //申报价格(单价) ,必填
        @NotNull(message = "申报价格(单价)不能为空")
        private BigDecimal unitPrice;

        //申报重量(单重)，单位 kg
        @NotNull(message = "申报重量不能为空")
        private Number unitWeight;

        //订单备注，用于打印配货单
        private String remark;

        //产品销售链接地址
        private String productUrl;

        //用于填写商品 SKU，FBA 订单必填
        private String sku;

        //配货信息
        private String invoiceRemark;

        //申报币种，默认USD，英国支持GBP/EUR，欧盟国家支持EUR。
        private String currencyCode;

        //SKU附件
        private String attachment;

        //材质
        private String invoicePart;

        //用途
        private String invoiceUsage;

    }

    //箱子明细信息，FBA 订单必填
    @Valid
    private List<ChildOrders> childOrders;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChildOrders {

        //箱子编号，FBA 订单必填
        private String boxNumber;

        //预估包裹单边长，单位 cm，默认 1，FBA 订单必填
        private Integer length;

        //预估包裹单边宽，单位 cm，默认 1，FBA 订单必填
        private Integer width;

        //预估包裹单边高，单位 cm，默认 1，FBA 订单必填
        private Integer height;

        //预估包裹总重量，单位 kg,最多 3 位小数，FBA 订单必填
        private BigDecimal boxWeight;


        //单箱 SKU 信息，FBA 订单必填
        private List<ChildDetails> childDetails;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ChildDetails {

            //用于填写商品 SKU，FBA 订单必填
            private String sku;

            //申报数量，FBA 订单必填
            private Integer quantity;
        }
    }

    //附加服务； 走欧盟税改IOSS流程的订单， IossCode或OrderExtra必须二者填一
    @Valid
    private List<OrderExtra> orderExtra;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderExtra {

        //额外服务代码:G0代表关税预付；10代表报关件；V1代表云途预缴IOSS附加服务费（走欧盟税改IOSS流程的订单， IossCode或OrderExtra必须二者填一）
        @NotNull
        private String extraCode;

        //额外服务名称
        @NotNull
        private String extraName;

        //额外服务值
        private String extraValue;

        //额外服务备注
        private String extraNote;
    }
}
