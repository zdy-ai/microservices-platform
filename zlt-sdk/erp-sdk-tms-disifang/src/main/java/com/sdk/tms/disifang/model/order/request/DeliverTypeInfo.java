package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName DeliverTypeInfo
 * @description: 货物到仓方式信息
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class DeliverTypeInfo implements Serializable {
    /**
     * 到仓方式（1:上门揽收；2:快递到仓；3:自送到仓；5:自送门店）
     * 是
     */
    @JSONField(name = "deliver_type")
    private String deliver_type;
    /**
     * PL1US1	收货仓库/门店代码（仓库代码）
     */
    @JSONField(name = "warehouse_code")
    private String warehouse_code;
    /**
     * 上门揽收信息
     */
    @JSONField(name = "pick_up_info")
    private PickUp pick_up_info;
    /**
     * 快递到仓信息
     */
    @JSONField(name = "express_to_4px_info")
    private ExpressTo4px express_to_4px_info;
    /**
     * 自己送仓信息
     */
    @JSONField(name = "self_send_to_4px_info")
    private SelfSendTo4px self_send_to_4px_info;
    /**
     * 投递信息
     */
    @JSONField(name = "deliver_to_recipient_info")
    private DeliverToRecipientInfo deliver_to_recipient_info;
    /**
     * 扩展字段
     */
    @JSONField(name = "ext")
    private String ext;
    /**
     * 分拣分区
     */
    @JSONField(name = "sort_code")
    private String sort_code;

    @JSONField(name = "order_attachment_info")
    private List<OrderAttachmentInfo> order_attachment_info;
}
