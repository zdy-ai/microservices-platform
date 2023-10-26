package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName DescriptionInfo
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class DescriptionInfo implements Serializable {
    @JSONField(name = "extended_description")
    private ExtendedDescription extendedDescription;
}
