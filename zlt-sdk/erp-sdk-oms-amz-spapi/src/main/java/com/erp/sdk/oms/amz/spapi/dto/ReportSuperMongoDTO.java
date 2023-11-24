package com.erp.sdk.oms.amz.spapi.dto;

import cn.hutool.core.util.StrUtil;
import com.common.core.anno.Panno;
import com.common.core.enums.PannoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 亚马逊报表mongo超类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ReportSuperMongoDTO {
    @Panno(findType = PannoEnum.IN,field = "marketplaceIds")
    private List<String> marketplaceIds;

    @Panno(findType = PannoEnum.EQ, field = "reportId")
    private String reportId;

    @Panno(findType = PannoEnum.EQ, field = "dataStartTime")
    private String dataStartTime;

    @Panno(findType = PannoEnum.EQ, field = "dataEndTime")
    private String dataEndTime;

    @Panno(findType = PannoEnum.EQ, field = "reportScheduleId")
    private String reportScheduleId;


}
