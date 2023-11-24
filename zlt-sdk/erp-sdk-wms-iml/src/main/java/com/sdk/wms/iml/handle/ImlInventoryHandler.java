package com.sdk.wms.iml.handle;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformInventoryDTO;
import com.common.business.dto.PlatformWarehouseDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractThirdWarehouseHandler;
import com.common.business.utils.MD5Util;
import com.common.core.exception.ServiceException;
import com.sdk.wms.iml.convert.ImlConverter;
import com.sdk.wms.iml.dto.request.ImlBaseRequest;
import com.sdk.wms.iml.dto.request.ImlGetInventoryReq;
import com.sdk.wms.iml.dto.request.ImlGetProductReq;
import com.sdk.wms.iml.dto.response.ImlInventoryResp;
import com.sdk.wms.iml.dto.response.ImlProductResp;
import com.sdk.wms.iml.dto.response.ImlResponse;
import com.sdk.wms.iml.dto.response.ImlWarehouseResp;
import com.sdk.wms.iml.service.ImlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 艾姆勒拉取库存数据
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.IML)
@BusinessType(BusinessTypeEnum.INVENTORY)
public class ImlInventoryHandler extends AbstractThirdWarehouseHandler<ImlInventoryResp, PlatformInventoryDTO> {

    @Resource
    private ImlService imlService;

    @Override
    public List<ImlInventoryResp> download(JobTaskDTO data) {
        //查询数据
        ImlGetInventoryReq req = new ImlGetInventoryReq();
        //最大页码100，从第一页开始查询
        req.setPageSize(100);
        List<ImlInventoryResp> respList = new ArrayList<>();
        int page = 1;
        while (true) {
            req.setPage(page);
            ImlResponse<List<ImlInventoryResp>> getProductInventory = imlService.getProductInventory(req);
            checkResponse(getProductInventory);
            respList.addAll(getProductInventory.getData());
            if (getProductInventory.getCount() <= page * 100) {
                break;
            }
            page++;
        }
        respList.forEach(v->{
            v.setUniqueId(MD5Util.toMD5(getTargetPlatform()+BusinessTypeEnum.INVENTORY.getCode()+v.getProductSku()+v.getWarehouseCode()));
            v.setAuthId(data.getShopId());
        });
        return respList;
    }

    private void checkResponse(ImlResponse<?> response) {
        if (!isSuccess(response.getAsk())) {
            log.error("艾姆勒查询库存数据失败," + response.getMessage());
            throw new ServiceException("艾姆勒查询库存数据失败," + response.getMessage());
        }
    }

    @Override
    public List<PlatformInventoryDTO> convert(List<ImlInventoryResp> sourceDataList) {
        return ImlConverter.INSTANCE.inventoryConversion(sourceDataList);
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.IML.getCode();
    }

    public boolean isSuccess(String ask){
        return "Success".equals(ask);
    }
}
