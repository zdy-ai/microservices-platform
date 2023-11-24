package com.sdk.tms.disifang.model.base;

/**
 * @author zdy
 * @ClassName TokenResultEntity
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
public class TokenResultEntity {
    private String accessToken;

    private String refreshToken;

    private String expiresIn;

    public TokenResultEntity() {}

    public TokenResultEntity(String accessToken, String refreshToken, String expiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String toString() {
        return "TokenResultEntity{accessToken='" + this.accessToken + '\'' + ", refreshToken='" + this.refreshToken + '\'' + ", expiresIn='" + this.expiresIn + '\'' + '}';
    }
}
