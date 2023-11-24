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
 * @date 2023年11月14日 15:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ImlGetProductReq extends ImlBaseRequest {

    //SKU
    @JSONField(name = "product_sku")
    private String productSku;

    //多个SKU,数组格式
    @JSONField(name = "product_sku_arr")
    private List<String> productSkuArr;

    //起始时间(产品创建) 格式支持yyyy-mm-dd 或 yyyy-mm-dd hh:mm:ss
    @JSONField(name = "start_time")
    private String startTime;

    //结束时间(产品创建) 格式支持yyyy-mm-dd 或 yyyy-mm-dd hh:mm:ss
    @JSONField(name = "end_time")
    private String endTime;

    //起始时间(产品更新) 格式支持yyyy-mm-dd 或 yyyy-mm-dd hh:mm:ss
    @JSONField(name = "update_start_time")
    private String updateStartTime;

    //结束时间(产品更新) 格式支持yyyy-mm-dd 或 yyyy-mm-dd hh:mm:ss
    @JSONField(name = "update_end_time")
    private String updateEndTime;
}
