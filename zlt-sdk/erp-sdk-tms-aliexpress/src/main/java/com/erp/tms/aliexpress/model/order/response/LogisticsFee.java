package com.erp.tms.aliexpress.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName LogisticsFee
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class LogisticsFee implements Serializable {
    /**
     * amount
     */
    @JSONField(name = "amount")
    private String amount;
    /**
     * cent
     */
    @JSONField(name = "cent")
    private String cent;
    /**
     * currencyCode
     */
    @JSONField(name = "currency_code")
    private String currency_code;
}
