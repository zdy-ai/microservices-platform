package com.sdk.tms.disifang.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zdy
 * @ClassName ResponseMsg
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
@Data
public class ResponseMsg {
    public String result;

    public String msg;

    public List<ResError> errors;

    public Object data;


    public static ResponseMsg fial(String msg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setMsg(msg);
        return responseMsg;
    }
}
