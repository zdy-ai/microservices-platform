package com.sdk.tms.disifang.model.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName OrderResponse
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class OrderResponse implements Serializable {
    /**
     * 直发委托单号
     */
    @JSONField(name = "ds_consignment_no")
    private String ds_consignment_no;
    /**
     * 4PX跟踪号
     */
    @JSONField(name = "4px_tracking_no")
    private String tracking_no;
    /**
     * @ deprecated   标签条码号。*注：参数为deprecated状态
     */
    @JSONField(name = "label_barcode")
    private String label_barcode;
    /**
     * 客户单号/客户参考号
     */
    @JSONField(name = "ref_no")
    private String ref_no;
    /**
     * 物流渠道号码。如果结果返回为空字符，表示暂时没有物流渠道号码，请稍后主动调用查询直发委托单接口查询
     */
    @JSONField(name = "logistics_channel_no")
    private String logistics_channel_no;
    /**
     * ODA标识(偏远地址：Y 非偏远地址：N)
     */
    @JSONField(name = "oda_result_sign")
    private String oda_result_sign;
}
