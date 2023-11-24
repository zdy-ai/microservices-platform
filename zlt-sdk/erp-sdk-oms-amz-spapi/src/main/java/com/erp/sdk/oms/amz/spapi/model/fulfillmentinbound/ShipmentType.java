/*
 * Selling Partner API for Fulfillment Inbound
 * The Selling Partner API for Fulfillment Inbound lets you create applications that create and update inbound shipments of inventory to Amazon's fulfillment network.
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.fulfillmentinbound;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Specifies the carrier shipment type in a putTransportDetails request.
 */
@JsonAdapter(ShipmentType.Adapter.class)
public enum ShipmentType {
  
  SP("SP"),
  
  LTL("LTL");

  private String value;

  ShipmentType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ShipmentType fromValue(String text) {
    for (ShipmentType b : ShipmentType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<ShipmentType> {
    @Override
    public void write(final JsonWriter jsonWriter, final ShipmentType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ShipmentType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ShipmentType.fromValue(String.valueOf(value));
    }
  }
}

