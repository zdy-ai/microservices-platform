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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Carrier will pick up option.
 */
@JsonAdapter(CarrierWillPickUpOption.Adapter.class)
public enum CarrierWillPickUpOption {
  
  CARRIERWILLPICKUP("CarrierWillPickUp"),
  
  SHIPPERWILLDROPOFF("ShipperWillDropOff"),
  
  NOPREFERENCE("NoPreference");

  private String value;

  CarrierWillPickUpOption(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static CarrierWillPickUpOption fromValue(String text) {
    for (CarrierWillPickUpOption b : CarrierWillPickUpOption.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<CarrierWillPickUpOption> {
    @Override
    public void write(final JsonWriter jsonWriter, final CarrierWillPickUpOption enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public CarrierWillPickUpOption read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CarrierWillPickUpOption.fromValue(String.valueOf(value));
    }
  }
}

