package com.sdk.wms.iml.handle;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformCityDictDTO;
import com.common.business.dto.PlatformInboundDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractThirdWarehouseHandler;
import com.common.business.utils.MD5Util;
import com.common.core.exception.ServiceException;
import com.sdk.wms.iml.convert.ImlConverter;
import com.sdk.wms.iml.dto.request.ImlGetProductReq;
import com.sdk.wms.iml.dto.request.ImlGetReceiptReq;
import com.sdk.wms.iml.dto.response.ImlProductResp;
import com.sdk.wms.iml.dto.response.ImlReceiptResp;
import com.sdk.wms.iml.dto.response.ImlRegionResp;
import com.sdk.wms.iml.dto.response.ImlResponse;
import com.sdk.wms.iml.service.ImlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 艾姆勒拉取入库单数据
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.IML)
@BusinessType(BusinessTypeEnum.INBOUND)
public class ImlInboundHandler extends AbstractThirdWarehouseHandler<ImlReceiptResp, PlatformInboundDTO> {

    @Resource
    private ImlService imlService;

    @Override
    public List<ImlReceiptResp> download(JobTaskDTO data) {
        LocalDateTime lastTime = data.getLastTime();
        LocalDateTime nextTime = data.getNextTime();
        if (lastTime.isEqual(nextTime)){
            //nextTime +30分钟
            nextTime = lastTime.plusMinutes(30);
        }
        //查询数据
        ImlGetReceiptReq imlGetReceiptReq = ImlGetReceiptReq.builder()
                .modifyDateFrom(lastTime.format(formatter))
                .modifyDateTo(nextTime.format(formatter))
                .pageSize(20)
                .build();

        List<ImlReceiptResp> respList = new ArrayList<>();
        int page = 1;
        while (true) {
            imlGetReceiptReq.setPage(page);
            ImlResponse<List<ImlReceiptResp>> response = imlService.getReceiptBatch(imlGetReceiptReq);
            checkResponse(response);
            respList.addAll(response.getData());
            if (response.getCount() <= page * 20) {
                break;
            }
            page++;
        }
        respList.forEach(v->{
            v.setUniqueId(MD5Util.toMD5(getTargetPlatform()+BusinessTypeEnum.CITY_DICT.getCode()+v.getReceivingCode()));
            v.setAuthId(data.getShopId());
        });

        return respList;
    }

    private void checkResponse(ImlResponse<?> response) {
        if (!isSuccess(response.getAsk())) {
            log.error("艾姆勒查询揽收基础数据失败," + response.getMessage());
            throw new ServiceException("艾姆勒查询揽收基础数据失败," + response.getMessage());
        }
    }

    @Override
    public List<PlatformInboundDTO> convert(List<ImlReceiptResp> sourceDataList) {
        return ImlConverter.INSTANCE.inboundConversion(sourceDataList);
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.IML.getCode();
    }

    public boolean isSuccess(String ask){
        return "Success".equals(ask);
    }
}
