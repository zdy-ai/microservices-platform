package com.sdk.tms.express.model.order.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName WaybillNoInfoList
 * @description: TODO
 * @date 2023年11月10日
 * @version: 1.0
 */
@Data
public class WaybillNoInfoList implements Serializable {
    /**
     * 运单号类型 1：母单 2 :子单 3 : 签回单
     */
    private Integer waybillType;
    /**
     * 运单号
     */
    private String waybillNo;
}
