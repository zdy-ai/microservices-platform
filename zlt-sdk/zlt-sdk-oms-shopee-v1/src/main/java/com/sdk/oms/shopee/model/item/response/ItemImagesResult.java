package com.sdk.oms.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ItemImagesResult extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Unique identifier for an item.
     */
    @JsonProperty("item_id")
    private Long itemId;

    /**
     * Image URLs for fail download.
     */
    @JsonProperty("fail_image")
    private List<String> failImage;

    /**
     * Image URLs of item.
     */
    private List<String> images;

    /**
     * The time when the image is inserted.
     */
    @JsonProperty("modified_time")
    private Long modifiedTime;

    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;
}
