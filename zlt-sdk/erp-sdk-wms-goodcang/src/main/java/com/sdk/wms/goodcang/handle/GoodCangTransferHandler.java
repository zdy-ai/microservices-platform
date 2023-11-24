package com.sdk.wms.goodcang.handle;

import cn.hutool.core.collection.CollectionUtil;
import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformTransferWarehouseDTO;
import com.common.business.dto.PlatformWarehouseDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractThirdWarehouseHandler;
import com.common.business.utils.MD5Util;
import com.common.core.exception.ServiceException;
import com.sdk.wms.goodcang.convert.GoodCangConverter;
import com.sdk.wms.goodcang.dto.response.GoodCangLogisticsAndWarehouseResp;
import com.sdk.wms.goodcang.dto.response.GoodCangResponse;
import com.sdk.wms.goodcang.dto.response.GoodCangTransferWarehouseResp;
import com.sdk.wms.goodcang.dto.response.GoodCangWarehouseResp;
import com.sdk.wms.goodcang.service.GoodCangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 谷仓拉取中转仓数据
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.GOOD_CANG)
@BusinessType(BusinessTypeEnum.TRANSFER)
public class GoodCangTransferHandler extends AbstractThirdWarehouseHandler<GoodCangTransferWarehouseResp, PlatformTransferWarehouseDTO> {

    @Resource
    private GoodCangService goodCangService;

    @Override
    public List<GoodCangTransferWarehouseResp> download(JobTaskDTO data) {
        GoodCangResponse<GoodCangLogisticsAndWarehouseResp> response = goodCangService.getSmCodeTwcToWarehouse();
        checkResponse(response);
        List<GoodCangTransferWarehouseResp> respList = new ArrayList<>();

        //封装参数
        processList(response.getData().getAirList(), respList);
        processList(response.getData().getExpressList(), respList);
        processList(response.getData().getLclList(), respList);

        respList.forEach(v->{
            v.setUniqueId(MD5Util.toMD5(getTargetPlatform()+BusinessTypeEnum.TRANSFER.getCode()+v.getLogisticsChannelCode()+v.getTransferWarehouseCode()+v.getDestinationWarehouseCode()));
            v.setAuthId(data.getShopId());
        });
        return respList;
    }

    private <T extends GoodCangLogisticsAndWarehouseResp.Base> void processList(List<T> list, List<GoodCangTransferWarehouseResp> respList) {
        if(CollectionUtil.isNotEmpty(list)){
            for(T item : list){
                String logisticsChannelCode = item.getSmCode();
                String logisticsChannelName = item.getSmCodeName();
                List<GoodCangLogisticsAndWarehouseResp.TwcToWarehouse> twcToWarehouseList = item.getTwcToWarehouseList();
                for(GoodCangLogisticsAndWarehouseResp.TwcToWarehouse twcToWarehouse : twcToWarehouseList){
                    GoodCangTransferWarehouseResp resp = getGoodCangTransferWarehouseResp(twcToWarehouse, logisticsChannelCode, logisticsChannelName);
                    respList.add(resp);
                }
            }
        }
    }

    private GoodCangTransferWarehouseResp getGoodCangTransferWarehouseResp(GoodCangLogisticsAndWarehouseResp.TwcToWarehouse twcToWarehouse, String logisticsChannelCode, String logisticsChannelName) {
        GoodCangTransferWarehouseResp resp = new GoodCangTransferWarehouseResp();
        resp.setLogisticsChannelCode(logisticsChannelCode);
        resp.setLogisticsChannelName(logisticsChannelName);
        resp.setTransferWarehouseCode(twcToWarehouse.getTransitWarehouseCode());
        resp.setTransferWarehouseName(twcToWarehouse.getTransitWarehouseName());
        resp.setDestinationWarehouseCode(twcToWarehouse.getWarehouseCode());
        resp.setDestinationWarehouseName(twcToWarehouse.getWarehouseName());
        return resp;
    }

    private void checkResponse(GoodCangResponse<?> response) {
        if (!isSuccess(response.getAsk())) {
            log.error("谷仓查询中转仓数据失败," + response.getMessage());
            throw new ServiceException("谷仓查询中转仓数据失败," + response.getMessage());
        }
    }

    @Override
    public List<PlatformTransferWarehouseDTO> convert(List<GoodCangTransferWarehouseResp> sourceDataList) {
        return GoodCangConverter.INSTANCE.transferWarehouseConversion(sourceDataList);
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.GOOD_CANG.getCode();
    }

    public boolean isSuccess(String ask){
        return "Success".equals(ask);
    }
}
