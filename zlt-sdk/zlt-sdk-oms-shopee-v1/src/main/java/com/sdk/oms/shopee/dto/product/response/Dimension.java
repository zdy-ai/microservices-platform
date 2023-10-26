package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Dimension
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Dimension implements Serializable {

    @JSONField(name = "package_length")
    private Long packageLength;
    @JSONField(name = "package_width")
    private Long packageWidth;
    @JSONField(name = "package_height")
    private Long packageHeight;
}
