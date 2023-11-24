package com.sdk.wms.iml.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author liuruipeng
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ImlGetInventoryReq extends ImlBaseRequest {

    //SKU
    @JSONField(name = "product_sku")
    private String productSku;

    //多个SKU,数组格式
    @JSONField(name = "product_sku_arr")
    private List<String> productSkuArr;

    //仓库代码
    @JSONField(name = "warehouse_code")
    private String warehouse_code;

    //多个仓库代码,数组格式
    @JSONField(name = "warehouse_code_arr")
    private List<String> warehouse_code_arr;
}
