package com.sdk.oms.shopee.model.globalProduct;

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

    private int package_length;
    private int package_width;
    private int package_height;
}
