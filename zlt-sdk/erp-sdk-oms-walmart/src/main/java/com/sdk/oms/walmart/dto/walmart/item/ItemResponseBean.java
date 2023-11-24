package com.sdk.oms.walmart.dto.walmart.item;

import com.google.gson.annotations.SerializedName;

public class ItemResponseBean {
    /**
     * mart : WALMART_US
     * sku : 2815-WM01
     * wpid : 14C0YQWR2H8J
     * upc : 617308600582
     * gtin : 00617308600582
     * productName : Desk Camera Mount Stand, Live Broadcast Boom Arm, Flexible Overhead Webcam Live Streaming Equipment, Microphone Boom Arm Webcam Stand for Photography YouTube Live Streaming Game
     * shelf : ["Home Page","Musical Instruments","Microphones","Stands and Booms"]
     * productType : Camera Stabilizers
     * price : {"currency":"USD","amount":638.99}
     * publishedStatus : UNPUBLISHED
     * unpublishedReasons : {"reason":["Your item is unpublished because the end date has passed. To republish your item, re-ingest the item with a new start and end date."]}
     * lifecycleStatus : RETIRED
     * condition : New
     * variantGroupId : DroneLen01
     * variantGroupInfo : {"isPrimary":false,"groupingAttributes":[{"name":"size","value":"Anamorphic Lens"}]}
     */

    @SerializedName("mart")
    private String mart;
    @SerializedName("sku")
    private String sku;
    @SerializedName("wpid")
    private String wpid;
    @SerializedName("upc")
    private String upc;
    @SerializedName("gtin")
    private String gtin;
    @SerializedName("productName")
    private String productName;
    @SerializedName("shelf")
    private String shelf;
    @SerializedName("productType")
    private String productType;
    @SerializedName("price")
    private PriceBean price;
    @SerializedName("publishedStatus")
    private String publishedStatus;
    @SerializedName("unpublishedReasons")
    private UnpublishedReasonsBean unpublishedReasons;
    @SerializedName("lifecycleStatus")
    private String lifecycleStatus;
    @SerializedName("condition")
    private String condition;
    @SerializedName("variantGroupId")
    private String variantGroupId;
    @SerializedName("variantGroupInfo")
    private VariantGroupInfoBean variantGroupInfo;

    public String getMart() {
        return mart;
    }

    public void setMart(String mart) {
        this.mart = mart;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getWpid() {
        return wpid;
    }

    public void setWpid(String wpid) {
        this.wpid = wpid;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public PriceBean getPrice() {
        return price;
    }

    public void setPrice(PriceBean price) {
        this.price = price;
    }

    public String getPublishedStatus() {
        return publishedStatus;
    }

    public void setPublishedStatus(String publishedStatus) {
        this.publishedStatus = publishedStatus;
    }

    public UnpublishedReasonsBean getUnpublishedReasons() {
        return unpublishedReasons;
    }

    public void setUnpublishedReasons(UnpublishedReasonsBean unpublishedReasons) {
        this.unpublishedReasons = unpublishedReasons;
    }

    public String getLifecycleStatus() {
        return lifecycleStatus;
    }

    public void setLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getVariantGroupId() {
        return variantGroupId;
    }

    public void setVariantGroupId(String variantGroupId) {
        this.variantGroupId = variantGroupId;
    }

    public VariantGroupInfoBean getVariantGroupInfo() {
        return variantGroupInfo;
    }

    public void setVariantGroupInfo(VariantGroupInfoBean variantGroupInfo) {
        this.variantGroupInfo = variantGroupInfo;
    }
}
