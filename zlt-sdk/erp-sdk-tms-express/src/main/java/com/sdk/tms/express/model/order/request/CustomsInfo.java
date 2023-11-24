package com.sdk.tms.express.model.order.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zdy
 * @ClassName CustomsInfo
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class CustomsInfo implements Serializable {
    /**
     * 客户订单货物总声明价值，包含子母件，精确到小数点后 3 位。如果是跨境件，则必填。关务
     */
    private BigDecimal declaredValue;
    /**
     * 中国内地
     * 默认
     * CNY，
     * 否则默认
     * 为 USD
     * <p>
     * 货物声明价值币别，跨境件报关需要填写参照附录币别代码附件
     */
    private String declaredValueCurrency;
    /**
     * 报关批次
     */
    private String customsBatchs;
    /**
     * 税金付款方式，支持以下值：1:寄付2：到付
     */
    private String taxPayMethod;
    /**
     * 税金结算账号
     */
    private String taxSettleAccounts;
    /**
     * 支付工具
     */
    private String paymentTool;
    /**
     * 支付号码？
     */
    private String paymentNumber;
    /**
     * 客户订单下单人姓名
     */
    private String orderName;
    /**
     * 客户订单下单人证件类型
     */
    private String orderCertType;
    /**
     * 客户订单下单人证件号
     */
    private String orderCertNo;
    /**
     * 税款
     */
    private String tax;
}
