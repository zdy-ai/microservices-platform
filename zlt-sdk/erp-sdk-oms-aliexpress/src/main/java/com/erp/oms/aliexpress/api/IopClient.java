package com.erp.oms.aliexpress.api;

import com.erp.oms.aliexpress.enums.Protocol;
import com.erp.oms.aliexpress.util.ApiException;


/**
 * @author zdy
 * @ClassName IopClient
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public interface IopClient {
    IopResponse execute(IopRequest paramIopRequest) throws ApiException;

    IopResponse execute(IopRequest paramIopRequest, String paramString) throws ApiException;

    IopResponse execute(IopRequest paramIopRequest, Protocol paramProtocol) throws ApiException;

    IopResponse execute(IopRequest paramIopRequest, String paramString, Protocol paramProtocol) throws ApiException;
}
