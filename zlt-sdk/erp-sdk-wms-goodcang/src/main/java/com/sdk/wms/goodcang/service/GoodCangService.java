package com.sdk.wms.goodcang.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sdk.wms.goodcang.constants.GoodCangConstants;
import com.sdk.wms.goodcang.dto.request.*;
import com.sdk.wms.goodcang.dto.response.*;
import com.sdk.wms.goodcang.utils.GoodCangUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Component
@Validated
public class GoodCangService {

    /**
     * 授权（调用拉取仓库接口，接口调用成功则说明授权成功）
     */
    public GoodCangResponse<Object> authorization(){
        return GoodCangResponse.builder().build();
    }

    /**
     * 获取商品列表
     */
    public GoodCangResponse<List<GoodCangSkuResp>> getSkuList(@Valid GoodCangGetSkuReq goodCangGetSkuReq){
        String json = JSON.toJSONString(goodCangGetSkuReq);
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_SKU_LIST,json);
        return JSONObject.parseObject(response,new TypeReference<GoodCangResponse<List<GoodCangSkuResp>>>() {}.getType());
    }

    /**
     * 获取仓库列表
     */
    public GoodCangResponse<List<GoodCangWarehouseResp>> getWarehouse(){
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_WAREHOUSE,new HashMap<>());
        return JSONObject.parseObject(response,new TypeReference<GoodCangResponse<List<GoodCangWarehouseResp>>>() {}.getType());
    }

    /**
     * 获取物流产品与目的仓中转仓
     */
    public GoodCangResponse<GoodCangLogisticsAndWarehouseResp> getSmCodeTwcToWarehouse(){
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_SMCODE_TWC_TO_WAREHOUSE,new HashMap<>());
        return JSONObject.parseObject(response,new TypeReference<GoodCangResponse<GoodCangLogisticsAndWarehouseResp>>() {}.getType());
    }

    /**
     * 获取收货批次
     * @param receivingCode 入库单号
     */
    public GoodCangResponse<GoodCangReceiptBatchResp> getReceiptBatch(@Valid @NotEmpty String receivingCode){
        Map<String,Object> paramsMap = new HashMap<>();
//        paramsMap.put("receiving_code",receivingCode);
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_RECEIPT_BATCH,paramsMap);
        GoodCangResponse<GoodCangReceiptBatchResp> respDto = JSONObject.parseObject(response,new TypeReference<GoodCangResponse<GoodCangReceiptBatchResp>>() {}.getType());
        //重新赋值，方便后面转换
        if(Objects.nonNull(respDto.getData())){
            respDto.getData().setReceivingStatus(respDto.getReceivingStatus());
            respDto.getData().setTransitType(respDto.getTransitType());
        }
        return respDto;
    }

    /**
     * 获取收货批次
     */
    public String getReceipt(@Valid GoodCangBaseRequest goodCangBaseRequest){
        String json = JSON.toJSONString(goodCangBaseRequest);
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_RECEIPT,json);
        return response;
    }

    /**
     * 获取库存
     */
    public GoodCangResponse<List<GoodCangInventoryResp>> getProductInventory(@Valid GoodCangGetInventoryReq goodCangGetInventoryReq){
        String json = JSON.toJSONString(goodCangGetInventoryReq);
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_PRODUCT_INVENTORY,json);
        return JSONObject.parseObject(response,new TypeReference<GoodCangResponse<List<GoodCangInventoryResp>>>() {}.getType());
    }

    /**
     * 创建入库单
     */
    public GoodCangResponse<String> createInboundBill(@Valid GoodCangCreateInboundReq goodCangCreateInboundReq){
        String json = JSON.toJSONString(goodCangCreateInboundReq);
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_CREATE_INBOUND_BILL,json);
        //处理返回值
        GoodCangResponse<String> respDto = JSONObject.parseObject(response,new TypeReference<GoodCangResponse<String>>() {}.getType());
        if(Objects.nonNull(respDto.getData())){
            respDto.setData(JSONObject.parseObject(respDto.getData()).get("receiving_code").toString());
        }
        return respDto;
    }

    /**
     * 取消入库单
     * 入库单审核通过后不能取消
     */
    public GoodCangResponse<String> cancelInboundBill(@Valid @NotEmpty(message = "入库单号不能为空") String receivingCode){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("receiving_code",receivingCode);
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_CANCEL_INBOUND_BILL,paramsMap);
        return JSONObject.parseObject(response,new TypeReference<GoodCangResponse<String>>() {}.getType());
    }

    /**
     * 创建出库单
     */
    public GoodCangResponse<String> createOutboundBill(@Valid GoodCangCreateOutboundReq goodCangCreateOutboundReq){
        String json = JSON.toJSONString(goodCangCreateOutboundReq);
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_CREATE_OUTBOUND_BILL,json);
        //处理返回值
        GoodCangResponse<String> respDto = JSONObject.parseObject(response,new TypeReference<GoodCangResponse<String>>() {}.getType());
        if(Objects.nonNull(respDto.getData())){
            respDto.setData(JSONObject.parseObject(respDto.getData()).get("order_code").toString());
        }
        return JSONObject.parseObject(response,new TypeReference<GoodCangResponse<String>>() {}.getType());
    }

    /**
     * 取消出库单
     */
    public GoodCangResponse<String> cancelOutboundBill(@Valid @NotEmpty(message = "订单号不能为空") String orderCode,String reason){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("order_code",orderCode);
        paramsMap.put("reason",reason);
        String response = GoodCangUtils.sendPost(GoodCangConstants.METHOD_GET_CANCEL_OUTBOUND_BILL,paramsMap);
        return JSONObject.parseObject(response,new TypeReference<GoodCangResponse<String>>() {}.getType());
    }
}
