package com.erp.oms.aliexpress.api;



import com.erp.oms.aliexpress.util.ApiException;
import com.erp.oms.aliexpress.util.IopHashMap;
import com.erp.oms.aliexpress.util.IopUtils;
import com.erp.oms.aliexpress.util.RequestContext;

import java.util.Date;

/**
 * @author zdy
 * @ClassName TopExecutor
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class TopExecutor extends BaseExecutor{
    public TopExecutor(String serverUrl, String appKey, String appSecret) {
        super(serverUrl, appKey, appSecret);
    }

    RequestContext getRequestContext(IopRequest request, String accessToken, IopHashMap bizParams) throws ApiException {
        RequestContext requestContext = new RequestContext();
        requestContext.setApiName(request.getApiName());
        IopHashMap params = request.getApiParams();
        IopHashMap commonParams = new IopHashMap();
        requestContext.setQueryParams(bizParams);
        commonParams.put("app_key", this.appKey);
        commonParams.put("v", "2.0");
        Long timestamp = request.getTimestamp();
        if (timestamp == null)
            timestamp = Long.valueOf(System.currentTimeMillis());
        commonParams.put("timestamp", new Date(timestamp.longValue()));
        commonParams.put("method", request.getApiName());
        commonParams.put("format", this.format);
        commonParams.put("session", accessToken);
        commonParams.put("partner_id", this.sdkVersion);
        commonParams.put("sign_method", this.signMethod);
        String simplify = (String)params.get("simplify");
        if (Boolean.TRUE.toString().equals(simplify))
            commonParams.put("simplify", Boolean.TRUE.toString());
        if (isDebugEnabled())
            commonParams.put("debug", Boolean.valueOf(true));
        requestContext.setCommonParams(commonParams);
        requestContext.setRequestUrl(this.serverUrl + "/sync?" + "method=" + request.getApiName());
        try {
            commonParams.put("sign", IopUtils.signApiRequest("", requestContext.getAllParams(), null, this.appSecret, this.signMethod));
        } catch (Exception e) {
            throw new ApiException(e);
        }
        return requestContext;
    }
}
