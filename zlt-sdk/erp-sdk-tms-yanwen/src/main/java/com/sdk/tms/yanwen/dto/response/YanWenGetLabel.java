package com.sdk.tms.yanwen.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuruipeng
 * @date 2023年10月30日 10:47
 */
@Data
@NoArgsConstructor
public class YanWenGetLabel {

    //运单号
    private String waybillNumber;

    //订单号
    private Boolean isSuccess;

    //错误信息
    private String errorMsg;

    //文件 base64 字符
    private String base64String;

    //标签尺寸类型
    private String labelType;
}
