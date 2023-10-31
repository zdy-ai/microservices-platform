package com.sdk.tms.express.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sdk.tms.express.enums.ExpressServiceCodeEnum;
import com.sdk.tms.express.model.base.BaseResponse;
import com.sdk.tms.express.model.base.BaseResult;
import com.sdk.tms.express.model.order.request.*;
import com.sdk.tms.express.model.order.response.OrderResponse;
import com.sdk.tms.express.model.order.response.OrderUpdateResponse;
import com.sdk.tms.express.utils.CallExpressServiceTools;
import com.sdk.tms.express.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author zdy
 * @ClassName ExpressShipperService
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Slf4j
@Component
public class ExpressShipperService {
    /**
     * 丰桥新沙箱测试顾客编码  Yg4Zf06w_sxZs3A5D
     * 校验码  3Xdk1jqeG1Xod9nUXus8Op7DNOkchTnw
     **/
    private static final String CLIENT_CODE = "Yg4Zf06w_sxZs3A5D";  //此处替换为您在丰桥平台获取的顾客编码
    private static final String CHECK_WORD = "3Xdk1jqeG1Xod9nUXus8Op7DNOkchTnw";//此处替换为您在丰桥平台获取的校验码


    //沙箱环境的地址 -PRO
    private static final String CALL_URL_BOX = "https://sfapi-sbox.sf-express.com/std/service";

    public static void main(String[] args) throws UnsupportedEncodingException {
//        List<CargoDetail> cargoDetailList = new ArrayList<>();
//        cargoDetailList.add(CargoDetail.builder().amount(new BigDecimal(200.5)).count(new BigDecimal(2.0))
//                .name("红星牌").unit("个").volume(new Double(0)).weight(new BigDecimal(0.2)).build());
//        List<ContactInfo> contactInfoList = new ArrayList<>();
//        contactInfoList.add(ContactInfo.builder().address("十堰市丹江口市公园路155号").city("十堰市").company("清雅轩保健品专营店").contact("张三丰")
//                .contactType(1).county("武当山风景区").mobile("17006805888").province("湖北省").build());
//        contactInfoList.add(ContactInfo.builder().address("湖北省襄阳市襄城区环城东路122号").city("襄阳市").contact("郭襄阳")
//                .contactType(2).county("襄城区").mobile("18963828829").province("湖北省").build());
//        OrderRequest orderRequest = OrderRequest.builder()
//                .orderId("QIAO-20200618-00524")
//                .language("zh-CN")
//                .expressTypeId(2L)
//                .isOneselfPickup(0)
//                .parcelQty(1L)
//                .payMethod(1)
//                .totalWidth(new BigDecimal(6))
//                .monthlyCard(7551234567L)
//                .cargoDetails(cargoDetailList)
//                .contactInfoList(contactInfoList)
//                .build();
//        BaseResult result = createOrder(CALL_URL_BOX, CLIENT_CODE, CHECK_WORD, orderRequest);
//
//        if (result.isSuccess()) {
//            OrderResponse response = JSONUtil.toBean(result.getMsgData(), OrderResponse.class);
//            System.out.println(response);
//        } else {
//            System.out.println(result);
//        }

        OrderUpdateRequest orderUpdateRequest = OrderUpdateRequest.builder()
                .orderId("QIAO-20200618-00524")
                .dealType(1) //客户订单操作标识：1：确认2：取消
                .build();

        BaseResult result = updateOrder(CALL_URL_BOX, CLIENT_CODE, CHECK_WORD, orderUpdateRequest);
        if (result.isSuccess()) {
            OrderUpdateResponse response = JSONUtil.toBean(result.getMsgData(), OrderUpdateResponse.class);
            System.out.println(response);
        } else {
            System.out.println(result);
        }
    }

    /**
     * 创建订单
     * <p>
     * 下订单接口提供以下四个功能：
     * (1) 客户系统向顺丰下发订单
     * (2) 为订单分配运单号
     * (3) 筛单
     * (4) 路由注册（可选）
     *
     * @param host
     * @param partnerId
     * @param md5Key
     * @param orderRequest
     * @return
     * @throws UnsupportedEncodingException
     */
    public static BaseResult createOrder(String host, String partnerId, String md5Key, OrderRequest orderRequest) throws UnsupportedEncodingException {
        IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_CREATE_ORDER; //下订单
        return doPost(host, partnerId, md5Key, JSONUtil.toJsonStr(orderRequest), standardService.getCode());
    }

    /**
     * 订单确认/取消接口
     * <p>
     * 接口用于以下场景:
     * (1) 客户在确定将货物交付给顺丰托运后，将运单上的一些重要信息，如快件重量通过此接口发送给顺丰。(2) 客户在发货前取消订单。
     * 注意：订单取消之后，订单号也是不能重复利用的。
     *
     * @param host
     * @param partnerId
     * @param md5Key
     * @param orderUpdateRequest
     * @return
     * @throws UnsupportedEncodingException
     */
    public static BaseResult updateOrder(String host, String partnerId, String md5Key, OrderUpdateRequest orderUpdateRequest) throws UnsupportedEncodingException {
        IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_UPDATE_ORDER; //订单确认/取消接口
        return doPost(host, partnerId, md5Key, JSONUtil.toJsonStr(orderUpdateRequest), standardService.getCode());
    }

    private static BaseResult doPost(String host, String partnerId, String md5Key, String msgData, String serviceCode) throws UnsupportedEncodingException {
        CallExpressServiceTools tools = CallExpressServiceTools.getInstance();
        Map<String, String> params = new HashMap<String, String>();

        String timeStamp = String.valueOf(System.currentTimeMillis());
        params.put("partnerID", partnerId);  // 顾客编码 ，对应丰桥上获取的clientCode
        params.put("requestID", UUID.randomUUID().toString().replace("-", ""));
        params.put("serviceCode", serviceCode);// 接口服务码
        params.put("timestamp", timeStamp);
        params.put("msgData", msgData);
        params.put("msgDigest", tools.getMsgDigest(msgData, timeStamp, md5Key));
        System.out.println("====调用实际请求：" + params);
        String result = HttpClientUtil.post(host, params);
        System.out.println("===返回结果：" + result);
        BaseResponse baseResponse = JSONUtil.toBean(result, BaseResponse.class);
        BaseResult baseResult = JSONUtil.toBean(baseResponse.getApiResultData(), BaseResult.class);
        return baseResult;
    }
}
