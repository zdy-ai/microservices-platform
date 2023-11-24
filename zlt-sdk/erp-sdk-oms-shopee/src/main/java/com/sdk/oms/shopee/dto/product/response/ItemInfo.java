package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName Image
 * @description: TODO
 * @date 2023年10月20日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
public class ItemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "item_id")
    private Long id;

    /**
     * shop id of the item
     */
    @JSONField(name = "category_id")
    private Long categoryId;
    /**
     * Name of the item in local language.
     */
    @JSONField(name = "item_name")
    private String name;

    /**
     * Description of the item in local language.
     */
    private String description;

    /**
     * An item SKU (stock keeping unit) is an identifier defined by a seller,
     * sometimes called parent SKU.
     */
    @JSONField(name = "item_sku")
    private String itemSku;

    /**
     * Timestamp that indicates the date and time that the item was created.
     */
    @JSONField(name = "create_time")
    private Long createTime;

    /**
     * Timestamp that indicates the last time that there was a change
     * in value of the item, such as price/stock change.
     */
    @JSONField(name = "update_time")
    private Long updateTime;

    /**
     * The current price of the item in the listing currency.
     */
    private String weight;

    /**
     * Is it second-hand.
     */
    private String condition;
    /**
     * Url of size chart image.
     */
    @JSONField(name = "size_chart")
    private String sizeChart;
    /**
     * Enumerated type that defines the current status of the item. Applicable values: NORMAL, DELETED, BANNED and UNLIST.
     */
    @JSONField(name = "item_status")
    private String status;
    /**
     * Does it contain model.
     */
    @JSONField(name = "has_model")
    private boolean hasModel;

    /**
     * Does it contain model.
     */
    @JSONField(name = "promotion_id")
    private Long promotionId;

    /**
     * Does it contain model.
     */
    @JSONField(name = "item_dangerous")
    private Long itemDangerous;


    /**
     * Type of description : values: See Data Definition- description_type (normal , extended).
     */
    @JSONField(name = "description_type")
    private String descriptionType;

    /**
     * (only TW seller and BR Local seller available) This field will return when the item has no model and TW seller or BR local seller have uploaded the gtin_code.
     */
    @JSONField(name = "gtin_code")
    private String gtinCode;

    /**
     * Image URLs of the item. It contains at most 9 URLs.
     */
    @JSONField(name = "attribute_list")
    private List<Attribute> attributes;

    /**
     * The three-digit code representing the currency unit used for the item in Shopee Listings.
     */
    @JSONField(name = "price_info")
    private List<PriceInfo> priceInfos;



    /**
     * the net weight of this item, the unit is KG.
     */
    @JSONField(name = "image")
    private Image image;

    /**
     * Should call shopee.item.GetCategories to get category first.
     * Related to result.categories.category_id
     */
    @JSONField(name = "dimension")
    private Dimension dimension;

    /**
     * The original price of the item in the listing currency.
     */
    @JSONField(name = "logistic_info")
    private List<Logistics> logistics;

    /**
     * The variation of item is to list out all models of this product
     */
    @JSONField(name = "pre_order")
    private PreOrder preOrder;

    /**
     * Attributes
     */
    @JSONField(name = "wholesales")
    List<WholeSale> wholesales;

    /**
     * Logistics
     */
    @JSONField(name = "video_info")
    private List<Video> videos;

    /**
     * The length of package for this single item, the unit is CM
     */
    @JSONField(name = "brand")
    private Brand brand;

    /**
     * Time for a warranty claim.Value should be in one of ONE_YEAR TWO_YEARS OVER_TWO_YEARS.
     */
    @JSONField(name = "complaint_policy")
    private ComplaintPolicy complaintPolicy;

    /**
     * Tax information
     */
    @JSONField(name = "tax_info")
    private TaxInfo taxInfo;

    /**
     * new stock object.
     *
     * Please check this FAQ for more detail: https://open.shopee.com/faq?top=162&sub=166&page=1&faq=230
     */
    @JSONField(name = "stock_info_v2")
    private StockInfo stockInfo;

    /**
     *New description field. Only whitelist sellers can use it.
     */
    @JSONField(name = "description_info")
    private DescriptionInfo descriptionInfo;
}
