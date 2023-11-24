package com.sdk.tms.yanwen.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liuruipeng
 */
@Data
@Builder
public class YanWenQueryOrderRequest {

    //运单号
    @NotNull(message = "单号集合不能为空")
    private List<String> listNumber;

}
