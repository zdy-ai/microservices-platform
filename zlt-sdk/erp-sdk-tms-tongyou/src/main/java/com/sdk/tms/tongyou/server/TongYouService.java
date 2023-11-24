package com.sdk.tms.tongyou.server;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.erp.model.tms.entity.LogisticsAuthEntity;
import com.sdk.tms.tongyou.constants.TongYouConstants;
import com.sdk.tms.tongyou.dto.TongYouSignDTO;
import com.sdk.tms.tongyou.dto.request.TongYouCallBackOrderRequest;
import com.sdk.tms.tongyou.dto.request.TongYouCreateOrderRequest;
import com.sdk.tms.tongyou.dto.request.TongYouGetOrderRequest;
import com.sdk.tms.tongyou.dto.request.TongYouPrintLabelRequest;
import com.sdk.tms.tongyou.dto.response.*;
import com.sdk.tms.tongyou.utils.TongYouUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component
@Validated
public class TongYouService {

    /**
     *  查询全部已开通的渠道
     */
    public TongYouResponse<List<TongYouChannel>> getAllChannel(Map<String, String> authMap){
        String response = TongYouUtils.sendPost(TongYouConstants.METHOD_GET_CHANNEL,null,authMap.get("clientSecret"));
        return JSONObject.parseObject(response,new TypeReference<TongYouResponse<List<TongYouChannel>>>() {}.getType());
    }


    /**
     *  创建订单
     */
    public TongYouCreateOrder createOrder(TongYouCreateOrderRequest request,Map<String, String> authMap){
        TongYouSignDTO tongYouSignDTO = TongYouSignDTO.builder()
                .logisticsId(request.getLogisticsId())
                .orderNo(request.getOrderNo())
                .countryCode(request.getRecipient().getCountryCode())
                .telNo(request.getRecipient().getTelNo())
                .address(request.getRecipient().getAddress())
                .city(request.getRecipient().getCity())
                .zip(request.getRecipient().getZip())
                .province(request.getRecipient().getProvince())
                .mobileNo(request.getRecipient().getMobileNo())
                .address3(request.getRecipient().getAddress3())
                .address2(request.getRecipient().getAddress2())
                .contactPerson(request.getRecipient().getContactPerson())
                .build();
        String sign = TongYouUtils.getCreateOrderSign(tongYouSignDTO,authMap.get("clientSecret"));
        Map<String, Object> paramsMap = BeanUtil.beanToMap(request);
        String response = TongYouUtils.sendPost(TongYouConstants.METHOD_CREATE_ORDER,paramsMap,sign,authMap.get("clientSecret"));
        return JSONObject.parseObject(response,TongYouCreateOrder.class);
    }

    /**
     *  回调订单
     */
    public TongYouCallBackOrder callBackOrderInfo(TongYouCallBackOrderRequest request,Map<String, String> authMap){
        String sign = TongYouUtils.getCallBackOrderSign(request.getLogisticsId(),request.getOrderNo(),authMap.get("clientSecret"));
        Map<String, Object> paramsMap = BeanUtil.beanToMap(request);
        String response = TongYouUtils.sendPost(TongYouConstants.METHOD_ORDER_CALL_BACK,paramsMap,sign,authMap.get("clientSecret"));
        return JSONObject.parseObject(response, TongYouCallBackOrder.class);
    }


    /**
     *  打印标签
     */
    public TongYouPrintLabel printLabel(TongYouPrintLabelRequest request,Map<String, String> authMap){
        String sign = TongYouUtils.getPrintLabelSign(request.getLogisticsId(),request.getOrderNo(),request.getTrackNo(),authMap.get("clientSecret"));
        Map<String, Object> paramsMap = BeanUtil.beanToMap(request);
        String response = TongYouUtils.sendPost(TongYouConstants.METHOD_PRINT_LABEL,paramsMap,sign,authMap.get("clientSecret"));
        return JSONObject.parseObject(response,TongYouPrintLabel.class);
    }


    /**
     *  查询订单信息
     */
    public TongYouOrderInfo getOrderInfo(TongYouGetOrderRequest request,Map<String, String> authMap){
        Map<String, Object> paramsMap = BeanUtil.beanToMap(request);
        String response = TongYouUtils.sendPost(TongYouConstants.METHOD_ORDER_GET,paramsMap,authMap.get("clientSecret"));
        return JSONObject.parseObject(response,TongYouOrderInfo.class);
    }
}
