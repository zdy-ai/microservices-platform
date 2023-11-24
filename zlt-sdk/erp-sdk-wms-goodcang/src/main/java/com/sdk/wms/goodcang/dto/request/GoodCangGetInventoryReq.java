package com.sdk.wms.goodcang.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

/**
 * @author liuruipeng
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GoodCangGetInventoryReq extends GoodCangBaseRequest {

    //商品SKU
    @JSONField(name = "product_sku")
    private String productSku;

    //客户SKU
    @JSONField(name = "product_sku_arr")
    private List<String> productSkuArr;

    //仓库code
    @JSONField(name = "warehouse_code")
    private String warehouseCode;

    //仓库codelist
    @JSONField(name = "warehouse_code_arr")
    private List<String> warehouseCodeList;

}
