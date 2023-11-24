package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName LogisticsServiceInfo
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class LogisticsServiceInfo implements Serializable {
    /**
     * 物流产品代码(点击查看详情)
     * 是
     */
    @NotBlank(message = "物流产品代码不能为空")
    @JSONField(name = "logistics_product_code")
    private String logisticsProductCode;
    /**
     * 单独报关（Y：单独报关；N：不单独报关） 默认值：N
     */
    @JSONField(name = "customs_service")
    private String customsService;
    /**
     * 签名服务（Y/N)；默认值：N
     */
    @JSONField(name = "signature_service")
    private String signatureService;
    /**
     * 	其他服务（待完善)
     */
    @JSONField(name = "value_added_services")
    private String valueAddedServices;
}
