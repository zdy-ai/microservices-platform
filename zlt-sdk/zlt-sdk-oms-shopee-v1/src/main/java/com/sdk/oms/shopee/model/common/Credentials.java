package com.sdk.oms.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.identity.AuthStore;

import java.io.Serializable;

public class Credentials extends Auth implements AuthStore {

    private static final long serialVersionUID = 1L;

    public Credentials() {
        super(Type.CREDENTIALS);
    }

    public Credentials(Long partnerId, String partnerKey) {
        this();
        setPartnerId(partnerId);
        setPartnerKey(partnerKey);
    }

    public Credentials(Long partnerId, String partnerKey, Long shopId) {
        this();
        setPartnerId(partnerId);
        setPartnerKey(partnerKey);
        setShopId(shopId);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    private static final class PasswordCredentials implements Serializable {

        private static final long serialVersionUID = 1L;

        @JsonProperty
        String username;
        @JsonProperty
        String password;

        public void setCredentials(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
