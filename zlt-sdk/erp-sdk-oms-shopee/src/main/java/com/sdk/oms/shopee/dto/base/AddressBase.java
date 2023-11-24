package com.sdk.oms.shopee.dto.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddressBase implements Serializable {
	
	private static final long serialVersionUID = 1L;

    /**
     * Name for the address.
     */
    protected String name;

    /**
     * The town of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    protected String town;

    /**
     * The district of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    protected String district;

    /**
     * The city of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    protected String city;

    /**
     * The state/province of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    protected String state;

    /**
     * The two-digit code representing the country of the Recipient.
     */
    protected String region;

    /**
     * Zip Code
     */
    @JSONField(name = "zipcode")
    protected String zipCode;
}
