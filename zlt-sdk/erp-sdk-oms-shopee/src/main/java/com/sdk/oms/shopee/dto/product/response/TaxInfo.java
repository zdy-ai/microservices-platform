package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Brand
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class TaxInfo implements Serializable {
    @JSONField(name = "ncm")
    private String ncm;
    @JSONField(name = "diff_state_cfop")
    private String diffStateCfop;

    @JSONField(name = "csosn")
    private String csosn;

    @JSONField(name = "origin")
    private String origin;

    @JSONField(name = "cest")
    private String cest;

    @JSONField(name = "measure_unit")
    private String measureUnit;

    @JSONField(name = "invoice_option")
    private String invoiceOption;

    @JSONField(name = "vat_rate")
    private String vatRate;

    @JSONField(name = "hs_code")
    private String hsCode;

    @JSONField(name = "tax_code")
    private String taxCode;
    @JSONField(name = "tax_type")
    private int taxType;

}
