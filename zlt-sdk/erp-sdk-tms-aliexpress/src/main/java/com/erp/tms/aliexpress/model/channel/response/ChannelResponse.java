package com.erp.tms.aliexpress.model.channel.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author zdy
 * @ClassName ChannelResponse
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class ChannelResponse {
    /**
     * 推荐显示排序
     */
    @JSONField(name = "recommend_order")
    private Integer recommendOrder;
    /**
     * 物流追踪号码校验规则，采用正则表达
     */
    @JSONField(name = "tracking_no_regex")
    private String trackingNoRegex;
    /**
     * 最小处理时间
     */
    @JSONField(name = "min_process_day")
    private Integer minProcessDay;
    /**
     * 物流公司
     */
    @JSONField(name = "logistics_company")
    private String logisticsCompany;
    /**
     * 最大处理时间
     */
    @JSONField(name = "max_process_day")
    private Integer maxProcessDay;
    /**
     * 展示名称
     */
    @JSONField(name = "display_name")
    private String displayName;
    /**
     * 物流服务key
     */
    @JSONField(name = "service_name")
    private String serviceName;
}
