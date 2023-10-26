package com.sdk.oms.shopee.service;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sdk.oms.shopee.dto.base.ShopeeResponse;
import com.sdk.oms.shopee.dto.order.request.OrderRequest;
import com.sdk.oms.shopee.dto.order.response.OrderDetail;
import com.sdk.oms.shopee.dto.order.response.ShopeeOrder;
import com.sdk.oms.shopee.utils.ShopeeApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.sdk.oms.shopee.constants.ShopeeConstants.*;

/**
 * @author zdy
 * @ClassName GlobalProductServiceImpl
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Component
@Slf4j
public class ShopeeOrderService {
    public static void main(String[] args) {
        ShopeeOrderService shopeeOrderService = new ShopeeOrderService();
        long timest = System.currentTimeMillis() / 1000L;
        Long time_from = timest - (3600 * 24 * 14);
        Long time_to = timest;
        //订单列表
        OrderRequest orderRequest = OrderRequest.builder()
                .offset(0)
                .timeFrom(time_from)
                .timeTo(time_to)
                .tmpPartnerKey(tmp_partner_key)
                .partnerId(partner_id)
                .token(shop_access_token)
                .shopId(shop_id)
                .host(host)
                .cursor("")
                .build();
        List<OrderDetail> platformOrderDTOS = new ArrayList<>();
        shopeeOrderService.getAllOrder(orderRequest, platformOrderDTOS);
        System.out.println(platformOrderDTOS.size());
//        shopeeOrderService.getOrderDetail(host, shop_access_token, shop_id, partner_id, tmp_partner_key,"231019B5QD22UG");
    }

    public void getAllOrder(OrderRequest orderRequest, List<OrderDetail> orderDetails) {
        ShopeeResponse shopeeResponse = this.getOrderList(orderRequest);
        if (Objects.isNull(shopeeResponse) || Objects.isNull(shopeeResponse.getResponse())) {
            return;
        }
        JSONObject response = shopeeResponse.getResponse();
        String error = response.getString("error");
        if (StrUtil.isNotEmpty(error)) {
            return;
        }
        JSONArray jsonArray = (JSONArray) response.get("order_list");
        //目录列表
        List<ShopeeOrder> orderList = JSONObject.parseArray(jsonArray.toJSONString(), ShopeeOrder.class);
        //获取item明细
        List<String> orderSns = orderList.stream().map(ShopeeOrder::getOrderSn).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(orderSns)) {
            orderRequest.setOrderSns(StrUtil.join(",", orderSns));
            ShopeeResponse orderDetail = this.getOrderDetail(orderRequest);
            JSONObject responseBaseInfo = orderDetail.getResponse();
            if (Objects.nonNull(responseBaseInfo)) {
                //循环填充
                JSONArray listBase = responseBaseInfo.getJSONArray("order_list");
                List<OrderDetail> list = JSONObject.parseArray(listBase.toJSONString(), OrderDetail.class);

                if (CollectionUtils.isNotEmpty(list)) {
                    orderDetails.addAll(list);
                }
            }
        }
        boolean more = response.getBoolean("more");
        if (more) {
            String next_cursor = response.getString("next_cursor");
            orderRequest.setCursor(next_cursor);
            //还有订单数据
            this.getAllOrder(orderRequest, orderDetails);
        }

    }

    private HashMap<String, Object> getOrderCommonParam(OrderRequest orderRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("timestamp", orderRequest.getTimestamp());
        paramMap.put("sign", ShopeeApiUtils.getOrderSign(orderRequest.getPath(), orderRequest.getToken(), orderRequest.getPartnerId(),
                orderRequest.getTmpPartnerKey(), orderRequest.getShopId()));
        paramMap.put("shop_id", orderRequest.getShopId());
        paramMap.put("partner_id", orderRequest.getPartnerId());
        paramMap.put("access_token", orderRequest.getToken());
        return paramMap;
    }

    public ShopeeResponse getOrderList(OrderRequest orderRequest) {
        String path = "/api/v2/order/get_order_list";
        orderRequest.setPath(path);
        long timestamp = System.currentTimeMillis() / 1000L;
        orderRequest.setTimestamp(timestamp);
        HashMap<String, Object> paramMap = getOrderCommonParam(orderRequest);
        //create_time, update_time.
        paramMap.put("time_range_field", "create_time");
        //15天内
        if (Objects.nonNull(orderRequest.getTimeFrom())) {
            paramMap.put("time_from", orderRequest.getTimeFrom());
        }
        if (Objects.nonNull(orderRequest.getTimeTo())) {
            paramMap.put("time_to", orderRequest.getTimeTo());
        }
        paramMap.put("timestamp", timestamp);
        //1-100
        paramMap.put("page_size", pageSize);
        paramMap.put("cursor", orderRequest.getCursor());
        //UNPAID/READY_TO_SHIP/PROCESSED/SHIPPED/COMPLETED/IN_CANCEL/CANCELLED/INVOICE_PENDING
//        paramMap.put("order_status", "PROCESSED");
//        paramMap.put("response_optional_fields", "order_status");
//        paramMap.put("request_order_status_pending", true);
        return ShopeeApiUtils.sendGet(orderRequest.getHost() + path, paramMap);
        /**
         * bodyStr:{"error":"","message":"","response":{"more":false,"next_cursor":"","order_list":[{"order_sn":"231019B5QD22UG","order_status":"PROCESSED"},{"order_sn":"231018906HF759","order_status":"PROCESSED"}]},"request_id":"c9dd8acb2dac5b7cda22a565f4f4f121"}
         */
    }

    public ShopeeResponse getOrderDetail(OrderRequest orderRequest) {
        String path = "/api/v2/order/get_order_detail";
        orderRequest.setPath(path);
        long timestamp = System.currentTimeMillis() / 1000L;
        orderRequest.setTimestamp(timestamp);
        HashMap<String, Object> paramMap = getOrderCommonParam(orderRequest);
        //The set of order_sn. If there are multiple order_sn, you need to use English comma to connect them. limit [1,50]
        paramMap.put("order_sn_list", orderRequest.getOrderSns());
        paramMap.put("response_optional_fields", "create_time,order_sn,order_status,pay_time,total_amount,currency," +
                "actual_shipping_fee,shipping_carrier,note,buyer_user_id,buyer_username");
        return ShopeeApiUtils.sendGet(orderRequest.getHost() + path, paramMap);
    }
}
