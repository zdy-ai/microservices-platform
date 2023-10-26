package com.sdk.oms.shopee.model.item.request;

import com.sdk.oms.shopee.model.BaseRequest;
import com.sdk.oms.shopee.model.item.Variation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VariationBatch extends BaseRequest {

	private static final long serialVersionUID = 1L;
    /**
     * The variation of item is to list out all models of this product
     */
    @Singular
    List<Variation> variations;

}
