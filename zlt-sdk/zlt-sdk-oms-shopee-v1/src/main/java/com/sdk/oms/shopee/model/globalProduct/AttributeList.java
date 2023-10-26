package com.sdk.oms.shopee.model.globalProduct;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName AttributeList
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class AttributeList implements Serializable {
private int attribute_id;
private String original_attribute_name;
private List<AttributeValueList> attribute_value_list;
}
