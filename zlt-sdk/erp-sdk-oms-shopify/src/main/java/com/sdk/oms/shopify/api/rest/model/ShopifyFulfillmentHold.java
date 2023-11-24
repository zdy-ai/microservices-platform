package com.sdk.oms.shopify.api.rest.model;

import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlRootElement;

@Data
public class ShopifyFulfillmentHold {

    private String reason;
    @JsonProperty("reason_notes")
    private String reasonNotes;
	

}
