package com.erp.sdk.oms.amz.spapi.convert;

import com.common.business.dto.PlatformFbaShipmentDTO;
import com.common.business.dto.PlatformFbaShipmentReceiveDTO;
import com.erp.sdk.oms.amz.spapi.dto.PlatformAmazonFbaShipmentDTO;
import com.erp.sdk.oms.amz.spapi.model.fulfillmentinbound.InboundShipmentItem;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 亚马逊FBA货件转换器
 *
 * @author Jim
 * @since 2023-11-01
 **/
@Mapper
@Component
public interface SdkFbaShipmentConverter {
    SdkFbaShipmentConverter INSTANCE = Mappers.getMapper(SdkFbaShipmentConverter.class);

    @Mappings({
            @Mapping(source = "shipmentInfo.shipmentName", target = "name"),
            @Mapping(target = "countryId", source = "shipmentInfo.shipFromAddress.countryCode"),
//            @Mapping(target = "countryName", source = "shipmentInfo.countryName"),
            @Mapping(target = "fulfillmentCenter", source = "shipmentInfo.destinationFulfillmentCenterId"),
//            @Mapping(target = "shipmentStatus", source = "shipmentInfo.shipmentStatus.value"),
            @Mapping(target = "platformShipmentStatus", source = "shipmentInfo.shipmentStatus"),
            @Mapping(target = "shipmentCreateTime", expression = "java(java.time.LocalDateTime.now(java.time.ZoneId.systemDefault()))"),
            @Mapping(target = "labelType", source = "shipmentInfo.labelPrepType.desc"),
            @Mapping(target = "packType", expression = "java(dto.convertPackType())"),
            @Mapping(target = "deliveryFromAddress", expression = "java(dto.combineDeliveryFromAddress())"),
            @Mapping(target = "fbaShipmentId", source = "shipmentInfo.shipmentId"),
//            @Mapping(target = "countryName", source = ""),
            @Mapping(target = "deliveryStatus", constant = "unShipped"),
//            @Mapping(target = "shipmentReceiveTime", source = ""),
//            @Mapping(target = "receiveDTOList")
    })
    PlatformFbaShipmentDTO downloadDtoToSaveDto(PlatformAmazonFbaShipmentDTO dto);


    @Mappings({
            @Mapping(target = "sellerSku", source = "sellerSKU"),
            @Mapping(target = "fnSku", source = "fulfillmentNetworkSKU"),
            @Mapping(target = "declareQty", source = "quantityShipped"),
            @Mapping(target = "receiveQty", source = "quantityReceived"),
            @Mapping(target = "deliveryQty", constant = "0"),
            @Mapping(target = "fbaShipmentId", source = "shipmentId"),
            @Mapping(target = "receiveDate", expression = "java(java.time.LocalDateTime.now(java.time.ZoneId.systemDefault()))")
    })
    PlatformFbaShipmentReceiveDTO receiveDtoToSaveDto(InboundShipmentItem item);


    List<PlatformFbaShipmentReceiveDTO> receiveDtoToSaveDtoList(List<InboundShipmentItem> item);
}
