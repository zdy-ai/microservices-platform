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
public class YunTuCancelOrder {

    //返回的结果码 Success(成功)/Failure(成功)
    private String status;

    //请求的单号类型
    private Integer type;

    //请求的单号
    private String orderNumber;

    //处理信息
    private String remark;

}
