package com.sdk.tms.tongyou.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author liuruipeng
 */
@Data
@Builder
@ToString
public class TongYouPrintLabelRequest {

    //业务单号。
    private String bNo;

    //订单编号，客户参考号（多个用英文逗号隔开）
    @NotNull(message = "订单编号不能为空")
    private String orderNo;

    //物流编码，拓扑链系统的渠道编号
    @NotNull(message = "物流编码不能为空")
    private String logisticsId;

    //追踪条码，有则必须填（多个用英文逗号隔开）
    private String trackNo;

    //来源
    private String source;

    //国家二字简码(若有多个则填写第一个即可)
    private String countryCode;

    //打印配货单(Y:打印;N:不打印)
    private String isPaoc;

    //打印报关单(Y:打印;N:不打印)
    private String isPcd;

    //打印面单尺寸，可不传，不传参
    //数按拓扑链客户端（可登录拓扑
    //链客户端）设置的默认参数进行
    //打印，如果传送参数，按传送参
    //数进行打印。
    //目前提供以下标准尺寸，后期还
    //会新增，不会减少，开发请预留，
    //如果传递过来的尺寸，物流商不
    //提供，按拓扑链客户端设置的默
    //认尺寸打印。
    //标准尺寸：
    //0:100mmx100mm
    //1:100mmx90mm
    //2:90mmx90mm
    //3:A4
    //4:A4x6
    //5:A4x8
    //6:100mmx150mm
    //7:100mmx200mm
    //8:4x4inch
    //9:4x6inch
    //10:100mmx170mm
    //11:80mmx90mm
    private String size;
}
