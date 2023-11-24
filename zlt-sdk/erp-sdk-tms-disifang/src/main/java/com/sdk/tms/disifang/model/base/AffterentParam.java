package com.sdk.tms.disifang.model.base;

import lombok.Builder;
import lombok.Data;

/**
 * @author zdy
 * @ClassName AffterentParam
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
@Builder
@Data
public class AffterentParam {

    private String method;

    private String appKey;

    private String version;

    private String format;

    private String accessToken;

    private String appSecret;

    private String language;
}
