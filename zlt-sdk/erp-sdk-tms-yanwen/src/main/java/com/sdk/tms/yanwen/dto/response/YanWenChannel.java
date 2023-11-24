package com.sdk.tms.yanwen.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class YanWenChannel {
    //渠道名（中文）
    private String nameCh;
    //渠道名（英文）
    private String nameEn;
    //id
    private String id;
}
