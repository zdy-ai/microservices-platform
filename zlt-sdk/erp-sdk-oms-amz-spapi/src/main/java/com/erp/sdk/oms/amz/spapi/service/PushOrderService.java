package com.erp.sdk.oms.amz.spapi.service;

import com.common.core.controller.vo.ApiResult;

/**
 * 亚马逊订单推送服务
 *
 * @Author Cloud
 * @Date 2023/9/4 10:42
 **/
public interface PushOrderService<T> {

    /**
     * 处理推送订单
     * @param ext
     * @return
     */
    ApiResult handle(T ext);

}
