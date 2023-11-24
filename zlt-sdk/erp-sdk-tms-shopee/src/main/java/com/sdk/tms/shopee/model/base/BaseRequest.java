package com.sdk.tms.shopee.model.base;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName BaseRequest
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class BaseRequest implements Serializable {
    @NotNull(message = "客户ID不能为空")
    private Long partnerId;
    private Long timestamp;
    @NotBlank(message = "授权token不能为空")
    private String accessToken;
    @NotNull(message = "店铺ID不能为空")
    private Long shopId;
    private String sign;
    private String path;
    private String host;
    @NotBlank(message = "客户key不能为空")
    private String partnerKey;
    private Integer pageSize;
    private String cursor;
}
