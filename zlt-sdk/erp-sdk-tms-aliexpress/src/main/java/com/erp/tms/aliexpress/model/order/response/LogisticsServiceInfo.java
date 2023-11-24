package com.erp.tms.aliexpress.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName LogisticsServiceInfo
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class LogisticsServiceInfo implements Serializable {
    /**
     * 物流服务编码
     */
    @JSONField(name = "code")
    private String code;
    /**
     * 资源编码
     */
    @JSONField(name = "resource_code")
    private String resource_code;
}
