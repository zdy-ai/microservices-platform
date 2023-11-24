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
 * Additional information required to purchase shipping.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T20:46:23.921+08:00")
public class AdditionalSellerInput {
  @SerializedName("DataType")
  private String dataType = null;

  @SerializedName("ValueAsString")
  private String valueAsString = null;

  @SerializedName("ValueAsBoolean")
  private Boolean valueAsBoolean = null;

  @SerializedName("ValueAsInteger")
  private Integer valueAsInteger = null;

  @SerializedName("ValueAsTimestamp")
  private String valueAsTimestamp = null;

  @SerializedName("ValueAsAddress")
  private Address valueAsAddress = null;

  @SerializedName("ValueAsWeight")
  private Weight valueAsWeight = null;

  @SerializedName("ValueAsDimension")
  private Length valueAsDimension = null;

  @SerializedName("ValueAsCurrency")
  private CurrencyAmount valueAsCurrency = null;

  public AdditionalSellerInput dataType(String dataType) {
    this.dataType = dataType;
    return this;
  }

   /**
   * The data type of the additional information.
   * @return dataType
  **/

  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public AdditionalSellerInput valueAsString(String valueAsString) {
    this.valueAsString = valueAsString;
    return this;
  }

   /**
   * The value when the data type is string.
   * @return valueAsString
  **/

  public String getValueAsString() {
    return valueAsString;
  }

  public void setValueAsString(String valueAsString) {
    this.valueAsString = valueAsString;
  }

  public AdditionalSellerInput valueAsBoolean(Boolean valueAsBoolean) {
    this.valueAsBoolean = valueAsBoolean;
    return this;
  }

   /**
   * The value when the data type is boolean.
   * @return valueAsBoolean
  **/

  public Boolean isValueAsBoolean() {
    return valueAsBoolean;
  }

  public void setValueAsBoolean(Boolean valueAsBoolean) {
    this.valueAsBoolean = valueAsBoolean;
  }

  public AdditionalSellerInput valueAsInteger(Integer valueAsInteger) {
    this.valueAsInteger = valueAsInteger;
    return this;
  }

   /**
   * The value when the data type is integer.
   * @return valueAsInteger
  **/

  public Integer getValueAsInteger() {
    return valueAsInteger;
  }

  public void setValueAsInteger(Integer valueAsInteger) {
    this.valueAsInteger = valueAsInteger;
  }

  public AdditionalSellerInput valueAsTimestamp(String valueAsTimestamp) {
    this.valueAsTimestamp = valueAsTimestamp;
    return this;
  }

   /**
   * The value when the data type is a date-time formatted string.
   * @return valueAsTimestamp
  **/

  public String getValueAsTimestamp() {
    return valueAsTimestamp;
  }

  public void setValueAsTimestamp(String valueAsTimestamp) {
    this.valueAsTimestamp = valueAsTimestamp;
  }

  public AdditionalSellerInput valueAsAddress(Address valueAsAddress) {
    this.valueAsAddress = valueAsAddress;
    return this;
  }

   /**
   * Get valueAsAddress
   * @return valueAsAddress
  **/

  public Address getValueAsAddress() {
    return valueAsAddress;
  }

  public void setValueAsAddress(Address valueAsAddress) {
    this.valueAsAddress = valueAsAddress;
  }

  public AdditionalSellerInput valueAsWeight(Weight valueAsWeight) {
    this.valueAsWeight = valueAsWeight;
    return this;
  }

   /**
   * Get valueAsWeight
   * @return valueAsWeight
  **/

  public Weight getValueAsWeight() {
    return valueAsWeight;
  }

  public void setValueAsWeight(Weight valueAsWeight) {
    this.valueAsWeight = valueAsWeight;
  }

  public AdditionalSellerInput valueAsDimension(Length valueAsDimension) {
    this.valueAsDimension = valueAsDimension;
    return this;
  }

   /**
   * Get valueAsDimension
   * @return valueAsDimension
  **/

  public Length getValueAsDimension() {
    return valueAsDimension;
  }

  public void setValueAsDimension(Length valueAsDimension) {
    this.valueAsDimension = valueAsDimension;
  }

  public AdditionalSellerInput valueAsCurrency(CurrencyAmount valueAsCurrency) {
    this.valueAsCurrency = valueAsCurrency;
    return this;
  }

   /**
   * Get valueAsCurrency
   * @return valueAsCurrency
  **/

  public CurrencyAmount getValueAsCurrency() {
    return valueAsCurrency;
  }

  public void setValueAsCurrency(CurrencyAmount valueAsCurrency) {
    this.valueAsCurrency = valueAsCurrency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdditionalSellerInput additionalSellerInput = (AdditionalSellerInput) o;
    return Objects.equals(this.dataType, additionalSellerInput.dataType) &&
        Objects.equals(this.valueAsString, additionalSellerInput.valueAsString) &&
        Objects.equals(this.valueAsBoolean, additionalSellerInput.valueAsBoolean) &&
        Objects.equals(this.valueAsInteger, additionalSellerInput.valueAsInteger) &&
        Objects.equals(this.valueAsTimestamp, additionalSellerInput.valueAsTimestamp) &&
        Objects.equals(this.valueAsAddress, additionalSellerInput.valueAsAddress) &&
        Objects.equals(this.valueAsWeight, additionalSellerInput.valueAsWeight) &&
        Objects.equals(this.valueAsDimension, additionalSellerInput.valueAsDimension) &&
        Objects.equals(this.valueAsCurrency, additionalSellerInput.valueAsCurrency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataType, valueAsString, valueAsBoolean, valueAsInteger, valueAsTimestamp, valueAsAddress, valueAsWeight, valueAsDimension, valueAsCurrency);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdditionalSellerInput {\n");
    
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    valueAsString: ").append(toIndentedString(valueAsString)).append("\n");
    sb.append("    valueAsBoolean: ").append(toIndentedString(valueAsBoolean)).append("\n");
    sb.append("    valueAsInteger: ").append(toIndentedString(valueAsInteger)).append("\n");
    sb.append("    valueAsTimestamp: ").append(toIndentedString(valueAsTimestamp)).append("\n");
    sb.append("    valueAsAddress: ").append(toIndentedString(valueAsAddress)).append("\n");
    sb.append("    valueAsWeight: ").append(toIndentedString(valueAsWeight)).append("\n");
    sb.append("    valueAsDimension: ").append(toIndentedString(valueAsDimension)).append("\n");
    sb.append("    valueAsCurrency: ").append(toIndentedString(valueAsCurrency)).append("\n");
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

