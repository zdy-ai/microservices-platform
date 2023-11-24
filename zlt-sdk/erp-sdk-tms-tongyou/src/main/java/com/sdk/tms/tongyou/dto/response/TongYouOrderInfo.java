package com.sdk.tms.tongyou.dto.response;

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
@ToString
public class TongYouOrderInfo extends TongYouResponse<Object> {

    //物流 id
    private String logisticsId;

    //收件人国家简码
    private String countryCode;

    //订单号
    private String orderNo;

    //追踪条码
    private String trackNo;

    //二级条码
    private String tTrackingNo;

    //转运单号
    private String transportNo;
}
