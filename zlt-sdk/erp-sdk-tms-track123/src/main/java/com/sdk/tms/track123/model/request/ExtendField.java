package com.sdk.tms.track123.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ExtendField
 * @description: TODO
 * @date 2023年11月21日
 * @version: 1.0
 */
@Data
public class ExtendField implements Serializable {
    /**
     * 手机尾号
     */
    private String phoneSuffix;
}
