/*
 * Selling Partner API for Pricing
 * The Selling Partner API for Pricing helps you programmatically retrieve product pricing and offer information for Amazon Marketplace products.
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.productpricing;

import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * PriceType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T20:54:01.888+08:00")
public class PriceType {
  @SerializedName("LandedPrice")
  private MoneyType landedPrice = null;

  @SerializedName("ListingPrice")
  private MoneyType listingPrice = null;

  @SerializedName("Shipping")
  private MoneyType shipping = null;

  @SerializedName("Points")
  private Points points = null;

  public PriceType landedPrice(MoneyType landedPrice) {
    this.landedPrice = landedPrice;
    return this;
  }

   /**
   * The value calculated by adding ListingPrice + Shipping - Points. Note that if the landed price is not returned, the listing price represents the product with the lowest landed price.
   * @return landedPrice
  **/

  public MoneyType getLandedPrice() {
    return landedPrice;
  }

  public void setLandedPrice(MoneyType landedPrice) {
    this.landedPrice = landedPrice;
  }

  public PriceType listingPrice(MoneyType listingPrice) {
    this.listingPrice = listingPrice;
    return this;
  }

   /**
   * The listing price of the item including any promotions that apply.
   * @return listingPrice
  **/

  public MoneyType getListingPrice() {
    return listingPrice;
  }

  public void setListingPrice(MoneyType listingPrice) {
    this.listingPrice = listingPrice;
  }

  public PriceType shipping(MoneyType shipping) {
    this.shipping = shipping;
    return this;
  }

   /**
   * The shipping cost of the product. Note that the shipping cost is not always available.
   * @return shipping
  **/

  public MoneyType getShipping() {
    return shipping;
  }

  public void setShipping(MoneyType shipping) {
    this.shipping = shipping;
  }

  public PriceType points(Points points) {
    this.points = points;
    return this;
  }

   /**
   * The number of Amazon Points offered with the purchase of an item, and their monetary value.
   * @return points
  **/

  public Points getPoints() {
    return points;
  }

  public void setPoints(Points points) {
    this.points = points;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceType priceType = (PriceType) o;
    return Objects.equals(this.landedPrice, priceType.landedPrice) &&
        Objects.equals(this.listingPrice, priceType.listingPrice) &&
        Objects.equals(this.shipping, priceType.shipping) &&
        Objects.equals(this.points, priceType.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(landedPrice, listingPrice, shipping, points);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceType {\n");
    
    sb.append("    landedPrice: ").append(toIndentedString(landedPrice)).append("\n");
    sb.append("    listingPrice: ").append(toIndentedString(listingPrice)).append("\n");
    sb.append("    shipping: ").append(toIndentedString(shipping)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

