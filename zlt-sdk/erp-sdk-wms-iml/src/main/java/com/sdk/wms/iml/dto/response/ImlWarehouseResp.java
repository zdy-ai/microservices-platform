package com.sdk.wms.iml.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.business.dto.CleanBaseDTO;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ImlWarehouseResp extends CleanBaseDTO implements Serializable {

    //仓库代码
    @JSONField(name = "warehouse_code")
    private String warehouseCode;

    //仓库名称
    @JSONField(name = "warehouse_name")
    private String warehouseName;

    //仓库所在国家二字码
    @JSONField(name = "country_code")
    private String countryCode;

    //仓库类型
    @JSONField(name = "warehouse_type")
    private String warehouseType;

    //仓库所在国家ID
    @JSONField(name = "country_id")
    private String countryId;

    //邮编
    @JSONField(name = "postcode")
    private String postcode;

    //省
    @JSONField(name = "state")
    private String state;

    //城市
    @JSONField(name = "city")
    private String city;

    //地址
    @JSONField(name = "street_address1")
    private String streetAddress1;

    //地址2
    @JSONField(name = "street_address2")
    private String streetAddress2;

    //编号
    @JSONField(name = "street_number")
    private String streetNumber;
}
