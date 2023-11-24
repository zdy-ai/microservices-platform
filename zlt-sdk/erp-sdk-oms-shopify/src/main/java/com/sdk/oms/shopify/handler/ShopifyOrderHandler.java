package com.sdk.oms.shopify.handler;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformOrderDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractOrderHandler;
import com.sdk.oms.shopify.api.rest.ShopifyRestClientService;
import com.sdk.oms.shopify.api.rest.model.ShopifyOrder;
import com.sdk.oms.shopify.api.rest.model.ShopifyProduct;
import com.sdk.oms.shopify.dto.PlatformShopifyListingDTO;
import com.sdk.oms.shopify.dto.PlatformShopifyOrderDTO;
import com.sdk.oms.shopify.dto.ShopifyShopInfoDTO;
import com.sdk.oms.shopify.service.ShopSdkServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Shopify订单处理器
 *
 * @Author Jim
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.SHOPIFY)
@BusinessType(BusinessTypeEnum.ORDER)
public class ShopifyOrderHandler extends AbstractOrderHandler<PlatformShopifyOrderDTO, PlatformOrderDTO> {

    @Resource
    private ShopifyRestClientService shopifyRestClientService;

    @Override
    public List<PlatformShopifyOrderDTO> download(JobTaskDTO data) {
        // Shopify订单下载
        ShopifyShopInfoDTO shopInfoDTO = ShopSdkServer.getTokenAndDomainByShopId(data.getShopId());
        if (null == shopInfoDTO) {
            log.error("[Shopify订单下载]从缓存中获取shopify token 失败: shopId={}", data.getShopId());
            return Collections.emptyList();
        }
        String shopifyShopDomain = shopInfoDTO.getShopDomain();
        String accessToken = shopInfoDTO.getAccessToken();

        ZoneOffset zoneOffset = ZoneOffset.systemDefault().getRules().getOffset(Instant.now());
        // 上次执行时间
        OffsetDateTime lastOffSetTime = data.getLastTime().atOffset(zoneOffset);
        // 下次执行时间
        OffsetDateTime nextOffSetTime = data.getNextTime().atOffset(zoneOffset);
        // 当前时间
        OffsetDateTime nowOffSetTime = OffsetDateTime.now(ZoneId.systemDefault());

        // Shopify产品下载所有(SDK已分页查询所有)
        List<ShopifyOrder> orders = shopifyRestClientService.getShopifyRestClient(shopifyShopDomain, accessToken)
                .getAllUpdatedOrdersCreatedBefore(lastOffSetTime, nextOffSetTime, nowOffSetTime);

        if (CollectionUtils.isEmpty(orders)) {
            return Collections.emptyList();
        }
        // 返回下载源数据
        return orders.stream()
                .map(e -> new PlatformShopifyOrderDTO(data, e, shopInfoDTO))
                .collect(Collectors.toList());
    }


    @Override
    public List<PlatformOrderDTO> convert(List<PlatformShopifyOrderDTO> sourceDataList) {
        // Shopify订单
        // 包含数据过滤数据 数据转换 数据合并拆分等操作
        return sourceDataList.stream()
                // 组装
                .map(PlatformShopifyOrderDTO::convertDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.SHOPIFY.getCode();
    }
}
