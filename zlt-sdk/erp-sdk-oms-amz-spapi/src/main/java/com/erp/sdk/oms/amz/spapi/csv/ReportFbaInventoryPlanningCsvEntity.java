package com.erp.sdk.oms.amz.spapi.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 亚马逊物流管理库存状况报告 实体
 */
@Data
@NoArgsConstructor
public class ReportFbaInventoryPlanningCsvEntity {
    @CsvBindByName(column = "snapshot-date")
    private String snapshotDate;

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

    @CsvBindByName(column = "available")
    private String available;

    @CsvBindByName(column = "pending-removal-quantity")
    private String pendingRemovalQuantity;

    @CsvBindByName(column = "inv-age-0-to-90-days")
    private String invAge0To90Days;

    @CsvBindByName(column = "inv-age-91-to-180-days")
    private String invAge91To180Days;

    @CsvBindByName(column = "inv-age-181-to-270-days")
    private String invAge181To270Days;

    @CsvBindByName(column = "inv-age-271-to-365-days")
    private String invAge271To365Days;

    @CsvBindByName(column = "inv-age-365-plus-days")
    private String invAge365PlusDays;

    @CsvBindByName(column = "currency")
    private String currency;

    @CsvBindByName(column = "units-shipped-t7")
    private String unitsShippedT7;

    @CsvBindByName(column = "units-shipped-t30")
    private String unitsShippedT30;

    @CsvBindByName(column = "units-shipped-t60")
    private String unitsShippedT60;

    @CsvBindByName(column = "units-shipped-t90")
    private String unitsShippedT90;

    @CsvBindByName(column = "alert")
    private String alert;

    @CsvBindByName(column = "your-price")
    private String yourPrice;

    @CsvBindByName(column = "sales-price")
    private String salesPrice;

    @CsvBindByName(column = "lowest-price-new-plus-shipping")
    private String lowestPriceNewPlusShipping;

    @CsvBindByName(column = "lowest-price-used")
    private String lowestPriceUsed;

    @CsvBindByName(column = "recommended-action")
    private String recommendedAction;

    @CsvBindByName(column = "healthy-inventory-level")
    private String healthyInventoryLevel;

    @CsvBindByName(column = "recommended-sales-price")
    private String recommendedSalesPrice;

    @CsvBindByName(column = "recommended-sale-duration-days")
    private String recommendedSaleDurationDays;

    @CsvBindByName(column = "recommended-removal-quantity")
    private String recommendedRemovalQuantity;

    @CsvBindByName(column = "estimated-cost-savings-of-recommended-actions")
    private String estimatedCostSavingsOfRecommendedActions;

    @CsvBindByName(column = "sell-through")
    private String sellThrough;

    @CsvBindByName(column = "item-volume")
    private String itemVolume;

    @CsvBindByName(column = "volume-unit-measurement")
    private String volumeUnitMeasurement;

    @CsvBindByName(column = "storage-type")
    private String storageType;

    @CsvBindByName(column = "storage-volume")
    private String storageVolume;

    @CsvBindByName(column = "marketplace")
    private String marketplace;

    @CsvBindByName(column = "product-group")
    private String productGroup;

    @CsvBindByName(column = "sales-rank")
    private String salesRank;

    @CsvBindByName(column = "days-of-supply")
    private String daysOfSupply;

    @CsvBindByName(column = "estimated-excess-quantity")
    private String estimatedExcessQuantity;

    @CsvBindByName(column = "weeks-of-cover-t30")
    private String weeksOfCoverT30;

    @CsvBindByName(column = "weeks-of-cover-t90")
    private String weeksOfCoverT90;

    @CsvBindByName(column = "featuredoffer-price")
    private String featuredOfferPrice;

    @CsvBindByName(column = "sales-shipped-last-7-days")
    private String salesShippedLast7Days;

    @CsvBindByName(column = "sales-shipped-last-30-days")
    private String salesShippedLast30Days;

    @CsvBindByName(column = "sales-shipped-last-60-days")
    private String salesShippedLast60Days;

    @CsvBindByName(column = "sales-shipped-last-90-days")
    private String salesShippedLast90Days;

    @CsvBindByName(column = "inv-age-0-to-30-days")
    private String invAge0To30Days;

    @CsvBindByName(column = "inv-age-31-to-60-days")
    private String invAge31To60Days;

    @CsvBindByName(column = "inv-age-61-to-90-days")
    private String invAge61To90Days;

    @CsvBindByName(column = "inv-age-181-to-330-days")
    private String invAge181To330Days;

    @CsvBindByName(column = "inv-age-331-to-365-days")
    private String invAge331To365Days;

    @CsvBindByName(column = "estimated-storage-cost-next-month")
    private String estimatedStorageCostNextMonth;

    @CsvBindByName(column = "inbound-quantity")
    private String inboundQuantity;

    @CsvBindByName(column = "inbound-working")
    private String inboundWorking;

    @CsvBindByName(column = "inbound-shipped")
    private String inboundShipped;

    @CsvBindByName(column = "inbound-received")
    private String inboundReceived;

    @CsvBindByName(column = "no-sale-last-6-months")
    private String noSaleLast6Months;

    @CsvBindByName(column = "reserved-quantity")
    private String reservedQuantity;

    @CsvBindByName(column = "unfulfillable-quantity")
    private String unfulfillableQuantity;

    @CsvBindByName(column = "quantity-to-be-charged-ais-181-210-days")
    private String quantityToBeChargedAis181To210Days;

    @CsvBindByName(column = "estimated-ais-181-210-days")
    private String estimatedAis181To210Days;

    @CsvBindByName(column = "quantity-to-be-charged-ais-211-240-days")
    private String quantityToBeChargedAis211To240Days;

    @CsvBindByName(column = "estimated-ais-211-240-days")
    private String estimatedAis211To240Days;

    @CsvBindByName(column = "quantity-to-be-charged-ais-241-270-days")
    private String quantityToBeChargedAis241To270Days;

    @CsvBindByName(column = "estimated-ais-241-270-days")
    private String estimatedAis241To270Days;

    @CsvBindByName(column = "quantity-to-be-charged-ais-271-300-days")
    private String quantityToBeChargedAis271To300Days;

    @CsvBindByName(column = "estimated-ais-271-300-days")
    private String estimatedAis271To300Days;

    @CsvBindByName(column = "quantity-to-be-charged-ais-301-330-days")
    private String quantityToBeChargedAis301To330Days;

    @CsvBindByName(column = "estimated-ais-301-330-days")
    private String estimatedAis301To330Days;

    @CsvBindByName(column = "quantity-to-be-charged-ais-331-365-days")
    private String quantityToBeChargedAis331To365Days;

    @CsvBindByName(column = "estimated-ais-331-365-days")
    private String estimatedAis331To365Days;

    @CsvBindByName(column = "quantity-to-be-charged-ais-365-PLUS-days")
    private String quantityToBeChargedAis365PlusDays;

    @CsvBindByName(column = "estimated-ais-365-plus-days")
    private String estimatedAis365PlusDays;


}
