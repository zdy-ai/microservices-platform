package com.erp.sdk.oms.amz.spapi.dto;

import com.common.business.dto.CleanBaseDTO;
import com.common.core.anno.Panno;
import com.common.core.enums.PannoEnum;
import com.erp.model.oms.entity.ShopInfoEntity;
import com.erp.sdk.oms.amz.spapi.model.fulfillmentinbound.Address;
import com.erp.sdk.oms.amz.spapi.model.fulfillmentinbound.InboundShipmentInfo;
import com.erp.sdk.oms.amz.spapi.model.fulfillmentinbound.InboundShipmentItem;
import com.erp.sdk.oms.amz.spapi.model.fulfillmentinbound.InboundShipmentItemList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 平台亚马逊FBA货件DTO
 *
 * @author Jim
 * @date 2023/11/1
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PlatformAmazonFbaShipmentDTO extends CleanBaseDTO {

    private InboundShipmentInfo shipmentInfo;

    private String shopId;

    private String shopName;

    private LocalDateTime platformUpdateTime;

    /**
     * 数据下载状态
     * 0 详情数据需要更新
     * 1 详情数据已更新
     */
    @Panno(findType = PannoEnum.EQ,field = "downloadStatus")
    private Integer downloadStatus;

    /**
     * 明细
     */
    private InboundShipmentItemList detailList;

    /**
     * 包装类型
     */
    public String convertPackType(){
        if(null != this.shipmentInfo) {
            if (null != this.getShipmentInfo().getAreCasesRequired()){
                return this.shipmentInfo.getAreCasesRequired() ? "原厂包装" : "混装";
            }
        }
        return "";
    }

    public static PlatformAmazonFbaShipmentDTO getByDownloadStatus(Integer status) {
        PlatformAmazonFbaShipmentDTO mongoDTO = new PlatformAmazonFbaShipmentDTO();
        mongoDTO.setDownloadStatus(status);
        return mongoDTO;
    }

    public static PlatformAmazonFbaShipmentDTO getUniqId(String uniqueId) {
        PlatformAmazonFbaShipmentDTO mongoDTO = new PlatformAmazonFbaShipmentDTO();
        mongoDTO.setUniqueId(uniqueId);
        return mongoDTO;
    }

    public PlatformAmazonFbaShipmentDTO(InboundShipmentInfo shipmentInfo, ShopInfoEntity shop) {
        this.shipmentInfo = shipmentInfo;
        this.shopId = shop.getId();
        this.shopName = shop.getName();
        this.platformUpdateTime = LocalDateTime.now(ZoneId.systemDefault());
        this.downloadStatus = 0;
        this.detailList = new InboundShipmentItemList();
        super.setUniqueId(shipmentInfo.getShipmentId());
    }

    /**
     * 拼接配送地址
     */
    public String combineDeliveryFromAddress(){
        Address shipFromAddress = this.shipmentInfo.getShipFromAddress();
        if (null == shipFromAddress){
            return "";
        }
        return String.join(" ",
                shipFromAddress.getPostalCode(),
                shipFromAddress.getCountryCode(),
                shipFromAddress.getStateOrProvinceCode(),
                shipFromAddress.getCity(),
                shipFromAddress.getAddressLine1(),
                shipFromAddress.getName()
        );

    }
}
