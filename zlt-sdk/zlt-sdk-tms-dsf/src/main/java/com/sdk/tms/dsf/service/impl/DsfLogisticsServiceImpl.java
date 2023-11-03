package com.sdk.tms.dsf.service.impl;

import com.central.common.annotation.PlatformType;
import com.central.common.enums.PlatformDictEnum;
import com.central.common.service.LogisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zdy
 * @ClassName DsfLogisticsServiceImpl
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
@Slf4j
@Component
@PlatformType(PlatformDictEnum.SDF)
public class DsfLogisticsServiceImpl implements LogisticsService {
    @Override
    public Object createOrder(String platformCode) {
        log.info("递四方创建订单接口");
        return null;
    }

    @Override
    public Object confirmOrder(String platformCode) {
        return null;
    }

    @Override
    public Object cancelOrder(String platformCode) {
        return null;
    }

    @Override
    public Object interceptOrder(String platformCode) {
        return null;
    }

    @Override
    public Object updateOrder(String platformCode) {
        return null;
    }

    @Override
    public Object queryOrder(String platformCode) {
        return null;
    }

    @Override
    public Object getLabelUrl(String platformCode) {
        return null;
    }

    @Override
    public Object getTrack(String platformCode) {
        return null;
    }

    @Override
    public Object getChannel(String platformCode) {
        return null;
    }
}
