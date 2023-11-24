package com.sdk.tms.tongyou.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TongYouChannel {

    //产品代码
    private String code;

    //渠道名（中文）
    private String cnName;

    //渠道名（英文）
    private String enName;

    //状态(0、正常；1、暂停；2、已关闭)
    private String status;

}
