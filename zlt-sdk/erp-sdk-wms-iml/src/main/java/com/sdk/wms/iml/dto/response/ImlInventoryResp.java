package com.sdk.wms.iml.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.business.dto.CleanBaseDTO;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ImlInventoryResp extends CleanBaseDTO implements Serializable {

    //SKU
    @JSONField(name = "product_sku")
    private String productSku;

    //仓库代码
    @JSONField(name = "warehouse_code")
    private String warehouseCode;

    //在途数量
    @JSONField(name = "onway")
    private Integer onway;

    //待上架数量
    @JSONField(name = "pending")
    private Integer pending;

    //可售数量
    @JSONField(name = "sellable")
    private Integer sellable;

    //不合格数量
    @JSONField(name = "unsellable")
    private Integer unsellable;

    //待出库数量
    @JSONField(name = "reserved")
    private Integer reserved;

    //历史出库数量
    @JSONField(name = "shipped")
    private Integer shipped;

    //待确认数量
    @JSONField(name = "unconfirmed")
    private Integer unconfirmed;
}
