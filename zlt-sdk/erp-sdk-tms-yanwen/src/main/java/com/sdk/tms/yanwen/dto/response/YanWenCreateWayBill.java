package com.sdk.tms.yanwen.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuruipeng
 * @date 2023年10月30日 10:47
 */
@Data
@NoArgsConstructor
public class YanWenCreateWayBill {

    //运单号
    private String waybillNumber;

    //订单号
    private String orderNumber;

    //转单号
    private String referenceNumber;

    //燕文参考单号
    private String yanwenNumber;
}
