package com.sdk.oms.shopee.constants;

/**
 * @author zdy
 * @ClassName ShopeeApiConstant
 * @description: 调用api接口
 * @date 2023年10月18日
 * @version: 1.0
 */
public interface ShopeeConstants {

    static String host = "https://partner.test-stable.shopeemobile.com";
//    static String host = "https://openplatform.shopee.cn/";
    static String redirect_url = "https://5e30-43-154-173-250.ngrok-free.app/return";
//    static long partner_id = 2006582;
    static long partner_id = 1070627L;
//    static long shop_id = 497438607;
    static long shop_id = 94083;
    static long main_account_id = 863141;
    static long merchant_id = 1007894L;
    //    static long update_time_from = 1611311600L;
//    static long update_time_to = 1696816269L;
    //page_size,update_time_from,update_time_to
    static int pageSize = 10;

    static String offset = "AAAAFA==";
    static String time_range_field = "create_time";
    static String code = "6f56774a41507076474a6151577a4f57";
    static String access_token = "564969706d64574e41666e716c6c7369";
    static String shop_access_token = "564969706d64574e41666e716c6c7369";
    static String shop_refresh_token = "564969706d64574e41666e716c6c7369";
    static String refresh_token = "56797a76526d4d5a4942586c70487a46";
    static String tmp_partner_key = "5975757847654870727869546f436e696f4b454d466a74586f46696555466348";
//    static String tmp_partner_key = "436568524178574244445975595377664f574e6b536d786b7256744158715974";
}
