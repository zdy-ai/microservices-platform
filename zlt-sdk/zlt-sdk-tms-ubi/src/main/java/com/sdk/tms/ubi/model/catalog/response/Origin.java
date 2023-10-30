package com.sdk.tms.ubi.model.catalog.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName Origin
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class Origin implements Serializable {
    private static final long serialVersionUID = 2801814838883246461L;

    private String country;
    private List<Facility> facilities;
}
