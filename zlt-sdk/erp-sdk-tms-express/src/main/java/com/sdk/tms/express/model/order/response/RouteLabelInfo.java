package com.sdk.tms.express.model.order.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author zdy
 * @ClassName RouteLabelInfo
 * @description: TODO
 * @date 2023年11月10日
 * @version: 1.0
 */
@Data
public class RouteLabelInfo implements Serializable {
    /**
     * 0000（接口参数异常） 0010（其它异常） 0001（xml解析异常） 0002（字段校验异常） 0003（票数节点超出最大值， 批量请求最大票数为100票） 0004（RLS获取路由标签的必要 字段为空） 1000 成功
     */
    private String code;
    /**
     * code为0XXX时的错误消息
     */
    private String message;
    /**
     * 路由标签响应详情
     */
    private RouteLabelRespDetailDto routeLabelData;
}
