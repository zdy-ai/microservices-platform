package com.sdk.tms.express.model.order.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ExtraInfo
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class ExtraInfo implements Serializable {
    /**
     * 扩展字段说明：attrName为字段定义，具体如下表，value 存在attrVal
     */
    private String attrName;
    /**
     * 扩展字段值
     */
    private String attrVal;
}
