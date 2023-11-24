package com.sdk.wms.goodcang.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodCangCreateInboundReq {

    //入库单类型
    @JSONField(name = "transit_type")
    @NotNull(message = "入库单类型不能为空")
    private Integer transitType;

    //参考号
    @JSONField(name = "reference_no")
    private String referenceNo;

    //运输方式
    @JSONField(name = "receiving_shipping_type")
    @NotNull(message = "运输方式不能为空")
    private Integer receivingShippingType;

    //跟踪号/海柜号
    //中转选填，verify=1（入库单提交审核）时自发，FBA转仓必填
    @JSONField(name = "tracking_number")
    private String trackingNumber;

    //海外仓仓库编码
    @JSONField(name = "warehouse_code")
    @NotBlank(message = "海外仓仓库编码不能为空")
    private String warehouseCode;

    //预计到达时间
    @JSONField(name = "eta_date")
    private LocalDate etaDate;

    //是否审核值
    @JSONField(name = "verify")
    private Integer verify;

    //备注
    @JSONField(name = "receiving_desc")
    private String receivingDesc;

    //入库单发货地址
    //仅适用于自发入库单
    @JSONField(name = "shiper_address")
    private ShiperAddress shiperAddress;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ShiperAddress {

        //联系人
        @JSONField(name = "sa_contacter")
        @NotBlank(message = "联系人不能为空")
        private String saContacter;

        //联系电话（手机号）
        @JSONField(name = "sa_contact_phone")
        @NotBlank(message = "联系电话（手机号）不能为空")
        private String saContactPhone;

        //发件国家/地区简称
        @JSONField(name = "sa_country_code")
        @NotBlank(message = "发件国家/地区简称不能为空")
        private String saCountryCode;

        //省/州
        @JSONField(name = "sa_state")
        @NotBlank(message = "省/州不能为空")
        private String saState;

        //城市
        @JSONField(name = "sa_city")
        @NotBlank(message = "城市不能为空")
        private String saCity;

        //区
        @JSONField(name = "sa_region")
        private String saRegion;

        //地址1
        @JSONField(name = "sa_address1")
        private String saAddress1;

        //地址2
        @JSONField(name = "sa_address2")
        private String saAddress2;
    }

    //进口商编码
    //- 目的仓库对应的国家/地区需要提供VAT(目前英国、德国、法国需要提供)
    //- transit_type=3特有
    //- 必填条件：clearance_service=1（自有税号清关）
    @JSONField(name = "import_company")
    private Integer importCompany;

    //入库单明细
    @NotNull(message = "入库单明细不能为空")
    private List<Item> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Item {

        //箱唛参考号
        //自发入库单/FBA入库单 才有该字段
        //FBA入库单，且为仓库装箱商品（is_rollover=1）时，必填。
        @JSONField(name = "reference_box_no")
        private String referenceBoxNo;

        //箱号
        @JSONField(name = "box_no")
        @NotNull(message = "箱号不能为空")
        private String boxNo;

        //箱子信息
        @JSONField(name = "box_details")
        @NotNull(message = "箱子信息不能为空")
        private List<BoxDetail> box_detailList;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static class BoxDetail {

            //商品SKU
            @JSONField(name = "product_sku")
            private String productSku;

            //数量
            @JSONField(name = "quantity")
            private Integer quantity;

            //FBA商品编码
            //transit_type=5（FBA入库单）, 且不是仓库装箱商品（is_rollover=0）时，必填。
            //为仓库装箱商品（is_rollover=1）时，无需填写，该值会默认置空。
            @JSONField(name = "fba_product_code")
            private String fbaProductCode;

            //序列号集成码
            @JSONField(name = "data_code")
            private String dataCode;

            //序列号
            @JSONField(name = "serial_number")
            private String serialNumber;
        }
    }

    //中转仓仓库编码
    //transit_type=3特有。（非整柜：物流产品绑定的中转仓库 ， 整柜：国内中转仓库）
    @JSONField(name = "transit_warehouse_code")
    private String transitWarehouseCode;

    //物流产品
    //transit_type=3特有。物流产品（整柜无需填）
    @JSONField(name = "sm_code")
    private String smCode;

    //报关方式
    //transit_type=3特有
    @JSONField(name = "customs_type")
    private Integer customsType;

    //揽收服务
    //transit_type=3特有
    @JSONField(name = "collecting_service")
    private Integer collectingService;

    //揽收资料
    //- transit_type=3特有必填条件
    //- 当collecting_service=1（上门揽收）时必填
    @JSONField(name = "collecting_address")
    private List<CollectingAddress> collectingAddressList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CollectingAddress{

        //揽收联系人-名
        @JSONField(name = "ca_first_name")
        private String caFirstName;

        //揽收联系人-姓
        @JSONField(name = "ca_last_name")
        private String caLastName;

        //揽收联系人电话
        @JSONField(name = "ca_contact_phone")
        private String caContactPhone;

        //揽收地址国家/地区
        @JSONField(name = "ca_country_code")
        private String caCountryCode;

        //揽收地址州/省份
        @JSONField(name = "ca_state")
        private String caState;

        //揽收地址城市
        @JSONField(name = "ca_city")
        private String caCity;

        //揽收地址邮编
        @JSONField(name = "ca_zipcode")
        private String caZipcode;

        //揽收地址1
        @JSONField(name = "ca_address1")
        private String caAddress1;

        //揽收地址2
        @JSONField(name = "ca_address2")
        private String caAddress2;
    }

    //客户自送信息
    //- transit_type=3特有
    //- 必填条件：当collecting_service=0（自送货物）时必填
    @JSONField(name = "customers_send_info")
    private CustomersSendInfo customersSendInfo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CustomersSendInfo{

        //预计到达中转仓时间
        @JSONField(name = "arrive_transfer_warehouse_time")
        private LocalDateTime arriveTransferWarehouseTime;

        //快递公司名称
        @JSONField(name = "company_name")
        private String companyName;

        //快递单号
        //注：多个快递单号用英文逗号隔开
        @JSONField(name = "delivery_code")
        private String deliveryCode;

        //司机姓名
        @JSONField(name = "driver_name")
        private String driverName;

        //司机电话
        @JSONField(name = "driver_phone")
        private String driverPhone;

        //车牌号
        @JSONField(name = "plate_no")
        private String plateNo;
    }

    //揽收时间
    @JSONField(name = "collecting_time")
    private LocalDateTime collectingTime;

    //车型
    //车型接口获取。
    //transit_type=3特有。当collecting_service=1时必填。
    @JSONField(name = "car_model_code")
    private String carModelCode;

    //重量
    @JSONField(name = "weight")
    private Float weight;

    //体积
    @JSONField(name = "volume")
    private Float volume;

    //是否自有税号清关
    //transit_type=3特有
    //注：当warehouse_code开启了VAT，必为1；如没开启，可选0或者1
    @JSONField(name = "clearance_service")
    private Integer clearanceService;

    //出口商编码
    //transit_type=3特有
    @JSONField(name = "export_company")
    private Integer exportCompany;

    //物理仓仓库代码
    //通过获取系统仓库接口获取物理仓编码，不传默认为仓库主物理仓编码。
    @JSONField(name = "wp_code")
    private String wpCode;

    //是否递延
    @JSONField(name = "is_delay")
    private Integer isDelay;

    //是否仓库装箱商
    @JSONField(name = "is_rollover")
    private Integer isRollover;
}
