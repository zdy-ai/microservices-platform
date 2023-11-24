package com.erp.sdk.oms.amz.spapi.dto;

import com.common.core.anno.Panno;
import com.common.core.enums.PannoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapping;


/**
 * 亚马逊物流预留库存报告 实体
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ReportReservedMongoDTO extends ReportSuperMongoDTO {
    @Panno(findType = PannoEnum.EQ, field = "sku")
    private String sku;

    @Panno(findType = PannoEnum.EQ, field = "fnsku")
    private String fnsku;

    @Panno(findType = PannoEnum.EQ, field = "asin")
    private String asin;

    @Panno(findType = PannoEnum.EQ, field = "product-name")
    private String productName;

    @Panno(findType = PannoEnum.EQ, field = "reserved_qty")
    private String reservedQty;

    @Panno(findType = PannoEnum.EQ, field = "reserved_customerorders")
    private String reservedCustomerOrders;

    @Panno(findType = PannoEnum.EQ, field = "reserved_fc-transfers")
    private String reservedFCTransfers;

    @Panno(findType = PannoEnum.EQ, field = "reserved_fc-processing")
    private String reservedFCProcessing;

    public static ReportReservedMongoDTO queryReportId(String reservedReportId) {
        ReportReservedMongoDTO reservedMongoDTO = new ReportReservedMongoDTO();
        reservedMongoDTO.setReportId(reservedReportId);
        return reservedMongoDTO;
    }

    public Integer reservedFCTransfersCheckToInt(){
        if (StringUtils.isBlank(this.reservedFCTransfers)){
            return 0;
        }
        return Integer.parseInt(this.reservedFCTransfers);
    }

    public Integer reservedFCProcessingCheckToInt(){
        if (StringUtils.isBlank(this.reservedFCProcessing)){
            return 0;
        }
        return Integer.parseInt(this.reservedFCProcessing);
    }

    public Integer reservedCustomerOrdersCheckToInt(){
        if (StringUtils.isBlank(this.reservedCustomerOrders)){
            return 0;
        }
        return Integer.parseInt(this.reservedCustomerOrders);
    }
}
