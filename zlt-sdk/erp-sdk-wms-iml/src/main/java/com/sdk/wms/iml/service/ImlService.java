package com.sdk.wms.iml.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sdk.wms.iml.constants.ImlConstants;
import com.sdk.wms.iml.dto.request.*;
import com.sdk.wms.iml.dto.response.*;
import com.sdk.wms.iml.utils.ImlUtils;
import jodd.util.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuruipeng
 */
@Component
@Validated
public class ImlService {

    /**
     * 授权（调用拉取仓库接口，接口调用成功则说明授权成功）
     */
    public ImlResponse<Object> authorization(){
        return ImlResponse.builder().build();
    }

    /**
     * 获取商品列表
     */
    public ImlResponse<List<ImlProductResp>> getSkuList(@Valid ImlGetProductReq imlProductReq){
        String response = ImlUtils.callService(ImlConstants.METHOD_GET_PRODUCT_LIST, imlProductReq);
        return JSONObject.parseObject(response,new TypeReference<ImlResponse<List<ImlProductResp>>>() {}.getType());
    }

    /**
     * 获取仓库列表
     */
    public ImlResponse<List<ImlWarehouseResp>> getWarehouse(ImlBaseRequest imlBaseRequest){
        String response = ImlUtils.callService(ImlConstants.METHOD_GET_WAREHOUSE,imlBaseRequest);
        return JSONObject.parseObject(response,new TypeReference<ImlResponse<List<ImlWarehouseResp>>>() {}.getType());
    }

    /**
     * 获取揽收区域
     */
    public ImlResponse<List<ImlRegionResp>> getReceivingRegion(){
        String response = ImlUtils.callService(ImlConstants.METHOD_GET_RECEIVING_REGION,null);
        return JSONObject.parseObject(response,new TypeReference<ImlResponse<List<ImlRegionResp>>>() {}.getType());
    }

    /**
     * 获取入库单
     */
    public ImlResponse<List<ImlReceiptResp>> getReceiptBatch(@Valid ImlGetReceiptReq imlGetReceiptReq){
        String response = ImlUtils.callService(ImlConstants.METHOD_GET_RECEIPT,imlGetReceiptReq);
        return JSONObject.parseObject(response,new TypeReference<ImlResponse<List<ImlReceiptResp>>>() {}.getType());
    }

    /**
     * 获取库存
     */
    public ImlResponse<List<ImlInventoryResp>> getProductInventory(@Valid ImlGetInventoryReq imlGetInventoryReq){
        String response = ImlUtils.callService(ImlConstants.METHOD_GET_PRODUCT_INVENTORY,imlGetInventoryReq);
        return JSONObject.parseObject(response,new TypeReference<ImlResponse<List<ImlInventoryResp>>>() {}.getType());
    }
    /**
     * 创建入库单
     */
    public ImlResponse<String> createInboundBill(@Valid ImlCreateInboundReq imlGetReceiptReq){
        String response = ImlUtils.callService(ImlConstants.METHOD_CREATE_INBOUND,imlGetReceiptReq);
        ImlResponse<String> respDto = JSONObject.parseObject(response,new TypeReference<ImlResponse<String>>() {}.getType());
        //处理返回值
        if(StringUtil.isNotBlank(respDto.getReceivingCode())){
            respDto.setData(respDto.getReceivingCode());
        }
        return respDto;
    }

    /**
     * 取消入库单
     */
    public ImlResponse<String> cancelInboundBill(@Valid @NotEmpty(message = "入库单号不能为空") String receivingCode){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("receiving_code",receivingCode);
        String response = ImlUtils.callService(ImlConstants.METHOD_CANCEL_INBOUND,paramsMap);
        return JSONObject.parseObject(response,new TypeReference<ImlResponse<String>>() {}.getType());
    }


    /**
     * 创建出库单
     */
    public ImlResponse<String> createOutboundBill(@Valid ImlCreateOutboundReq imlCreateOutboundReq){
        String response = ImlUtils.callService(ImlConstants.METHOD_CREATE_ORDER,imlCreateOutboundReq);
        System.out.println(response);
        ImlResponse<String> respDto = JSONObject.parseObject(response,new TypeReference<ImlResponse<String>>() {}.getType());
        //处理返回值
        if(StringUtil.isNotBlank(respDto.getOrderCode())){
            respDto.setData(respDto.getOrderCode());
        }
        return respDto;
    }

    /**
     * 取消出库单
     */
    public ImlResponse<String> cancelOutboundBill(@Valid @NotEmpty(message = "入库单号不能为空") String orderCode,String reason){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("order_code",orderCode);
        paramsMap.put("reason",reason);
        String response = ImlUtils.callService(ImlConstants.METHOD_CANCEL_ORDER,paramsMap);
        return JSONObject.parseObject(response,new TypeReference<ImlResponse<String>>() {}.getType());
    }
}
