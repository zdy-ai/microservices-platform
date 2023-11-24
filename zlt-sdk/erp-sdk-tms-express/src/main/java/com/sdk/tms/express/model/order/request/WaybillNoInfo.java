package com.sdk.tms.express.model.order.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName WaybillNoInfo
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class WaybillNoInfo implements Serializable {
    /**
     * 运单号类型1：母单2 :子单3 : 签回单
     */
    private Integer waybillType;
    /**
     * 运单号
     */
    private String waybillNo;
}
