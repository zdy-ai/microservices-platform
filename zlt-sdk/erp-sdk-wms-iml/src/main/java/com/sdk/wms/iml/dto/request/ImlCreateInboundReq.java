package com.sdk.wms.iml.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.xmlbeans.impl.jam.mutable.MElement;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImlCreateInboundReq {

    //入库单参考号
    @JSONField(name = "reference_no")
    @NotNull(message = "入库单参考号不能为空")
    private String referenceNo;

    //交货方式，0自送，1揽收
    @JSONField(name = "income_type")
    private Integer incomeType;

    //入库单类型：D:自发头程,T中转代发
    @JSONField(name = "receiving_type")
    private String receivingType;

    //目的仓
    @JSONField(name = "warehouse_code")
    @NotNull(message = "目的仓不能为空")
    private String warehouseCode;

    //交货仓，中转代发时，必填
    @JSONField(name = "transit_warehouse_code")
    private String transitWarehouseCode;

    //物流产品，中转代发时，必填
    @JSONField(name = "sm_code")
    private String smCode;

    //运输方式
    @JSONField(name = "shipping_method")
    private String shippingMethod;

    //跟踪号，中转代发时，必填
    @JSONField(name = "tracking_number")
    private String trackingNumber;

    //入库单描述
    @JSONField(name = "receiving_desc")
    private String receivingDesc;

    //预计到达日期
    @JSONField(name = "eta_date")
    private Date etaDate;

    //联系人，交货方式为揽收时，必填
    @JSONField(name = "contacter")
    private String contacter;

    //联系电话，交货方式为揽收时，必填
    @JSONField(name = "contact_phone")
    private String contactPhone;

    //揽收支持的省ID，交货方式为揽收时，必填，参考getRegionForReceiving
    @JSONField(name = "region_id_level0")
    private Integer regionIdLevel0;

    //揽收支持的市ID，交货方式为揽收时，必填，参考getRegionForReceiving
    @JSONField(name = "region_id_level1")
    private Integer regionIdLevel1;

    //揽收支持的区ID，交货方式为揽收时，必填，参考getRegionForReceiving
    @JSONField(name = "region_id_level2")
    private Integer regionIdLevel2;

    //揽收地址，交货方式为揽收时，必填
    @JSONField(name = "street")
    private String street;

    //是否审核,0新建不审核(草稿状态)，1新建并审核， 默认为0， 审核通过之后，不可编辑
    @JSONField(name = "verify")
    private Integer verify;

    //关税类型：P：实报实销；默认为空
    @JSONField(name = "tax_type")
    private String taxType;

    //报关类型：Y：单独退税报关；N：无退税报关；;默认为空
    @JSONField(name = "customer_type")
    private String customerType;

    //保险服务：Y 是；N：否；默认为否 （保险服务只有在 中转代发才会生效-参考PC端）
    @JSONField(name = "is_insurance")
    private String isInsurance;

    //入库单明细
    @JSONField(name = "items")
    @NotNull(message = "入库单明细不能为空")
    private List<Item> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Item {

        //SKU
        @JSONField(name = "product_sku")
        @NotNull(message = "SKU不能为空")
        private String productSku;

        //数量
        @JSONField(name = "quantity")
        @NotNull(message = "数量不能为空")
        private Integer quantity;

        //箱号
        @JSONField(name = "box_no")
        @NotNull(message = "箱号不能为空")
        private Integer boxNo;

        //单SKU申报金额
        @JSONField(name = "insured_amount")
        private BigDecimal insuredAmount;

    }
    //附件文件
    @JSONField(name = "api_attachment_label")
    private AttachmentLabel apiAttachmentLabel;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AttachmentLabel {

        //文件类型(rar或者zip)
        @JSONField(name = "file_type")
        private String fileType;

        //base64编码
        @JSONField(name = "file_data")
        private String fileData;

    }

    //头程明细表
    @JSONField(name = "api_attachment_file")
    private AttachmentFile apiAttachmentFile;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AttachmentFile {

        //文件类型(xls或者xlsx)
        @JSONField(name = "file_type")
        private String fileType;

        //base64编码
        @JSONField(name = "file_data")
        private String fileData;

    }
}
