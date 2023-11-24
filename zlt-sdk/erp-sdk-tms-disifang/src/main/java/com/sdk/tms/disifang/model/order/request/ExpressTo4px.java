package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ExpressTo4px
 * @description: 快递到仓信息
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class ExpressTo4px implements Serializable {
    /**
     * 快递公司
     */
    @JSONField(name = "express_company")
    private String express_company;
    /**
     * 追踪号
     */
    @JSONField(name = "tracking_no")
    private String tracking_no;
}
