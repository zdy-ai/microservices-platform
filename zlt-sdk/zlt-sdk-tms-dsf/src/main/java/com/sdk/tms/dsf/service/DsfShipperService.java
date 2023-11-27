package com.sdk.tms.dsf.service;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.central.common.utils.OkHttpUtils;
import com.sdk.tms.dsf.constants.AmbientEnum;
import com.sdk.tms.dsf.model.base.AffterentParam;
import com.sdk.tms.dsf.model.base.ResponseMsg;
import com.sdk.tms.dsf.model.label.request.LabelRequest;
import com.sdk.tms.dsf.model.order.request.OrderRequest;
import com.sdk.tms.dsf.utils.ApiHttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zdy
 * @ClassName DsfLogisticsServiceImpl
 * @description: 递四方物流服务
 * @date 2023年10月31日
 * @version: 1.0
 */
@Slf4j
@Component
public class DsfShipperService {
    static String host = "https://open.4px.com/router/api/service";
    //        static String host = "https://open-test.4px.com/router/api/service";
    static String method = "ds.xms.label.getlist";
    static String appKey = "";
    static String appSecret = "";

    /**
     * 批量获取标签 打印标签
     *
     * @param appKey
     * @param appSecret
     * @param labelRequest
     * @return ResponseMsg
     */
    public ResponseMsg getLabelList(String appKey, String appSecret, LabelRequest labelRequest) {
        String method = "ds.xms.label.getlist";
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String s = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(labelRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONUtil.toBean(s, ResponseMsg.class);
        System.out.println(responseMsg);
        return responseMsg;
    }

    /**
     * 创建揽收预约单 下单
     *
     * @param appKey
     * @param appSecret
     * @param orderRequest
     * @return ResponseMsg
     */
    public ResponseMsg createOrder(String appKey, String appSecret, OrderRequest orderRequest) {
        String method = "ds.xms.api.collect.create.order";
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String s = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(orderRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONUtil.toBean(s, ResponseMsg.class);
        System.out.println(responseMsg);
        //{"data":{"collect_no":"2021081600000003"},"msg":"系统处理成功","result":"1"}
        return responseMsg;
    }

    /**
     * 创建揽收预约单 下单
     *
     * @param appKey
     * @param appSecret
     * @param orderRequest
     * @return ResponseMsg
     */
    public ResponseMsg cancelOrder(String appKey, String appSecret, OrderRequest orderRequest) {
        String method = "ds.xms.order.cancel";
        AffterentParam param = AffterentParam.builder()
                .version("1.0")
                .format("json")
                .language("cn")
                .appKey(appKey)
                .appSecret(appSecret)
                .method(method)
                .build();
        String s = ApiHttpClientUtils.apiJsonPost(param, JSONUtil.toJsonStr(orderRequest), AmbientEnum.FORMAT_ADDRESS);
        ResponseMsg responseMsg = JSONUtil.toBean(s, ResponseMsg.class);
        System.out.println(responseMsg);
        //{"data":{"collect_no":"2021081600000003"},"msg":"系统处理成功","result":"1"}
        return responseMsg;
    }


    public static void main(String[] args) {
        DsfShipperService dsfShipperService = new DsfShipperService();
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
//        System.out.println(md5);
//        System.out.println(md52);
        //timestamp1698823437409
        //timestamp1532592413187
        LabelRequest labelRequest = LabelRequest.builder()
                .requestNo(Collections.singletonList("304364437899"))
                .logisticsProductCode("E4")
                .isPrintBuyerId("N")
                .isPrintCustomerWeight("N")
                .isPrintDeclarationList("N")
                .isPrintTime("N")
                .isPrintPickInfo("N")
                .isPrintPickBarcode("N")
                .build();
        dsfShipperService.getLabelList(appKey, appSecret, labelRequest);

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
//        System.out.println(s);
    }
}
