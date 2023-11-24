package com.sdk.oms.shopee.dto.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Invoice
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class Invoice implements Serializable {
    @JSONField(name = "number")
    private String number;
    @JSONField(name = "series_number")
    private String seriesNumber;
    @JSONField(name = "access_key")
    private String accessKey;
    @JSONField(name = "issue_date")
    private Long issueDate;
    @JSONField(name = "total_value")
    private float totalValue;
    @JSONField(name = "products_total_value")
    private float productsTotalValue;
    @JSONField(name = "tax_code")
    private String taxCode;
}
