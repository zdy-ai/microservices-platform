package com.sdk.tms.express.model.base;

import cn.hutool.json.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName BaseResponse
 * @description: TODO
 * @date 2023年10月31日
 * @version: 1.0
 */
@Data
public class BaseResponse implements Serializable {
    private String apiErrorMsg;
    private String apiResponseID;
    private String apiResultCode;
    private JSONObject apiResultData;
}
