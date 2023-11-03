package com.central.common.handler;

import com.central.common.annotation.PlatformType;
import com.central.common.service.LogisticsService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 业务初始化处理
 *
 * @author Cloud
 */
@Service
public class LogisticsHandler {
    private final Map<String, LogisticsService> handlers = new HashMap<>();

    @Resource
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        Map<String, LogisticsService> beans = context.getBeansOfType(LogisticsService.class);
        for (Object bean : beans.values()) {
            PlatformType platformAnnotation = bean.getClass().getAnnotation(PlatformType.class);
            handlers.put(platformAnnotation.value().getCode(), (LogisticsService) bean);
        }
    }

    public LogisticsService getHandler(String platform) {
        return handlers.get(platform);
    }
}
