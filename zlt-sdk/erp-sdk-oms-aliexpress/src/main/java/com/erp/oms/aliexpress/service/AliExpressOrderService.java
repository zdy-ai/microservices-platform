package com.erp.oms.aliexpress.service;

import com.alibaba.fastjson.JSONObject;
import com.common.core.utils.UUID;

import com.erp.oms.aliexpress.api.IopClient;
import com.erp.oms.aliexpress.api.IopClientImpl;
import com.erp.oms.aliexpress.api.IopRequest;
import com.erp.oms.aliexpress.api.IopResponse;
import com.erp.oms.aliexpress.constants.ApiNamePathConstants;
import com.erp.oms.aliexpress.enums.Protocol;
import com.erp.oms.aliexpress.util.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 速卖通订单服务
 *
 * @author yl
 * @date 2023-11-22
 */
@Slf4j
@Component
public class AliExpressOrderService {


    /**
     * 拉取订单
     *
     * @return
     * @parms
     * @author yl
     * @date 2023-11-22
     */
    public void listOrder(Map<String, String> map) throws ApiException {

        String appKey = map.getOrDefault("clientId", "");
        String appSecret = map.getOrDefault("clientSecret", "");

        String baseUrl = map.getOrDefault("baseUrl", "");

        IopClient client = new IopClientImpl(baseUrl, appKey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.trade.seller.orderlist.get");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("current_page", 1);
        paramMap.put("page_size", 20);
        paramMap.put("create_date_start","2023-11-01 00:00:00");
        paramMap.put("create_date_end","2023-11-03 00:00:00");
        request.addApiParameter("simplify", "true");
        request.addApiParameter("param_aeop_order_query", JSONObject.toJSONString(paramMap));
        String token = "50000201347txAyeuenSZSrh8BiTAsWVDfFNIWkzSnFXkuwgvw4IUHrpU3L15038533N";

        IopResponse response = client.execute(request,token, Protocol.TOP);

        System.out.println("response===>" + response.getBody());

    }

    public static void main(String[] args) throws ApiException {
        AliExpressOrderService orderService = new AliExpressOrderService();
        Map<String, String> map = new HashMap<>();
        map.put("clientId","502978");
        map.put("clientSecret","DfFGCAXMY7pptKfhz7IkWEa0zC0xddhY");
        map.put("baseUrl","https://api-sg.aliexpress.com");
        orderService.listOrder(map);
    }
}
