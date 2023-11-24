package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName StockInfo
 * @description: TODO
 * @date 2023年10月24日
 * @version: 1.0
 */
@Data
public class StockInfo implements Serializable {

    @JSONField(name = "summary_info")
    private SummaryInfo summaryInfo;

    @JSONField(name = "seller_stock")
    private List<SellerStock> sellerStocks;

    @JSONField(name = "shopee_stock")
    private List<ShopeeStock> shopeeStocks;
}
