package com.sdk.tms.yanwen.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class YanWenRequestDTO implements Serializable {
    private String userId;
    private String format;
    private String method;
    private Long timestamp;
    private String version;
    private String sign;
    private String data;
}
