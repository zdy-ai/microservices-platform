package com.sdk.tms.yuntu.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class YunTuChannel {
    //运输方式代号
    private String code;
    //运输方式中文名称
    private String cName;
    //运输方式英文名称
    private String eName;
    //是否带跟踪号
    private String hasTrackingNumber;
    //运输方式显示名称
    private String displayName;
}
