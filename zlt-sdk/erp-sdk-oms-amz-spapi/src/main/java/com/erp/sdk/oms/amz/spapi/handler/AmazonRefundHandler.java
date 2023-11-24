package com.erp.sdk.oms.amz.spapi.handler;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformRefundDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractOrderHandler;
import com.common.business.handler.AbstractRefundHandler;
import com.erp.sdk.oms.amz.spapi.dto.PlatformAmazonRefundDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 亚马逊退款订单处理器
 *
 * @Author Cloud
 * @Date 2023/8/31 15:48
 **/
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.AMAZON)
@BusinessType(BusinessTypeEnum.REFUND)
public class AmazonRefundHandler extends AbstractRefundHandler<PlatformAmazonRefundDTO, PlatformRefundDTO> {

    @Override
    public List<PlatformAmazonRefundDTO> download(JobTaskDTO data) {

        // TODO: 亚马逊订单下载

        // 返回下载源数据
        return null;
    }


    @Override
    public List<PlatformRefundDTO> convert(List<PlatformAmazonRefundDTO> sourceDataList) {

        // TODO: 亚马逊订单转换为发送mq数据
        // 包含数据过滤数据 数据转换 数据合并拆分等操作
        return null;
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.AMAZON.getCode();
    }
}
