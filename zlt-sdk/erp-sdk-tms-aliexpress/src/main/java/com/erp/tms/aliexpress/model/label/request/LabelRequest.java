package com.erp.tms.aliexpress.model.label.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName LabelRequest
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LabelRequest implements Serializable {
    /**
     * 物流公司
     */
    @JSONField(name = "print_detail")
    private Boolean print_detail;
    /**
     * 物流公司
     */
    @JSONField(name = "warehouse_order_query_d_t_os")
    private List<WarehouseOrderQuery> warehouseOrderQueries;

}
