package com.sdk.wms.goodcang.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.business.dto.CleanBaseDTO;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class GoodCangSkuResp extends CleanBaseDTO implements Serializable {

    //商品sku
    @JSONField(name = "product_sku")
    private String productSku;

    //客户参考号
    @JSONField(name = "reference_no")
    private String referenceNo;

    //产品状态
    @JSONField(name = "product_status")
    private String productStatus;

    //中文名称
    @JSONField(name = "product_title_cn")
    private String productTitleCn;

    //英文名称
    @JSONField(name = "product_title_en")
    private String productTitleEn;

    //中文申报品名
    @JSONField(name = "product_declared_name_cn")
    private String productDeclaredNameCn;

    //重量 单位CM
    @JSONField(name = "product_weight")
    private Float productWeight;

    //长 单位CM
    @JSONField(name = "product_length")
    private Float productLength;

    //宽 单位CM
    @JSONField(name = "product_width")
    private Float productWidth;

    //高 单位CM
    @JSONField(name = "product_height")
    private Float productHeight;

    //实收重量 单位KG
    @JSONField(name = "Product_real_weight")
    private Float productRealWeight;

    //实收长 单位CM
    @JSONField(name = "Product_real_length")
    private Float productRealLength;

    //实收宽 单位CM
    @JSONField(name = "Product_real_width")
    private Float productRealWidth;

    //实收高 单位CM
    @JSONField(name = "Product_real_height")
    private Float productRealHeight;

    //货物属性
    @JSONField(name = "contain_battery")
    private Integer containBattery;

    //商品包裹类型
    @JSONField(name = "type_of_goods")
    private Integer typeOfGoods;

    //一级品类
    @JSONField(name = "cat_id_level0")
    private Integer catIdLevel0;

    //二级品类
    @JSONField(name = "cat_id_level1")
    private Integer catIdLevel1;

    //三级品类
    @JSONField(name = "cat_id_level2")
    private Integer catIdLevel2;

    //品类语言
    @JSONField(name = "cat_lang")
    private String catLang;

    //是否品牌
    private Integer branded;

    //商品品牌
    @JSONField(name = "product_brand")
    private String productBrand;

    //商品型号
    @JSONField(name = "product_model")
    private String productModel;

    //商品链接
    @JSONField(name = "product_link")
    private String productLink;

    //成交单位
    private String unit;

    //商品图片链接
    @JSONField(name = "image_link")
    private List<String> imageLink;

    //商品关税信息
    @JSONField(name = "tax_info")
    private List<TaxInfo> taxInfoList;

    @Data
    @ToString
    public static class TaxInfo {

        //可发国家/地区
        @JSONField(name = "exportable_country")
        private String exportableCountry;

        //进口申报品名
        @JSONField(name = "product_declared_name")
        private String productDeclaredName;

        //关税计算值
        @JSONField(name = "tariff_calculation_value")
        private Float tariffCalculationValue;

        //币种
        private String currency;

        //关税百分比
        @JSONField(name = "tariff_percentage")
        private String tariffPercentage;

        //附加关税税率
        @JSONField(name = "additional_tax_rate")
        private String additionalTaxRate;

        //VAT税率
        @JSONField(name = "vat_tax_rate")
        private String vatTaxRate;

        //海外仓是否可存 Y/N
        @JSONField(name = "allow_save")
        private String allowSave;

        //头程类型
        @JSONField(name = "head_type")
        private String headType;

        //申报价值
        @JSONField(name = "declared_value")
        private String declaredValue;

    }

    //出口国关税信息
    @JSONField(name = "export_country")
    private List<ExportCountry> exportCountryList;

    @Data
    @ToString
    public static class ExportCountry {

        //国家/地区简称
        @JSONField(name = "country_code")
        private String countryCode;

        //申报价值
        @JSONField(name = "declared_value")
        private Float declaredValue;
    }

    //进口国清关信息
    @JSONField(name = "import_country")
    private List<ImportCountry> importCountryList;

    @Data
    @ToString
    public static class ImportCountry {

        //国家/地区简称
        @JSONField(name = "country_code")
        private String countryCode;

        //申报价值
        @JSONField(name = "declared_value")
        private Float declaredValue;
    }

    //是否异形商品
    @JSONField(name = "IsIrregular")
    private Integer isIrregular;

    //进口国备注
    @JSONField(name = "import_country_remark")
    private String importCountryRemark;

    //查验审核备注
    @JSONField(name = "check_remark")
    private String checkRemark;

    //货型
    @JSONField(name = "cargo_type")
    private String cargoType;

    //添加时间
    @JSONField(name = "product_add_time")
    private LocalDateTime productAddTime;

    //异动时间
    @JSONField(name = "product_modify_time")
    private LocalDateTime productModifyTime;

    //第三方条码列表
    @JSONField(name = "thirdparty_sku_mapping")
    private List<String> thirdPartySkuMapping;

    //出库是否采集序列号
    @JSONField(name = "is_collect_serial_number")
    private Boolean isCollectSerialNumber;

    //入库是否采集序列号
    @JSONField(name = "is_inbound_collect_serial_number")
    private Boolean isInboundCollectSerialNumber;

    //SKU包装属性
    @JSONField(name = "sku_wrapper_type")
    private Integer skuWrapperType;

    //电池信息
    @JSONField(name = "battery_info")
    private BatteryInfo batteryInfo;

    @Data
    @ToString
    public static class BatteryInfo {

        //电池型号
        @JSONField(name = "battery_model")
        private String batteryModel;

        //UN编码
        @JSONField(name = "un_code")
        private String unCode;

        //电池功率范围（WH）
        @JSONField(name = "battery_power_range")
        private Integer batteryPowerRange;

        //电池功率（WH）
        @JSONField(name = "battery_power")
        private Integer batteryPower;

        //MSDS报告证书链接
        @JSONField(name = "msds_file_url")
        private String msdsFileUrl;
    }

    //备注
    private String remark;

    //原箱预报内件数
    @JSONField(name = "predict_pcs_inner")
    private Integer predictPcsInner;

    //原箱实际内件数
    @JSONField(name = "receive_pcs_inner")
    private Integer receivePcsInner;
}
