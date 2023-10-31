package com.sdk.tms.express.model.order.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ContactInfo
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class ContactInfo implements Serializable {
    /**
     * 地址类型：1，寄件方信息2，到件方信息
     * 是
     */
    private Integer contactType;
    /***
     *公司名称
     */
    private String company;
    /***
     *联系人
     */
    private String contact;
    /***
     *联系电话
     */
    private String tel;
    /***
     *方手机
     */
    private String mobile;
    /***
     *城市代码或国家代码，如果是跨境件，则此字段为必填。
     */
    private String zoneCode;
    /***
     *国家或地区2 位代码参照附录国家代码附件
     * 是
     */
    private String country;
    /***
     *所在省级行政区名称，必须是标准的省级行政区名称如：北京、广东省、广西壮族自治区等；此字段影响原寄地代码识别，建议尽可能传该字段的值。
     */
    private String province;
    /***
     *所在地级行政区名称，必须是标准的城市称谓如：北京市、深圳市、大理白族自治州等；此字段影响原寄地代码识别，建议尽可能传该字段的值
     */
    private String city;
    /***
     *所在县/区级行政区名称，必须是标准的县/区称谓，如：福田区，南涧彝族自治县、准格尔旗等。
     */
    private String county;
    /***
     *详细地址，若province/city字段的值不传，此字段必须包含省市信息，避免影响原寄地代码识别，如：广东省深圳市福田区新洲十一街万基商务大厦10 楼；若需要生成电子运单，则为必填。
     */
    private String address;
    /***
     *邮编，跨境件必填（中国内地，港澳台互寄除外）。
     */
    private String postCode;
    /***
     *邮箱地址
     */
    private String email;
    /***
     *税号
     */
    private String taxNo;
}
