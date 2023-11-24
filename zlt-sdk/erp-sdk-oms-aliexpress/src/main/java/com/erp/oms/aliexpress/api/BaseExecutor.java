package com.erp.oms.aliexpress.api;

import com.erp.oms.aliexpress.util.*;
import com.erp.oms.aliexpress.util.json.JSONValidatingReader;

import java.io.IOException;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName BaseExecutor
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public abstract class BaseExecutor {
    protected String serverUrl;

    protected String appKey;

    protected String appSecret;

    protected String signMethod = "sha256";

    protected int connectTimeout = 15000;

    protected int readTimeout = 30000;

    protected boolean useGzipEncoding = true;

    protected Proxy proxy;

    protected String sdkVersion = "iop-sdk-java-20181207";

    protected String logLevel = "ERROR";

    protected String format = "json";

    public BaseExecutor(String serverUrl, String appKey, String appSecret) {
        this.serverUrl = serverUrl.endsWith("/") ? serverUrl.substring(0, serverUrl.length() - 1) : serverUrl;
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    abstract RequestContext getRequestContext(IopRequest paramIopRequest, String paramString, IopHashMap paramIopHashMap) throws ApiException;

    protected IopResponse doExecute(IopRequest request, String accessToken) throws ApiException {
        long start = System.currentTimeMillis();
        IopHashMap bizParams = new IopHashMap((request.getApiParams() != null) ? (Map)request.getApiParams() : new HashMap<String, String>());
        RequestContext requestContext = getRequestContext(request, accessToken, bizParams);
        try {
            String rpcUrl = requestContext.getRequestUrl();
            String urlQuery = WebUtils.buildQuery(requestContext.getAllParams(), "UTF-8");
            String fullUrl = WebUtils.buildRequestUrl(rpcUrl, new String[] { urlQuery });
            String rsp = null;
            if (this.useGzipEncoding)
                request.addHeaderParameter("Accept-Encoding", "gzip");
            if (request.getFileParams() != null) {
                rsp = WebUtils.requestWithFile(fullUrl, (Map)bizParams, request.getFileParams(), request.getHeaderParams(), "UTF-8", this.connectTimeout, this.readTimeout, request.getHttpMethod());
            } else {
                rsp = WebUtils.request(fullUrl, null, request.getHeaderParams(), this.connectTimeout, this.readTimeout, "UTF-8", this.proxy, request.getHttpMethod());
            }
            requestContext.setResponseBody(rsp);
        } catch (IOException e) {
            IopLogger.write(this.appKey, this.sdkVersion, request.getApiName(), this.serverUrl, requestContext.getAllParams(), System.currentTimeMillis() - start, e.toString());
            throw new ApiException(e);
        } catch (Exception e) {
            IopLogger.write(this.appKey, this.sdkVersion, request.getApiName(), this.serverUrl, requestContext.getAllParams(), System.currentTimeMillis() - start, e.toString());
            throw new ApiException(e);
        }
        IopResponse response = parseResponse(requestContext.getResponseBody());
        if (!response.isSuccess()) {
            IopLogger.write(this.appKey, this.sdkVersion, request.getApiName(), this.serverUrl, requestContext.getAllParams(), System.currentTimeMillis() - start, response.getBody());
        } else if (isDebugEnabled() || isInfoEnabled()) {
            IopLogger.write(this.appKey, this.sdkVersion, request.getApiName(), this.serverUrl, requestContext.getAllParams(), System.currentTimeMillis() - start, "");
        }
        return response;
    }

    public boolean isDebugEnabled() {
        return this.logLevel.equals("DEBUG");
    }

    private IopResponse parseResponse(String jsonRsp) {
        JSONValidatingReader jSONValidatingReader = new JSONValidatingReader();
        Map<?, ?> root = (Map<?, ?>)jSONValidatingReader.read(jsonRsp);
        IopResponse response = new IopResponse();
        response.setType((String)root.get("type"));
        response.setCode((String)root.get("code"));
        response.setMessage((String)root.get("message"));
        response.setRequestId((String)root.get("request_id"));
        response.setBody(jsonRsp);
        return response;
    }

    public boolean isInfoEnabled() {
        return this.logLevel.equals("INFO");
    }

    public boolean isErrorEnabled() {
        return this.logLevel.equals("ERROR");
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public boolean isUseGzipEncoding() {
        return this.useGzipEncoding;
    }

    public void setUseGzipEncoding(boolean useGzipEncoding) {
        this.useGzipEncoding = useGzipEncoding;
    }

    public String getSignMethod() {
        return this.signMethod;
    }

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public String getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
