package com.sdk.oms.walmart.handler;


import cn.hutool.json.JSONUtil;
import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformOrderDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractOrderHandler;
import com.sdk.oms.walmart.api.WalmartStaticKey;
import com.sdk.oms.walmart.dto.PlatformWalmartListingDTO;
import com.sdk.oms.walmart.dto.PlatformWalmartOrderDTO;
import com.sdk.oms.walmart.dto.WalmartShopInfoDTO;
import com.sdk.oms.walmart.dto.walmart.WalmartOrderDTO;
import com.sdk.oms.walmart.dto.walmart.item.ItemResponseBean;
import com.sdk.oms.walmart.dto.walmart.WalmartItemDTO;
import com.sdk.oms.walmart.dto.walmart.WalmartTokenDTO;
import com.sdk.oms.walmart.dto.walmart.order.OrderBean;
import com.sdk.oms.walmart.service.WalmartSdkClientService;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 沃尔玛订单信息
 * @Author Luo_WG
 * @Date 2023/10/18 11:24
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.WALMART)
@BusinessType(BusinessTypeEnum.ORDER)
public class WalmartOrderHandler extends AbstractOrderHandler<PlatformWalmartOrderDTO, PlatformOrderDTO> {

    @Resource
    private  WalmartSdkClientService walmartSdkClientService;

    @Override
    public List<PlatformWalmartOrderDTO> download(JobTaskDTO data) {
        //  根据店铺ID获取授权
        WalmartShopInfoDTO shopInfoDTO = WalmartSdkClientService.getTokenByShopId(data.getShopId());
        if (null == shopInfoDTO){
            log.error("[Walmart产品下载]从缓存中获取Walmart token 失败: shopId={}", data.getShopId());
            return Collections.emptyList();
        }
        //获取令牌
        String baseUrl = WalmartStaticKey.baseUrl + "token";

        WalmartTokenDTO walmartTokenDTO = walmartSdkClientService.sendWalmartPostToken(baseUrl, shopInfoDTO.getClientId(), shopInfoDTO.getClientSecret());

        baseUrl = WalmartStaticKey.baseUrl + data.getApiCode();

        List<OrderBean> orderBeanList = new ArrayList<>();

        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();

        String nextCursor = "";

        StringBuffer sb = new StringBuffer();
        //获取新创建的订单
        while(true) {
            sb.setLength(0);
            sb.append(baseUrl);
            if (StringUtil.isBlank(nextCursor)) {
                sb.append("?lastModifiedStartDate=");
                sb.append(data.getLastTime());
                sb.append("&lastModifiedEndDate=");
                sb.append(data.getNextTime());
                sb.append("&createdStartDate=");
                sb.append(data.getLastTime());
                sb.append("&createdEndDate=");
                sb.append(data.getNextTime());
                sb.append("&status=Acknowledged,Shipped,Delivered,Cancelled");
                sb.append("&limit=200&productInfo=true");
            } else {
                sb.append(baseUrl);
                sb.append(nextCursor);
            }
            //拉取数据
            String date = walmartSdkClientService.sendWalmartGet(baseUrl, shopInfoDTO.getClientId(), shopInfoDTO.getClientSecret(), walmartTokenDTO.getAccessToken(), paramMap);

            WalmartOrderDTO walmartOrderDTO = JSONUtil.toBean(date, WalmartOrderDTO.class);
            if (CollectionUtils.isEmpty(walmartOrderDTO.getList().getElements().getOrder())) {
                break;
            }

            orderBeanList.addAll(walmartOrderDTO.getList().getElements().getOrder());

            nextCursor = walmartOrderDTO.getList().getMeta().getNextCursor();//下一页
            if (StringUtil.isBlank(nextCursor)) {
                break;
            }
        }

        if (CollectionUtils.isEmpty(orderBeanList)) {
            return Collections.emptyList();
        }

        // 返回下载源数据
        return orderBeanList.stream()
                .map(e -> new PlatformWalmartOrderDTO(e, data, shopInfoDTO))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlatformOrderDTO> convert(List<PlatformWalmartOrderDTO> sourceDataList) {
        // 包含数据过滤数据 数据转换 数据合并拆分等操作
        return sourceDataList.stream()
                // 组装
                .map(PlatformWalmartOrderDTO::convertDTO).collect(Collectors.toList());
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.WALMART.getCode();
    }
}
