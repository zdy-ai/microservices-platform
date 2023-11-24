package com.sdk.tms.shopee.model.logistics.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Size
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class Size implements Serializable {
    @JSONField(name = "size_id")
    private String sizeId;
    private String name;
    @JSONField(name = "default_price")
    private Float defaultPrice;
}
