package com.sdk.wms.goodcang.constants;

public class GoodCangConstants {
    public static final String BASE_URL = "https://uat-oms.eminxing.com";
//    public static final String BASE_URL_2 = "https://oms.goodcang.net";
    public static final String METHOD_GET_SKU_LIST = "/public_open/product/get_product_sku_list";
    public static final String METHOD_GET_WAREHOUSE = "/public_open/base_data/get_warehouse";
    public static final String METHOD_GET_RECEIPT_BATCH = "/public_open/inbound_order/get_receipt_batch";
    public static final String METHOD_GET_SMCODE_TWC_TO_WAREHOUSE = "/public_open/inbound_order/get_smcode_twc_to_warehouse";
    public static final String METHOD_GET_CREATE_INBOUND_BILL = "/public_open/inbound_order/create_grn";
    public static final String METHOD_GET_CANCEL_INBOUND_BILL = "/public_open/inbound_order/del_grn";
    public static final String METHOD_GET_CREATE_OUTBOUND_BILL = "/public_open/order/create_order";
    public static final String METHOD_GET_CANCEL_OUTBOUND_BILL = "/public_open/order/cancel_order";
    public static final String METHOD_GET_PRODUCT_INVENTORY = "/public_open/inventory/get_product_inventory";
    public static final String METHOD_GET_RECEIPT = "/public_open/inbound_order/get_grn_list";
}
