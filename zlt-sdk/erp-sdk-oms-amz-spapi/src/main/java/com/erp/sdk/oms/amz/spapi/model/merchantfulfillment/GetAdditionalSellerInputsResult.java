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
 * The payload for the getAdditionalSellerInputs operation.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T20:46:23.921+08:00")
public class GetAdditionalSellerInputsResult {
  @SerializedName("ShipmentLevelFields")
  private AdditionalInputsList shipmentLevelFields = null;

  @SerializedName("ItemLevelFieldsList")
  private ItemLevelFieldsList itemLevelFieldsList = null;

  public GetAdditionalSellerInputsResult shipmentLevelFields(AdditionalInputsList shipmentLevelFields) {
    this.shipmentLevelFields = shipmentLevelFields;
    return this;
  }

   /**
   * Get shipmentLevelFields
   * @return shipmentLevelFields
  **/

  public AdditionalInputsList getShipmentLevelFields() {
    return shipmentLevelFields;
  }

  public void setShipmentLevelFields(AdditionalInputsList shipmentLevelFields) {
    this.shipmentLevelFields = shipmentLevelFields;
  }

  public GetAdditionalSellerInputsResult itemLevelFieldsList(ItemLevelFieldsList itemLevelFieldsList) {
    this.itemLevelFieldsList = itemLevelFieldsList;
    return this;
  }

   /**
   * Get itemLevelFieldsList
   * @return itemLevelFieldsList
  **/

  public ItemLevelFieldsList getItemLevelFieldsList() {
    return itemLevelFieldsList;
  }

  public void setItemLevelFieldsList(ItemLevelFieldsList itemLevelFieldsList) {
    this.itemLevelFieldsList = itemLevelFieldsList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAdditionalSellerInputsResult getAdditionalSellerInputsResult = (GetAdditionalSellerInputsResult) o;
    return Objects.equals(this.shipmentLevelFields, getAdditionalSellerInputsResult.shipmentLevelFields) &&
        Objects.equals(this.itemLevelFieldsList, getAdditionalSellerInputsResult.itemLevelFieldsList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shipmentLevelFields, itemLevelFieldsList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAdditionalSellerInputsResult {\n");
    
    sb.append("    shipmentLevelFields: ").append(toIndentedString(shipmentLevelFields)).append("\n");
    sb.append("    itemLevelFieldsList: ").append(toIndentedString(itemLevelFieldsList)).append("\n");
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

