package com.sdk.tms.ubi.model.catalog.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName ServiceCataLog
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class ServiceCataLog implements Serializable {
    private static final long serialVersionUID = 2801814838883246461L;
    private String serviceCode;
    private String serviceName;
    private String nativeName;
    private String serviceProvider;
    private String serviceProviderCode;
    private String serviceDescription;
    private String customerSupportPhone;
    private String customerSupportEMail;
    private List<Origin> origins;
}
