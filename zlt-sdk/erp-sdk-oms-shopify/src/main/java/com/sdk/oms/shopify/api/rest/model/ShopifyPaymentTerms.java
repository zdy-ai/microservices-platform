package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyPaymentTerms {


    private String amount;
    private String currency;
    @JsonProperty("payment_terms_name")
    private String paymentTermsName;
    @JsonProperty("payment_terms_type")
    private String paymentTermsType;
    @JsonProperty("due_in_days")
    private String dueInDays;
    @JsonProperty("payment_schedules")
    private List<ShopifyPaymentSchedules> paymentSchedules = new LinkedList<>();

    @JsonAnySetter
    public void ignored(String name, Object value) {
        log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
    }
}
