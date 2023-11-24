package com.sdk.tms.ubi.model.catalog.response;

import cn.hutool.json.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName FacilityAddress
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class FacilityAddress implements Serializable {
    private static final long serialVersionUID = 2801814838883246461L;
    private String contact;
    private String company;
    private String addressLine1;
    private String addressLine2;
    private String district;
    private String city;
    private String province;
    private String postCode;
    private String countryCode;
    private String email;
    private String contactNumber;
    private List<JSONObject> pickups;
}
