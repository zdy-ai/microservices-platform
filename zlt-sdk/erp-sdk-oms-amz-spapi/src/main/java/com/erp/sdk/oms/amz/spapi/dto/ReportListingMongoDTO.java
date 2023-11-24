package com.erp.sdk.oms.amz.spapi.dto;

import com.common.core.anno.Panno;
import com.common.core.enums.PannoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * 商品报告实体
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ReportListingMongoDTO extends ReportSuperMongoDTO  {

    @Panno(findType = PannoEnum.EQ, field = "item-name")
    private String itemName;

    @Panno(findType = PannoEnum.EQ, field = "item-description")
    private String itemDescription;

    @Panno(findType = PannoEnum.EQ, field = "listing-id")
    private String listingId;

    @Panno(findType = PannoEnum.EQ, field = "seller-sku")
    private String sellerSku;

    @Panno(findType = PannoEnum.EQ, field = "price")
    private String price;

    @Panno(findType = PannoEnum.EQ, field = "quantity")
    private String quantity;

    @Panno(findType = PannoEnum.EQ, field = "open-date")
    private String openDate;

    @Panno(findType = PannoEnum.EQ, field = "image-url")
    private String imageUrl;

    @Panno(findType = PannoEnum.EQ, field = "item-is-marketplace")
    private String itemIsMarketplace;

    @Panno(findType = PannoEnum.EQ, field = "product-id-type")
    private String productIdType;

    @Panno(findType = PannoEnum.EQ, field = "zshop-shipping-fee")
    private String zshopShippingFee;

    @Panno(findType = PannoEnum.EQ, field = "item-note")
    private String itemNote;

    @Panno(findType = PannoEnum.EQ, field = "item-condition")
    private String itemCondition;

    @Panno(findType = PannoEnum.EQ, field = "zshop-category1")
    private String zshopCategory1;

    @Panno(findType = PannoEnum.EQ, field = "zshop-browse-path")
    private String zshopBrowsePath;

    @Panno(findType = PannoEnum.EQ, field = "zshop-storefront-feature")
    private String zshopStorefrontFeature;

    @Panno(findType = PannoEnum.EQ, field = "asin1")
    private String asin1;

    @Panno(findType = PannoEnum.EQ, field = "asin2")
    private String asin2;

    @Panno(findType = PannoEnum.EQ, field = "asin3")
    private String asin3;

    @Panno(findType = PannoEnum.EQ, field = "will-ship-internationally")
    private String willShipInternationally;

    @Panno(findType = PannoEnum.EQ, field = "expedited-shipping")
    private String expeditedShipping;

    @Panno(findType = PannoEnum.EQ, field = "zshop-boldface")
    private String zshopBoldface;

    @Panno(findType = PannoEnum.EQ, field = "product-id")
    private String productId;

    @Panno(findType = PannoEnum.EQ, field = "bid-for-featured-placement")
    private String bidForFeaturedPlacement;

    @Panno(findType = PannoEnum.EQ, field = "add-delete")
    private String addDelete;

    @Panno(findType = PannoEnum.EQ, field = "pending-quantity")
    private String pendingQuantity;

    @Panno(findType = PannoEnum.EQ, field = "fulfillment-channel")
    private String fulfillmentChannel;

    @Panno(findType = PannoEnum.EQ, field = "merchant-shipping-group")
    private String merchantShippingGroup;

}
