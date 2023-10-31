package com.sdk.tms.express.model.base;

import cn.hutool.json.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName BaseResult
 * @description: TODO
 * @date 2023年10月31日
 * @version: 1.0
 */
@Data
public class BaseResult implements Serializable {
    private boolean success;
    private String errorCode;
    private String errorMsg;
    private JSONObject msgData;
}
