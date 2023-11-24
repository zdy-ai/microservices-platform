package com.sdk.tms.weishi.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liuruipeng
 */
@Data
@NoArgsConstructor
@ToString
public class WeiShiGetTrackNumber{

    //客户参考单号
    private String orderNumber;

    //物流运单号
    private String wayBillNumber;

    //尾程跟踪单号
    private String trackingNumber;
}
