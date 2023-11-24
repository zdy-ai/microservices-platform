package com.sdk.wms.iml.handle;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformWarehouseDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractThirdWarehouseHandler;
import com.common.business.utils.MD5Util;
import com.common.core.exception.ServiceException;
import com.sdk.wms.iml.convert.ImlConverter;
import com.sdk.wms.iml.dto.request.ImlBaseRequest;
import com.sdk.wms.iml.dto.response.ImlResponse;
import com.sdk.wms.iml.dto.response.ImlWarehouseResp;
import com.sdk.wms.iml.service.ImlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 艾姆勒拉取仓库数据
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.IML)
@BusinessType(BusinessTypeEnum.WAREHOUSE)
public class ImlWarehouseHandler extends AbstractThirdWarehouseHandler<ImlWarehouseResp, PlatformWarehouseDTO> {

    @Resource
    private ImlService imlService;

    @Override
    public List<ImlWarehouseResp> download(JobTaskDTO data) {
        ImlResponse<List<ImlWarehouseResp>> response = imlService.getWarehouse(ImlBaseRequest.builder().build());
        checkResponse(response);
        List<ImlWarehouseResp> imlWarehouseData = response.getData();
        imlWarehouseData.forEach(v->{
            v.setUniqueId(MD5Util.toMD5(getTargetPlatform()+BusinessTypeEnum.WAREHOUSE.getCode()+v.getWarehouseCode()));
            v.setAuthId(data.getShopId());
        });
        return imlWarehouseData;
    }

    private void checkResponse(ImlResponse<?> response) {
        if (!isSuccess(response.getAsk())) {
            log.error("艾姆勒查询仓库数据失败," + response.getMessage());
            throw new ServiceException("艾姆勒查询仓库数据失败," + response.getMessage());
        }
    }

    @Override
    public List<PlatformWarehouseDTO> convert(List<ImlWarehouseResp> sourceDataList) {
        return ImlConverter.INSTANCE.warehouseConversion(sourceDataList);
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.IML.getCode();
    }

    public boolean isSuccess(String ask){
        return "Success".equals(ask);
    }
}
