/*
 * Selling Partner API for Solicitations
 * With the Solicitations API you can build applications that send non-critical solicitations to buyers. You can get a list of solicitation types that are available for an order that you specify, then call an operation that sends a solicitation to the buyer for that order. Buyers cannot respond to solicitations sent by this API, and these solicitations do not appear in the Messaging section of Seller Central or in the recipient's Message Center. The Solicitations API returns responses that are formed according to the <a href=https://tools.ietf.org/html/draft-kelly-json-hal-08>JSON Hypertext Application Language</a> (HAL) standard.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.solicitations;

import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * GetSolicitationActionResponseEmbedded
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T21:00:32.319+08:00")
public class GetSolicitationActionResponseEmbedded {
  @SerializedName("schema")
  private GetSchemaResponse schema = null;

  public GetSolicitationActionResponseEmbedded schema(GetSchemaResponse schema) {
    this.schema = schema;
    return this;
  }

   /**
   * Get schema
   * @return schema
  **/

  public GetSchemaResponse getSchema() {
    return schema;
  }

  public void setSchema(GetSchemaResponse schema) {
    this.schema = schema;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSolicitationActionResponseEmbedded getSolicitationActionResponseEmbedded = (GetSolicitationActionResponseEmbedded) o;
    return Objects.equals(this.schema, getSolicitationActionResponseEmbedded.schema);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schema);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSolicitationActionResponseEmbedded {\n");
    
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
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

