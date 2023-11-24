package com.erp.sdk.oms.amz.spapi.dto;

import com.common.core.anno.Panno;
import com.common.core.enums.PannoEnum;
import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 亚马逊物流管理库存状况报告 实体
 */
@Data
@NoArgsConstructor
public class ReportFbaInventoryPlanningMongoDTO extends ReportSuperMongoDTO {
    @Panno(findType = PannoEnum.EQ, field = "snapshot-date")
    private String snapshotDate;

    @Panno(findType = PannoEnum.EQ, field = "sku")
    private String sku;

    @Panno(findType = PannoEnum.EQ, field = "fnsku")
    private String fnsku;

    @Panno(findType = PannoEnum.EQ, field = "asin")
    private String asin;

    @Panno(findType = PannoEnum.EQ, field = "product-name")
    private String productName;

    @Panno(findType = PannoEnum.EQ, field = "condition")
    private String condition;

    @Panno(findType = PannoEnum.EQ, field = "available")
    private String available;

    @Panno(findType = PannoEnum.EQ, field = "pending-removal-quantity")
    private String pendingRemovalQuantity;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-0-to-90-days")
    private String invAge0To90Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-91-to-180-days")
    private String invAge91To180Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-181-to-270-days")
    private String invAge181To270Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-271-to-365-days")
    private String invAge271To365Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-365-plus-days")
    private String invAge365PlusDays;

    @Panno(findType = PannoEnum.EQ, field = "currency")
    private String currency;

    @Panno(findType = PannoEnum.EQ, field = "units-shipped-t7")
    private String unitsShippedT7;

    @Panno(findType = PannoEnum.EQ, field = "units-shipped-t30")
    private String unitsShippedT30;

    @Panno(findType = PannoEnum.EQ, field = "units-shipped-t60")
    private String unitsShippedT60;

    @Panno(findType = PannoEnum.EQ, field = "units-shipped-t90")
    private String unitsShippedT90;

    @Panno(findType = PannoEnum.EQ, field = "alert")
    private String alert;

    @Panno(findType = PannoEnum.EQ, field = "your-price")
    private String yourPrice;

    @Panno(findType = PannoEnum.EQ, field = "sales-price")
    private String salesPrice;

    @Panno(findType = PannoEnum.EQ, field = "lowest-price-new-plus-shipping")
    private String lowestPriceNewPlusShipping;

    @Panno(findType = PannoEnum.EQ, field = "lowest-price-used")
    private String lowestPriceUsed;

    @Panno(findType = PannoEnum.EQ, field = "recommended-action")
    private String recommendedAction;

    @Panno(findType = PannoEnum.EQ, field = "healthy-inventory-level")
    private String healthyInventoryLevel;

    @Panno(findType = PannoEnum.EQ, field = "recommended-sales-price")
    private String recommendedSalesPrice;

    @Panno(findType = PannoEnum.EQ, field = "recommended-sale-duration-days")
    private String recommendedSaleDurationDays;

    @Panno(findType = PannoEnum.EQ, field = "recommended-removal-quantity")
    private String recommendedRemovalQuantity;

    @Panno(findType = PannoEnum.EQ, field = "estimated-cost-savings-of-recommended-actions")
    private String estimatedCostSavingsOfRecommendedActions;

    @Panno(findType = PannoEnum.EQ, field = "sell-through")
    private String sellThrough;

    @Panno(findType = PannoEnum.EQ, field = "item-volume")
    private String itemVolume;

    @Panno(findType = PannoEnum.EQ, field = "volume-unit-measurement")
    private String volumeUnitMeasurement;

    @Panno(findType = PannoEnum.EQ, field = "storage-type")
    private String storageType;

    @Panno(findType = PannoEnum.EQ, field = "storage-volume")
    private String storageVolume;

    @Panno(findType = PannoEnum.EQ, field = "marketplace")
    private String marketplace;

    @Panno(findType = PannoEnum.EQ, field = "product-group")
    private String productGroup;

    @Panno(findType = PannoEnum.EQ, field = "sales-rank")
    private String salesRank;

    @Panno(findType = PannoEnum.EQ, field = "days-of-supply")
    private String daysOfSupply;

    @Panno(findType = PannoEnum.EQ, field = "estimated-excess-quantity")
    private String estimatedExcessQuantity;

    @Panno(findType = PannoEnum.EQ, field = "weeks-of-cover-t30")
    private String weeksOfCoverT30;

    @Panno(findType = PannoEnum.EQ, field = "weeks-of-cover-t90")
    private String weeksOfCoverT90;

    @Panno(findType = PannoEnum.EQ, field = "featuredoffer-price")
    private String featuredOfferPrice;

    @Panno(findType = PannoEnum.EQ, field = "sales-shipped-last-7-days")
    private String salesShippedLast7Days;

    @Panno(findType = PannoEnum.EQ, field = "sales-shipped-last-30-days")
    private String salesShippedLast30Days;

    @Panno(findType = PannoEnum.EQ, field = "sales-shipped-last-60-days")
    private String salesShippedLast60Days;

    @Panno(findType = PannoEnum.EQ, field = "sales-shipped-last-90-days")
    private String salesShippedLast90Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-0-to-30-days")
    private String invAge0To30Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-31-to-60-days")
    private String invAge31To60Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-61-to-90-days")
    private String invAge61To90Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-181-to-330-days")
    private String invAge181To330Days;

    @Panno(findType = PannoEnum.EQ, field = "inv-age-331-to-365-days")
    private String invAge331To365Days;

    @Panno(findType = PannoEnum.EQ, field = "estimated-storage-cost-next-month")
    private String estimatedStorageCostNextMonth;

    @Panno(findType = PannoEnum.EQ, field = "inbound-quantity")
    private String inboundQuantity;

    @Panno(findType = PannoEnum.EQ, field = "inbound-working")
    private String inboundWorking;

    @Panno(findType = PannoEnum.EQ, field = "inbound-shipped")
    private String inboundShipped;

    @Panno(findType = PannoEnum.EQ, field = "inbound-received")
    private String inboundReceived;

    @Panno(findType = PannoEnum.EQ, field = "no-sale-last-6-months")
    private String noSaleLast6Months;

    @Panno(findType = PannoEnum.EQ, field = "reserved-quantity")
    private String reservedQuantity;

    @Panno(findType = PannoEnum.EQ, field = "unfulfillable-quantity")
    private String unfulfillableQuantity;

    @Panno(findType = PannoEnum.EQ, field = "quantity-to-be-charged-ais-181-210-days")
    private String quantityToBeChargedAis181To210Days;

    @Panno(findType = PannoEnum.EQ, field = "estimated-ais-181-210-days")
    private String estimatedAis181To210Days;

    @Panno(findType = PannoEnum.EQ, field = "quantity-to-be-charged-ais-211-240-days")
    private String quantityToBeChargedAis211To240Days;

    @Panno(findType = PannoEnum.EQ, field = "estimated-ais-211-240-days")
    private String estimatedAis211To240Days;

    @Panno(findType = PannoEnum.EQ, field = "quantity-to-be-charged-ais-241-270-days")
    private String quantityToBeChargedAis241To270Days;

    @Panno(findType = PannoEnum.EQ, field = "estimated-ais-241-270-days")
    private String estimatedAis241To270Days;

    @Panno(findType = PannoEnum.EQ, field = "quantity-to-be-charged-ais-271-300-days")
    private String quantityToBeChargedAis271To300Days;

    @Panno(findType = PannoEnum.EQ, field = "estimated-ais-271-300-days")
    private String estimatedAis271To300Days;

    @Panno(findType = PannoEnum.EQ, field = "quantity-to-be-charged-ais-301-330-days")
    private String quantityToBeChargedAis301To330Days;

    @Panno(findType = PannoEnum.EQ, field = "estimated-ais-301-330-days")
    private String estimatedAis301To330Days;

    @Panno(findType = PannoEnum.EQ, field = "quantity-to-be-charged-ais-331-365-days")
    private String quantityToBeChargedAis331To365Days;

    @Panno(findType = PannoEnum.EQ, field = "estimated-ais-331-365-days")
    private String estimatedAis331To365Days;

    @Panno(findType = PannoEnum.EQ, field = "quantity-to-be-charged-ais-365-PLUS-days")
    private String quantityToBeChargedAis365PlusDays;

    @Panno(findType = PannoEnum.EQ, field = "estimated-ais-365-plus-days")
    private String estimatedAis365PlusDays;


    public static ReportFbaInventoryPlanningMongoDTO queryReportId(String inventoryPlanningReportId) {
        ReportFbaInventoryPlanningMongoDTO mongoDTO = new ReportFbaInventoryPlanningMongoDTO();
        mongoDTO.setReportId(inventoryPlanningReportId);
        return mongoDTO;
    }
}
