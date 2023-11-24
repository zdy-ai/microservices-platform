package com.sdk.wms.goodcang.dto.response;

import com.common.business.dto.CleanBaseDTO;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class GoodCangTransferWarehouseResp extends CleanBaseDTO implements Serializable {

    //物流渠道编码
    private String logisticsChannelCode;

    //物流渠道名称
    private String logisticsChannelName;

    //中转仓编码
    private String transferWarehouseCode;

    //中转仓名称
    private String transferWarehouseName;

    //目的仓编码
    private String destinationWarehouseCode;

    //目的仓名称
    private String destinationWarehouseName;
}
