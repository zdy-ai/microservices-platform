package com.sdk.wms.iml.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.business.threadlocal.ThirdWarehouseContext;
import com.common.core.exception.ServiceException;
import com.sdk.wms.iml.soap.Ec;
import com.sdk.wms.iml.soap.Ec_Service;
import jodd.util.StringUtil;

public class ImlUtils {

    public static String callService(String service, Object obj){
        Ec_Service ecService = new Ec_Service();
        Ec ec = ecService.getEcSOAP();
        String appToken = String.valueOf(ThirdWarehouseContext.getAuthMap().get("appToken"));
        String appKey = String.valueOf(ThirdWarehouseContext.getAuthMap().get("appKey"));
        if(StringUtil.isBlank(appKey) || StringUtil.isBlank(appToken)){
            throw new ServiceException("获取不到授权值，正确授权值为：appToken,appKey");
        }
        String param = JSON.toJSONString(obj);
        String response =  ec.callService(param,appToken,appKey,service);
        ThirdWarehouseContext.setRequestJson(param);
        ThirdWarehouseContext.setResponseJson(response);
        return response;
    }

}
