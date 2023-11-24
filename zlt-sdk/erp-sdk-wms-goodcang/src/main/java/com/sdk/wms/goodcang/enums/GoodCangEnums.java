package com.sdk.wms.goodcang.enums;

import lombok.Getter;

@Getter
public enum GoodCangEnums {
    CONTAIN_BATTERY("containBattery",GoodsAttributeEnum.class),
    TYPE_OF_GOODS("typeOfGoods",ProductPackageTypeEnum.class),
    CAT_LANG("catLang",LanguageEnum.class),
    HEAD_TYPE("headType",HeadTypeEnum.class),
    SKU_WRAPPER_TYPE("skuWrapperType",ProductSkuWrapperTypeEnum.class),
    RECEIVING_STATUS("receivingStatus",OpenReceivingStatusEnum.class),
    TRANSIT_TYPE("transitType",OpenTransitTypeEnum.class),
    RECEIVING_SHIPPING_TYPE("receivingShippingType",ProductCodeEnum.class),
    CUSTOMS_TYPE("customsType",CustomsTypeNewEnum.class),
    COLLECTING_SERVICE("collectingService",OpenCollectingServiceEnum.class),
    BUSINESS_TYPE("businessType",OrderBusinessTypeEnum.class),
    LOGISTICS_RECOMMENDATION_OPTION("logisticsRecommendationOption",NewLogisticsTimelinessEnum.class),
    LABEL_REPLACEMENT_OPTION("labelReplacementOption",FbaOrderLabelReplacementOptionEnum.class),
    CUSTOMER_PACKAGE_REQUIREMENT("customerPackageRequirement",PackageReqEnum.class),
    PRODUCT_FREEZE_STATUS("productFreezeStatus",InventoryProductFreezeStatusEnum.class),
    CANCEL_STATUS("cancelStatus",OrderCancelStatusEnum.class),
    ;

    private final String fieldName;
    private final Class<?> enumClz;

    GoodCangEnums(String fieldName, Class<?> enumClz) {
        this.fieldName = fieldName;
        this.enumClz = enumClz;
    }

    /**
     * 货物属性枚举
     */
    @Getter
    public enum GoodsAttributeEnum {
        GENERAL_CARGO(0,"普货"),
        INCLUDING_BATTERY(1,"含电池"),
        PURE_BATTERY(2,"纯电池"),
        TEXTILE(3,"纺织品"),
        FRAGILE_PRODUCTS(4,"易碎品"),
        EXCEEDING_STANDARD_PURE_BATTERIES(6,"超标纯电池"),
        EXCEEDING_STANDARD_WITH_BATTERIES(7,"超标含电池")
        ;
        private final Integer code;
        private final String name;
        GoodsAttributeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 包裹类型枚举
     */
    @Getter
    public enum ProductPackageTypeEnum {
        PACKAGE(0,"包裹"),
        ENVELOPE(1,"信封")
        ;
        private final Integer code;
        private final String name;

        ProductPackageTypeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 包裹类型枚举
     */
    @Getter
    public enum LanguageEnum {
        ZH("zh","中文"),
        EN("en","英文")
        ;
        private final String code;
        private final String name;

        LanguageEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 头程类型
     */
    @Getter
    public enum HeadTypeEnum {
        ZH("GC","谷仓头程"),
        EN("MJ","卖家直发")
        ;
        private final String code;
        private final String name;

        HeadTypeEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * SKU包装属性
     */
    @Getter
    public enum ProductSkuWrapperTypeEnum {
        PRE_PACKAGING(1,"预包装"),
        SALES_PACKAGING(2,"销售包装"),
        ORIGINAL_PACKAGING_COLOR_BOX(3,"原包彩盒")
        ;
        private final Integer code;
        private final String name;

        ProductSkuWrapperTypeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 入库单状态
     */
    @Getter
    public enum OpenReceivingStatusEnum {
        DRAFT(0,"草稿"),
        PENDING_REVIEW(1,"待审核"),
        REVIEW_FAILED(2,"审核不通过"),
        TRANSFER_WAREHOUSE_TO_BE_SIGNED(3,"中转仓待签收"),
        TRANSFER_WAREHOUSE_TO_BE_RECEIVED(4,"中转仓待收货"),
        TRANSIT_WAREHOUSE_WAITING_DISTRIBUTION(5,"中转仓待配货"),
        TRANSIT_WAREHOUSE_TO_BE_SHIPPED(6,"中转仓待发货"),
        OVERSEAS_WAREHOUSE_IN_TRANSIT(7,"海外仓在途"),
        RECEIVING_FROM_OVERSEAS_WAREHOUSES(8,"海外仓收货中"),
        COMPLETION_OVERSEAS_WAREHOUSE_RECEIPT(9,"海外仓收货完成"),
        COMPLETION_OF_OVERSEAS_WAREHOUSE_LISTING(10,"海外仓上架完成"),
        ABANDONMENT(100,"废弃"),
        ;
        private final Integer code;
        private final String name;

        OpenReceivingStatusEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 入库单类型
     */
    @Getter
    public enum OpenTransitTypeEnum {
        STANDARD_RECEIPT(0,"标准入库单"),
        TRANSFER_RECEIPT(3,"中转入库单(标准货运单)"),
        FBA_WAREHOUSE_RECEIPT(5,"FBA入库单"),
        ;
        private final Integer code;
        private final String name;

        OpenTransitTypeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 运输方式
     */
    @Getter
    public enum ProductCodeEnum {
        AIR_TRANSPORT(0,"空运"),
        SEA_FREIGHT_BULK_CARGO(1,"海运散货"),
        EXPRESS(2,"快递"),
        RAIL_TRANSPORT_FULL_CONTAINER(3,"铁运整柜"),
        OCEAN_FREIGHT_FULL_CONTAINER(4,"海运整柜"),
        RAIL_FREIGHT_BULK_CARGO(5,"铁运散货")
        ;
        private final Integer code;
        private final String name;

        ProductCodeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 报关方式
     */
    @Getter
    public enum CustomsTypeNewEnum {
        AGENCY_CUSTOMS_DECLARATION(0,"贸易代理报关"),
        REFUND_CUSTOMS_DECLARATION(1,"退税报关"),
        SELF_CUSTOMS_DECLARATION(2,"报关自理")
        ;
        private final Integer code;
        private final String name;

        CustomsTypeNewEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 揽收服务
     */
    @Getter
    public enum OpenCollectingServiceEnum {
        SELF_DELIVERED_GOODS(0,"自送货物"),
        PICK_UP(1,"上门提货")
        ;
        private final Integer code;
        private final String name;

        OpenCollectingServiceEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 配送方式
     */
    @Getter
    public enum OrderBusinessTypeEnum {
        SELF_DELIVERED_GOODS(0,"仓配一体"),
        PICK_UP(1,"仓配分离")
        ;
        private final Integer code;
        private final String name;

        OrderBusinessTypeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }
    /**
     * 物流优选时效枚举选项
     */
    @Getter
    public enum NewLogisticsTimelinessEnum {
        ONE_TO_THREE_DAY(1,"预估1-3个工作日"),
        THREE_TO_SIX_DAY(2,"预估3-6个工作日"),
        LEAST_SIX_DAY(3,"预估6个工作日以上"),
        FASTEST_ESTIMATION_TIME(4,"预估时效最快"),
        ESTIMATED_COST_SAVINGS(5,"预估费用最省")
        ;
        private final Integer code;
        private final String name;

        NewLogisticsTimelinessEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 换标要求
     */
    @Getter
    public enum FbaOrderLabelReplacementOptionEnum {
        ONE_TO_THREE_DAY(1,"外箱"),
        THREE_TO_SIX_DAY(2,"内箱")
        ;
        private final Integer code;
        private final String name;

        FbaOrderLabelReplacementOptionEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 订单包装要求
     */
    @Getter
    public enum PackageReqEnum {
        CARTON(1,"纸箱"),
        EXPRESS_BAG(2,"快递袋"),
        BUBBLE_BAG(3,"气泡袋"),
        ENVIRONMENTALLY_FRIENDLY_BAGS(4,"环保袋")
        ;
        private final Integer code;
        private final String name;

        PackageReqEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 商品冻结状态
     */
    @Getter
    public enum InventoryProductFreezeStatusEnum {
        NORMAL(0,"正常"),
        FREEZE(1,"冻结"),
        THAWING(2,"解冻")
        ;
        private final Integer code;
        private final String name;

        InventoryProductFreezeStatusEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 商品冻结状态
     */
    @Getter
    public enum OrderCancelStatusEnum {
        SUCCESSFUL(2,"拦截成功"),
        FAILED(3,"拦截失败")
        ;
        private final Integer code;
        private final String name;

        OrderCancelStatusEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
