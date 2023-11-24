package com.erp.tms.aliexpress.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName QueryResponse
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class QueryResponse implements Serializable {
    @JSONField(name = "current_page")
    private Integer currentPage;
    @JSONField(name = "error_desc")
    private String errorDesc;
    @JSONField(name = "result_list")
    private List<QueryResult> resultList;
    @JSONField(name = "success")
    private Boolean success;
    @JSONField(name = "total_page")
    private Integer totalPage;
}
