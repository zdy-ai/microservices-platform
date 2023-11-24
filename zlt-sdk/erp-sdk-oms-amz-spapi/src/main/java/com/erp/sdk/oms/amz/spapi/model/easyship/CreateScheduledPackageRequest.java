/*
 * Selling Partner API for Easy Ship
 * The Selling Partner API for Easy Ship helps you build applications that help sellers manage and ship Amazon Easy Ship orders.  Your Easy Ship applications can:  * Get available time slots for packages to be scheduled for delivery.  * Schedule, reschedule, and cancel Easy Ship orders.  * Print labels, invoices, and warranties.  See the [Marketplace Support Table](doc:easy-ship-api-v2022-03-23-use-case-guide) for the differences in Easy Ship operations by marketplace.
 *
 * OpenAPI spec version: 2022-03-23
 * Contact: marketplaceapitest@amazon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.easyship;

import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * The request schema for the &#x60;createScheduledPackage&#x60; operation.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-07-24T13:36:02.735+08:00")
public class CreateScheduledPackageRequest {
  @SerializedName("amazonOrderId")
  private String amazonOrderId = null;

  @SerializedName("marketplaceId")
  private String marketplaceId = null;

  @SerializedName("packageDetails")
  private PackageDetails packageDetails = null;

  public CreateScheduledPackageRequest amazonOrderId(String amazonOrderId) {
    this.amazonOrderId = amazonOrderId;
    return this;
  }

   /**
   * Get amazonOrderId
   * @return amazonOrderId
  **/

  public String getAmazonOrderId() {
    return amazonOrderId;
  }

  public void setAmazonOrderId(String amazonOrderId) {
    this.amazonOrderId = amazonOrderId;
  }

  public CreateScheduledPackageRequest marketplaceId(String marketplaceId) {
    this.marketplaceId = marketplaceId;
    return this;
  }

   /**
   * Get marketplaceId
   * @return marketplaceId
  **/

  public String getMarketplaceId() {
    return marketplaceId;
  }

  public void setMarketplaceId(String marketplaceId) {
    this.marketplaceId = marketplaceId;
  }

  public CreateScheduledPackageRequest packageDetails(PackageDetails packageDetails) {
    this.packageDetails = packageDetails;
    return this;
  }

   /**
   * Get packageDetails
   * @return packageDetails
  **/

  public PackageDetails getPackageDetails() {
    return packageDetails;
  }

  public void setPackageDetails(PackageDetails packageDetails) {
    this.packageDetails = packageDetails;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateScheduledPackageRequest createScheduledPackageRequest = (CreateScheduledPackageRequest) o;
    return Objects.equals(this.amazonOrderId, createScheduledPackageRequest.amazonOrderId) &&
        Objects.equals(this.marketplaceId, createScheduledPackageRequest.marketplaceId) &&
        Objects.equals(this.packageDetails, createScheduledPackageRequest.packageDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amazonOrderId, marketplaceId, packageDetails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateScheduledPackageRequest {\n");
    
    sb.append("    amazonOrderId: ").append(toIndentedString(amazonOrderId)).append("\n");
    sb.append("    marketplaceId: ").append(toIndentedString(marketplaceId)).append("\n");
    sb.append("    packageDetails: ").append(toIndentedString(packageDetails)).append("\n");
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

