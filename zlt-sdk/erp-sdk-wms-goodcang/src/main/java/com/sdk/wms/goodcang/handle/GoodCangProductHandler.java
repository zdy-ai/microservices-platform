package com.sdk.wms.goodcang.handle;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractThirdWarehouseHandler;
import com.common.business.utils.MD5Util;
import com.common.core.exception.ServiceException;
import com.sdk.wms.goodcang.convert.GoodCangConverter;
import com.sdk.wms.goodcang.dto.request.GoodCangGetSkuReq;
import com.sdk.wms.goodcang.dto.response.GoodCangResponse;
import com.sdk.wms.goodcang.dto.response.GoodCangSkuResp;
import com.sdk.wms.goodcang.service.GoodCangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 谷仓拉取产品数据
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.GOOD_CANG)
@BusinessType(BusinessTypeEnum.PRODUCT)
public class GoodCangProductHandler extends AbstractThirdWarehouseHandler<GoodCangSkuResp, PlatformProductDTO> {

    @Resource
    private GoodCangService goodCangService;

    @Override
    public List<GoodCangSkuResp> download(JobTaskDTO data) {
        LocalDateTime lastTime = data.getLastTime();
        LocalDateTime nextTime = data.getNextTime();
        if (lastTime.isEqual(nextTime)){
            //nextTime +30分钟
            nextTime = lastTime.plusMinutes(30);
        }

        //查询数据
        GoodCangGetSkuReq goodCangGetSkuReq = new GoodCangGetSkuReq();
        goodCangGetSkuReq.setProductUpdateTimeFrom(lastTime.format(formatter));
        goodCangGetSkuReq.setProductUpdateTimeTo(nextTime.format(formatter));
        //最大页码200，从第一页开始查询
        goodCangGetSkuReq.setPageSize(200);

        List<GoodCangSkuResp> respList = new ArrayList<>();
        int page = 1;
        while (true) {
            goodCangGetSkuReq.setPage(page);
            GoodCangResponse<List<GoodCangSkuResp>> goodCangResponse = goodCangService.getSkuList(goodCangGetSkuReq);
            checkResponse(goodCangResponse);
            respList.addAll(goodCangResponse.getData());
            if (goodCangResponse.getCount() <= page * 200) {
                break;
            }
            page++;
        }
        respList.forEach(v->v.setUniqueId(MD5Util.toMD5(getTargetPlatform()+v.getProductSku())));
        return respList;
    }

    private void checkResponse(GoodCangResponse<?> response) {
        if (!isSuccess(response.getAsk())) {
            log.error("谷仓查询产品数据失败," + response.getMessage());
            throw new ServiceException("谷仓查询产品数据失败," + response.getMessage());
        }
    }

    @Override
    public List<PlatformProductDTO> convert(List<GoodCangSkuResp> sourceDataList) {
        return GoodCangConverter.INSTANCE.productConversion(sourceDataList);
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.GOOD_CANG.getCode();
    }

    public boolean isSuccess(String ask){
        return "Success".equals(ask);
    }
}
