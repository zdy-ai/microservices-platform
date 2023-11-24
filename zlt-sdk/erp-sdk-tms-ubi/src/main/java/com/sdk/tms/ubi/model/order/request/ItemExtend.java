package com.sdk.tms.ubi.model.order.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ItemExtend
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class ItemExtend implements Serializable {
    private static final long serialVersionUID = 2801814838883246461L;
    //税号
    private String vendorid;
    //GST免税码，如果vendorid正确，该字段值自动设置为“PAID”
    private String gstexemptionCode;
    //发货人税号
    private String senderTaxId;
    //订单配送港口，针对加拿大服务
    private String injectPort;
    //订单起始港口
    private String originPort;
}
