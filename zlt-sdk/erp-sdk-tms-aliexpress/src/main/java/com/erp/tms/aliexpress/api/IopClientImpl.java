package com.erp.tms.aliexpress.api;

import com.erp.tms.aliexpress.domain.Protocol;
import com.erp.tms.aliexpress.util.ApiException;
import com.erp.tms.aliexpress.util.IopLogger;
import com.erp.tms.aliexpress.util.WebUtils;
import java.net.Proxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * @author zdy
 * @ClassName IopClientImpl
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class IopClientImpl implements IopClient{
    private final GopExecutor gopDelegate;

    private final TopExecutor topDelegate;

    private final GopRestExecutor gopRestDelegate;

    private final Map<Protocol, BaseExecutor> factory;

    public IopClientImpl(String serverUrl, String appKey, String appSecret) {
        this.gopDelegate = new GopExecutor(serverUrl, appKey, appSecret);
        this.topDelegate = new TopExecutor(serverUrl, appKey, appSecret);
        this.gopRestDelegate = new GopRestExecutor(serverUrl, appKey, appSecret);
        this.factory = new HashMap<Protocol, BaseExecutor>();
        this.factory.put(Protocol.GOP, this.gopDelegate);
        this.factory.put(Protocol.TOP, this.topDelegate);
        this.factory.put(Protocol.REST_VND_2, this.gopRestDelegate);
    }

    public IopClientImpl(String serverUrl, String appKey, String appSecret, int connectTimeout, int readTimeout) {
        this(serverUrl, appKey, appSecret);
        setConnectTimeout(connectTimeout);
        setReadTimeout(readTimeout);
    }

    public IopResponse execute(IopRequest request, Protocol protocol) throws ApiException {
        return ((BaseExecutor)this.factory.get(protocol)).doExecute(request, null);
    }

    public IopResponse execute(IopRequest request, String accessToken, Protocol protocol) throws ApiException {
        return ((BaseExecutor)this.factory.get(protocol)).doExecute(request, accessToken);
    }

    public IopResponse execute(IopRequest request) throws ApiException {
        return execute(request, Protocol.GOP);
    }

    public IopResponse execute(IopRequest request, String accessToken) throws ApiException {
        return execute(request, accessToken, Protocol.GOP);
    }

    public void setNeedEnableLogger(boolean needEnableLogger) {
        IopLogger.setNeedEnableLogger(needEnableLogger);
    }

    public void setIgnoreSSLCheck(boolean ignore) {
        WebUtils.setIgnoreSSLCheck(ignore);
    }

    public void setUseGzipEncoding(boolean useGzipEncoding) {
        if (this.factory == null)
            return;
        Collection<BaseExecutor> values = this.factory.values();
        for (BaseExecutor executor : values)
            executor.setUseGzipEncoding(useGzipEncoding);
    }

    public void setConnectTimeout(int connectTimeout) {
        if (this.factory == null)
            return;
        Collection<BaseExecutor> values = this.factory.values();
        for (BaseExecutor executor : values)
            executor.setConnectTimeout(connectTimeout);
    }

    public void setReadTimeout(int readTimeout) {
        if (this.factory == null)
            return;
        Collection<BaseExecutor> values = this.factory.values();
        for (BaseExecutor executor : values)
            executor.setReadTimeout(readTimeout);
    }

    public void setSignMethod(String signMethod) {
        if (this.factory == null)
            return;
        Collection<BaseExecutor> values = this.factory.values();
        for (BaseExecutor executor : values)
            executor.setSignMethod(signMethod);
    }

    public void setProxy(Proxy proxy) {
        if (this.factory == null)
            return;
        Collection<BaseExecutor> values = this.factory.values();
        for (BaseExecutor executor : values)
            executor.setProxy(proxy);
    }

    public void setLogLevel(String logLevel) {
        if (this.factory == null)
            return;
        Collection<BaseExecutor> values = this.factory.values();
        for (BaseExecutor executor : values)
            executor.setLogLevel(logLevel);
    }
}
