package com.erp.sdk.oms.amz.spapi.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.common.business.constant.MongoTableNameContant;
import com.common.core.exception.ServiceException;
import com.erp.sdk.oms.amz.spapi.csv.ReportFbaInventoryPlanningCsvEntity;
import com.erp.sdk.oms.amz.spapi.csv.ReportFbaMyiAllInventoryCsvEntity;
import com.erp.sdk.oms.amz.spapi.csv.ReportListingCsvEntity;
import com.erp.sdk.oms.amz.spapi.csv.ReportReservedCsvEntity;
import com.erp.sdk.oms.amz.spapi.dto.*;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 亚马逊SP-API中使用的报告类型
 * <a href="https://developer-docs.amazon.com/sp-api/docs/inventory-reports-attributes">来源链接</a>
 *
 * @author Jim
 * @date 2023/10/17 10:13
 */
@Getter
@AllArgsConstructor
public enum AmazonReportRecordTypeEnum {
    // 库存报告类型值
    // https://developer-docs.amazon.com/sp-api/docs/report-type-values-inventory
//    GET_FLAT_FILE_OPEN_LISTINGS_DATA("GET_FLAT_FILE_OPEN_LISTINGS_DATA", "库存报告", false, "", null),
//    GET_MERCHANT_LISTINGS_ALL_DATA("GET_MERCHANT_LISTINGS_ALL_DATA", "所有商品信息报告", false, MongoTableNameContant.REPORT_AMAZON_LISTING, ReportListingCsvEntity.class, ReportListingMongoDTO.class),
    GET_MERCHANT_LISTINGS_DATA("GET_MERCHANT_LISTINGS_DATA", "在售商品报告", false, MongoTableNameContant.REPORT_AMAZON_LISTING, ReportListingCsvEntity.class, ReportListingMongoDTO.class),
//    GET_MERCHANT_LISTINGS_INACTIVE_DATA("GET_MERCHANT_LISTINGS_INACTIVE_DATA", "非在售商品报告", false, "", null),
//    GET_MERCHANT_LISTINGS_DATA_BACK_COMPAT("GET_MERCHANT_LISTINGS_DATA_BACK_COMPAT", "表符分隔的库存模板文件在售商品报告", false, "", null),
//    GET_MERCHANT_LISTINGS_DATA_LITE("GET_MERCHANT_LISTINGS_DATA_LITE", "在售商品报告精简版（仅包含数量大于零的商品的 SKU、ASIN、价格和数量字段）", false, "", null),
//    GET_MERCHANT_LISTINGS_DATA_LITER("GET_MERCHANT_LISTINGS_DATA_LITER", "在售商品报告精简版（仅包含数量大于零的商品的 SKU 和数量字段。）", false, "", null),
//    GET_MERCHANT_CANCELLED_LISTINGS_DATA("GET_MERCHANT_CANCELLED_LISTINGS_DATA", "已取消商品报告", false, "", null),
//    GET_MERCHANTS_LISTINGS_FYP_REPORT("GET_MERCHANTS_LISTINGS_FYP_REPORT", "禁止显示商品报告", false, "", null),
//    GET_PAN_EU_OFFER_STATUS("GET_PAN_EU_OFFER_STATUS", "欧洲整合服务资格：亚马逊物流 ASIN", false, "", null),
//    GET_MFN_PANEU_OFFER_STATUS("GET_MFN_PANEU_OFFER_STATUS", "欧洲整合服务资格：自配送 ASIN", false, "", null),
//    GET_REFERRAL_FEE_PREVIEW_REPORT("GET_REFERRAL_FEE_PREVIEW_REPORT", "销售佣金预览报告", false, "", null),

    // 亚马逊物流 (FBA) 报告类型值
    // https://developer-docs.amazon.com/sp-api/docs/report-type-values-fba
    // 亚马逊物流库存报告
    GET_FBA_MYI_ALL_INVENTORY_DATA("GET_FBA_MYI_ALL_INVENTORY_DATA", "亚马逊物流管理库存 - 已存档", true, MongoTableNameContant.REPORT_AMAZON_FBA_MYI_ALL_INVENTORY, ReportFbaMyiAllInventoryCsvEntity.class, ReportFbaMyiAllInventoryMongoDTO.class),
    GET_RESERVED_INVENTORY_DATA("GET_RESERVED_INVENTORY_DATA", "亚马逊物流预留库存报告", true, MongoTableNameContant.REPORT_AMAZON_RESERVED,ReportReservedCsvEntity.class, ReportReservedMongoDTO.class),
    GET_FBA_INVENTORY_PLANNING_DATA("GET_FBA_INVENTORY_PLANNING_DATA", "亚马逊物流管理库存状况报告", true, MongoTableNameContant.REPORT_AMAZON_FBA_INVENTORY_PLANNING, ReportFbaInventoryPlanningCsvEntity.class, ReportFbaInventoryPlanningMongoDTO.class),

    ;

    /**
     * 商城编号
     */
    @EnumValue
    @JsonValue
    private final String recordType;

    /**
     * 名称
     */
    private final String name;

    /**
     * 是否直接保存mongo? true = 是， false=否
     */
    private final boolean directSaveMongo;

    /**
     * mongo表名
     */
    private final String mongoTableName;

    /**
     * CSV实体
     */
    private final Class<?> cvsClass;

    /**
     * mongo表实体
     */
    private final Class<?> mongoDTOClass;


    /**
     * 通过reportType字符串查询枚举类型
     */
    public static AmazonReportRecordTypeEnum getByRecordType(String reportType) {
        return Stream.of(AmazonReportRecordTypeEnum.values())
                .filter(e -> e.getRecordType().equalsIgnoreCase(reportType))
                .findFirst()
                .orElse(null)
                ;
    }

    /**
     * 获取和检查mongo
     */
    public Class<?> getAndCheckMongoDTOClass() {
        if (null == this.getMongoDTOClass()) {
            throw new ServiceException("未找到对应mongo表实体, recordType=" + this.recordType);
        }
        return this.mongoDTOClass;
    }

    /**
     * 库存相关报告
     */
    public static List<String> getInventoryReportList() {
        return Stream.of(GET_FBA_MYI_ALL_INVENTORY_DATA,
                        GET_RESERVED_INVENTORY_DATA,
                        GET_FBA_INVENTORY_PLANNING_DATA)
                .map(AmazonReportRecordTypeEnum::getRecordType)
                .collect(Collectors.toList());
    }
}
