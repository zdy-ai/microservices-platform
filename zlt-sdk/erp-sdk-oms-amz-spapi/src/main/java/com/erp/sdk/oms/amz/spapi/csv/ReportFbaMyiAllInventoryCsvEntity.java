package com.erp.sdk.oms.amz.spapi.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 亚马逊物流管理库存-已存档 实体
 */
@Data
@NoArgsConstructor
public class ReportFbaMyiAllInventoryCsvEntity {
    @CsvBindByName(column = "sku")
    private String sku;

    @CsvBindByName(column = "fnsku")
    private String fnsku;

    @CsvBindByName(column = "asin")
    private String asin;

    @CsvBindByName(column = "product-name")
    private String productName;

    @CsvBindByName(column = "condition")
    private String condition;

    @CsvBindByName(column = "your-price")
    private String yourPrice;

    @CsvBindByName(column = "mfn-listing-exists")
    private String mfnListingExists;

    @CsvBindByName(column = "mfn-fulfillable-quantity")
    private String mfnFulfillableQuantity;

    @CsvBindByName(column = "afn-listing-exists")
    private String afnListingExists;

    @CsvBindByName(column = "afn-warehouse-quantity")
    private String afnWarehouseQuantity;

    @CsvBindByName(column = "afn-fulfillable-quantity")
    private String afnFulfillableQuantity;

    @CsvBindByName(column = "afn-unsellable-quantity")
    private String afnUnsellableQuantity;

    @CsvBindByName(column = "afn-reserved-quantity")
    private String afnReservedQuantity;

    @CsvBindByName(column = "afn-total-quantity")
    private String afnTotalQuantity;

    @CsvBindByName(column = "per-unit-volume")
    private String perUnitVolume;

    @CsvBindByName(column = "afn-inbound-working-quantity")
    private String afnInboundWorkingQuantity;

    @CsvBindByName(column = "afn-inbound-shipped-quantity")
    private String afnInboundShippedQuantity;

    @CsvBindByName(column = "afn-inbound-receiving-quantity")
    private String afnInboundReceivingQuantity;

    @CsvBindByName(column = "afn-researching-quantity")
    private String afnResearchingQuantity;

    @CsvBindByName(column = "afn-reserved-future-supply")
    private String afnReservedFutureSupply;

    @CsvBindByName(column = "afn-future-supply-buyable")
    private String afnFutureSupplyBuyable;

}
