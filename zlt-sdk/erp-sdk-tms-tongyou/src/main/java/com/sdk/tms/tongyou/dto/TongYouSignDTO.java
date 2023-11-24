package com.sdk.tms.tongyou.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author liuruipeng
 */
@Data
@Builder
@ToString
public class TongYouSignDTO {

    private String logisticsId;
    private String orderNo;
    private String contactPerson ;
    private String countryCode;
    private String province;
    private String city;
    private String address;
    private String address2;
    private String address3;
    private String telNo;
    private String mobileNo;
    private String zip;

    public String sign(){
        return logisticsId+orderNo+contactPerson+countryCode+province+city+address+address2+address3+telNo+mobileNo+zip;
    }
}
