package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName AttributeValue
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
public class AttributeValue implements Serializable {

    @JSONField(name = "value_id")
    private Long id;

    @JSONField(name = "original_value_name")
    private String valueName;

    @JSONField(name = "value_unit")
    private String valueUnit;
}
