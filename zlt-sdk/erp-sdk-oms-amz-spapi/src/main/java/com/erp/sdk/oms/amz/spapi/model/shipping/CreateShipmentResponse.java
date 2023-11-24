/*
 * Selling Partner API for Shipping
 * Provides programmatic access to Amazon Shipping APIs.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.shipping;

import com.erp.sdk.oms.amz.spapi.model.ErrorList;
import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * The response schema for the createShipment operation.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T20:59:38.614+08:00")
public class CreateShipmentResponse {
  @SerializedName("payload")
  private CreateShipmentResult payload = null;

  @SerializedName("errors")
  private ErrorList errors = null;

  public CreateShipmentResponse payload(CreateShipmentResult payload) {
    this.payload = payload;
    return this;
  }

   /**
   * The payload for createShipment operation
   * @return payload
  **/

  public CreateShipmentResult getPayload() {
    return payload;
  }

  public void setPayload(CreateShipmentResult payload) {
    this.payload = payload;
  }

  public CreateShipmentResponse errors(ErrorList errors) {
    this.errors = errors;
    return this;
  }

   /**
   * Encountered errors for the operation.
   * @return errors
  **/

  public ErrorList getErrors() {
    return errors;
  }

  public void setErrors(ErrorList errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateShipmentResponse createShipmentResponse = (CreateShipmentResponse) o;
    return Objects.equals(this.payload, createShipmentResponse.payload) &&
        Objects.equals(this.errors, createShipmentResponse.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payload, errors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateShipmentResponse {\n");
    
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

