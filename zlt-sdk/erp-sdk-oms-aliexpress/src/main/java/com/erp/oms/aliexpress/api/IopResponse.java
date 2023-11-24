package com.erp.oms.aliexpress.api;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName IopResponse
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class IopResponse implements Serializable{
    private static final long serialVersionUID = 5014379068811962022L;

    private String type;

    private String code;

    private String message;

    private String requestId;

    private String body;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isSuccess() {
        return (this.code == null || "0".equals(this.code));
    }
}
