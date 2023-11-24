package com.sdk.tms.yuntu.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author liuruipeng
 */
@Data
@NoArgsConstructor
@ToString
public class YunTuInterceptOrder {

    //返回的结果码
    private String result;

    //请求的单号类型
    private Integer type;

    //请求的单号
    private String orderNumber;

    //处理信息
    private String remark;

}
