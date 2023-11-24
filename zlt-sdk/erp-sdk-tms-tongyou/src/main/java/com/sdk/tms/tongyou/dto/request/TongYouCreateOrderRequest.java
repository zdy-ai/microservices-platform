package com.sdk.tms.tongyou.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

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
public class TongYouCreateOrderRequest {

    //业务单号
    private String bNo;

    //带电与否（0：否 ; 1：是）。默认 0：否
    @NotNull(message = "带电与否不能为空")
    private Integer charged;

    //保险金额
    private Number insuranceValue;

    //保价金额
    private Number insureValue;

    //物品类型（0、礼物；1、文件;2、商业样本;3、回货品;4、其他）默认 0：礼物
    @NotNull(message = "物品类型不能为空")
    private Integer itemType;

    //物流编码（拓扑链系统中的系统渠道编号）
    @NotNull(message = "物流编码不能为空")
    private String logisticsId;

    //材质
    private String material;

    //备注
    private String note;

    //订单编号
    @NotNull(message = "订单编号不能为空")
    private String orderNo;

    //护照号
    private String passportNumber;

    //包裹类型（0、文件；1、包裹;）默认 1：包裹
    private Integer pracelType;

    //来源
    private String source;

    //税号
    private String taxId;

    //IOSS 编号
    private String iossVatId;

    //是否已税（0：否，1：是）默认 0：否
    private Integer isTaxed;

    //运费，有就传，没有默认 0
    @JSONField(name = "transport_cost")
    private Number transportCost;

    //是否代收货款（0：否，1：是）
    private Number cod;

    //代收货款币别（币别码）cod 填写 1，则该字段必填
    private String codCurrency;

    //代收货款金额（保留三位小数）cod 填写 1，则该字段必填
    private Number codAmount;

    //追踪条码
    private String trackNo;

    //转单号
    private String transportNo;

    //预报重量（kg）
    @NotNull(message = "预报重量（kg）不能为空")
    private Number weight;

    @Valid
    @NotNull(message = "收件人信息不能为空")
    private Recipient recipient;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Recipient {

        //买家账号 id
        @JSONField(name = "act_id")
        @NotNull(message = "买家账号id不能为空")
        private String actId;

        //收件人地址
        @NotNull(message = "收件人地址不能为空")
        private String address;

        //收件人地址2
        @NotNull(message = "收件人地址2不能为空")
        private String address2;

        //收件人地址3
        @NotNull(message = "收件人地址3不能为空")
        private String address3;

        //收件人公司名称
        private String cName;

        //收件人城市
        @NotNull(message = "收件人城市不能为空")
        private String city;

        //收件人姓名
        @JSONField(name = "contact_person")
        @NotNull(message = "收件人姓名不能为空")
        private String contactPerson;

        //国家
        private String country;

        //收件人国 家 二 字 简 码 code(ISO/3166-2)
        @JSONField(name = "country_code")
        @NotNull(message = "收件人国 家 二 字 简 码不能为空")
        private String countryCode;

        //收件人邮箱
        private String email;

        //传真号码
        @JSONField(name = "fax_no")
        private String faxNo;

        //手机[必传]（电话、手机其中一个可传空字符）
        @JSONField(name = "mobile_no")
        @NotNull(message = "收件人电话不能为空")
        private String mobileNo;

        //收件人州省
        @NotNull(message = "收件人州省不能为空")
        private String province;

        //电话[必传]（电话、手机其中一个可传空字符）
        @JSONField(name = "tel_no")
        @NotNull(message = "收件人手机不能为空")
        private String telNo;

        //邮编
        @NotNull(message = "收件人邮编不能为空")
        private String zip;
    }

    //发件人信息
    @Valid
    @NotNull(message = "发件人信息不能为空")
    private Sender sender;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sender {

        //发件人账号 id
        @JSONField(name = "actId")
        private String actId;

        //发件人地址 1
        @NotNull(message = "发件人地址不能为空")
        private String address1;

        //发件人地址 2
        private String address2;

        //发件人地址 3
        private String address3;

        //公司名称
        @JSONField(name = "c_name")
        private String cName;

        //城市
        @NotNull(message = "发件人城市不能为空")
        private String city;

        //发件人国家二字简码
        @NotNull(message = "发件人国家二字简码不能为空")
        private String country;

        //邮箱
        private String emai;

        //发件人手机号
        @NotNull(message = "发件人手机号不能为空")
        private String mobile;

        //发件人姓名
        @NotNull(message = "发件人姓名不能为空")
        private String name;

        //发件人邮编
        @NotNull(message = "发件人邮编不能为空")
        private String postcode;

        //发件人州省
        @NotNull(message = "发件人州省不能为空")
        private String province;

        //电话（可与手机号一致）
        @NotNull(message = "发件人电话不能为空")
        private String tel;
    }

    //申报明细列表
    @Valid
    @NotNull(message = "申报明细列表不能为空")
    private List<DeclareInfo> declareInfos;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeclareInfo {

        //申报币别（币别码）
        @NotNull(message = "申报币别不能为空")
        private String currency;

        //物品描述
        private String des;

        //海关编号
        private String hs;

        //物品中文名称
        @NotNull(message = "物品中文名称不能为空")
        private String nameCN;

        //物品英文名称
        @NotNull(message = "物品英文名称不能为空")
        private String nameEN;

        //申报物品价格(单价)
        @NotNull(message = "申报物品价格(单价)不能为空")
        private Number price;

        //申报数量
        @NotNull(message = "申报数量不能为空")
        private Integer qty;

        //Sku
        private String sku;

        //申报重量（kg）(单件重量)
        @NotNull(message = "申报重量（kg）(单件重量)不能为空")
        private Number weight;

        //产品链接
        private String url;

    }
}
