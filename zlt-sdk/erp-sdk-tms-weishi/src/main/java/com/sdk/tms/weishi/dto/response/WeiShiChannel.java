package com.sdk.tms.weishi.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class WeiShiChannel {

    //产品代码
    private String code;

    //渠道名（中文）
    @JSONField(name = "cn_name")
    private String cnName;

    //渠道名（英文）
    @JSONField(name = "en_name")
    private String enName;

    //是否可跟踪轨迹(Y/N)
    @JSONField(name = "track_status")
    private String trackStatus;

    //快递时效
    private String aging;
}
