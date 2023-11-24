package com.sdk.wms.iml.handle;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformCityDictDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractThirdWarehouseHandler;
import com.common.business.utils.MD5Util;
import com.common.core.exception.ServiceException;
import com.sdk.wms.iml.convert.ImlConverter;
import com.sdk.wms.iml.dto.request.ImlGetProductReq;
import com.sdk.wms.iml.dto.response.ImlProductResp;
import com.sdk.wms.iml.dto.response.ImlResponse;
import com.sdk.wms.iml.service.ImlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 艾姆勒拉取产品数据
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.IML)
@BusinessType(BusinessTypeEnum.PRODUCT)
public class ImlProductHandler extends AbstractThirdWarehouseHandler<ImlProductResp, PlatformProductDTO> {

    @Resource
    private ImlService imlService;

    @Override
    public List<ImlProductResp> download(JobTaskDTO data) {
        LocalDateTime lastTime = data.getLastTime();
        LocalDateTime nextTime = data.getNextTime();
        if (lastTime.isEqual(nextTime)){
            //nextTime +30分钟
            nextTime = lastTime.plusMinutes(30);
        }

        //查询数据
        ImlGetProductReq imlGetProductReq = new ImlGetProductReq();
        imlGetProductReq.setUpdateStartTime(lastTime.format(formatter));
        imlGetProductReq.setUpdateEndTime(nextTime.format(formatter));
        //最大页码100，从第一页开始查询
        imlGetProductReq.setPageSize(100);

        List<ImlProductResp> respList = new ArrayList<>();
        int page = 1;
        while (true) {
            imlGetProductReq.setPage(page);
            ImlResponse<List<ImlProductResp>> goodCangResponse = imlService.getSkuList(imlGetProductReq);
            checkResponse(goodCangResponse);
            respList.addAll(goodCangResponse.getData());
            if (goodCangResponse.getCount() <= page * 100) {
                break;
            }
            page++;
        }
        respList.forEach(v->v.setUniqueId(MD5Util.toMD5(getTargetPlatform()+BusinessTypeEnum.PRODUCT.getCode()+v.getProductSku())));
        return respList;
    }

    private void checkResponse(ImlResponse<?> response) {
        if (!isSuccess(response.getAsk())) {
            log.error("艾姆勒查询产品数据失败," + response.getMessage());
            throw new ServiceException("艾姆勒查询产品数据失败," + response.getMessage());
        }
    }

    @Override
    public List<PlatformProductDTO> convert(List<ImlProductResp> sourceDataList) {
        return ImlConverter.INSTANCE.productConversion(sourceDataList);
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.IML.getCode();
    }

    public boolean isSuccess(String ask){
        return "Success".equals(ask);
    }
}
