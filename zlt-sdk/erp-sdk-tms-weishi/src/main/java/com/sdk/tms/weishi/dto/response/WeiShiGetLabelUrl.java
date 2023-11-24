package com.sdk.tms.weishi.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liuruipeng
 */
@Data
@NoArgsConstructor
@ToString
public class WeiShiGetLabelUrl extends WeiShiResponse<Object>{

    //PDF标签格式URL地址。注标签URL有效时间为1个星期，如果未保存标签文件到本地,可以重新调用获取标签接口生成新的标签。
    private String url;
}
