package com.sdk.tms.weishi.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liuruipeng
 */
@Data
@Builder
public class WeiShiGetTrackNumberRequest {

    //客户参考号
    @NotNull(message = "客户参考号不能为空")
    @JSONField(name = "reference_no")
    private List<String> referenceNoList;

}
