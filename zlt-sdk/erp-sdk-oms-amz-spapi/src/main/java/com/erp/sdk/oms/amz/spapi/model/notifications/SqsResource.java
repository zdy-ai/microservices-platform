/*
 * Selling Partner API for Notifications
 * The Selling Partner API for Notifications lets you subscribe to notifications that are relevant to a selling partner's business. Using this API you can create a destination to receive notifications, subscribe to notifications, delete notification subscriptions, and more.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.notifications;

import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * The information required to create an Amazon Simple Queue Service (Amazon SQS) queue destination.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-15T20:51:27.111+08:00")
public class SqsResource {
  @SerializedName("arn")
  private String arn = null;

  public SqsResource arn(String arn) {
    this.arn = arn;
    return this;
  }

   /**
   * The Amazon Resource Name (ARN) associated with the SQS queue.
   * @return arn
  **/

  public String getArn() {
    return arn;
  }

  public void setArn(String arn) {
    this.arn = arn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SqsResource sqsResource = (SqsResource) o;
    return Objects.equals(this.arn, sqsResource.arn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(arn);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SqsResource {\n");
    
    sb.append("    arn: ").append(toIndentedString(arn)).append("\n");
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

