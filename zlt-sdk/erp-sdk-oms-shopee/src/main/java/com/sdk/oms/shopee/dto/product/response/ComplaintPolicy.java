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
public class ComplaintPolicy implements Serializable {
    @JSONField(name = "warranty_time")
    private String warrantyTime;
    @JSONField(name = "exclude_entrepreneur_warranty")
    private boolean excludeEntrepreneurWarranty;
    @JSONField(name = "complaint_address_id")
    private Long complaintAddressId;
    @JSONField(name = "additional_information")
    private String additionalInformation;

}
