package com.sdk.wms.goodcang.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;

/**
 * @author liuruipeng
 * @date 2023年11月14日 15:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GoodCangBaseRequest {

    @Max(value = 200,message = "每页最大长度不能大于200")
    protected Integer pageSize;

    protected Integer page;
}
