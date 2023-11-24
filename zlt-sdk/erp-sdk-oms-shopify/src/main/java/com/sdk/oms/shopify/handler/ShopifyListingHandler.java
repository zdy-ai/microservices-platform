package com.sdk.oms.shopify.handler;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.constant.MongoTableNameContant;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractProductHandler;
import com.erp.model.dmp.gyy.GyyShopInfoEntity;
import com.sdk.oms.shopify.api.rest.ShopifyRestClientService;
import com.sdk.oms.shopify.api.rest.model.ShopifyProducts;
import com.sdk.oms.shopify.dto.PlatformShopifyListingDTO;
import com.sdk.oms.shopify.dto.ShopifyShopInfoDTO;
import com.sdk.oms.shopify.service.ShopSdkServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Shopify产品处理器
 *
 * @Author Jim
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.SHOPIFY)
@BusinessType(BusinessTypeEnum.PRODUCT)
public class ShopifyListingHandler extends AbstractProductHandler<PlatformShopifyListingDTO, PlatformProductDTO> {

    @Resource
    private ShopifyRestClientService shopifyRestClientService;


    @Override
    public List<PlatformShopifyListingDTO> download(JobTaskDTO data) {
        //  根据店铺ID获取授权
        ShopifyShopInfoDTO tokenDTO = ShopSdkServer.getTokenAndDomainByShopId(data.getShopId());
        if (null == tokenDTO){
            log.error("[Shopify产品下载]从缓存中获取shopify token 失败: shopId={}", data.getShopId());
            return Collections.emptyList();
        }
        String shopifyShopDomain = tokenDTO.getShopDomain();
        String accessToken = tokenDTO.getAccessToken();

        // Shopify产品下载所有(SDK已分页查询所有)
        ShopifyProducts products = shopifyRestClientService.getShopifyRestClient(shopifyShopDomain, accessToken).getProducts();
        if (CollectionUtils.isEmpty(products.values())) {
            return Collections.emptyList();
        }
        // 返回下载源数据
        return products.values().stream()
                .map(e -> new PlatformShopifyListingDTO(e, data))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlatformProductDTO> convert(List<PlatformShopifyListingDTO> sourceDataList) {
        // Shopify商品转换为发送mq数据
        // 包含数据过滤数据 数据转换 数据合并拆分等操作
        return sourceDataList.stream()
                // 已发布并售卖中
                .filter(e -> e.getShopifyProduct().isPublished() && "active".equalsIgnoreCase(e.getShopifyProduct().getStatus()))
                // 组装
                .map(PlatformShopifyListingDTO::convertDTO)
                .flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.SHOPIFY.getCode();
    }

}
