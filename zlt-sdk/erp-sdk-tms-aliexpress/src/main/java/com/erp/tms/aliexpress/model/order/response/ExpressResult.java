package com.erp.tms.aliexpress.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName ExpressResult
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class ExpressResult implements Serializable {
    @JSONField(name = "current_page")
    private Integer current_page;
    @JSONField(name = "error_desc")
    private String error_desc;
    @JSONField(name = "result_list")
    private List<QueryResult> result_list;
    private Integer success;
    @JSONField(name = "total_page")
    private Integer total_page;
}
