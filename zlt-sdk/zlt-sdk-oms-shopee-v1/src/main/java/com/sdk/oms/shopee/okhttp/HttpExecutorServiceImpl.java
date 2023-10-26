package com.sdk.oms.shopee.okhttp;

import com.sdk.oms.shopee.core.api.exceptions.AuthenticationException;
import com.sdk.oms.shopee.core.api.exceptions.ConnectionException;
import com.sdk.oms.shopee.core.transport.HttpExecutorService;
import com.sdk.oms.shopee.core.transport.HttpRequest;
import com.sdk.oms.shopee.core.transport.HttpResponse;
import okhttp3.Response;
import org.springframework.stereotype.Service;


/**
 * HttpExecutor is the default implementation for HttpExecutorService which is responsible for interfacing with OKHttp and mapping common status codes, requests and responses
 * back to the common API
 */
@Service
public class HttpExecutorServiceImpl implements HttpExecutorService {

    private static final String NAME = "OKHttp Connector";

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> HttpResponse execute(HttpRequest<R> request) {
        try {
            return invoke(request);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Invokes the given request
     *
     * @param <R>     the return type
     * @param request the request to invoke
     * @return the response
     * @throws Exception the exception
     */
    private <R> HttpResponse invoke(HttpRequest<R> request) throws Exception {

        HttpCommand<R> command = HttpCommand.create(request);

        try {
            return invokeRequest(command);
        } catch (Exception pe) {
            throw new ConnectionException(pe.getMessage(), 0, pe);
        }
    }

    private <R> HttpResponse invokeRequest(HttpCommand<R> command) throws Exception {
        Response response = command.execute();
        if (command.getRetries() == 0 && response.code() == 401) {
            //Suppose to do reAuthenticate, since client doesn't require it.
            //TODO: to be
            throw new AuthenticationException("Authentication Failed", response.code());
        }
        return HttpResponseImpl.wrap(response);
    }

    @Override
    public String getExecutorDisplayName() {
        return NAME;
    }

}
