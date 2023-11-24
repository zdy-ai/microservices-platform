package com.sdk.tms.track123.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName RegisterRequest
 * @description: TODO
 * @date 2023年11月21日
 * @version: 1.0
 */
@Data
public class RegisterRequest implements Serializable {
    /**
     * 物流单号
     */
    @NotBlank(message = "跟踪单号不能为空")
    private String trackNo;
    /**
     * 物流商对应的唯一简码,如果简码为空,系统会根据规则自动匹配
     */
    private String courierCode;
    /**
     * 订单号，由商家/平台所产生的订单编号
     */
    private String orderNo;
    /**
     * 目的国国家二字简码:CN,US,GB
     */
    private String country;
    /**
     * 发货时间
     */
    private String shipTime;
    /**
     * 	客户邮箱,订单关联的客户邮箱
     */
    private String customerEmail;
    /**
     * 邮编号(最多15位字母或数字组成，可以包含+，-，和空格)
     */
    private String postalCode;
    /**
     *	备注
     */
    private String remark;
    /**
     * 扩展字段（用于补充附加信息，如手机尾号）
     */
    private ExtendField extendFieldMap;
}
