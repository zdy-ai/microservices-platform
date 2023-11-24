/*
 * Selling Partner API for Tokens 
 * The Selling Partner API for Tokens provides a secure way to access a customers's PII (Personally Identifiable Information). You can call the Tokens API to get a Restricted Data Token (RDT) for one or more restricted resources that you specify. The RDT authorizes you to make subsequent requests to access these restricted resources.
 *
 * OpenAPI spec version: 2021-03-01
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.tokens;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;


import java.io.IOException;
import java.util.Objects;

/**
 * Model of a restricted resource.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-06T16:48:46.313+08:00")
public class RestrictedResource {
  /**
   * The HTTP method used with the restricted resource.
   */
  @JsonAdapter(MethodEnum.Adapter.class)
  public enum MethodEnum {
    GET("GET"),
    
    PUT("PUT"),
    
    POST("POST"),
    
    DELETE("DELETE");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MethodEnum fromValue(String text) {
      for (MethodEnum b : MethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<MethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MethodEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return MethodEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("method")
  private MethodEnum method = null;

  @SerializedName("path")
  private String path = null;

  public RestrictedResource method(MethodEnum method) {
    this.method = method;
    return this;
  }

   /**
   * The HTTP method used with the restricted resource.
   * @return method
  **/

  public MethodEnum getMethod() {
    return method;
  }

  public void setMethod(MethodEnum method) {
    this.method = method;
  }

  public RestrictedResource path(String path) {
    this.path = path;
    return this;
  }

   /**
   * The path from a restricted operation. This could be:  - A specific path containing a seller&#39;s order ID, for example &#x60;&#x60;&#x60;/orders/v0/orders/902-3159896-1390916/address&#x60;&#x60;&#x60;.  - A generic path that does not contain a seller&#39;s order ID, for example&#x60;&#x60;&#x60;/orders/v0/orders/{orderId}/address&#x60;&#x60;&#x60;).
   * @return path
  **/

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestrictedResource restrictedResource = (RestrictedResource) o;
    return Objects.equals(this.method, restrictedResource.method) &&
        Objects.equals(this.path, restrictedResource.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, path);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestrictedResource {\n");
    
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

