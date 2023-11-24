package com.sdk.wms.iml.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.business.dto.CleanBaseDTO;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ImlRegionResp extends CleanBaseDTO implements Serializable {

    //区域ID
    @JSONField(name = "region_id")
    private Integer regionId;

    //父区域关联ID
    @JSONField(name = "parent_region_id")
    private Integer parentRegionId;

    //区域名称
    @JSONField(name = "region_name")
    private String regionName;

    //区域级别,0中国，1省，2市，3区/县
    @JSONField(name = "region_level")
    private Integer regionLevel;

}
