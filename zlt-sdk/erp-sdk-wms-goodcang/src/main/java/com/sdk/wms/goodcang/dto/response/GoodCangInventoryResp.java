package com.sdk.wms.goodcang.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.business.dto.CleanBaseDTO;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class GoodCangInventoryResp extends CleanBaseDTO implements Serializable {

    //商品sku
    @JSONField(name = "product_sku")
    private String productSku;

    //仓库描述
    @JSONField(name = "warehouse_desc")
    private String warehouseDesc;

    //仓库代码
    @JSONField(name = "warehouse_code")
    private String warehouseCode;

    //尾程在途数量
    @JSONField(name = "onway")
    private Integer onway;

    //发货在途数量
    @JSONField(name = "transfer_onway")
    private Integer transferOnway;

    //总在途数量
    @JSONField(name = "total_onway")
    private Integer totalOnway;

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

    //备货数量
    @JSONField(name = "stocking")
    private Integer stocking;

    //缺货数量
    @JSONField(name = "pi_no_stock")
    private Integer piNoStock;

    //冻结数量
    @JSONField(name = "pi_freeze")
    private Integer piFreeze;

    //历史出库数量
    @JSONField(name = "shipped")
    private Integer shipped;

    //商品冻结状态
    @JSONField(name = "product_freeze_status")
    private Integer productFreezeStatus;

    //商品冻结状态名称
    @JSONField(name = "product_freeze_status_text")
    private String productFreezeStatusText;
}
