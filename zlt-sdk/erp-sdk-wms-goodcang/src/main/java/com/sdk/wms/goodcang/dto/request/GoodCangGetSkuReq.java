package com.sdk.wms.goodcang.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author liuruipeng
 * @date 2023年11月14日 15:44
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GoodCangGetSkuReq extends GoodCangBaseRequest {

    //商品SKU
    @JSONField(name = "product_sku")
    private String productSku;

    //客户SKU
    @JSONField(name = "product_sku_arr")
    private List<String> productSkuArr;

    //修改开始时间 格式：2020-10-01 00:00:00"
    @JSONField(name = "product_update_time_from")
    private String productUpdateTimeFrom;

    //修改结束时间 格式：2020-10-01 00:00:00"
    @JSONField(name = "product_update_time_to")
    private String productUpdateTimeTo;

}
