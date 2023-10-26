package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ImageInfo
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class ImageInfo implements Serializable {
    @JSONField(name = "image_id")
    private String imageId;

    @JSONField(name = "image_url")
    private String imageUrl;
}
