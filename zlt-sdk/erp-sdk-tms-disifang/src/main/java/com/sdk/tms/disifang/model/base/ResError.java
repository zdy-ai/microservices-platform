package com.sdk.tms.disifang.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ResError
 * @description: TODO
 * @date 2023年11月16日
 * @version: 1.0
 */
@Data
public class ResError implements Serializable {

    @JSONField(name = "error_code")
    String errorCode;
    @JSONField(name = "error_msg")
    String errorMsg;
    @JSONField(name = "reference_code")
    String referenceCode;
}
