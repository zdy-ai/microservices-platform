package com.sdk.tms.ubi.model.catalog.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Facility
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class Facility implements Serializable {
    private static final long serialVersionUID = 2801814838883246461L;
    private String code;
    private FacilityAddress facilityAddress;
}
