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
public class YunTuPrintLabel {

    //打印标签地址
    private String url;

    private String base64;

    //跟踪号
    private List<OrderInfo> orderInfos;

    @Data
    @ToString
    @NoArgsConstructor
    public static class OrderInfo {

        //客户订单号
        private String customerOrderNumber;

        //错误信息
        private String error;

        //错误代码 100-正确，200-不存在打印模板
        private Integer code;
    }
}
