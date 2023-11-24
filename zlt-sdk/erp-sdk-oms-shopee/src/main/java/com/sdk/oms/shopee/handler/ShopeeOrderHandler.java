package com.sdk.oms.shopee.handler;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformOrderDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractOrderHandler;
import com.common.core.controller.vo.ApiResult;
import com.erp.model.dmp.dto.CfgAppClientDTO;
import com.erp.model.dmp.entity.CfgAppClientEntity;
import com.erp.model.dmp.enums.AppClientEnum;
import com.erp.model.oms.entity.ShopAuthEntity;
import com.erp.model.oms.enums.AuthStatusEnum;
import com.erp.rpc.dmp.feign.DmpTaskFeign;
import com.erp.rpc.oms.feign.ShopeeFeign;
import com.sdk.oms.shopee.dto.PlatformShopeeOrderDTO;
import com.sdk.oms.shopee.dto.order.request.OrderRequest;
import com.sdk.oms.shopee.dto.order.response.OrderDetail;
import com.sdk.oms.shopee.service.ShopeeOrderService;
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
 * 亚马逊订单处理器
 *
 * @Author Cloud
 * @Date 2023/8/31 15:48
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.SHOPEE)
@BusinessType(BusinessTypeEnum.ORDER)
public class ShopeeOrderHandler extends AbstractOrderHandler<PlatformShopeeOrderDTO, PlatformOrderDTO> {

    @Resource
    private ShopeeFeign shopeeFiegn;
    @Resource
    private DmpTaskFeign dmpTaskFeign;
    @Resource
    private ShopeeOrderService shopeeOrderService;

    @Override
    public List<PlatformShopeeOrderDTO> download(JobTaskDTO data) {
        LocalDateTime lastTime = data.getLastTime();
        long timeFrom = Timestamp.valueOf(lastTime).getTime() / 1000;
        log.info("shopId:{},lastTime:{},timeFrom:{}",data.getShopId(), lastTime, timeFrom);
        LocalDateTime nextTime = data.getNextTime();
        if (lastTime.compareTo(nextTime) == 0){
            //nextTime +1天
            nextTime = lastTime.plusDays(1);
        }
        long timeTo = Timestamp.valueOf(nextTime).getTime() / 1000;
        log.info("shopId:{},nextTime:{},timeTo:{}",data.getShopId(), nextTime, timeTo);
        //获取主店铺token
        //根据主店铺获取子店铺token
//        ApiResult<List<ShopAuthEntity>> shopeeShop = shopeeFiegn.getShopeeShopList("shopee_shop", AuthStatusEnum.ALREADY.getCode());
//        if (CollectionUtils.isEmpty(shopeeShop.getData())) {
//            return Collections.emptyList();
//        }
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
        List<OrderDetail> orderDTOS = new ArrayList<>();
        ApiResult<ShopAuthEntity> shopeeShopById = shopeeFiegn.getShopeeShopById(data.getShopId());
        if (Objects.nonNull(shopeeShopById) && Objects.nonNull(shopeeShopById.getData())
                && "shopee_shop".equalsIgnoreCase(shopeeShopById.getData().getType())) {
            OrderRequest orderRequest = OrderRequest.builder()
                    .offset(0)
                    .timeFrom(timeFrom)
                    .timeTo(timeTo)
                    .tmpPartnerKey(cfgAppClient.getClientSecret())
                    .partnerId(Long.parseLong(cfgAppClient.getClientId()))
                    .token(shopeeShopById.getData().getAccessToken())
                    .shopId(Long.parseLong(shopeeShopById.getData().getShopeeId()))
                    .host(cfgAppClient.getUrl())
                    .cursor("")
                    .build();
            List<OrderDetail> orderDetails = new ArrayList<>();
            try {
                shopeeOrderService.getAllOrder(orderRequest, orderDetails);
            } catch (Exception e) {
                log.error("获取订单数据异常:{}", e.getMessage());
            }
            if (CollectionUtils.isNotEmpty(orderDetails)) {
                orderDTOS.addAll(orderDetails);
            }
        }
        // 返回下载源数据
        return orderDTOS.stream()
                .map(e -> new PlatformShopeeOrderDTO(e, data))
                .collect(Collectors.toList());
    }


    @Override
    public List<PlatformOrderDTO> convert(List<PlatformShopeeOrderDTO> sourceDataList) {
        if (CollectionUtils.isEmpty(sourceDataList)) {
            return Collections.emptyList();
        }
        return sourceDataList.stream()
                .map(PlatformShopeeOrderDTO::convertDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.SHOPEE.getCode();
    }
}
