package com.sdk.oms.walmart.dto.walmart.order;

import com.google.gson.annotations.SerializedName;

public class ItemBean {
    /**
     * productName : Protective Vlog Cage for Action 2 - Metal Frame Housing Cage Vlogging Accessories Magnetic Case for DJI Action 2 Power Combo or Dual-Screen Combo
     * sku : 2872-WM01
     * imageUrl : https://i5.walmartimages.com/asr/8a14dd43-262f-4fd0-96c9-0b1bc07a785a.a382d1098548c68f71ffe966d07af095.jpeg
     */

    @SerializedName("productName")
    private String productName;
    @SerializedName("sku")
    private String sku;
    @SerializedName("imageUrl")
    private String imageUrl;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
