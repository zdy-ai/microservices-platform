package com.sdk.tms.express.enums;

import com.sdk.tms.express.service.IServiceCodeStandard;
import com.sf.csim.express.service.PrePathEnum;

/**
 * @Description: 驿站服务类
 * @Date: 2021/10/18 14:57
 * @Version: 1.0
 */
public enum POSTServiceCodeEnum implements IServiceCodeStandard {

    //驿站服务代码
    COM_RECE_EOS_WILLBILLBUSS_130("COM_RECE_EOS_WILLBILLBUSS_130", "POST.1.COM_RECE_EOS_WILLBILLBUSS_130.json"),
    COM_RECE_EOS_WILLBILLBUSS_655("COM_RECE_EOS_WILLBILLBUSS_655", "POST.2.COM_RECE_EOS_WILLBILLBUSS_655.json"),
    COM_RECE_EOS_WILLBILLBUSS_656("COM_RECE_EOS_WILLBILLBUSS_656", "POST.3.COM_RECE_EOS_WILLBILLBUSS_656.json"),
    COM_RECE_EOS_WILLBILLBUSS_657("COM_RECE_EOS_WILLBILLBUSS_657", "POST.4.COM_RECE_EOS_WILLBILLBUSS_657.json"),
    COM_RECE_EOS_WILLBILLBUSS_658("COM_RECE_EOS_WILLBILLBUSS_658", "POST.5.COM_RECE_EOS_WILLBILLBUSS_658.json"),
    COM_RECE_EOS_WILLBILLBUSS_659("COM_RECE_EOS_WILLBILLBUSS_659", "POST.6.COM_RECE_EOS_WILLBILLBUSS_659.json"),
    COM_RECE_EOS_WILLBILLBUSS_STORE_INFO("COM_RECE_EOS_WILLBILLBUSS_STORE_INFO", "POST.7.COM_RECE_EOS_WILLBILLBUSS_STORE_INFO.json"),
    COM_RECE_EOS_QUERY_GRID_INFO("COM_RECE_EOS_QUERY_GRID_INFO", "POST.8.COM_RECE_EOS_QUERY_GRID_INFO.json"),
    COM_RECE_TOAP_SUBMIT_RESOURCE_INFO("COM_RECE_TOAP_SUBMIT_RESOURCE_INFO", "POST.9.COM_RECE_TOAP_SUBMIT_RESOURCE_INFO.json"),
    ;

    private String path;
    private String code;

    POSTServiceCodeEnum(String code, String path){
        this.code = code;
        this.path = path;
    }

    @Override
    public String getPath() {
        return PrePathEnum.POST_PATH.getPath()+this.path;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}
