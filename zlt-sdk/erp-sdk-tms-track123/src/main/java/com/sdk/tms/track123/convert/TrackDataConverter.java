package com.sdk.tms.track123.convert;

import com.sdk.tms.track123.dto.PlatformTrack123TrackDTO;
import com.sdk.tms.track123.dto.PlatformTrackDTO;
import com.sdk.tms.track123.model.response.Rejected;
import com.sdk.tms.track123.model.response.TrackInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zdy
 * @ClassName TrackDataConverter
 * @description: TODO
 * @date 2023年11月23日
 * @version: 1.0
 */
@Mapper
@Component
public interface TrackDataConverter {
    TrackDataConverter INSTANCE = Mappers.getMapper(TrackDataConverter.class);

}
