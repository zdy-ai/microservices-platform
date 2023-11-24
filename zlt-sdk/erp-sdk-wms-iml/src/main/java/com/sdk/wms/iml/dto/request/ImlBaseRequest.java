package com.sdk.wms.iml.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author liuruipeng
 * @date 2023年11月14日 15:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ImlBaseRequest {

    @NotNull(message = "分页参数不能为空")
    protected Integer page;

    @NotNull(message = "分页参数不能为空")
    @Max(value = 100,message = "每页数量最大值为100")
    protected Integer pageSize;

}
