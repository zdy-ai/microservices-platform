package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.sdk.tms.disifang.model.base.Address;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ReturnInfo
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class ReturnInfo implements Serializable {

    /**
     * 境内/国内异常处理策略(Y：退件--实际是否支持退件，以及退件策略、费用，参考报价表；N：销毁；U：其他--等待客户指令) 默认值：N；
     * 是
     */
    @JSONField(name = "is_return_on_domestic")
    private String isReturnOnDomestic = "N";
    /**
     * 	境内/国内退件接收地址信息（退件地址非必填；若填写，则姓名/电话/邮编/国家/城市/详细地址均需填写）
     */
    @JSONField(name = "domestic_return_addr")
    private Address  domesticReturnAddr;
    /**
     * 	境外/国外异常处理策略(Y：退件--实际是否支持退件，以及退件策略、费用，参考报价表；N：销毁；U：其他--等待客户指令) 默认值：N；
     */
    @JSONField(name = "is_return_on_oversea")
    private String  isReturnOnOversea = "N";
    /**
     * 	境外/国外退件接收地址信息（退件地址非必填；若填写，则姓名/电话/邮编/国家/城市/详细地址均需填写
     */
    @JSONField(name = "oversea_return_addr")
    private Address  overseaReturnAddr;
}
