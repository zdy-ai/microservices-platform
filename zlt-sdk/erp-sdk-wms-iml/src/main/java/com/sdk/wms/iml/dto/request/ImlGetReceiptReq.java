package com.sdk.wms.iml.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ImlGetReceiptReq extends ImlBaseRequest {

    //入库单号
    @JSONField(name = "receiving_code")
    private String receivingCode;

    //多个入库单号,数组格式
    @JSONField(name = "receiving_code_arr")
    private List<String> receivingCodeArr;

    //起始时间(创建时间,有入库单号的时候此参数失效)格式支持yyyy-mm-dd 或 yyyy-mm-dd hh:mm:ss
    @JSONField(name = "create_date_from")
    private String createDateFrom;

    //结束时间(创建时间,有入库单号的时候此参数失效) 格式支持yyyy-mm-dd 或 yyyy-mm-dd hh:mm:ss
    @JSONField(name = "create_date_to")
    private String createDateTo;

    //起始时间(修改时间,有入库单号的时候此参数失效) 格式支持yyyy-mm-dd 或 yyyy-mm-dd hh:mm:ss
    @JSONField(name = "modify_date_from")
    private String modifyDateFrom;

    //结束时间(修改时间,有入库单号的时候此参数失效) 格式支持yyyy-mm-dd 或 yyyy-mm-dd hh:mm:ss
    @JSONField(name = "modify_date_to")
    private String modifyDateTo;

    //保税用户填1,其它可不填
    @JSONField(name = "business_type")
    private String businessType;
}
