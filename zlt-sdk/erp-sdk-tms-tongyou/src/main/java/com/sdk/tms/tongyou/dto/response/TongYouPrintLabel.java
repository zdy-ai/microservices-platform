package com.sdk.tms.tongyou.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liuruipeng
 */
@Data
@NoArgsConstructor
@ToString
public class TongYouPrintLabel extends TongYouResponse<Object> {

    //面单返回方式(0:base64,1:url) *返回方式不能固定，具体返回的格式，根据这个值判断即可
    private Integer type;

    //pdf 文件转 Base64 编码,多个以英文逗号隔开
    private String base64;

    //面单请求地址,多个以英文逗号隔开
    private String url;

    // 面 单 返 回 单 个 或 多 个 文 件 (S: 单个,M:多个)
    private String rfile;

    // 物流单号(追踪条码)
    private String logisticsNo;

}
