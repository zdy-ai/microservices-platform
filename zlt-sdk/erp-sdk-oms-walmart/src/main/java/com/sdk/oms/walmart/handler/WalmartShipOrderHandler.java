package com.sdk.oms.walmart.handler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.sdk.oms.walmart.api.WalmartStaticKey;
import com.sdk.oms.walmart.dto.WalmartShopInfoDTO;
import com.sdk.oms.walmart.dto.walmart.WalmartItemDTO;
import com.sdk.oms.walmart.dto.walmart.WalmartShipOrderDTO;
import com.sdk.oms.walmart.dto.walmart.WalmartTokenDTO;
import com.sdk.oms.walmart.dto.walmart.item.ItemResponseBean;
import com.sdk.oms.walmart.dto.walmart.ship.*;
import com.sdk.oms.walmart.service.WalmartSdkClientService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

public class WalmartShipOrderHandler {

    public static void main(String[] args) {
        String baseUrl = "https://marketplace.walmartapis.com/v3/orders/{purchaseOrderId}/shipping";
        String clientId = "2434a35c-7c42-4420-9618-0c179b68a8c2";
        String clientSecret = "AMW5lbVFqG2DMP4DuLezhSkbk4u0JLGUjdFlsrl_p0sagsBkYPPiQhRbEvkE4a6k6KXNKhB--RGlqPKIfhUoV28";
        //获取令牌
        baseUrl = WalmartStaticKey.baseUrl + "token";

        List<String> list = new ArrayList<>();
        WalmartSdkClientService walmartSdkClientService = new WalmartSdkClientService();
        WalmartTokenDTO walmartTokenDTO = walmartSdkClientService.sendWalmartPostToken(baseUrl, clientId, clientSecret);
        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        Integer pageSize = 200;
        paramMap.put("limit", pageSize);
        paramMap.put("lastModifiedStartDate", "2023-09-01T00:00:00");
        paramMap.put("lastModifiedEndDate", "2023-10-27T00:00:00");
        paramMap.put("createdStartDate", "2023-09-01T00:00:00");
        paramMap.put("createdEndDate", "2023-10-27T00:00:00");
        paramMap.put("status", "Acknowledged,Shipped,Delivered,Cancelled");
        paramMap.put("productInfo", "true");
//        WalmartTokenDTO s = walmartSdkClientService.sendWalmartPostToken(baseUrl, clientId, clientSecret);
        baseUrl = WalmartStaticKey.baseUrl + "orders/{purchaseOrderId}/shipping";
        WalmartShipOrderDTO walmartShipOrderDTO = new WalmartShipOrderDTO();

        OrderShipmentBean orderShipmentBean = new OrderShipmentBean();

        OrderLinesBean orderLinesBean = new OrderLinesBean();

        List<OrderLineBean> orderLineBeanList = new ArrayList<>();
        //详情：
        for (String s : list) {

            OrderLineBean orderLineBean = new OrderLineBean();
            //详情序号
            orderLineBean.setLineNumber("1");
            //订单号：要求唯一
            orderLineBean.setSellerOrderId("");

            //订单状态
            OrderLineStatusesBean orderLineStatuses = new OrderLineStatusesBean();
            List<OrderLineStatusBean> orderLineStatus = new ArrayList<>();
            //发货状态
            orderLineStatus.get(0).setStatus("Shipped");

            //----------------设置发货数量信息-----------------------------------
            StatusQuantityBean statusQuantity = new StatusQuantityBean();
            //发货数量
            statusQuantity.setAmount("0");
            //计量单位
            statusQuantity.setUnitOfMeasurement("EACH");
            orderLineStatus.get(0).setStatusQuantity(statusQuantity);

            //----------------有关包裹装运和跟踪更新的信息列表-----------------------------------
            TrackingInfoBean trackingInfo = new TrackingInfoBean();
            //包裹的发货日期
            trackingInfo.setShipDateTime(System.currentTimeMillis());
            //有关包裹承运商的信息
            CarrierNameBean carrierName = new CarrierNameBean();
            trackingInfo.setCarrierName(carrierName);
            //运输方式。可以是以下类型之一：Standard、Express、OneDay、WhiteGlove、Value或Freight
            trackingInfo.setMethodCode("Standard");
            //运单号
            trackingInfo.setTrackingNumber("");
            orderLineStatus.get(0).setTrackingInfo(trackingInfo);

            orderLineStatuses.setOrderLineStatus(orderLineStatus);
            orderLineBean.setOrderLineStatuses(orderLineStatuses);

            orderLineBeanList.add(orderLineBean);
        }
        orderLinesBean.setOrderLine(orderLineBeanList);


        orderShipmentBean.setOrderLines(orderLinesBean);

        walmartShipOrderDTO.setOrderShipment(orderShipmentBean);


        HashMap<String, Object> map = (HashMap<String, Object>) BeanUtil.beanToMap(walmartShipOrderDTO);
        String s = walmartSdkClientService.sendWalmartPost(baseUrl, clientId, clientSecret, walmartTokenDTO.getAccessToken(), map);
        System.out.println(s);
    }
}
