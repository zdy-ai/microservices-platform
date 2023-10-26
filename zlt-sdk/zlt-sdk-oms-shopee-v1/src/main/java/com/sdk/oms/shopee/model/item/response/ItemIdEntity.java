package com.sdk.oms.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.ErrorResponse;
import com.sdk.oms.shopee.model.ModelIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ItemIdEntity extends ErrorResponse implements ModelIdEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Item Id
     */
    @JsonProperty("item_id")
    private Long id;

    /**
     * messages for Delete
     */
    private String msg;

}
