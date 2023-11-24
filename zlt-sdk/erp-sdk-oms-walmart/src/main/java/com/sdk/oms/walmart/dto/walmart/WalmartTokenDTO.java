package com.sdk.oms.walmart.dto.walmart;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 沃尔玛获取token
 * @Author Luo_WG
 * @Date 2023/10/18 14:02
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class WalmartTokenDTO {
    /**
     * 短令牌
     */
    @SerializedName("access_token")
    private String accessToken;
    /**
     * token类型
     */
    @SerializedName("token_type")
    private String tokenType;
    /**
     * 失效时间
     */
    @SerializedName("expires_in")
    private String expiresIn;

}
