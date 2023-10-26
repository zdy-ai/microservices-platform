package com.sdk.oms.shopee.model.returns.response;

import com.sdk.oms.shopee.core.model.ModelEntity;
import com.sdk.oms.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReturnActionResult extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;


    /**
     * The serial number of return.
     */
    private String returnsn;

    /**
     * Action Result Message
     */
    private String msg;
}
