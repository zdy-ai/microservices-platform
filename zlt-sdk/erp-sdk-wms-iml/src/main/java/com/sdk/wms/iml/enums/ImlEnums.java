package com.sdk.wms.iml.enums;

import com.common.business.enums.InstockStatusEnum;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum ImlEnums {
    PRODUCT_STATUS("productStatus",productStatusEnum.class),
    INCOME_TYPE("incomeType",IncomeTypeEnum.class),
    RECEIVING_STATUS("receivingStatus",ReceivingStatusEnum.class),
    CANCEL_STATUS("cancelStatus",CancelStatusEnum.class),
    ;

    private final String fieldName;
    private final Class<?> enumClz;

    ImlEnums(String fieldName, Class<?> enumClz) {
        this.fieldName = fieldName;
        this.enumClz = enumClz;
    }

    /**
     * 产品状态枚举
     */
    @Getter
    public enum productStatusEnum {
        ABANDONMENT("X","废弃"),
        DRAFT("D","草稿"),
        AVAILABLE("S","可用"),
        UNDER_REVIEW("P","审核中"),
        REVIEW_FAILED("R","审核不通过"),
        ;
        private final String code;
        private final String name;
        productStatusEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 交货方式
     */
    @Getter
    public enum IncomeTypeEnum {
        SELF_DELIVERY(0,"自送"),
        COLLECT(1,"揽收")
        ;
        private final Integer code;
        private final String name;
        IncomeTypeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 入库单状态
     */
    @Getter
    public enum ReceivingStatusEnum {
        NEW("C","新建",InstockStatusEnum.TO_BE_SHIPPED),
        FIRST_JOURNEY_ON_THE_WAY("W","头程在途",InstockStatusEnum.TO_BE_SIGNED),
        INITIAL_RECEIVING("P","头程收货中",InstockStatusEnum.TO_BE_SIGNED),
        IN_TRANSIT("Z","转运中",InstockStatusEnum.TO_BE_SIGNED),
        RECEIVING_DESTINATION_WAREHOUSE("G","目的仓库收货中",InstockStatusEnum.PARTIAL_SIGNED),
        COMPLETION_RECEIVING_DESTINATION_WAREHOUSE("F","目的仓收货完成",InstockStatusEnum.SIGNED),
        COMPLETE_LISTING("E","完成上架",InstockStatusEnum.SIGNED),
        ABANDONMENT("X","废弃",InstockStatusEnum.CANCELED)
        ;
        private final String code;
        private final String name;
        private final InstockStatusEnum instockStatusEnum;
        ReceivingStatusEnum(String code, String name, InstockStatusEnum instockStatusEnum) {
            this.code = code;
            this.name = name;
            this.instockStatusEnum = instockStatusEnum;
        }

        public static String getInstockByCode(String code){
            return Arrays.stream(ReceivingStatusEnum.values())
                    .filter(item -> code.equals(item.getCode()))
                    .findFirst()
                    .map(ReceivingStatusEnum::getInstockStatusEnum)
                    .map(InstockStatusEnum::getCode)
                    .orElse(code);
        }

    }
    /**
     * 取消订单结果
     */
    @Getter
    public enum CancelStatusEnum {
        INTERCEPTING(1,"拦截中"),
        INTERCEPTION_SUCCESSFUL(2,"拦截成功"),
        INTERCEPTION_FAILED(3,"拦截失败"),
        SUCCESSFULLY_INTERCEPTED_BUT_NOT_REFUNDED_FEES(4,"拦截成功但未退费用"),
        ;
        private final Integer code;
        private final String name;
        CancelStatusEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
