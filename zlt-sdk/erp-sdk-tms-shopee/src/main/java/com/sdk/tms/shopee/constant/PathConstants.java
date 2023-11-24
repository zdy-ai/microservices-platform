package com.sdk.tms.shopee.constant;

/**
 * @author zdy
 * @ClassName PathConstants
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
public interface PathConstants {

    String HOST = "https://openplatform.shopee.cn";
    //获取渠道列表
    String GET_CHANNEL_LIST_URL = "/api/v2/logistics/get_channel_list";
    //获取跟踪号码列表
    String GET_TRACK_NUMBER_LIST_URL = "/api/v2/first_mile/get_tracking_number_list";
    //单个获取运单号
    String GET_TRACK_NUMBER_URL = "/api/v2/logistics/get_tracking_number";

}
