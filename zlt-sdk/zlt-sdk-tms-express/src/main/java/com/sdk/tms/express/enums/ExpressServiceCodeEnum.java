package com.sdk.tms.express.enums;

import com.sdk.tms.express.constants.PathConstants;
import com.sdk.tms.express.service.IServiceCodeStandard;
import com.sf.csim.express.service.PrePathEnum;

/**
 * @Description: 速运APIServiceCode
 * @Date: 2021/10/18 13:49
 * @Version: 1.0
 */
public enum ExpressServiceCodeEnum implements IServiceCodeStandard {
    /* 下单服务名称 */
    EXP_RECE_CREATE_ORDER("EXP_RECE_CREATE_ORDER", "01.order.json"),
    /* 订单结果查询服务名称 */
    EXP_RECE_SEARCH_ORDER_RESP("EXP_RECE_SEARCH_ORDER_RESP", "02.order.query.json"),
    /* 订单确认、取消服务名称 */
    EXP_RECE_UPDATE_ORDER("EXP_RECE_UPDATE_ORDER", "03.order.confirm.json"),
    /* 订单筛选服务名称 */
    EXP_RECE_FILTER_ORDER_BSP("EXP_RECE_FILTER_ORDER_BSP", "04.order.filter.json"),
    /* 路由查询服务名称 */
    EXP_RECE_SEARCH_ROUTES("EXP_RECE_SEARCH_ROUTES", "05.route_query_by_MailNo.json"),
    /* 子单号申请服务名称*/
    EXP_RECE_GET_SUB_MAILNO("EXP_RECE_GET_SUB_MAILNO", "07.sub.mailno.json"),
    /*清单运费查询服务名称*/
    EXP_RECE_QUERY_SFWAYBILL("EXP_RECE_QUERY_SFWAYBILL", "09.waybills_fee.json"),
    /*路由注册服务名称*/
    EXP_RECE_REGISTER_ROUTE("EXP_RECE_REGISTER_ROUTE", "12.register_route.json"),
    /*退货下单接口名称*/
    EXP_RECE_CREATE_REVERSE_ORDER("EXP_RECE_CREATE_REVERSE_ORDER", "13.reverse_order.json"),
    /*退货消单接口名称*/
    EXP_RECE_CANCEL_REVERSE_ORDER("EXP_RECE_CANCEL_REVERSE_ORDER", "14.cancel_reverse_order.json"),
    /*派件通知接口名称*/
    EXP_RECE_DELIVERY_NOTICE("EXP_RECE_DELIVERY_NOTICE", "15.delivery_notice.json"),
    /*图片注册及推送接口名称*/
    EXP_RECE_REGISTER_WAYBILL_PICTURE("EXP_RECE_REGISTER_WAYBILL_PICTURE", "16.register_waybill_picture.json"),
    /*截单转寄接口*/
    EXP_RECE_WANTED_INTERCEPT("EXP_RECE_WANTED_INTERCEPT", "18.wanted_intercept.json"),
    /*时效标准及价格查询名称*/
    EXP_RECE_QUERY_DELIVERTM("EXP_RECE_QUERY_DELIVERTM", "19.query_delivertm.json"),
    /*云打印面单接口名称*/
    COM_RECE_CLOUD_PRINT_WAYBILLS("COM_RECE_CLOUD_PRINT_WAYBILLS", "20.cloud_print_waybills.json"),
    /*路由上传接口名称*/
    EXP_RECE_UPLOAD_ROUTE("EXP_RECE_UPLOAD_ROUTE", "21.upload_route.json"),
    /*预计派送时间查询接口名称*/
    EXP_RECE_SEARCH_PROMITM("EXP_RECE_SEARCH_PROMITM", "22.search_promitm.json"),
    /*揽件服务时间查询接口名称*/
    EXP_EXCE_CHECK_PICKUP_TIME("EXP_EXCE_CHECK_PICKUP_TIME", "23.check_pickup_time.json"),
    /*运单号合法性校验接口名称*/
    EXP_RECE_VALIDATE_WAYBILLNO("EXP_RECE_VALIDATE_WAYBILLNO", "24.validate_waybillno.json"),
    ;

    ExpressServiceCodeEnum(String code, String path) {
        this.code = code;
        this.path = path;
    }
    private String code;
    private String path;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getPath() {
        return PrePathEnum.EXPRESS_PATH.getPath()+path;
    }

}
