package com.erp.sdk.oms.amz.spapi.convert;

import com.erp.sdk.oms.amz.spapi.dto.PlatformAmazonListingDTO;
import com.erp.sdk.oms.amz.spapi.dto.ReportListingMongoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * 亚马逊货件转换器
 *
 * @author Jim
 * @since 2023-11-01
 **/
@Mapper
@Component
public interface SdkListingConverter {

    SdkListingConverter INSTANCE = Mappers.getMapper(SdkListingConverter.class);


    @Mappings({
            @Mapping(target = "uniqueId", source = "mongoDTO.listingId"),
            @Mapping(target = "shopId", source = "shopId"),
            @Mapping(target = "downloadStatus", constant = "0"),
            @Mapping(target = "platformUpdateTime", expression = "java(java.time.OffsetDateTime.parse(mongoDTO.getDataEndTime()).toLocalDateTime())"),
    })
    PlatformAmazonListingDTO mongoDtoToListingDto(ReportListingMongoDTO mongoDTO, String shopId);
}
