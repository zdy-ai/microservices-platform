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
public class Brand implements Serializable {
    @JSONField(name = "brand_id")
    private Long brandId;
    @JSONField(name = "original_brand_name")
    private String originalBrandName;
}
