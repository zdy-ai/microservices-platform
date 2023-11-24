package com.erp.sdk.oms.amz.spapi.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 亚马逊SP-API FBA货件状态
 * <a href="https://developer-docs.amazon.com/sp-api/docs/fulfillment-inbound-api-v0-reference#querytype-subgroup-2">来源链接</a>
 *
 * @author Jim
 * @date 2023/11/1
 */
@Getter
@AllArgsConstructor
public enum AmazonFbaShipmentStatusEnum {

    WORKING("WORKING",	"工作中" ,"货件由卖家创建，但尚未发货"),
    READY_TO_SHIP("READY_TO_SHIP",	"准备发货" ,"卖家已打印箱子标签（适用于小包裹货件）或托拍标签（适用于汽运零担货件）"),
    SHIPPED("SHIPPED",	"已发货" ,"货物已由承运人取件"),
    RECEIVING("RECEIVING",	"开始接收" ,"货件已到达运营中心，但并非所有商品都标记为已接收"),
    CANCELLED("CANCELLED",	"已取消" ,"货件发往运营中心后，卖家取消了货件"),
    DELETED("DELETED",	"已删除" ,"在货件发往运营中心之前，卖家已取消货件"),
    CLOSED("CLOSED",	"已关闭" ,"货件已到达运营中心，所有商品均已标记为已收到"),
    ERROR("ERROR",	"错误" ,"货件有错误，亚马逊未处理"),
    IN_TRANSIT("IN_TRANSIT",	"中转" ,"承运人已通知运营中心其知悉货件"),
    DELIVERED("DELIVERED",	"已送达" ,"货件已由承运人送达运营中心"),
    CHECKED_IN("CHECKED_IN",	"确认收到货" ,"货件已在运营中心的收货码头办理登机手续"),

    ;


    /**
     * 商城编号
     */
    @EnumValue
    @JsonValue
    private final String code;

    /**
     * 名称
     */
    private final String name;

    /**
     * 描述
     */
    private final String desc;

    public static List<String> getAllStatus(){
        return Stream.of(AmazonFbaShipmentStatusEnum.values())
                .map(AmazonFbaShipmentStatusEnum::getCode)
                .collect(Collectors.toList());
    }

}
