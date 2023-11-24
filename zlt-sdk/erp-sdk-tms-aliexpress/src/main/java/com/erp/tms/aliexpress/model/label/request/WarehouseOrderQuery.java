package com.erp.tms.aliexpress.model.label.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName WarehouseOrderQuery
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class WarehouseOrderQuery implements Serializable {
    /**
     *
     * international logistics waybill ID
     * 是
     */
    @NotBlank(message = "运单号不能为空")
    @JSONField(name = "international_logistics_id")
    private String international_logistics_id;
    /**
     *
     * id is optional
     *
     */
    @JSONField(name = "id")
    private Long id;
}
