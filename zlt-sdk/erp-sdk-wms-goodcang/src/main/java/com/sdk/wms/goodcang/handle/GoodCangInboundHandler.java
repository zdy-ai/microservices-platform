package com.sdk.wms.goodcang.handle;

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
import com.sdk.wms.goodcang.convert.GoodCangConverter;
import com.sdk.wms.goodcang.dto.response.GoodCangResponse;
import com.sdk.wms.goodcang.dto.response.GoodCangWarehouseResp;
import com.sdk.wms.goodcang.service.GoodCangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 谷仓拉取入库数据
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.GOOD_CANG)
@BusinessType(BusinessTypeEnum.INBOUND)
public class GoodCangInboundHandler extends AbstractThirdWarehouseHandler<GoodCangWarehouseResp, PlatformWarehouseDTO> {

    @Resource
    private GoodCangService goodCangService;

    @Override
    public List<GoodCangWarehouseResp> download(JobTaskDTO data) {
        GoodCangResponse<List<GoodCangWarehouseResp>> response = goodCangService.getWarehouse();
        checkResponse(response);
        List<GoodCangWarehouseResp> goodCangGetSkuReq = response.getData();
        goodCangGetSkuReq.forEach(v->{
            v.setUniqueId(MD5Util.toMD5(getTargetPlatform()+v.getWarehouseCode()));
            v.setAuthId(data.getShopId());
        });
        return goodCangGetSkuReq;
    }

    private void checkResponse(GoodCangResponse<?> response) {
        if (!isSuccess(response.getAsk())) {
            log.error("谷仓查询入库数据失败," + response.getMessage());
            throw new ServiceException("谷仓查询入库数据失败," + response.getMessage());
        }
    }

    @Override
    public List<PlatformWarehouseDTO> convert(List<GoodCangWarehouseResp> sourceDataList) {
        return GoodCangConverter.INSTANCE.warehouseConversion(sourceDataList);
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.GOOD_CANG.getCode();
    }

    public boolean isSuccess(String ask){
        return "Success".equals(ask);
    }
}
