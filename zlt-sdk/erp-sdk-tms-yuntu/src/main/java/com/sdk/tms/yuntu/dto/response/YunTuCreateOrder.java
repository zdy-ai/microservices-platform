package com.sdk.tms.yuntu.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author liuruipeng
 */
@Data
@NoArgsConstructor
@ToString
public class YunTuCreateOrder {

    //客户的订单号
    private String customerOrderNumber;

    //运单请求状态，1-成功，0-失败
    private Integer success;

    //1-已产生跟踪号，2-等待后续更新跟踪号,3-不需要跟踪号
    private String trackType;

    //运单请求失败反馈失败原因
    private String remark;

    //0-不需要分配地址，1-需要分配地址
    private Integer requireSenderAddress;

    //代理单号
    private String agentNumber;

    //YT 运单号
    private String wayBillNumber;

    //跟踪号
    private String trackingNumber;

    //箱子信息
    private List<ShipperBoxs> ShipperBoxs;

    @Data
    @Builder
    @ToString
    public static class ShipperBoxs {

        //箱子号码
        private String boxNumber;

        //物流运单子单号
        private String shipperHawbcode;
    }
}
