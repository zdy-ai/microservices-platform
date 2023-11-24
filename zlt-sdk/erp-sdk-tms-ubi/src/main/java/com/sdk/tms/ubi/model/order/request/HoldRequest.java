package com.sdk.tms.ubi.model.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName HoldRequest
 * @description: TODO
 * @date 2023年11月09日
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoldRequest implements Serializable {
    /**
     * 客户单号（Ref No.）或者跟踪号（Tracking No.）
     */
    @NotNull(message = "客户单号不能为空")
    private List<String> orderIds;
    /**
     *  1：扣留
     *  2：释放。（未启用
     */
    private Integer holdType;
}
