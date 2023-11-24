package com.sdk.tms.weishi.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liuruipeng
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class WeiShiCreateOrder extends WeiShiResponse<Object>{

    private String agentNumber;

    //纬狮跟踪单号
    private String orderCode;

    //客户参考号
    private String referenceNo;

    //最后一公里服务商单号
    private String shippingMethodNo;

    //标签下载地址
    private String labelUrl;

    //标签类型
    private String label_type;
}
