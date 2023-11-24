/*
 * Selling Partner API for Listings Restrictions
 * The Selling Partner API for Listings Restrictions provides programmatic access to restrictions on Amazon catalog listings.  For more information, see the [Listings Restrictions API Use Case Guide](doc:listings-restrictions-api-v2021-08-01-use-case-guide).
 *
 * OpenAPI spec version: 2021-08-01
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.model.listingsrestrictions;

import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A list of restrictions for the specified Amazon catalog item.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-07-24T13:50:01.907+08:00")
public class RestrictionList {
  @SerializedName("restrictions")
  private List<Restriction> restrictions = new ArrayList<Restriction>();

  public RestrictionList restrictions(List<Restriction> restrictions) {
    this.restrictions = restrictions;
    return this;
  }

  public RestrictionList addRestrictionsItem(Restriction restrictionsItem) {
    this.restrictions.add(restrictionsItem);
    return this;
  }

   /**
   * Get restrictions
   * @return restrictions
  **/

  public List<Restriction> getRestrictions() {
    return restrictions;
  }

  public void setRestrictions(List<Restriction> restrictions) {
    this.restrictions = restrictions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestrictionList restrictionList = (RestrictionList) o;
    return Objects.equals(this.restrictions, restrictionList.restrictions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restrictions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestrictionList {\n");
    
    sb.append("    restrictions: ").append(toIndentedString(restrictions)).append("\n");
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

