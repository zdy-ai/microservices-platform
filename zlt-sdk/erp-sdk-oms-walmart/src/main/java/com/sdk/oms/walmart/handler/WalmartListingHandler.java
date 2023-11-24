package com.sdk.oms.walmart.handler;

import cn.hutool.json.JSONUtil;
import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractProductHandler;
import com.sdk.oms.walmart.api.WalmartStaticKey;
import com.sdk.oms.walmart.dto.PlatformWalmartListingDTO;
import com.sdk.oms.walmart.dto.WalmartShopInfoDTO;
import com.sdk.oms.walmart.dto.walmart.WalmartTokenDTO;
import com.sdk.oms.walmart.dto.walmart.item.ItemResponseBean;
import com.sdk.oms.walmart.dto.walmart.WalmartItemDTO;
import com.sdk.oms.walmart.service.WalmartSdkClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 沃尔玛商品信息
 * @Author Luo_WG
 * @Date 2023/10/18 11:24
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.WALMART)
@BusinessType(BusinessTypeEnum.PRODUCT)
public class WalmartListingHandler extends AbstractProductHandler<PlatformWalmartListingDTO, PlatformProductDTO> {

    @Resource
    private  WalmartSdkClientService walmartSdkClientService;

    @Override
    public List<PlatformWalmartListingDTO> download(JobTaskDTO data) {
        //  根据店铺ID获取授权
        WalmartShopInfoDTO tokenDTO = WalmartSdkClientService.getTokenByShopId(data.getShopId());
        if (null == tokenDTO){
            log.error("[Walmart产品下载]从缓存中获取Walmart token 失败: shopId={}", data.getShopId());
            return Collections.emptyList();
        }
        //获取令牌
        String baseUrl = WalmartStaticKey.baseUrl + "token";

        WalmartTokenDTO walmartTokenDTO = walmartSdkClientService.sendWalmartPostToken(baseUrl, tokenDTO.getClientId(), tokenDTO.getClientSecret());

        baseUrl = WalmartStaticKey.baseUrl + data.getApiCode();

        List<ItemResponseBean> itemResponseList = new ArrayList<>();

        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        //每次最多获取200条
        Integer pageSize = 200;
        //当前页数
        Integer pageNo = 0;
        //总页数
        Integer pageCount = 1;

        paramMap.put("offset", pageNo);
        paramMap.put("limit", pageSize);
        while(pageNo < pageCount) {

            //拉取数据
            String date = walmartSdkClientService.sendWalmartGet(baseUrl, tokenDTO.getClientId(), tokenDTO.getClientSecret(), walmartTokenDTO.getAccessToken(), paramMap);

            WalmartItemDTO walmartItemDTO = JSONUtil.toBean(date, WalmartItemDTO.class);
            if (CollectionUtils.isEmpty(walmartItemDTO.getItemResponse())) {
                break;
            }
            pageCount = (walmartItemDTO.getTotalItems() + pageSize - 1) / pageSize;

            pageNo++;

            itemResponseList.addAll(walmartItemDTO.getItemResponse());
        }

        if (CollectionUtils.isEmpty(itemResponseList)) {
            return Collections.emptyList();
        }

        // 返回下载源数据
        return itemResponseList.stream()
                .map(e -> new PlatformWalmartListingDTO(e, data))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlatformProductDTO> convert(List<PlatformWalmartListingDTO> sourceDataList) {
        // 包含数据过滤数据 数据转换 数据合并拆分等操作
        return sourceDataList.stream()
                // 组装
                .map(PlatformWalmartListingDTO::convertDTO).collect(Collectors.toList());
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.WALMART.getCode();
    }

}
