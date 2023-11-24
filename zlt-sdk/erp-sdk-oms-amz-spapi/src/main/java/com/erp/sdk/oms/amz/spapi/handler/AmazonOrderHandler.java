package com.erp.sdk.oms.amz.spapi.handler;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.constant.BusinessCommonConstants;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformOrderDTO;
import com.common.business.dto.PlatformOrderDetailDTO;
import com.common.business.dto.PlatformOrderFinanceDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractOrderHandler;
import com.common.core.exception.ServiceException;
import com.common.core.utils.date.DateUtil;
import com.erp.model.oms.entity.ShopInfoEntity;
import com.erp.rpc.oms.feign.ShopInfoFeign;
import com.erp.sdk.oms.amz.spapi.api.OrdersV0Api;
import com.erp.sdk.oms.amz.spapi.client.ApiException;
import com.erp.sdk.oms.amz.spapi.dto.PlatformAmazonOrderDTO;
import com.erp.sdk.oms.amz.spapi.enums.AmazonMarketplaceEnum;
import com.erp.sdk.oms.amz.spapi.model.orders.Money;
import com.erp.sdk.oms.amz.spapi.model.orders.Order;
import com.erp.sdk.oms.amz.spapi.model.orders.OrderItemList;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 亚马逊订单处理器
 *
 * @Author Cloud
 * @Date 2023/8/31 15:48
 **/
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.AMAZON)
@BusinessType(BusinessTypeEnum.ORDER)
public class AmazonOrderHandler extends AbstractOrderHandler<PlatformAmazonOrderDTO, PlatformOrderDTO> {

    @Resource
    private ShopInfoFeign shopInfoFeign;

    @Override
    public List<PlatformAmazonOrderDTO> download(JobTaskDTO data) {
        // 获取店铺信息
        String shopId = data.getShopId();
        ShopInfoEntity shop = shopInfoFeign.getShopInfoById(shopId);
        if (null == shop) {
            throw new ServiceException("未找到店铺信息:shopId=" + shopId);
        }
        AmazonMarketplaceEnum marketplaceEnum = AmazonMarketplaceEnum.getByCountryCode(shop.getDictCountryCode());
        // 亚马逊订单下载
        OrdersV0Api api = OrdersV0Api.initApi(marketplaceEnum.getEndpointsEnum(), false);
        String createdAfter = null;
        // 正式环境请求
        // 东八区转UTC时间
        String lastUpdatedAfter = DateUtil.plus8SameUtcOffset(data.getLastTime()).toString();
        String lastUpdatedBefore = DateUtil.plus8SameUtcOffset(data.getNextTime()).toString();
        try {
            // 发起请求
            List<Order> orderList = api.getAllOrders(Collections.singletonList(marketplaceEnum.getMarketplaceId()),
                    createdAfter, null, lastUpdatedAfter, lastUpdatedBefore, null, null, null, null, null,
                    null, null, null, null, null, null, null, null, null,null, null);
            // 返回下载源数据
            return orderList.stream()
                    .map(e-> new PlatformAmazonOrderDTO(e, shop))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("请求亚马逊SP-APi订单失败,body=" + JSONUtil.toJsonStr(e));
        }
    }


    @Override
    public List<PlatformOrderDTO> convert(List<PlatformAmazonOrderDTO> sourceDataList) {
        //亚马逊订单转换为发送mq数据
        // 包含数据过滤数据 数据转换 数据合并拆分等操作
        return sourceDataList.stream()
                // 组装
                .map(e-> PlatformAmazonOrderDTO.convertDTO(e, this.getIsSendMq()))
                .collect(Collectors.toList());
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.AMAZON.getCode();
    }

    /**
     * 是否发送MQ
     * true=发送
     * false=不发送（有其他详情需要额外拉取）
     */
    @Override
    public Boolean getIsSendMq() {
        return Boolean.FALSE;
    }

    @Override
    public PlatformAmazonOrderDTO downloadDetail(PlatformAmazonOrderDTO dto, JSONObject extendObj) {
        ShopInfoEntity shopInfoEntity = shopInfoFeign.getShopInfoById(dto.getShopId());
        if (null == shopInfoEntity){
            throw new ServiceException("未找到店铺详情:"+ dto.getShopId());
        }
        AmazonMarketplaceEnum marketPlaceEnum = AmazonMarketplaceEnum.getByCountryCode(shopInfoEntity.getDictCountryCode());
        // 查询订单详情
        OrdersV0Api ordersVoApi = OrdersV0Api.initApi(marketPlaceEnum.getEndpointsEnum(), false);
        OrderItemList allOrderItems = null;
        try {
            allOrderItems = ordersVoApi.getAllOrderItems(dto.getUniqueId(), null);
        } catch (ApiException e) {
            throw new ServiceException("查询亚马逊订单详情失败："+JSONUtil.toJsonStr(e));
        }
        if (CollectionUtils.isEmpty(allOrderItems)){
            return dto;
        }
//        List<PlatformOrderDetailDTO> detailDtoList = allOrderItems.stream()
//                .map(PlatformAmazonOrderDTO::intPlatformOrderDetailDTO)
//                .collect(Collectors.toList());
        dto.setDetails(allOrderItems);
        return dto;
    }

}
