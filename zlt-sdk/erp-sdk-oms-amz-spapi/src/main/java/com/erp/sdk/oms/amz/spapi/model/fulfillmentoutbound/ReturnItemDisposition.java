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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The condition of the return item when received by an Amazon fulfillment center.
 */
@JsonAdapter(ReturnItemDisposition.Adapter.class)
public enum ReturnItemDisposition {
  
  SELLABLE("Sellable"),
  
  DEFECTIVE("Defective"),
  
  CUSTOMERDAMAGED("CustomerDamaged"),
  
  CARRIERDAMAGED("CarrierDamaged"),
  
  FULFILLERDAMAGED("FulfillerDamaged");

  private String value;

  ReturnItemDisposition(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ReturnItemDisposition fromValue(String text) {
    for (ReturnItemDisposition b : ReturnItemDisposition.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<ReturnItemDisposition> {
    @Override
    public void write(final JsonWriter jsonWriter, final ReturnItemDisposition enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ReturnItemDisposition read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ReturnItemDisposition.fromValue(String.valueOf(value));
    }
  }
}

