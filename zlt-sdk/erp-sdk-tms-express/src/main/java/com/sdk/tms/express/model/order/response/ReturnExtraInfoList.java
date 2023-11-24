package com.sdk.tms.express.model.order.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ReturnExtraInfoList
 * @description: TODO
 * @date 2023年11月10日
 * @version: 1.0
 */
@Data
public class ReturnExtraInfoList implements Serializable {
    /**
     * 扩展属性名
     */
    private String attrName;
    /**
     * 扩展属性值
     */
    private String attrVal;
}
