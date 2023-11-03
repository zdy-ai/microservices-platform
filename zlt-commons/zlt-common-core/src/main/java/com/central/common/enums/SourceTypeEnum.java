package com.central.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@NoArgsConstructor
public enum SourceTypeEnum {
    SELF_ADD("selfAdd", "手动新增",""),


    //SCM
    PURCHASE_ORDER("purchaseOrder", "采购订单","purchase_order"),
    PURCHASE_APPLICATION("purchaseApplication", "采购申请单","purchase_application"),
    SUBCONTRACT_ORDER("subcontractOrder", "委外订单","subcontract_order"),
    SUBCONTRACT_CHANGE("subcontractChange", "委外变更","subcontract_change"),
    PURCHASE_PRICE_CHANGE("purchasePriceChange", "采购价变更","purchase_price_change"),
    SALES_DEMAND("salesDemand", "备货申请","sales_demand"),
    PURCHASE_CHANGE("purchaseChange", "采购变更","purchase_change"),
    PURCHASE_PRICE("purchasePrice", "采购价目表","purchase_price"),
    SUPPLIER("supplier", "供应商列表","supplier"),


    //WMS
    PO_INSTOCK("poInstock", "采购入库单","po_instock"),
    QC_INFO("qcInfo", "质检单","qc_info"),
    PO_RETURN("poReturn", "采购退货单","po_return"),
    PO_RETURN_DETAIL("poReturnDetail", "采购退货单详情","po_return_detail"),
    PO_RECEIVE("poReceive", "仓库签收单","po_receive"),
    TRANSFER_APPLICATION("transferApplication", "调拨申请单","transfer_application"),
    SO_RETURN_NOTICE("soReturnNotice", "销售退货通知单","so_return_notice"),
    SO_RETURN_RECEIVE("soReturnReceive", "销售退货签收单","so_return_receive"),
    SO_RETURN_INSTOCK("soReturnInstock", "销售退货入库单","so_return_instock"),
    SO_DELIVERY_NOTICE("soDeliveryNotice", "销售发货通知单","so_delivery_notice"),
    TRANSFER_OUT("transferOut", "分布式调出单","transfer_out"),
    TRANSFER_INFO("transferInfo", "直接调拨单","transfer_info"),
    MACHINE_INFO("machineInfo", "加工单","machine_info"),
    SO_OUTSTOCK("soOutstock", "销售出库单","so_outstock"),
    STOCKTAKING_TASK("stocktakingTask", "盘点任务单","stocktaking_task"),
    STOCKTAKING_PLAN("stocktakingPlan", "盘点计划单","stocktaking_plan"),
    OTHER_INSTOCK("otherInstock", "其他入库","other_instock"),
    OTHER_OUTSTOCK("otherOutstock", "其他出库","other_outstock"),
    WAREHOUSE("warehouse", "仓库","warehouse"),

    STOCKTAKING_PROFIT_LOSS("stocktakingTaskProfitLoss", "盘盈盘亏单","stocktaking_profit_loss"),



    //OMS
    SO_RETURN("soReturn", "销售退货订单","so_return"),
    SO_INFO("soInfo", "销售订单","so_info"),
    SO_CHANGE("soChange", "销售变更单","so_change"),
    CUSTOMER_INFO( "customerInfo", "客户表","customer_info"),
    SO_B2C( "soB2c", "B2C销售订单","so_b2c"),
    CUSTOMER_B2C( "customerB2c", "B2C客户表","customer_b2c"),
    SHOP( "shop", "店铺","shop_info"),
    CUSTOMER_CONTACT( "customerContact", "客户联系人","customer_contact"),
    CUSTOMER_GROUP( "customerGroup", "客户分组","customer_group"),
    LISTING_INFO( "listingInfo", "产品信息","listing_info"),
    //Kingdee
    SAL_RETURNSTOCK("SAL_RETURNSTOCK", "金蝶销售退货单",""),
    SAL_OUTSTOCK("SAL_OUTSTOCK", "金蝶销售出库单",""),
    STK_TRANSFERDIRECT("STK_TransferDirect", "金蝶直接调拨单",""),
    BD_RATE("BD_Rate", "汇率列表",""),


    // PLM
    PRODUCT_BOM_INFO("productBomInfo", "BOM管理","product_bom_info"),
    PRODUCT_COMBINATION("productCombination", "组合产品",""),

    PRODUCT_DETAIL("productDetail", "产品管理","product_detail"),
    PROJECT_TASK("projectTask", "任务列表","project_task"),
    PRODUCT_CHANGE("productChange", "变更管理","product_change"),
    BASIC_CATEGORY("basicCategory", "产品分类","basic_category"),

    //SYS
    SYS_DEPARTMENT("sysDepartment", "部门","sys_department"),
    SYS_USER_INFO("sysUserInfo", "用户","sys_user_info"),

    //Mabang
    MABANG_FBA_DELIVERY("MB_FBA_DELIVERY", "马帮FBA发货单",""),

    ;

    /**
     * 类型
     */
    @EnumValue
    @JsonValue
    private String code;
    /**
     * 名称
     */
    private String name;

    private String tableName;

    SourceTypeEnum(String type, String name, String tableName) {
        this.code = type;
        this.name = name;
        this.tableName = tableName;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getTableName() {
        return tableName;
    }

    public static String getName(String type) {
        for (SourceTypeEnum sourceTypeEnum : SourceTypeEnum.values()) {
            if (type.equals(sourceTypeEnum.getCode())) {
                return sourceTypeEnum.getName();
            }
        }
        return "";
    }

    public static SourceTypeEnum getEnum(String type) {
        for (SourceTypeEnum sourceTypeEnum : SourceTypeEnum.values()) {
            if (type.equals(sourceTypeEnum.getCode())) {
                return sourceTypeEnum;
            }
        }
        return null;
    }

    public static SourceTypeEnum getByCode(String code) {
        return Arrays.stream(SourceTypeEnum.values()).filter(r -> Objects.equals(r.getCode(), code)).findFirst().orElse(null);
    }
}
