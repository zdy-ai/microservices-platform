package com.erp.tms.aliexpress.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName RequestContext
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class RequestContext {
    private String requestUrl;

    private String responseBody;

    private String apiName;

    private IopHashMap commonParams;

    private IopHashMap queryParams;

    private IopHashMap pathParams;

    public IopHashMap getPathParams() {
        return this.pathParams;
    }

    public void setPathParams(IopHashMap pathParams) {
        this.pathParams = pathParams;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public IopHashMap getQueryParams() {
        return this.queryParams;
    }

    public void setQueryParams(IopHashMap queryParams) {
        this.queryParams = queryParams;
    }

    public String getApiName() {
        return this.apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public IopHashMap getCommonParams() {
        return this.commonParams;
    }

    public void setCommonParams(IopHashMap commonParams) {
        this.commonParams = commonParams;
    }

    public Map<String, String> getAllParams() {
        Map<String, String> params = new HashMap<String, String>();
        if (this.commonParams != null && !this.commonParams.isEmpty())
            params.putAll(this.commonParams);
        if (this.queryParams != null && !this.queryParams.isEmpty())
            params.putAll(this.queryParams);
        return params;
    }
}
