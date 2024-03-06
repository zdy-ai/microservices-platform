package com.sdk.tms.ubi.model.order;

import com.central.common.annotation.Panno;
import com.central.common.enums.PannoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 清洗基础数据
 *
 * @Author Cloud
 * @Date 2023/6/13 16:12
 **/
@Getter
@Setter
public class CleanBaseDTO extends UniqueDto {
    /**
     * 清洗数据 0 未清洗 1 清洗中 2 清洗完成
     */
    @Panno(findType = PannoEnum.EQ,field = "isClean")
    private Integer isClean;

    /**
     * 上次推送时间
     */
    @Panno(findType = PannoEnum.EQ,field = "lastPushTime")
    private String lastPushTime;

    /**
     * 数据下载时间
     */
    @Panno(findType = PannoEnum.EQ,field = "downloadTime")
    private String downloadTime;

    /**
     * erp授权Id
     */
    @Panno(findType = PannoEnum.EQ,field = "authId")
    private String authId;

    /**
     * 更新的Map(空=更新所有)
     * 只更新指定的字段
     */
    private Map<String, Object> updateFieldMap;
}
