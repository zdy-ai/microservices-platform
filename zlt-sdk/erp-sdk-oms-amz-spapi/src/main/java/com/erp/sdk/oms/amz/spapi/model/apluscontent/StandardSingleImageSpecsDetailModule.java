/*
 * Selling Partner API for A+ Content Management
 * With the A+ Content API, you can build applications that help selling partners add rich marketing content to their Amazon product detail pages. A+ content helps selling partners share their brand and product story, which helps buyers make informed purchasing decisions. Selling partners assemble content by choosing from content modules and adding images and text.
 *
 * OpenAPI spec version: 2020-11-01
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.apluscontent;

import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * A standard image with paragraphs and a bulleted list, and extra space for technical details.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-03-03T10:37:36.644+08:00")
public class StandardSingleImageSpecsDetailModule {
  @SerializedName("headline")
  private TextComponent headline = null;

  @SerializedName("image")
  private ImageComponent image = null;

  @SerializedName("descriptionHeadline")
  private TextComponent descriptionHeadline = null;

  @SerializedName("descriptionBlock1")
  private StandardTextBlock descriptionBlock1 = null;

  @SerializedName("descriptionBlock2")
  private StandardTextBlock descriptionBlock2 = null;

  @SerializedName("specificationHeadline")
  private TextComponent specificationHeadline = null;

  @SerializedName("specificationListBlock")
  private StandardHeaderTextListBlock specificationListBlock = null;

  @SerializedName("specificationTextBlock")
  private StandardTextBlock specificationTextBlock = null;

  public StandardSingleImageSpecsDetailModule headline(TextComponent headline) {
    this.headline = headline;
    return this;
  }

   /**
   * Get headline
   * @return headline
  **/

  public TextComponent getHeadline() {
    return headline;
  }

  public void setHeadline(TextComponent headline) {
    this.headline = headline;
  }

  public StandardSingleImageSpecsDetailModule image(ImageComponent image) {
    this.image = image;
    return this;
  }

   /**
   * Get image
   * @return image
  **/

  public ImageComponent getImage() {
    return image;
  }

  public void setImage(ImageComponent image) {
    this.image = image;
  }

  public StandardSingleImageSpecsDetailModule descriptionHeadline(TextComponent descriptionHeadline) {
    this.descriptionHeadline = descriptionHeadline;
    return this;
  }

   /**
   * Get descriptionHeadline
   * @return descriptionHeadline
  **/

  public TextComponent getDescriptionHeadline() {
    return descriptionHeadline;
  }

  public void setDescriptionHeadline(TextComponent descriptionHeadline) {
    this.descriptionHeadline = descriptionHeadline;
  }

  public StandardSingleImageSpecsDetailModule descriptionBlock1(StandardTextBlock descriptionBlock1) {
    this.descriptionBlock1 = descriptionBlock1;
    return this;
  }

   /**
   * Get descriptionBlock1
   * @return descriptionBlock1
  **/

  public StandardTextBlock getDescriptionBlock1() {
    return descriptionBlock1;
  }

  public void setDescriptionBlock1(StandardTextBlock descriptionBlock1) {
    this.descriptionBlock1 = descriptionBlock1;
  }

  public StandardSingleImageSpecsDetailModule descriptionBlock2(StandardTextBlock descriptionBlock2) {
    this.descriptionBlock2 = descriptionBlock2;
    return this;
  }

   /**
   * Get descriptionBlock2
   * @return descriptionBlock2
  **/

  public StandardTextBlock getDescriptionBlock2() {
    return descriptionBlock2;
  }

  public void setDescriptionBlock2(StandardTextBlock descriptionBlock2) {
    this.descriptionBlock2 = descriptionBlock2;
  }

  public StandardSingleImageSpecsDetailModule specificationHeadline(TextComponent specificationHeadline) {
    this.specificationHeadline = specificationHeadline;
    return this;
  }

   /**
   * Get specificationHeadline
   * @return specificationHeadline
  **/

  public TextComponent getSpecificationHeadline() {
    return specificationHeadline;
  }

  public void setSpecificationHeadline(TextComponent specificationHeadline) {
    this.specificationHeadline = specificationHeadline;
  }

  public StandardSingleImageSpecsDetailModule specificationListBlock(StandardHeaderTextListBlock specificationListBlock) {
    this.specificationListBlock = specificationListBlock;
    return this;
  }

   /**
   * Get specificationListBlock
   * @return specificationListBlock
  **/

  public StandardHeaderTextListBlock getSpecificationListBlock() {
    return specificationListBlock;
  }

  public void setSpecificationListBlock(StandardHeaderTextListBlock specificationListBlock) {
    this.specificationListBlock = specificationListBlock;
  }

  public StandardSingleImageSpecsDetailModule specificationTextBlock(StandardTextBlock specificationTextBlock) {
    this.specificationTextBlock = specificationTextBlock;
    return this;
  }

   /**
   * Get specificationTextBlock
   * @return specificationTextBlock
  **/

  public StandardTextBlock getSpecificationTextBlock() {
    return specificationTextBlock;
  }

  public void setSpecificationTextBlock(StandardTextBlock specificationTextBlock) {
    this.specificationTextBlock = specificationTextBlock;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StandardSingleImageSpecsDetailModule standardSingleImageSpecsDetailModule = (StandardSingleImageSpecsDetailModule) o;
    return Objects.equals(this.headline, standardSingleImageSpecsDetailModule.headline) &&
        Objects.equals(this.image, standardSingleImageSpecsDetailModule.image) &&
        Objects.equals(this.descriptionHeadline, standardSingleImageSpecsDetailModule.descriptionHeadline) &&
        Objects.equals(this.descriptionBlock1, standardSingleImageSpecsDetailModule.descriptionBlock1) &&
        Objects.equals(this.descriptionBlock2, standardSingleImageSpecsDetailModule.descriptionBlock2) &&
        Objects.equals(this.specificationHeadline, standardSingleImageSpecsDetailModule.specificationHeadline) &&
        Objects.equals(this.specificationListBlock, standardSingleImageSpecsDetailModule.specificationListBlock) &&
        Objects.equals(this.specificationTextBlock, standardSingleImageSpecsDetailModule.specificationTextBlock);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headline, image, descriptionHeadline, descriptionBlock1, descriptionBlock2, specificationHeadline, specificationListBlock, specificationTextBlock);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StandardSingleImageSpecsDetailModule {\n");
    
    sb.append("    headline: ").append(toIndentedString(headline)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    descriptionHeadline: ").append(toIndentedString(descriptionHeadline)).append("\n");
    sb.append("    descriptionBlock1: ").append(toIndentedString(descriptionBlock1)).append("\n");
    sb.append("    descriptionBlock2: ").append(toIndentedString(descriptionBlock2)).append("\n");
    sb.append("    specificationHeadline: ").append(toIndentedString(specificationHeadline)).append("\n");
    sb.append("    specificationListBlock: ").append(toIndentedString(specificationListBlock)).append("\n");
    sb.append("    specificationTextBlock: ").append(toIndentedString(specificationTextBlock)).append("\n");
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

