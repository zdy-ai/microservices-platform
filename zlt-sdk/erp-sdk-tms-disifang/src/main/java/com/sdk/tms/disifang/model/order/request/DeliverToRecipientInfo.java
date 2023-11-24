package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName DeliverToRecipientInfo
 * @description: 投递信息
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class DeliverToRecipientInfo implements Serializable {
    /**
     * 投递类型：HOME_DELIVERY-投递到门；SELF_PICKUP_STATION-投递门店（自提点）；SELF_SERVICE_STATION-投递自提柜(自助点）；默认：HOME_DELIVERY；注：目前暂时不支持投递门店、投递自提柜
     */
    @JSONField(name = "deliver_type")
    private String deliver_type;
    /**
     * 自提门店/自提点的信息(选择自提时必传，点击获取详情)
     */
    @JSONField(name = "station_code")
    private String station_code;
}
