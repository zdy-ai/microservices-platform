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

import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * Container specification for checking the service rate.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T20:59:38.614+08:00")
public class ContainerSpecification {
  @SerializedName("dimensions")
  private Dimensions dimensions = null;

  @SerializedName("weight")
  private Weight weight = null;

  public ContainerSpecification dimensions(Dimensions dimensions) {
    this.dimensions = dimensions;
    return this;
  }

   /**
   * The length, width, and height of the container.
   * @return dimensions
  **/

  public Dimensions getDimensions() {
    return dimensions;
  }

  public void setDimensions(Dimensions dimensions) {
    this.dimensions = dimensions;
  }

  public ContainerSpecification weight(Weight weight) {
    this.weight = weight;
    return this;
  }

   /**
   * The weight of the container.
   * @return weight
  **/

  public Weight getWeight() {
    return weight;
  }

  public void setWeight(Weight weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContainerSpecification containerSpecification = (ContainerSpecification) o;
    return Objects.equals(this.dimensions, containerSpecification.dimensions) &&
        Objects.equals(this.weight, containerSpecification.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dimensions, weight);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContainerSpecification {\n");
    
    sb.append("    dimensions: ").append(toIndentedString(dimensions)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
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

