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
public class TongYouCallBackOrder extends TongYouResponse<Object> {

    //非实时返回条码渠道，判断是否需 要 通 过 请 求 回 调 方 法orderCallback 获取条码(0：否,1：是)
    private Integer isCallBack;

    //物流编号
    private String orderNo;

    //物流单号(追踪条码)
    private String logisticsNo;

    // 二级追踪条码
    private String logisticsId;

    //判断是否有面单返回(0：否,1：是 ) ， 如 果 有 面 单 返 回 ，ReturnLabel 不为空
    private Integer isReturnLabel;

    //返回面单表
    private ReturnLabel returnLabel;

    @Data
    @ToString
    @NoArgsConstructor
    public static class ReturnLabel {

        //面单返回方式(0:base64,1:url) *返回方式不能固定，具体返回的格式，根据这个值判断即可
        private String type;

        //面单返回单个或多个文件(S:单个,M:多个)
        private String rfile;

        //pdf 文件转 Base64 编码,多个以英文逗号隔开
        private String base64;

        //面单请求地址,多个以英文逗号隔开
        private String url;
    }
}
