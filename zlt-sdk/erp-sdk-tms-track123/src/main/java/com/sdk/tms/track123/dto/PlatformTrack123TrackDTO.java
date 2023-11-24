package com.sdk.tms.track123.dto;

import com.common.business.dto.CleanBaseDTO;
import com.common.business.dto.JobTaskDTO;
import com.common.business.enums.PlatformDictEnum;
import com.common.core.anno.Panno;
import com.common.core.enums.PannoEnum;
import com.erp.model.oms.entity.ShopInfoEntity;
import com.sdk.tms.track123.model.response.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 平台亚马逊FBA货件DTO
 *
 * @author Jim
 * @date 2023/11/1
 **/
@Slf4j
@Setter
@Getter
@NoArgsConstructor
public class PlatformTrack123TrackDTO extends CleanBaseDTO {


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
    //查询成功的单号
    private TrackInfo accepted;
    //查询失败的单号
    private List<Rejected> rejected;

    public PlatformTrack123TrackDTO(ResponseData responseData, JobTaskDTO data) {
        this.accepted = responseData.getAccepted();
        this.rejected = responseData.getRejected();
        this.setIsClean(0);
        this.setPlatform(PlatformDictEnum.TRACK123.getCode());
        this.setUniqueId(UUID.randomUUID().toString());
        this.setDownloadTime(LocalDateTime.now(ZoneId.systemDefault()).toString());
        this.setLastPushTime(data.getNextTime().toString());
    }
}
