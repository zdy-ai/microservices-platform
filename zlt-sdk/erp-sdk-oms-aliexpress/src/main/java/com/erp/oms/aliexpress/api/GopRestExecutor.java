package com.erp.oms.aliexpress.api;

import com.erp.oms.aliexpress.util.IopHashMap;
import com.erp.oms.aliexpress.util.RequestContext;
import com.erp.oms.aliexpress.util.WebUtils;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName GopRestExecutor
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class GopRestExecutor extends GopExecutor {
    public GopRestExecutor(String serverUrl, String appKey, String appSecret) {
        super(serverUrl, appKey, appSecret);
    }

    protected String getUrl(IopRequest request, RequestContext requestContext) {
        String path = request.getApiName();
        IopHashMap pathParams = new IopHashMap();
        StringBuilder sb = new StringBuilder();
        IopHashMap apiParams = request.getApiParams();
        String[] arr = path.split("/");
        for (String s : arr) {
            if (s != null && s.length() != 0)
                if (s.startsWith("{") && s.endsWith("}")) {
                    String k = s.substring(1, s.length() - 1);
                    String v = (String)apiParams.get(k);
                    pathParams.put(k, v);
                    sb.append("/").append(v);
                } else {
                    sb.append("/").append(s);
                }
        }
        requestContext.setPathParams(pathParams);
        String realPath = sb.toString();
        requestContext.setApiName(realPath);
        return WebUtils.buildRestUrl(this.serverUrl + "/rest/2.0", realPath);
    }

    protected IopHashMap getBizParams(IopRequest request, RequestContext requestContext) {
        IopHashMap pathParams = requestContext.getPathParams();
        IopHashMap bizParams = new IopHashMap((request.getApiParams() != null) ? (Map)request.getApiParams() : new HashMap<String, String>());
        if (pathParams == null || pathParams.isEmpty())
            return bizParams;
        IopHashMap result = new IopHashMap();
        for (Map.Entry<String, String> entry : (Iterable<Map.Entry<String, String>>)bizParams.entrySet()) {
            String key = entry.getKey();
            if (!pathParams.containsKey(key))
                result.put(key, entry.getValue());
        }
        return result;
    }
}
