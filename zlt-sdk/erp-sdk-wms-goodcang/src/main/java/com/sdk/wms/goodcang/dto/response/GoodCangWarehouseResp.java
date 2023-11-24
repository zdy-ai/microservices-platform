package com.sdk.wms.goodcang.dto.response;

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
public class GoodCangWarehouseResp extends CleanBaseDTO implements Serializable {

    //仓库代码
    @JSONField(name = "warehouse_code")
    private String warehouseCode;

    //仓库名称
    @JSONField(name = "warehouse_name")
    private String warehouseName;

    //仓库所在国家/地区代码
    @JSONField(name = "country_code")
    private String countryCode;

    //物理仓对象数组
    @JSONField(name = "wp_list")
    private List<PhysicalWarehouse> wpList;

    @Data
    @ToString
    public static class PhysicalWarehouse {

        //物理仓名称
        private String name;

        //物理仓编码
        private String code;

        //地址信息
        private Address address;

        @Data
        @ToString
        public static class Address {

            //州 省份
            private String state;

            //城市
            private String city;

            //邮编
            private String postcode;

            //联系人
            private String contacter;

            //电话
            private String phone;

            //地址1
            @JSONField(name = "street_address1")
            private String streetAddress1;

            //地址2
            @JSONField(name = "street_address2")
            private String streetAddress2;

            //门牌号
            @JSONField(name = "street_number")
            private String streetNumber;
        }
    }
}
