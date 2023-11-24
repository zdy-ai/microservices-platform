package com.sdk.wms.goodcang.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodCangCreateOutboundReq {

    //订单参考号
    @JSONField(name = "reference_no")
    private String referenceNo;

    //平台
    @JSONField(name = "platform")
    private String platform;

    //物流产品代码
    //参考getShippingMethod。
    //（当使用物流优选服务时，可选填项，参见vas.logistics_recommendation_option选项）。
    //当使用物流优选时，该参数必须传null，或者不传，否则报错。
    @JSONField(name = "shipping_method")
    @NotNull(message = "物流产品代码不能为空")
    private String shippingMethod;

    //配送仓库代码
    //参考getWarehouse。（当使用物流优选服务时，可选填项，参见vas.logistics_recommendation_option选项）。
    //当使用物流优选时，且入参提供了仓库，则系统在该仓库范围内选择适用的物流方式。
    @JSONField(name = "warehouse_code")
    @NotNull(message = "配送仓库代码不能为空")
    private String warehouseCode;

    //收件人国家/地区
    @JSONField(name = "country_code")
    @NotNull(message = "收件人国家/地区不能为空")
    private String countryCode;

    //省/州
    @JSONField(name = "province")
    @NotNull(message = "省/州不能为空")
    private String province;

    //城市
    @JSONField(name = "city")
    @NotNull(message = "城市不能为空")
    private String city;

    //公司名称
    @JSONField(name = "company")
    private String company;

    //地址1
    //关于地址1长度限制50的说明：
    //市面上绝大部分物流服务商，不支持地址1超过50字符，超过的部分，要拆解到地址2。
    //地址1、地址2必填一个。
    @JSONField(name = "address1")
    @NotNull(message = "地址1不能为空")
    private String address1;

    //地址2
    @JSONField(name = "address2")
    private String address2;

    //邮编
    @JSONField(name = "zipcode")
    @NotNull(message = "邮编不能为空")
    private String zipcode;

    //门牌号
    @JSONField(name = "doorplate")
    private String doorplate;

    //收件人名
    @JSONField(name = "name")
    @NotNull(message = "收件人名不能为空")
    private String name;

    //收件人姓
    @JSONField(name = "last_name")
    private String lastName;

    //收件人电话
    @JSONField(name = "phone")
    private String phone;

    //收件人邮箱
    @JSONField(name = "email")
    private String email;

    //分机号
    @JSONField(name = "cell_phone")
    private String cellPhone;

    //是否直接审核
    //默认为0
    //审核通过之后，不可编辑
    @JSONField(name = "verify")
    private Integer verify;

    //派送方式是否允许修改
    @JSONField(name = "is_shipping_method_not_allow_update")
    private Integer isShippingMethodNotAllowUpdate;

    //签名服务
    @JSONField(name = "is_signature")
    private Integer isSignature;

    //保险服务
    @JSONField(name = "is_insurance")
    private Integer isInsurance;

    //保额
    @JSONField(name = "insurance_value")
    private Float insuranceValue;

    //FBA Shipment ID FBA 类型订单必填 是12位数字+加字母组成
    @JSONField(name = "fba_shipment_id")
    private String fbaShipmentId;

    //FBA Shipment ID创建时间
    @JSONField(name = "fba_shipment_id_create_time")
    private String fbaShipmentIdCreateTime;

    //FBA换标服务
    @JSONField(name = "is_change_label")
    private Integer isChangeLabel;

    //LiftGate服务
    @JSONField(name = "LiftGate")
    private Integer liftGate;

    //年龄检测服务
    //若选择的物流产品支持年龄检测服务不填则默认16，该服务只可填16或18。其他物流产品默认为0不检测。
    //特别说明：如果物流产品支持年龄检测服务，该参数只能传16或18，传0或者不传，将强制改为16。
    @JSONField(name = "age_detection")
    private Integer ageDetection;

    //付款时间
    @JSONField(name = "payment_time")
    private String paymentTime;

    //订单附件id数组
    @JSONField(name = "attachment_ids")
    private List<Integer> attachmentIds;

    //订单备注
    @JSONField(name = "order_desc")
    private String orderDesc;

    //订单明细
    @JSONField(name = "items")
    @NotNull(message = "订单明细不能为空")
    private List<Item> itemList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Item {

        //商品SKU
        @JSONField(name = "product_sku")
        @NotNull(message = "商品SKU不能为空")
        private String productSku;

        //数量
        @JSONField(name = "quantity")
        @NotNull(message = "数量不能为空")
        private Integer quantity;

        //FBA商品编码
        @JSONField(name = "fba_product_code")
        private String fbaProductCode;

        //订单交易号
        @JSONField(name = "transaction_id")
        private String transactionId;

        //订单商品编码
        @JSONField(name = "item_id")
        private String itemId;

        //合规负责人编码
        @JSONField(name = "euro_terms_code")
        private String euroTermsCode;

        //内件货物总数量
        @JSONField(name = "label_replacement_qty")
        private Integer labelReplacementQty;

        //海关编码
        @JSONField(name = "hs_code")
        private String hsCode;

        //申报价值(USD)
        @JSONField(name = "product_declared_value")
        private Float productDeclaredValue;

        //每单件换标数量
        //换标服务为 1:换标 时，不传默认为 1
        //当换标服务为 0:不换标 时，该参数必须为null，或者不传。
        @JSONField(name = "change_label_qty_piece")
        private Integer changeLabelQtyPiece;
    }

    //配送方式
    //该字段受限于是否开通仓配分离服务（仓配分离服务只支持标准订单）
    @JSONField(name = "business_type")
    private String businessType;

    //预计到货日期
    //物流产品支持则填写， 格式例如：2021-03-01
    @JSONField(name = "estimated_arrival_date")
    private String estimatedArrivalDate;

    //到货时间段
    //兼容数字枚举 或 具体时间段
    //具体时间段支持“~”和“-”两种时间分隔符（例如：08:00~12:00 或 08:00-12:00）
    //物流产品支持则可填写，否则输入无效。
    @JSONField(name = "estimated_arrival_time")
    private String estimatedArrivalTime;

    //发件人信息
    @JSONField(name = "sender_info")
    private SenderInfo senderInfo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SenderInfo {

        //发件人姓名
        @JSONField(name = "name")
        private String name;

        //发件人电话
        @JSONField(name = "phone")
        private Integer phone;
    }

    //欧盟税改资料
    @JSONField(name = "vat_change_info")
    private VatChangeInfo vatChangeInfo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class VatChangeInfo {

        //IOSS号码
        @JSONField(name = "ioss_number")
        private String iossNumber;

        //PID号码
        @JSONField(name = "pid_number")
        private String pidNumber;

        //收件人EORI
        @JSONField(name = "recipient_eori")
        private String recipientEori;

        //收件人VAT
        @JSONField(name = "recipient_vat")
        private String recipientVat;

        //发件人EORI
        @JSONField(name = "shipper_eori")
        private String shipperEori;

        //发件人VAT
        @JSONField(name = "shipper_vat")
        private String shipperVat;

        //收件人VAT注册国/地区
        //参考getCountry获取国家/地区列表接口的 country_code 字段
        @JSONField(name = "recipient_vat_country")
        private String recipientVatCountry;

        //收件人EORI注册国/地区
        //参考getCountry获取国家/地区列表接口的 country_code 字段
        @JSONField(name = "recipient_eori_country")
        private String recipientEoriCountry;

        //发件人公司名称
        @JSONField(name = "shipper_company_name")
        private String shipperCompanyName;
    }

    //是否仓库装箱商品
    //FBA订单适用。is_warehouse_packing = 1时，FBA转仓单信息（carton_info）必填。
    @JSONField(name = "is_warehouse_packing")
    private Integer isWarehousePacking;

    //FBA转仓单信息
    @JSONField(name = "carton_info")
    private CartonInfo cartonInfo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CartonInfo {

        //箱唛号列表
        @JSONField(name = "carton_list")
        private List<CartonDetail> cartonList;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static class CartonDetail {

            //箱唛号
            @JSONField(name = "carton_no")
            private String cartonNo;

            //FBA箱唛号
            @JSONField(name = "fba_box_mark")
            private String fbaBoxMark;
        }

        //商品信息变更列表
        @JSONField(name = "renewal_product_list")
        private List<RenewalProduct> renewalProductList;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static class RenewalProduct {

            //商品sku
            @JSONField(name = "sku")
            private String sku;

            //海关编码
            @JSONField(name = "hs_code")
            private String hsCode;

            //申报价值(USD)
            @JSONField(name = "product_declared_value")
            private String productDeclaredValue;
        }
    }

    //卡派渠道物流信息
    //FBA类型订单 并且 所选物流产品为卡派渠道（is_truck=1）时, 必填。
    @JSONField(name = "truck_info")
    private TruckInfo truckInfo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TruckInfo {

        //参考号
        //当物流产品为卡派渠道时需要填写，也可更换非卡派渠道物流产品
        @JSONField(name = "reference_id")
        private String referenceId;

        //店铺名称
        //当物流产品为卡派渠道时需要填写，也可更换非卡派渠道物流产品
        @JSONField(name = "seller_name")
        private String sellerName;

        //FBA仓库代码
        //亚马逊仓库地址四字代码，当物流产品为卡派渠道时需要填写，也可更换非卡派渠道物流产品
        @JSONField(name = "fba_warehouse_code")
        private String fbaWarehouseCode;
    }

    //平台模式
    @JSONField(name = "property_label")
    private String propertyLabel;

    //订单包装要求
    //请注意：未开启订单销售包材服务不支持选择
    @JSONField(name = "customer_package_requirement")
    private Integer customerPackageRequirement;

    //是否打板
    //当前填写的物流产品为支持客户选择是否打板时，此字段传是或否才会生效。若物流产品不支持客户选择是否打板，此字段传是或否均不生效，谷仓会忽略此字段传值。
    @JSONField(name = "is_optional_board")
    private Integer isOptionalBoard;
}
