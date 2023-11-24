package com.sdk.tms.yuntu.dto.response;

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
public class YunTuTrackingNumber {

    //客户的订单号
    private String customerOrderNumber;

    //跟踪号
    private String trackingNumber;

    //运单号
    private String wayBillNumber;

    //详情描述
    private String remark;

    //1-跟踪号生成成功;2-跟踪号生成中;3-跟踪号无需生成;4-跟踪号生成失败
    private Integer status;

    //子单跟踪号信息
    private List<ChildTrackingInfo> childTrackings;

    @Data
    @ToString
    @NoArgsConstructor
    public static class ChildTrackingInfo {

        //子单号
        private String childOrderNumber;

        //子单跟踪号
        private String childTrackingNumber;
    }
}
