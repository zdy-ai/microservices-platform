package com.erp.sdk.oms.amz.spapi.service.impl;

import com.common.business.dto.DmpSyncMqDTO;
import com.common.core.controller.vo.ApiResult;
import com.erp.sdk.oms.amz.spapi.service.PushOrderService;
import org.springframework.stereotype.Service;

/**
 * 亚马逊订单推送服务
 *
 * @Author Cloud
 * @Date 2023/9/4 10:43
 **/
@Service
public class PushOrderServiceImpl implements PushOrderService<DmpSyncMqDTO> {
    @Override
    public ApiResult handle(DmpSyncMqDTO ext) {
        // 封装订单数据


        // 发送订单数据到亚马逊

        System.out.println("ext = " + ext);
        // 返回操作结果和错误信息
        return ApiResult.success();
    }
}
