package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Field
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class Field implements Serializable {
    @JSONField(name = "field_type")
    private String fieldType;

    @JSONField(name = "text")
    private String text;

    @JSONField(name = "image_info")
    private ImageInfo imageInfo;
}
