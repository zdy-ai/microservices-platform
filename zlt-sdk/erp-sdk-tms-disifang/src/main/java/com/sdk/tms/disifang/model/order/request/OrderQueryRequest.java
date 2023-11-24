package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName OrderRequest
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
@Builder
public class OrderQueryRequest implements Serializable {
    /**
     * 请求单号
     */
    @NotBlank(message = "请求单号不能为空")
    @JSONField(name = "request_no")
    private String request_no;

    /**
     * 	委托单创建时间-开始时间（*注：时间格式的传入值需要转换为long类型格式。）时间差为7天
     */
    @JSONField(name = "start_time_of_create_consignment")
    private Long start_time_of_create_consignment;
    /**
     * 	委托单创建时间-结束时间（（*注：时间格式的传入值需要转换为long类型格式。） 时间差为7天
     */
    @JSONField(name = "end_time_of_create_consignment")
    private Long end_time_of_create_consignment;

    /**
     * 	委托单状态：已预报：P；已交接/已交货：V；库内作业中/已入库：H；已出库：C；已完成：F；已退件：R；已关闭：X；所有：ALL（默认）
     */
    @JSONField(name = "consignment_status")
    private String consignment_status;
}
