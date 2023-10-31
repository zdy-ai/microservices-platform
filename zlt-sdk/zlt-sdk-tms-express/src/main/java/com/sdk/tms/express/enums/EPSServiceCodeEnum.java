package com.sdk.tms.express.enums;

import com.sdk.tms.express.service.IServiceCodeStandard;
import com.sf.csim.express.service.PrePathEnum;

/**
 * @Description: 快递管家
 * @Date: 2021/10/18 15:15
 * @Version: 1.0
 */
public enum EPSServiceCodeEnum implements IServiceCodeStandard {

    //快递管家
    COM_RECE_EPS_ORDER("COM_RECE_EPS_ORDER", "EPS.1.COM_RECE_EPS_ORDER.json"),
    COM_RECE_EPS_SEARCH_ROUTES("COM_RECE_EPS_SEARCH_ROUTES", "EPS.2.COM_RECE_EPS_SEARCH_ROUTES.json"),
    COM_RECE_EPS_ORDER_UPDTE("COM_RECE_EPS_ORDER_UPDTE", "EPS.3.COM_RECE_EPS_ORDER_UPDTE.json"),
    COM_RECE_EPS_SEARCH_ORDER_RESP("COM_RECE_EPS_SEARCH_ORDER_RESP", "EPS.4.COM_RECE_EPS_SEARCH_ORDER_RESP.json"),
    COM_RECE_EPS_QUERY_SFWAYBILL("COM_RECE_EPS_QUERY_SFWAYBILL", "EPS.5.COM_RECE_EPS_QUERY_SFWAYBILL.json"),
//    COM_PUSH_EPS_ROUTES("COM_PUSH_EPS_ROUTES", "EPS.6.COM_PUSH_EPS_ROUTES.json"),
    ;

    EPSServiceCodeEnum(String code, String path) {
        this.code = code;
        this.path = path;
    }

    private String code;
    private String path;
    @Override
    public String getPath() {
        return PrePathEnum.EPS_PATH.getPath()+this.path;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}
