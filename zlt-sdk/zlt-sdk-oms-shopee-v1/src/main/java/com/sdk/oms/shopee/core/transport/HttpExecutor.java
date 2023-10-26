package com.sdk.oms.shopee.core.transport;

import cn.hutool.extra.spring.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class HttpExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(HttpExecutor.class);
    private static final HttpExecutor INSTANCE = new HttpExecutor();
    @Resource
    private HttpExecutorService service;

    private HttpExecutor() {}

    private HttpExecutorService service() {
        if (service != null) {
            return service;
        }else {
            return SpringUtil.getBean(HttpExecutorService.class);
        }

//        Iterator<HttpExecutorService> it = ServiceLoader.load(HttpExecutorService.class, getClass().getClassLoader()).iterator();
//        if (!it.hasNext())
//        {
//            LOG.error("No Rest Client connector found in classpath");
//            throw new ConnectorNotFoundException("No Rest Client connector found in classpath");
//        }
//        return service = it.next();
    }

    public static HttpExecutor create() {
        return INSTANCE;
    }

    public String getExecutorName() {
        return service().getExecutorDisplayName();
    }

    /**
     * Delegate to {@link HttpExecutorService#execute(HttpRequest)}
     */
    public <R> HttpResponse execute(HttpRequest<R> request) {
        LOG.debug("Executing Request: {} -> {}", request.getEndpoint(), request.getPath());
        return service().execute(request);
    }
}
