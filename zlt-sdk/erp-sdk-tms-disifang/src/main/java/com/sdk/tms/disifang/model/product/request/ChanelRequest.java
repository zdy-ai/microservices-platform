package com.sdk.tms.disifang.model.product.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ChanelRequest
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
@Builder
public class ChanelRequest implements Serializable {
    /**
     * 运输方式：1 所有方式；2 国际快递；3 国际小包；4 专线；5 联邮通；6 其他；
     * 是
     */
    @JSONField(name = "transport_mode")
    private String transport_mode = "1";
    /**
     * 起运地-国家二字码。此查询条件暂不可用
     */
    @JSONField(name = "source_country_code")
    private String source_country_code;
    /**
     * 起始地-仓库代码。此查询条件暂不可用
     */
    @JSONField(name = "source_warehouse_code")
    private String source_warehouse_code;
    /**
     * 目的地-国家二字码。此查询条件暂不可用
     */
    @JSONField(name = "dest_country_code")
    private String dest_country_code;
}
