package com.sdk.tms.track123.constant;

/**
 * @author zdy
 * @ClassName PathConstants
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public interface PathConstants {

    String BASE_URL = "https://api.track123.com";

    //获取快递物流商列表 getCourierList
    String GET_COURIER_URL = "/gateway/open-api/tk/v2/courier/list";
    String GET_TRACK_URL = "/gateway/open-api/tk/v2/track/query";
    String REGISTER_LOGISTICS_NUMBER = "/gateway/open-api/tk/v2/track/import";
}
