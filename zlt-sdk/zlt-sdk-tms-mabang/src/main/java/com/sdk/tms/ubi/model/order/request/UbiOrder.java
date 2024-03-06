package com.sdk.tms.ubi.model.order.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName UbiOrder
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class UbiOrder implements Serializable {
    private static final long serialVersionUID = 2801814838883246461L;
    //客户端的订单唯一标识
    private String referenceNo;
    //客户端订单号
    private String referenceNo1;
    //跟踪号
    private String trackingNo;
    //服务代码，物流商提供
    private String serviceCode;
    //服务选项，物流商提供
    private String serviceOption;
    //DDU/DDP
    private String incoterm;
    //英文品名
    private String description;
    //中文品名
    private String nativeDescription;
    //重量(>=0.000001)
    private Double weight;
    //重量单位，枚举值：G, KG,LB
    //默认值：KG
    private String weightUnit;
    //长
    private Double length;
    //宽
    private Double width;
    //高
    private Double height;
    //体积(>=0.01)
    private Double volume;
    //长度单位，枚举值：M, CM
    //默认值：CM
    private String dimensionUnit;
    //货值(>=0.01)，与sum(itemCount * unitValue)的误差不能超过0.1
    private Double invoiceValue;
    //币种，ISO货币代码
    private String invoiceCurrency;
    //枚举值：Y/N
    //默认值：N
    private Boolean pickUp;
    //不需要签名（置放于收货人门口）
    private Boolean authorityToLeave;
    //
    private Boolean lockerService;
    /**
     * 电池类型，枚举值：
     * No Battery
     * Lithium Ion Polymer
     * Lithium Ion Alloy
     * 默认值：No Battery
     */
    private String batteryType;
    /**
     * 电池包装，枚举值：
     * No Battery
     * Inside Equipment
     * Packaged with Equipment
     * Battery Only
     * Other
     * 默认值：No Battery
     */
    private String batteryPacking;
    //默认值：false
    private Boolean dangerousGoods;
    //捡货清单，一般面单上会显示出来
    private String sku;
    //派送指令
    private String instruction;
    //发件网点，物流商提供
    private String facility;
    //平台代码
    private String platform;


    //收件人名称
    //限制英语/法语字符/非纯数字
    private String recipientName;
    //收件人税号
    private String recipientTaxId;
    //收件人公司名
    private String recipientCompany;
    //电话
    private String phone;
    //邮箱
    private String email;
    //地址第一行
    //限制英语/法语字符/非纯数字
    private String addressLine1;
    //地址第二行
    private String addressLine2;
    //地址第三行
    private String addressLine3;
    //城市
    private String city;
    //省 限制英语/法语字符/非纯数字
    private String state;
    //邮编
    private String postcode;
    //国家二字代码
    private String country;
    //发件人名称 限制英语/法语字符/非纯数字
    private String shipperName;
    //电话
    private String shipperPhone;
    //地址第一行
    private String shipperAddressLine1;
    //地址第二行
    private String shipperAddressLine2;
    //地址第三行
    private String shipperAddressLine3;
    //城市
    private String shipperCity;
    //省
    private String shipperState;
    //邮编
    private String shipperPostcode;
    //国家二字代码
    private String shipperCountry;
    //客户邮箱
    private String shipperEmail;

    //退货
    /**
     * 退件选项
     *
     * 空
     * Return
     * Destroy
     */
    private String returnOption;
    //退件接收人名称
    private String returnName;
    //地址第一行
    private String returnAddressLine1;
    //地址第二行
    private String returnAddressLine2;
    //地址第三行
    private String returnAddressLine3;
    //城市
    private String returnCity;
    //省
    private String returnState;
    //邮编
    private String returnPostcode;
    //国家二字代码
    private String returnCountry;
    //退货电话
    private String returnPhone;

    //item信息
    private List<OrderItem> orderItems;
    //扩展字段
    private ItemExtend extendData;
    //一票多件
    private List<UbiOrder> pieces;
}
