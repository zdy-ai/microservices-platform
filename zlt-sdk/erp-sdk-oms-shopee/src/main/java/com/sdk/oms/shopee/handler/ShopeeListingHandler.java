package com.sdk.oms.shopee.handler;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractProductHandler;
import com.common.core.controller.vo.ApiResult;
import com.erp.model.dmp.dto.CfgAppClientDTO;
import com.erp.model.dmp.entity.CfgAppClientEntity;
import com.erp.model.dmp.enums.AppClientEnum;
import com.erp.model.oms.entity.ShopAuthEntity;
import com.erp.model.oms.enums.AuthStatusEnum;
import com.erp.rpc.dmp.feign.DmpTaskFeign;
import com.erp.rpc.oms.feign.ShopeeFeign;
import com.sdk.oms.shopee.dto.PlatformShopeeListingDTO;
import com.sdk.oms.shopee.dto.product.request.ProductRequest;
import com.sdk.oms.shopee.dto.product.response.ItemInfo;
import com.sdk.oms.shopee.service.ShopeeProductService;
import io.seata.common.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 亚马逊产品处理器
 *
 * @Author Cloud
 * @Date 2023/8/31 15:48
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.SHOPEE)
@BusinessType(BusinessTypeEnum.PRODUCT)
public class ShopeeListingHandler extends AbstractProductHandler<PlatformShopeeListingDTO, PlatformProductDTO> {
    @Resource
    private ShopeeFeign shopeeFiegn;
    @Resource
    private DmpTaskFeign dmpTaskFeign;
    @Resource
    private ShopeeProductService shopeeProductService;

    @Override
    public List<PlatformShopeeListingDTO> download(JobTaskDTO data) {
        LocalDateTime lastTime = data.getLastTime();
        long timeFrom = Timestamp.valueOf(lastTime).getTime() / 1000;
        log.info("lastTime:{},timeFrom:{}", lastTime, timeFrom);
        LocalDateTime nextTime = data.getNextTime();
        if (lastTime.compareTo(nextTime) == 0){
            //nextTime +1天
            nextTime = lastTime.plusDays(1);
        }
        long timeTo = Timestamp.valueOf(nextTime).getTime() / 1000;
        log.info("nextTime:{},timeTo:{}", nextTime, timeTo);
        //获取主店铺token
        //根据主店铺获取子店铺token
        CfgAppClientDTO.FindDTO findDTO = new CfgAppClientDTO.FindDTO();
        AppClientEnum appClientEnum = AppClientEnum.SHOPEE_ACCESS_TOKEN;
        findDTO.setBusinessType(appClientEnum.getBusinessType());
        findDTO.setDictPlatform(appClientEnum.getPlatform());
        findDTO.setPlatformType(appClientEnum.getPlatformType());
        CfgAppClientEntity cfgAppClient = null;
        try {
            cfgAppClient = dmpTaskFeign.getCfgAppClient(findDTO);
        }catch (Exception e){
            log.error("erp-dmp服务获取虾皮配置信息异常：{}",e.getMessage());
        }
        if (Objects.isNull(cfgAppClient)) {
            return Collections.emptyList();
        }
        List<ItemInfo> itemInfos = new ArrayList<>();

        ApiResult<ShopAuthEntity> shopeeShopById = shopeeFiegn.getShopeeShopById(data.getShopId());
        if (Objects.nonNull(shopeeShopById) && Objects.nonNull(shopeeShopById.getData()) && Objects.nonNull(shopeeShopById.getData().getType())
               && "shopee_shop".equalsIgnoreCase(shopeeShopById.getData().getType())) {
            ProductRequest productRequest = ProductRequest.builder()
                    .host(cfgAppClient.getUrl())
                    .offset(0)
                    .token(shopeeShopById.getData().getAccessToken())
                    .shopId(Long.parseLong(shopeeShopById.getData().getShopeeId()))
                    .partnerId(Long.parseLong(cfgAppClient.getClientId()))
                    .tmpPartnerKey(cfgAppClient.getClientSecret())
                    .timeFrom(timeFrom)
                    .timeTo(timeTo)
                    .build();
            List<ItemInfo> list = new ArrayList<>();
            try {
                shopeeProductService.getAllProduct(productRequest, list);
            } catch (Exception e) {
                log.error("获取产品数据异常:{}", e.getMessage());
            }
            if (CollectionUtils.isNotEmpty(list)) {
                itemInfos.addAll(list);
            }
        }
        // 返回下载源数据
        return itemInfos.stream()
                .map(e -> new PlatformShopeeListingDTO(e, data))
                .collect(Collectors.toList());
    }


    @Override
    public List<PlatformProductDTO> convert(List<PlatformShopeeListingDTO> sourceDataList) {
        if (CollectionUtils.isEmpty(sourceDataList)) {
            return Collections.emptyList();
        }
        return sourceDataList.stream()
                .map(PlatformShopeeListingDTO::convertDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.SHOPEE.getCode();
    }
}
