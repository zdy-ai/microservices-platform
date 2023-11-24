package com.erp.sdk.oms.amz.spapi.dto;

import com.common.core.anno.Panno;
import com.common.core.enums.PannoEnum;
import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapping;


/**
 * 亚马逊物流管理库存-已存档 实体
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ReportFbaMyiAllInventoryMongoDTO extends ReportSuperMongoDTO {
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

    @Panno(findType = PannoEnum.EQ, field = "your-price")
    private String yourPrice;

    @Panno(findType = PannoEnum.EQ, field = "mfn-listing-exists")
    private String mfnListingExists;

    @Panno(findType = PannoEnum.EQ, field = "mfn-fulfillable-quantity")
    private String mfnFulfillableQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-listing-exists")
    private String afnListingExists;

    @Panno(findType = PannoEnum.EQ, field = "afn-warehouse-quantity")
    private String afnWarehouseQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-fulfillable-quantity")
    private String afnFulfillableQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-unsellable-quantity")
    private String afnUnsellableQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-reserved-quantity")
    private String afnReservedQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-total-quantity")
    private String afnTotalQuantity;

    @Panno(findType = PannoEnum.EQ, field = "per-unit-volume")
    private String perUnitVolume;

    @Panno(findType = PannoEnum.EQ, field = "afn-inbound-working-quantity")
    private String afnInboundWorkingQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-inbound-shipped-quantity")
    private String afnInboundShippedQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-inbound-receiving-quantity")
    private String afnInboundReceivingQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-researching-quantity")
    private String afnResearchingQuantity;

    @Panno(findType = PannoEnum.EQ, field = "afn-reserved-future-supply")
    private String afnReservedFutureSupply;

    @Panno(findType = PannoEnum.EQ, field = "afn-future-supply-buyable")
    private String afnFutureSupplyBuyable;

    public static ReportFbaMyiAllInventoryMongoDTO queryReportId(String myiAllInventoryReportId) {
        ReportFbaMyiAllInventoryMongoDTO mongoDTO = new ReportFbaMyiAllInventoryMongoDTO();
        mongoDTO.setReportId(myiAllInventoryReportId);
        return mongoDTO;
    }

    /**
     * 配送渠道：mfn-listing-exists=true为卖家自配送；afn-listing-exists=true为亚马逊配送
     */
    public String switchDeliveryChannels(){
        if ("YES".equalsIgnoreCase(this.mfnListingExists)){
            return "selfDelivery";
        }
        if ("YES".equalsIgnoreCase(this.afnListingExists)){
            return "amazonDelivery";
        }
        return "";
    }

    public Integer mfnFulfillableQuantityCheckToInt(){
        if (StringUtils.isBlank(this.mfnFulfillableQuantity)){
            return 0;
        }
        return Integer.parseInt(this.mfnFulfillableQuantity);
    }
    public Integer afnInboundWorkingQuantityCheckToInt(){
        if (StringUtils.isBlank(this.afnInboundWorkingQuantity)){
            return 0;
        }
        return Integer.parseInt(this.afnInboundWorkingQuantity);
    }
    public Integer afnInboundShippedQuantityCheckToInt(){
        if (StringUtils.isBlank(this.afnInboundShippedQuantity)){
            return 0;
        }
        return Integer.parseInt(this.afnInboundShippedQuantity);
    }
    public Integer afnInboundReceivingQuantityCheckToInt(){
        if (StringUtils.isBlank(this.afnInboundReceivingQuantity)){
            return 0;
        }
        return Integer.parseInt(this.afnInboundReceivingQuantity);
    }
    public Integer afnFulfillableQuantityCheckToInt(){
        if (StringUtils.isBlank(this.afnFulfillableQuantity)){
            return 0;
        }
        return Integer.parseInt(this.afnFulfillableQuantity);
    }
    public Integer afnReservedQuantityCheckToInt(){
        if (StringUtils.isBlank(this.afnReservedQuantity)){
            return 0;
        }
        return Integer.parseInt(this.afnReservedQuantity);
    }
    public Integer afnResearchingQuantityCheckToInt(){
        if (StringUtils.isBlank(this.afnResearchingQuantity)){
            return 0;
        }
        return Integer.parseInt(this.afnResearchingQuantity);
    }
    public Integer afnUnsellableQuantityCheckToInt(){
        if (StringUtils.isBlank(this.afnUnsellableQuantity)){
            return 0;
        }
        return Integer.parseInt(this.afnUnsellableQuantity);
    }


}
