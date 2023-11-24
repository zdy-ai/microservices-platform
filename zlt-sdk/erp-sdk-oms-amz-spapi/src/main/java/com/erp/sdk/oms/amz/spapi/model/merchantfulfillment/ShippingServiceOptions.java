/*
 * Selling Partner API for Merchant Fulfillment
 * The Selling Partner API for Merchant Fulfillment helps you build applications that let sellers purchase shipping for non-Prime and Prime orders using Amazon’s Buy Shipping Services.
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.merchantfulfillment;

import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * Extra services provided by a carrier.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T20:46:23.921+08:00")
public class ShippingServiceOptions {
  @SerializedName("DeliveryExperience")
  private DeliveryExperienceType deliveryExperience = null;

  @SerializedName("DeclaredValue")
  private CurrencyAmount declaredValue = null;

  @SerializedName("CarrierWillPickUp")
  private Boolean carrierWillPickUp = null;

  @SerializedName("CarrierWillPickUpOption")
  private CarrierWillPickUpOption carrierWillPickUpOption = null;

  @SerializedName("LabelFormat")
  private LabelFormat labelFormat = null;

  public ShippingServiceOptions deliveryExperience(DeliveryExperienceType deliveryExperience) {
    this.deliveryExperience = deliveryExperience;
    return this;
  }

   /**
   * The delivery confirmation level.
   * @return deliveryExperience
  **/

  public DeliveryExperienceType getDeliveryExperience() {
    return deliveryExperience;
  }

  public void setDeliveryExperience(DeliveryExperienceType deliveryExperience) {
    this.deliveryExperience = deliveryExperience;
  }

  public ShippingServiceOptions declaredValue(CurrencyAmount declaredValue) {
    this.declaredValue = declaredValue;
    return this;
  }

   /**
   * The declared value of the shipment. The carrier uses this value to determine the amount to use to insure the shipment. If DeclaredValue is greater than the carrier&#39;s minimum insurance amount, the seller is charged for the additional insurance as determined by the carrier. For information about optional insurance coverage, see the Seller Central Help [UK](https://sellercentral.amazon.co.uk/gp/help/200204080) [US](https://sellercentral.amazon.com/gp/help/200204080).
   * @return declaredValue
  **/

  public CurrencyAmount getDeclaredValue() {
    return declaredValue;
  }

  public void setDeclaredValue(CurrencyAmount declaredValue) {
    this.declaredValue = declaredValue;
  }

  public ShippingServiceOptions carrierWillPickUp(Boolean carrierWillPickUp) {
    this.carrierWillPickUp = carrierWillPickUp;
    return this;
  }

   /**
   * When true, the carrier will pick up the package.  Note: Scheduled carrier pickup is available only using Dynamex (US), DPD (UK), and Royal Mail (UK).
   * @return carrierWillPickUp
  **/

  public Boolean isCarrierWillPickUp() {
    return carrierWillPickUp;
  }

  public void setCarrierWillPickUp(Boolean carrierWillPickUp) {
    this.carrierWillPickUp = carrierWillPickUp;
  }

  public ShippingServiceOptions carrierWillPickUpOption(CarrierWillPickUpOption carrierWillPickUpOption) {
    this.carrierWillPickUpOption = carrierWillPickUpOption;
    return this;
  }

   /**
   * Get carrierWillPickUpOption
   * @return carrierWillPickUpOption
  **/

  public CarrierWillPickUpOption getCarrierWillPickUpOption() {
    return carrierWillPickUpOption;
  }

  public void setCarrierWillPickUpOption(CarrierWillPickUpOption carrierWillPickUpOption) {
    this.carrierWillPickUpOption = carrierWillPickUpOption;
  }

  public ShippingServiceOptions labelFormat(LabelFormat labelFormat) {
    this.labelFormat = labelFormat;
    return this;
  }

   /**
   * The seller&#39;s preferred label format.
   * @return labelFormat
  **/

  public LabelFormat getLabelFormat() {
    return labelFormat;
  }

  public void setLabelFormat(LabelFormat labelFormat) {
    this.labelFormat = labelFormat;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingServiceOptions shippingServiceOptions = (ShippingServiceOptions) o;
    return Objects.equals(this.deliveryExperience, shippingServiceOptions.deliveryExperience) &&
        Objects.equals(this.declaredValue, shippingServiceOptions.declaredValue) &&
        Objects.equals(this.carrierWillPickUp, shippingServiceOptions.carrierWillPickUp) &&
        Objects.equals(this.carrierWillPickUpOption, shippingServiceOptions.carrierWillPickUpOption) &&
        Objects.equals(this.labelFormat, shippingServiceOptions.labelFormat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deliveryExperience, declaredValue, carrierWillPickUp, carrierWillPickUpOption, labelFormat);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShippingServiceOptions {\n");
    
    sb.append("    deliveryExperience: ").append(toIndentedString(deliveryExperience)).append("\n");
    sb.append("    declaredValue: ").append(toIndentedString(declaredValue)).append("\n");
    sb.append("    carrierWillPickUp: ").append(toIndentedString(carrierWillPickUp)).append("\n");
    sb.append("    carrierWillPickUpOption: ").append(toIndentedString(carrierWillPickUpOption)).append("\n");
    sb.append("    labelFormat: ").append(toIndentedString(labelFormat)).append("\n");
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

