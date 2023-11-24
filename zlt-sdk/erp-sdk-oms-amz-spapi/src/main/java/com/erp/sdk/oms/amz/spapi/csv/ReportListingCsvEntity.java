package com.erp.sdk.oms.amz.spapi.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 库存报告实体
 */
@Data
@NoArgsConstructor
public class ReportListingCsvEntity implements Serializable {

    @CsvBindByName(column = "item-name")
    private String itemName;

    @CsvBindByName(column = "item-description")
    private String itemDescription;

    @CsvBindByName(column = "listing-id")
    private String listingId;

    @CsvBindByName(column = "seller-sku")
    private String sellerSku;

    @CsvBindByName(column = "price")
    private String price;

    @CsvBindByName(column = "quantity")
    private String quantity;

    @CsvBindByName(column = "open-date")
    private String openDate;

    @CsvBindByName(column = "image-url")
    private String imageUrl;

    @CsvBindByName(column = "item-is-marketplace")
    private String itemIsMarketplace;

    @CsvBindByName(column = "product-id-type")
    private String productIdType;

    @CsvBindByName(column = "zshop-shipping-fee")
    private String zshopShippingFee;

    @CsvBindByName(column = "item-note")
    private String itemNote;

    @CsvBindByName(column = "item-condition")
    private String itemCondition;

    @CsvBindByName(column = "zshop-category1")
    private String zshopCategory1;

    @CsvBindByName(column = "zshop-browse-path")
    private String zshopBrowsePath;

    @CsvBindByName(column = "zshop-storefront-feature")
    private String zshopStorefrontFeature;

    @CsvBindByName(column = "asin1")
    private String asin1;

    @CsvBindByName(column = "asin2")
    private String asin2;

    @CsvBindByName(column = "asin3")
    private String asin3;

    @CsvBindByName(column = "will-ship-internationally")
    private String willShipInternationally;

    @CsvBindByName(column = "expedited-shipping")
    private String expeditedShipping;

    @CsvBindByName(column = "zshop-boldface")
    private String zshopBoldface;

    @CsvBindByName(column = "product-id")
    private String productId;

    @CsvBindByName(column = "bid-for-featured-placement")
    private String bidForFeaturedPlacement;

    @CsvBindByName(column = "add-delete")
    private String addDelete;

    @CsvBindByName(column = "pending-quantity")
    private String pendingQuantity;

    @CsvBindByName(column = "fulfillment-channel")
    private String fulfillmentChannel;

    @CsvBindByName(column = "merchant-shipping-group")
    private String merchantShippingGroup;

}
