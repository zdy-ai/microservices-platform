package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName Attribute
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
public class Attribute implements Serializable {

    @JSONField(name = "attribute_id")
    private Long id;

    @JSONField(name = "original_attribute_name")
    private String attributeName;

    /**
     * This is to indicate whether this attribute is mandantory.
     */
    @JSONField(name = "is_mandatory")
    private boolean isMandatory;

    @JSONField(name = "attribute_value_list")
    List<AttributeValue> attributeValueList;
}
