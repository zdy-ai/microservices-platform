package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import org.springframework.data.annotation.ReadOnlyProperty;

@Slf4j
@Data
@NoArgsConstructor
@JsonTypeName(value = "webhook")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class Webhook {

    private String topic;

    private String address;

    private String format;

    private String[] fields;

    private String[] metafieldNamespaces;

    @ReadOnlyProperty
    private int id;

    @ReadOnlyProperty
    @JsonProperty("api_version")
    private String apiVersion;

    @JsonProperty("created_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;



    /**
     * @param name
     * @param value
     */
    @JsonAnySetter
    public void ignored(String name, Object value) {
        log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
    }
}
