package com.sdk.tms.express.model.order.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName RlsResultRespDto
 * @description: TODO
 * @date 2023年10月31日
 * @version: 1.0
 */
@Data
public class RlsResultRespDto implements Serializable {
    /**
     * 返回调用结果，1000：调用成功；其他调用失败
     */
    private String code;
    /**
     * 路由标签数据详细数据
     */
    private List<RouteLabelRespDetailDto> routeLabelData;
    /**
     * 失败异常描述
     */
    private String message;
}
