package com.erp.oms.aliexpress.api;



import com.erp.oms.aliexpress.util.FileItem;
import com.erp.oms.aliexpress.util.IopHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName IopRequest
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class IopRequest {
    protected IopHashMap apiParams;

    protected IopHashMap headerParams;

    protected Map<String, FileItem> fileParams;

    private Long timestamp;

    private String apiName;

    private String httpMethod = "POST";

    public IopRequest() {}

    public IopRequest(String apiName) {
        this.apiName = apiName;
    }

    public void addApiParameter(String key, String value) {
        if (this.apiParams == null)
            this.apiParams = new IopHashMap();
        this.apiParams.put(key, value);
    }

    public void addFileParameter(String key, FileItem file) {
        if (this.fileParams == null)
            this.fileParams = new HashMap<String, FileItem>();
        this.fileParams.put(key, file);
    }

    public void addHeaderParameter(String key, String value) {
        if (this.headerParams == null)
            this.headerParams = new IopHashMap();
        this.headerParams.put(key, value);
    }

    public IopHashMap getApiParams() {
        return this.apiParams;
    }

    public Map<String, FileItem> getFileParams() {
        return this.fileParams;
    }

    public Map<String, String> getHeaderParams() {
        return (Map<String, String>)this.headerParams;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getApiName() {
        return this.apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setHeaderParams(IopHashMap headerParams) {
        this.headerParams = headerParams;
    }
}
