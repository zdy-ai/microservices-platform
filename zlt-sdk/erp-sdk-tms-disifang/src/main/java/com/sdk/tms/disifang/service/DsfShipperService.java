package com.sdk.tms.disifang.service;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.sdk.tms.disifang.constants.AmbientEnum;
import com.sdk.tms.disifang.model.base.AffterentParam;
import com.sdk.tms.disifang.model.base.ResponseMsg;
import com.sdk.tms.disifang.model.label.request.LabelRequest;
import com.sdk.tms.disifang.model.label.request.LabelSingleRequest;
import com.sdk.tms.disifang.model.order.request.*;
import com.sdk.tms.disifang.model.product.request.ChanelRequest;
import com.sdk.tms.disifang.utils.ApiHttpClientUtils;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName DsfLogisticsServiceImpl
 * @description: 递四方物流服务
 * @date 2023年10月31日
 * @version: 1.0
 */
@Slf4j
@Validated
@Component
public class DsfShipperService {
    //生产环境
    static String host = "https://open.4px.com/router/api/service";
    static String appKey = "fad2854e-93a7-4598-95ff-cb60557dbc0a";
    static String appSecret = "0e91ca81-22f8-4fce-95d1-18ed6269604b";

    //测试环境
//    static String host = "https://open-test.4px.com/router/api/service";
//    static String appKey = "5dca6db7-6a21-4d31-a5f8-33a24a4f5b9d";
//    static String appSecret = "b8bd24a5-35b0-4e8a-bbc0-c7458e21c7ad";

    private void validate(String appKey,String appSecret,String method){
        assert StringUtils.isNotEmpty(appKey);
        assert StringUtils.isNotEmpty(appSecret);
        assert StringUtils.isNotEmpty(method);
    }
    /**
     * 获取标签 打印标签
     *
     * @param authMap
     * @param labelSingleRequest
     * @return ResponseMsg
     */
    public ResponseMsg getLabel(Map<String, String> authMap, LabelSingleRequest labelSingleRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.label.get";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String s = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(labelSingleRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(s, ResponseMsg.class);
        return responseMsg;
    }

    /**
     * 批量获取标签 打印标签
     *
     * @param authMap
     * @param labelRequest
     * @return ResponseMsg
     */
    public ResponseMsg getLabelList(Map<String, String> authMap, LabelRequest labelRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.label.getlist";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String s = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(labelRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(s, ResponseMsg.class);
        return responseMsg;
    }

    /**
     * 物流产品查询 获取渠道
     *
     * @param authMap
     * @param chanelRequest
     * @return ResponseMsg
     */
    public ResponseMsg getChanelList(Map<String, String> authMap, ChanelRequest chanelRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.logistics_product.getlist";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String s = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(chanelRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(s, ResponseMsg.class);
        return responseMsg;
    }

    /**
     * 创建直发委托单
     *
     * @param authMap
     * @param orderRequest
     * @return ResponseMsg
     */
    public ResponseMsg createOrder(Map<String, String> authMap, OrderRequest orderRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.order.create";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String result = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(orderRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(result, ResponseMsg.class);
        //{"data":{"collect_no":"2021081600000003"},"msg":"系统处理成功","result":"1"}
        return responseMsg;
    }

    /**
     * 取消直发委托单
     *
     * @param authMap
     * @param orderCancelRequest
     * @return ResponseMsg
     */
    public ResponseMsg cancelOrder(Map<String, String> authMap, OrderCancelRequest orderCancelRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.order.cancel";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String result = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(orderCancelRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(result, ResponseMsg.class);
        //{"data":{"collect_no":"2021081600000003"},"msg":"系统处理成功","result":"1"}
        return responseMsg;
    }

    /**
     * 申请|取消拦截订单
     *
     * @param authMap
     * @param orderInterceptRequest
     * @return ResponseMsg
     */
    public ResponseMsg interceptOrder(Map<String, String> authMap, OrderInterceptRequest orderInterceptRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.order.hold";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String result = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(orderInterceptRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(result, ResponseMsg.class);
        //{"data":{"collect_no":"2021081600000003"},"msg":"系统处理成功","result":"1"}
        return responseMsg;
    }

    /**
     * 查询直发委托单
     *
     * @param authMap
     * @param orderQueryRequest
     * @return ResponseMsg
     */
    public ResponseMsg queryOrder(Map<String, String> authMap, OrderQueryRequest orderQueryRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.order.get";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String result = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(orderQueryRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(result, ResponseMsg.class);
        //{"data":{"collect_no":"2021081600000003"},"msg":"系统处理成功","result":"1"}
        return responseMsg;
    }

    /**
     * 创建揽收预约单 下单
     *
     * @param authMap
     * @param orderCollectRequest
     * @return ResponseMsg
     */
    public ResponseMsg createCollectOrder(Map<String, String> authMap, OrderCollectRequest orderCollectRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.api.collect.create.order";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String s = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(orderCollectRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(s, ResponseMsg.class);
        //{"data":{"collect_no":"2021081600000003"},"msg":"系统处理成功","result":"1"}
        return responseMsg;
    }

    /**
     * 创建揽收预约单 下单
     *
     * @param authMap
     * @param orderCollectRequest
     * @return ResponseMsg
     */
    public ResponseMsg cancelCollectOrder(Map<String, String> authMap, OrderCollectRequest orderCollectRequest) {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String method = "ds.xms.order.cancel";
        validate(appKey,appSecret,method);
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String s = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(orderCollectRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONObject.parseObject(s, ResponseMsg.class);
        //{"data":{"collect_no":"2021081600000003"},"msg":"系统处理成功","result":"1"}
        return responseMsg;
    }


    public static void main(String[] args) {
        DsfShipperService dsfShipperService = new DsfShipperService();
//        String token = "5dca6db7-6a21-4d31-a5f8-33a24a4f5b9d";
//        String key = "b8bd24a5-35b0-4e8a-bbc0-c7458e21c7ad";
        Map<String, String> map = new HashMap<>();
        map.put("clientId",appKey);
        map.put("clientSecret",appSecret);
        ChanelRequest chanelRequest = ChanelRequest.builder().transport_mode("1").build();
        ResponseMsg chanelList = dsfShipperService.getChanelList(map, chanelRequest);
//        String str = "app_key16081f05-e8fc-4250-b9c4-0660d1ecbb28" +
//                "formatjson" +
//                "methodds.xms.order.create" +
//                "timestamp1532592413187" +
//                "v1.0" +
//                "{\"aa\":\"bb\"}" +
//                "7eebf328-8e5a-4030-904d-ec6e89174fbc";
//
//        String md5 = DigestUtil.md5Hex(str);
//        String md52 = DigestUtil.md5Hex(str, Charset.defaultCharset());
        //timestamp1698823437409
        //timestamp1532592413187
//        LabelRequest labelRequest = LabelRequest.builder()
//                .requestNo(Collections.singletonList("304364437899"))
//                .logisticsProductCode("E4")
//                .isPrintBuyerId("N")
//                .isPrintCustomerWeight("N")
//                .isPrintDeclarationList("N")
//                .isPrintTime("N")
//                .isPrintPickInfo("N")
//                .isPrintPickBarcode("N")
//                .build();
//        dsfShipperService.getLabelList(appKey, appSecret, labelRequest);

//        AffterentParam param = AffterentParam.builder()
////                .accessToken()
//                .version("1.0")
//                .format("json")
//                .language("cn")
//                .appKey(appKey)
//                .appSecret(appSecret)
//                .method(method)
//                .build();
//
//        Map<String, Object> paramMap = new LinkedHashMap<>();
//        paramMap.put("request_no", Collections.singletonList("304364437899"));
//        paramMap.put("logistics_product_code","E4");
//        paramMap.put("is_print_time","N");
//        paramMap.put("is_print_buyer_id","N");
//        paramMap.put("is_print_pick_info","N");
//        paramMap.put("is_print_declaration_list","N");
//        paramMap.put("is_print_customer_weight","N");
//        paramMap.put("create_package_label","N");
//        paramMap.put("is_print_pick_barcode","N");
////        AmbientEnum ambient = new ApiHttpClientUtils();
//        String s = ApiHttpClientUtils.apiJsongPost(param, paramMap, AmbientEnum.FORMAT_ADDRESS);
    }
}
