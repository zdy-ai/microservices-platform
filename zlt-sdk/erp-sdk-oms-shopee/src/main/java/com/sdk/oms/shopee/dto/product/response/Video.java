package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Video
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Video implements Serializable {
    @JSONField(name = "video_url")
    private String videoUrl;
    @JSONField(name = "thumbnail_url")
    private String thumbnailUrl;
    @JSONField(name = "")
    private String duration;
}
