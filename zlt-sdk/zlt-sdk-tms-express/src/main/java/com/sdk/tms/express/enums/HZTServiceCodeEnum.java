package com.sdk.tms.express.enums;

import com.sdk.tms.express.service.IServiceCodeStandard;
import com.sf.csim.express.service.PrePathEnum;

/**
 * @Author: 800005
 * @Description: 函证通服务代码
 * @Date: 20221/02/22 22:22
 * @Version: 1.0
 */
public enum HZTServiceCodeEnum implements IServiceCodeStandard {

    //函证通
	COM_RECE_HZTSA_BATCH_CREATE_WAYBILLS("COM_RECE_HZTSA_BATCH_CREATE_WAYBILLS", "HZT.1.COM_RECE_HZTSA_BATCH_CREATE_WAYBILLS.json"),
	COM_RECE_HZTSA_CREATE_ORDER("COM_RECE_HZTSA_CREATE_ORDER", "HZT.2.COM_RECE_HZTSA_CREATE_ORDER.json"),
	COM_RECE_HZTSA_PLACE_ORDERS("COM_RECE_HZTSA_PLACE_ORDERS", "HZT.3.COM_RECE_HZTSA_PLACE_ORDERS.json"),
	COM_RECE_HZTSA_CANCEL_ORDER("COM_RECE_HZTSA_CANCEL_ORDERS", "HZT.4.COM_RECE_HZTSA_CANCEL_ORDER.json"),
	COM_RECE_HZTSA_SEARCH_ROUTES("COM_RECE_HZTSA_SEARCH_ROUTES", "HZT.5.COM_RECE_HZTSA_SEARCH_ROUTES.json"),
	COM_PUSH_HZTSA_EXPRESS_IMG_LETTER("COM_PUSH_HZTSA_EXPRESS_IMG_LETTER", "HZT.6.COM_RECE_HZTSA_SEARCH_EXPRESS_IMG.json"),
 
    ;

    HZTServiceCodeEnum(String code, String path) {
        this.code = code;
        this.path = path;
    }

    private String code;
    private String path;
    @Override
    public String getPath() {
        return PrePathEnum.HZT_PATH.getPath()+this.path;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}
