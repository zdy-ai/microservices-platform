package com.sdk.wms.goodcang.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class GoodCangReceiptBatchResp implements Serializable {


    //尾程仓收货批次
    @JSONField(name = "gc_receiving_data")
    private List<GcReceiving> gcReceivingDataList;

    @Data
    @ToString
    public static class GcReceiving {

        //收货时间
        @JSONField(name = "received_time")
        private LocalDateTime receivedTime;

        //入库单箱号
        @JSONField(name = "box_no")
        private String boxNo;

        //商品高度
        @JSONField(name = "product_height")
        private Float productHeight;

        //商品长度
        @JSONField(name = "product_length")
        private Float productLength;

        //商品SKU
        @JSONField(name = "product_sku")
        private String productSku;

        //商品重量
        @JSONField(name = "product_weight")
        private Float productWeight;

        //商品宽度
        @JSONField(name = "product_width")
        private Float productWidth;

        //预报数量
        @JSONField(name = "quantity")
        private Integer quantity;

        //收货数量
        @JSONField(name = "received_qty")
        private Integer receivedQty;

        //入库单号
        @JSONField(name = "receiving_code")
        private String receivingCode;
    }

    //中转仓收货批次(箱子)
    @JSONField(name = "transit_box_data")
    private List<TransitBox> transitBoxDataList;

    @Data
    @ToString
    public static class TransitBox {

        //箱子高度
        @JSONField(name = "box_height")
        private Float boxHeight;

        //箱子长度
        @JSONField(name = "box_length")
        private Float boxLength;

        //入库单箱号
        @JSONField(name = "box_no")
        private String boxNo;

        //箱子重量
        @JSONField(name = "box_weight")
        private Float boxWeight;

        //箱子宽度
        @JSONField(name = "box_width")
        private Float boxWidth;

        //入库单号
        @JSONField(name = "receiving_code")
        private String receivingCode;
    }

    //尾程仓收货批次
    @JSONField(name = "transit_data")
    private List<Transit> transitDataList;

    @Data
    @ToString
    public static class Transit {

        //入库单箱号
        @JSONField(name = "box_no")
        private String boxNo;

        //商品高度
        @JSONField(name = "product_height")
        private Float productHeight;

        //商品长度
        @JSONField(name = "product_length")
        private Float productLength;

        //商品SKU
        @JSONField(name = "product_sku")
        private String productSku;

        //商品重量
        @JSONField(name = "product_weight")
        private Float productWeight;

        //商品宽度
        @JSONField(name = "product_width")
        private Float productWidth;

        //预报数量
        @JSONField(name = "quantity")
        private Integer quantity;

        //收货数量
        @JSONField(name = "received_qty")
        private Integer receivedQty;

        //入库单号
        @JSONField(name = "receiving_code")
        private String receivingCode;

    }

    //入库单状态
    @JSONField(name = "receiving_status")
    private Integer receivingStatus;

    //入库单类型
    @JSONField(name = "transit_type")
    private Integer transitType;

}
