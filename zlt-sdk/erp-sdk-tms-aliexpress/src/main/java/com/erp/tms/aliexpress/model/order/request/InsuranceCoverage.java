package com.erp.tms.aliexpress.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zdy
 * @ClassName InsuranceCoverage
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class InsuranceCoverage implements Serializable {
    private BigDecimal cent;
    /**
     * 币种三字码
     */
    @JSONField(name = "currency_code")
    private BigDecimal currency_code;
}
