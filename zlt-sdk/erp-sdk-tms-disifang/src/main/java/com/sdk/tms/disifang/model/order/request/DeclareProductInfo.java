package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.core.anno.StateEnumValue;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zdy
 * @ClassName DeclareProductInfo
 * @description: 海关申报信息
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class DeclareProductInfo implements Serializable {
    /**
     * 申报产品代码（在4PX已备案申报产品的代码
     */
    @JSONField(name = "declare_product_code")
    private String declare_product_code;
    /**
     * 手机	申报品名(当地语言)
     */
    @JSONField(name = "declare_product_name_cn")
    private String declare_product_name_cn;
    /**
     * Phone	申报品名（英语）
     */
    @JSONField(name = "declare_product_name_en")
    private String declare_product_name_en;
    /**
     * 通讯	用途
     */
    @JSONField(name = "uses")
    private String uses;
    /**
     * 34×24×12	规格
     */
    @JSONField(name = "specification")
    private String specification;
    /**
     * 金属、塑料	成分
     */
    @JSONField(name = "component")
    private String component;
    /**
     * 1000	单件商品净重（默认以g为单位）
     */
    @JSONField(name = "unit_net_weight")
    private Integer unit_net_weight;
    /**
     * 2300	单件商品毛重（默认以g为单位）
     */
    @JSONField(name = "unit_gross_weight")
    private Integer unit_gross_weight;
    /**
     * 金属、塑料	材质
     */
    @JSONField(name = "material")
    private String material;
    /**
     * 3	申报数量
     * 是
     */
    @NotNull(message = "申报数量不能为空")
    @JSONField(name = "declare_product_code_qty")
    private Integer declare_product_code_qty;
    /**
     * PCS	单位（点击查看详情；默认值：PCS）
     */
    @JSONField(name = "unit_declare_product")
    private String unit_declare_product = "PCS";
    /**
     * CN	原产地（ISO标准2字码）点击查看详情
     */
    @JSONField(name = "origin_country")
    private String origin_country;
    /**
     * CN	出口国/起始国/发件人国家（ISO标准2字码）
     */
    @JSONField(name = "country_export")
    private String country_export;
    /**
     * CN	进口国/目的国/收件人国家（ISO标准2字码
     */
    @JSONField(name = "country_import")
    private String country_import;
    /**
     * 9004909000	出口国/起始国/发件人国家_海关编码(只支持数字)
     */
    @JSONField(name = "hscode_export")
    private String hscode_export;
    /**
     * 9004909000	进口国/目的国/收件人国家_海关编码(只支持数字)
     */
    @JSONField(name = "hscode_import")
    private String hscode_import;
    /**
     * 23	出口国/起始国/发件人国家_申报单价（按对应币别的法定单位，最多4位小数点）
     * 是
     */
    @NotNull(message = "起始国申报单价不能为空")
    @JSONField(name = "declare_unit_price_export")
    private BigDecimal declare_unit_price_export;
    /**
     * USD	出口国/起始国/发件人国家_申报单价币种（按照ISO标准；支持的币种，根据物流产品+收件人国家配置；币种需和进口国申报币种一致）
     *  是
     */
    @StateEnumValue(strValues = {"USD", "EUR","GBP","CNY","AUD","CAD"}, message = "起始国申报单价币种代码有误")
    @JSONField(name = "currency_export")
    private String currency_export;
    /**
     * 进口国/目的国/收件人国家_申报单价（按对应币别的法定单位，最多4位小数点）
     *  是
     */
    @NotNull(message = "目的国申报单价不能为空")
    @JSONField(name = "declare_unit_price_import")
    private BigDecimal declare_unit_price_import;
    /**
     * 进口国/目的国/收件人国家_申报单价币种（按照ISO标准；支持的币种，根据物流产品+收件人国家配置；币种需和出口国申报币种一致）
     * 是
     */
    @StateEnumValue(strValues = {"USD", "EUR","GBP","CNY","AUD","CAD"}, message = "目的国申报单价币种代码有误")
    @JSONField(name = "currency_import")
    private String currency_import;
    /**
     * none	出口国/起始国/发件人国家_品牌(必填；若无，填none即可)
     * 是
     */
    @JSONField(name = "brand_export")
    private String brand_export = "none";
    /**
     * 狮子牌	进口国/目的国/收件人国家_品牌(必填；若无，填none即可)
     * 是
     */
    @JSONField(name = "brand_import")
    private String brand_import = "none";
    /**
     * https://ju.taobao.com/jusp/other/mingpin/tp.htm?spm=875.7931836/B.2017039.4.5ff54265S5IEz9&pos=2&acm=201708280-2.1003.2.3116407&scm=1003.2.201708280-2.OTHER_1519569914238_3116407
     * 商品销售URL
     */
    @JSONField(name = "sales_url")
    private String sales_url;
    /**
     * skutest	配货字段（打印标签选择显示配货信息是将会显示：package_remarks*qty）
     */
    @JSONField(name = "package_remarks")
    private String package_remarks;
}
