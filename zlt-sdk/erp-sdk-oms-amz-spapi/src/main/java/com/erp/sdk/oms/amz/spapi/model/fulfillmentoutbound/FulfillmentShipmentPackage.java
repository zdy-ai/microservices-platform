/*
 * Selling Partner APIs for Fulfillment Outbound
 * The Selling Partner API for Fulfillment Outbound lets you create applications that help a seller fulfill Multi-Channel Fulfillment orders using their inventory in Amazon's fulfillment network. You can get information on both potential and existing fulfillment orders.
 *
 * OpenAPI spec version: 2020-07-01
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.fulfillmentoutbound;

import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * Package information for a shipment in a fulfillment order.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T20:44:18.412+08:00")
public class FulfillmentShipmentPackage {
  @SerializedName("packageNumber")
  private Integer packageNumber = null;

  @SerializedName("carrierCode")
  private String carrierCode = null;

  @SerializedName("trackingNumber")
  private String trackingNumber = null;

  @SerializedName("estimatedArrivalDate")
  private String estimatedArrivalDate = null;

  public FulfillmentShipmentPackage packageNumber(Integer packageNumber) {
    this.packageNumber = packageNumber;
    return this;
  }

   /**
   * Identifies a package in a shipment.
   * @return packageNumber
  **/

  public Integer getPackageNumber() {
    return packageNumber;
  }

  public void setPackageNumber(Integer packageNumber) {
    this.packageNumber = packageNumber;
  }

  public FulfillmentShipmentPackage carrierCode(String carrierCode) {
    this.carrierCode = carrierCode;
    return this;
  }

   /**
   * Identifies the carrier who will deliver the shipment to the recipient.
   * @return carrierCode
  **/

  public String getCarrierCode() {
    return carrierCode;
  }

  public void setCarrierCode(String carrierCode) {
    this.carrierCode = carrierCode;
  }

  public FulfillmentShipmentPackage trackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
    return this;
  }

   /**
   * The tracking number, if provided, can be used to obtain tracking and delivery information.
   * @return trackingNumber
  **/

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public void setTrackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }

  public FulfillmentShipmentPackage estimatedArrivalDate(String estimatedArrivalDate) {
    this.estimatedArrivalDate = estimatedArrivalDate;
    return this;
  }

   /**
   * The estimated arrival date and time of the package, in ISO 8601 date time format.
   * @return estimatedArrivalDate
  **/

  public String getEstimatedArrivalDate() {
    return estimatedArrivalDate;
  }

  public void setEstimatedArrivalDate(String estimatedArrivalDate) {
    this.estimatedArrivalDate = estimatedArrivalDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FulfillmentShipmentPackage fulfillmentShipmentPackage = (FulfillmentShipmentPackage) o;
    return Objects.equals(this.packageNumber, fulfillmentShipmentPackage.packageNumber) &&
        Objects.equals(this.carrierCode, fulfillmentShipmentPackage.carrierCode) &&
        Objects.equals(this.trackingNumber, fulfillmentShipmentPackage.trackingNumber) &&
        Objects.equals(this.estimatedArrivalDate, fulfillmentShipmentPackage.estimatedArrivalDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packageNumber, carrierCode, trackingNumber, estimatedArrivalDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FulfillmentShipmentPackage {\n");
    
    sb.append("    packageNumber: ").append(toIndentedString(packageNumber)).append("\n");
    sb.append("    carrierCode: ").append(toIndentedString(carrierCode)).append("\n");
    sb.append("    trackingNumber: ").append(toIndentedString(trackingNumber)).append("\n");
    sb.append("    estimatedArrivalDate: ").append(toIndentedString(estimatedArrivalDate)).append("\n");
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

