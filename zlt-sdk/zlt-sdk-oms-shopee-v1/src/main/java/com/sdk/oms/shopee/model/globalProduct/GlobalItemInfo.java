package com.sdk.oms.shopee.model.globalProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdk.oms.shopee.model.ErrorResponse;
import com.sdk.oms.shopee.model.ModelIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author zdy
 * @ClassName GlobalProductBase
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GlobalItemInfo extends ErrorResponse implements ModelIdEntity {
    public static final long serialVersionUID = 1L;


    /**
     * global_item_id
     */
    @JsonProperty("global_item_id")
    private Long id;

    /**
     * global_item_name
     */
    @JsonProperty("global_item_name")
    private String globalItemName;

    private String description;

    @JsonProperty("global_item_sku")
    private String globalItemSku;

    @JsonProperty("global_item_status")
    private String globalItemStatus;

    @JsonProperty("create_time")
    private Long createTime;

    @JsonProperty("update_time")
    private Long update_time;

    private List<StockInfo> stock_info;
    private List<PriceInfo> price_info;
    private List<Image> image;
    private float weight;
    private List<Dimension> dimension;
    private List<PreOrder> pre_order;
    private String size_chart;
    private String condition;
    private String has_model;
    private List<Video> video;
    private Brand brand;
    private List<AttributeList> attribute_list;
    private DescriptionInfo description_info;
    private String description_type;
    /**
     * messages for Delete
     */
    private String msg;
}
