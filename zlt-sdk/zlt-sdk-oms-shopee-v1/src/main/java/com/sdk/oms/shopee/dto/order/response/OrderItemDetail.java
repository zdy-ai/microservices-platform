package com.sdk.oms.shopee.dto.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.sdk.oms.shopee.dto.product.response.ImageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class OrderItemDetail implements Serializable {

	private static final long serialVersionUID = 1L;

    @JSONField(name = "item_id")
    private Long itemId;

    /**
     * Name of the item in local language.
     */
    @JSONField(name = "item_name")
    private String name;

    /**
     * A item SKU (stock keeping unit) is an identifier defined by a seller,
     */
    @JSONField(name = "item_sku")
    private String itemSku;

    @JSONField(name = "model_id")
    private Long modelId;
    @JSONField(name = "model_name")
    private String modelName;
    @JSONField(name = "model_sku")
    private String modelSku;
    @JSONField(name = "model_quantity_purchased")
    private Integer modelQuantityPurchased;
    @JSONField(name = "model_original_price")
    private float modelOriginalPrice;
    @JSONField(name = "model_discounted_price")
    private float modelDiscountedPrice;
    /**
     * TThis value indicates whether buyer buy the order item in wholesale price.
     */
    @JSONField(name = "is_wholesale")
    private boolean wholesale;
    @JSONField(name = "weight")
    private float weight;
    @JSONField(name = "add_on_deal")
    private boolean addOnDeal;
    @JSONField(name = "main_item")
    private boolean mainItem;
    @JSONField(name = "add_on_deal_id")
    private Long addOnDealId;
    @JSONField(name = "promotion_type")
    private String promotionType;
    @JSONField(name = "promotion_id")
    private Long promotionId;
    @JSONField(name = "order_item_id")
    private Long orderItemId;

    /**
     * The identify of product promotion.
     */
    @JSONField(name = "promotion_group_id")
    private Long promotionGroupId;
    @JSONField(name = "image_info")
    private ImageInfo imageInfo;

    @JSONField(name = "product_location_id")
    private List<String> productLocationId;

    @JSONField(name = "is_prescription_item")
    private boolean isPrescriptionItem;

    @JSONField(name = "is_b2c_owned_item")
    private boolean isB2cOwnedItem;
}
