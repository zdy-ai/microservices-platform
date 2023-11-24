package com.sdk.wms.iml.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.business.dto.CleanBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ImlReceiptResp extends CleanBaseDTO implements Serializable {

    //入库单号
    @JSONField(name = "receiving_code")
    private String receivingCode;

    //客户参考号
    @JSONField(name = "reference_no")
    private String referenceNo;

    //交货方式，0自送，1揽收
    @JSONField(name = "income_type")
    private Integer incomeType;

    //目的仓库
    @JSONField(name = "warehouse_code")
    private String warehouseCode;

    //交货仓库
    @JSONField(name = "transit_warehouse_code")
    private String transitWarehouseCode;

    //运输方式
    @JSONField(name = "shipping_method")
    private String shippingMethod;

    //跟踪号
    @JSONField(name = "tracking_number")
    private String trackingNumber;

    //入库单状态 C:新建 W:头程在途 P:头程收货中 Z:转运中 G:目的仓库收货中 F:目的仓收货完成 E:完成上架 X:废弃
    @JSONField(name = "receiving_status")
    private String receivingStatus;

    //入库单说明
    @JSONField(name = "receiving_desc")
    private String receivingDesc;

    //预计到达日期
    @JSONField(name = "eta_date")
    private Date etaDate;

    //创建日期
    @JSONField(name = "receiving_add_time")
    private LocalDateTime receivingAddTime;

    //修改日期
    @JSONField(name = "receiving_modify_time")
    private LocalDateTime receivingModifyTime;

    //揽收支持的省ID， 参考getRegionForReceiving
    @JSONField(name = "region_id_level0")
    private Integer regionIdLevel0;

    //揽收支持的市ID， 参考getRegionForReceiving
    @JSONField(name = "region_id_level1")
    private Integer regionIdLevel1;

    //揽收支持的区ID， 参考getRegionForReceiving
    @JSONField(name = "region_id_level2")
    private Integer regionIdLevel2;

    //揽收地址
    @JSONField(name = "street")
    private String street;

    //联系人，交货方式为揽收时，必填
    @JSONField(name = "contacter")
    private String contacter;

    //联系电话，交货方式为揽收时，必填
    @JSONField(name = "contact_phone")
    private String contactPhone;

    //总箱数
    @JSONField(name = "box_total")
    private Integer boxTotal;

    //产品总数
    @JSONField(name = "sku_total")
    private Integer skuTotal;

    //SKU种类
    @JSONField(name = "sku_species")
    private Integer skuSpecies;


    @JSONField(name = "items")
    private List<Item> items;

    @Data
    @ToString
    public static class Item {

        //SKU
        @JSONField(name = "product_sku")
        private String productSku;

        //产品编码
        @JSONField(name = "product_barcode")
        private String productBarcode;

        //数量
        @JSONField(name = "quantity")
        private Integer quantity;

        //收货数
        @JSONField(name = "received_quantity")
        private Integer receivedQuantity;

        //上架数量
        @JSONField(name = "putaway_quantity")
        private Integer putawayQuantity;

        //上架数
        @JSONField(name = "putaway_qty")
        private Integer putawayQty;

        //更新时间
        @JSONField(name = "rd_update_time")
        private LocalDateTime rdUpdateTime;

        //箱号
        @JSONField(name = "box_no")
        private Integer boxNo;

        //库位类型统计数量,0:良品,1:不良品,2:暂存
        @JSONField(name = "loCountType")
        private String loCountType;

    }
}
