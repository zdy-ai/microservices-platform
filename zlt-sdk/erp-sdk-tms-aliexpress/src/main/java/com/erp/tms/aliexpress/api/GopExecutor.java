package com.erp.tms.aliexpress.api;

import com.erp.tms.aliexpress.util.ApiException;
import com.erp.tms.aliexpress.util.IopHashMap;
import com.erp.tms.aliexpress.util.IopUtils;
import com.erp.tms.aliexpress.util.RequestContext;
import com.erp.tms.aliexpress.util.WebUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName GopExecutor
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class GopExecutor extends BaseExecutor{
    public GopExecutor(String serverUrl, String appKey, String appSecret) {
        super(serverUrl, appKey, appSecret);
    }

    RequestContext getRequestContext(IopRequest request, String accessToken, IopHashMap bizParams) throws ApiException {
        RequestContext requestContext = new RequestContext();
        requestContext.setApiName(request.getApiName());
        IopHashMap commonParams = new IopHashMap();
        requestContext.setRequestUrl(getUrl(request, requestContext));
        requestContext.setQueryParams(getBizParams(request, requestContext));
        commonParams.put("app_key", this.appKey);
        Long timestamp = request.getTimestamp();
        if (timestamp == null)
            timestamp = Long.valueOf(System.currentTimeMillis());
        commonParams.put("timestamp", new Date(timestamp.longValue()));
        commonParams.put("sign_method", this.signMethod);
        commonParams.put("access_token", accessToken);
        commonParams.put("partner_id", this.sdkVersion);
        commonParams.put("simplify", Boolean.TRUE.toString());
        if (isDebugEnabled())
            commonParams.put("debug", Boolean.valueOf(true));
        requestContext.setCommonParams(commonParams);
        try {
            commonParams.put("sign", IopUtils.signApiRequest(requestContext, this.appSecret, this.signMethod));
        } catch (Exception e) {
            throw new ApiException(e);
        }
        return requestContext;
    }

    protected String getUrl(IopRequest request, RequestContext requestContext) {
        return WebUtils.buildRestUrl(this.serverUrl + "/rest", request.getApiName());
    }

    protected IopHashMap getBizParams(IopRequest request, RequestContext requestContext) {
        return new IopHashMap((request.getApiParams() != null) ? (Map)request.getApiParams() : new HashMap<String, String>());
    }
}
