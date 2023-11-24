package com.sdk.tms.yanwen.server;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.common.core.enums.ApiError;
import com.erp.model.tms.entity.LogisticsAuthEntity;
import com.sdk.tms.yanwen.constants.YanWenConstants;
import com.sdk.tms.yanwen.dto.request.YanWenCancelOrderRequest;
import com.sdk.tms.yanwen.dto.request.YanWenCreateWayBillRequest;
import com.sdk.tms.yanwen.dto.request.YanWenGetLabelRequest;
import com.sdk.tms.yanwen.dto.request.YanWenQueryOrderRequest;
import com.sdk.tms.yanwen.dto.response.*;
import com.sdk.tms.yanwen.utils.YanWenUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Component
@Validated
public class YanWenService {

    /**
     *  查询全部已开通的渠道
     * @return List<YanWenChannel>
     */
    public YanWenResponse<List<YanWenChannel>> getAllChannel(Map<String,String> map){
        String response = YanWenUtils.sendPost(YanWenConstants.METHOD_CHANNEL_GETLIST,null,map.get("clientId"),map.get("clientSecret"));
        YanWenResponse<List<YanWenChannel>> yanWenResponseDTO;
        try {
            yanWenResponseDTO = JSONObject.parseObject(response,new TypeReference<YanWenResponse<List<YanWenChannel>>>() {}.getType());
        }catch (JSONException e){
            yanWenResponseDTO = YanWenResponse.error(ApiError.ERROR_400.code.toString(),response);
        }

        return yanWenResponseDTO;
    }

    /**
     *  创建运单
     */
    public YanWenResponse<YanWenCreateWayBill> createWayBill(@Valid YanWenCreateWayBillRequest request,Map<String,String> map){
        Map<String, Object> paramsMap = BeanUtil.beanToMap(request);
        String response = YanWenUtils.sendPost(YanWenConstants.METHOD_ORDER_CREATE,paramsMap,map.get("clientId"),map.get("clientSecret"));
        YanWenResponse<YanWenCreateWayBill> yanWenResponseDTO;
        try {
            yanWenResponseDTO = JSONObject.parseObject(response,new TypeReference<YanWenResponse<YanWenCreateWayBill>>() {}.getType());
        }catch (JSONException e){
            yanWenResponseDTO = YanWenResponse.error(ApiError.ERROR_400.code.toString(),response);
        }

        return yanWenResponseDTO;
    }

    /**
     * 打印标签
     */
    public YanWenResponse<YanWenGetLabel> getLabel(@Valid YanWenGetLabelRequest request,Map<String,String> map){
        Map<String, Object> paramsMap = BeanUtil.beanToMap(request);
        String response = YanWenUtils.sendPost(YanWenConstants.METHOD_ORDER_LABEL_GET,paramsMap,map.get("clientId"),map.get("clientSecret"));
        YanWenResponse<YanWenGetLabel> yanWenResponseDTO;
        try {
            yanWenResponseDTO =  JSONObject.parseObject(response,new TypeReference<YanWenResponse<YanWenGetLabel>>() {}.getType());
        }catch (JSONException e){
            yanWenResponseDTO = YanWenResponse.error(ApiError.ERROR_400.code.toString(),response);
        }

        return yanWenResponseDTO;
    }

    /**
     *  取消订单
     */
    public YanWenResponse<String> cancelOrder(@Valid YanWenCancelOrderRequest request,Map<String,String> map){
        Map<String, Object> paramsMap = BeanUtil.beanToMap(request);
        String response = YanWenUtils.sendPost(YanWenConstants.METHOD_ORDER_CANCEL,paramsMap,map.get("clientId"),map.get("clientSecret"));
        YanWenResponse<String> yanWenResponseDTO;
        try {
            yanWenResponseDTO =  JSONObject.parseObject(response,new TypeReference<YanWenResponse<String>>() {}.getType());
        }catch (JSONException e){
            yanWenResponseDTO = YanWenResponse.error(ApiError.ERROR_400.code.toString(),response);
        }

        return yanWenResponseDTO;
    }

    /**
     *  取消订单
     */
    public YanWenResponse<List<YanWenQueryOrder>> queryOrder(@Valid YanWenQueryOrderRequest request,Map<String,String> map){
        Map<String, Object> paramsMap = BeanUtil.beanToMap(request);
        String response = YanWenUtils.sendPost(YanWenConstants.METHOD_ORDER_QUERY,paramsMap,map.get("clientId"),map.get("clientSecret"));
        YanWenResponse<List<YanWenQueryOrder>> yanWenResponseDTO;
        try {
            yanWenResponseDTO =  JSONObject.parseObject(response,new TypeReference<YanWenResponse<List<YanWenQueryOrder>>>() {}.getType());
        }catch (JSONException e){
            yanWenResponseDTO = YanWenResponse.error(ApiError.ERROR_400.code.toString(),response);
        }

        return yanWenResponseDTO;
    }
}
