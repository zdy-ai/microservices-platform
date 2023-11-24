package com.sdk.tms.express.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.common.core.utils.OkHttpUtils;
import com.sdk.tms.express.constants.PathConstants;
import com.sdk.tms.express.enums.ExpressServiceCodeEnum;
import com.sdk.tms.express.model.base.BaseResponse;
import com.sdk.tms.express.model.base.BaseResult;
import com.sdk.tms.express.model.order.request.*;
import com.sdk.tms.express.model.order.response.OrderResponse;
import com.sdk.tms.express.model.order.response.OrderUpdateResponse;
import com.sdk.tms.express.utils.CallExpressServiceTools;
import com.sdk.tms.express.utils.FileUtil;
import com.sdk.tms.express.utils.HttpClientUtil;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
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


    public static void main(String[] args) throws UnsupportedEncodingException {
        ExpressShipperService expressShipperService = new ExpressShipperService();
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
//        BaseResult result = expressShipperService.createOrder(CLIENT_CODE, CHECK_WORD, orderRequest);
//
//        if (result.isSuccess()) {
//            OrderResponse response = JSONUtil.toBean(result.getMsgData(), OrderResponse.class);
//            System.out.println(response);
//        } else {
//            System.out.println(result);
//        }
        //确认订单
//        OrderUpdateRequest orderUpdateRequest = OrderUpdateRequest.builder()
//                .orderId("QIAO-20200618-00524")
//                .dealType(1) //客户订单操作标识：1：确认2：取消
//                .build();
//
//        BaseResult result = expressShipperService.updateOrder(CLIENT_CODE, CHECK_WORD, orderUpdateRequest);
//        if (result.isSuccess()) {
//            OrderUpdateResponse response = JSONUtil.toBean(result.getMsgData(), OrderUpdateResponse.class);
//            System.out.println(response);
//        } else {
//            System.out.println(result);
//        }
        //查询顶顶那
//        OrderQueryRequest orderQueryRequest = OrderQueryRequest.builder()
//                .orderId("QIAO-20200618-00524")//waybillNo=SF7444473356235
//                .searchType(1)
//                .language("zh-CN")
//                .build();
//        BaseResult baseResult = expressShipperService.queryOrder(CLIENT_CODE, CHECK_WORD, orderQueryRequest);
//        System.out.println(baseResult);
        //获取标签
//        OrderLabelRequest orderLabelRequest = OrderLabelRequest.builder()
//                .templateCode("fm_210_standard_" + CLIENT_CODE)
//                .documents(Collections.singletonList(Document.builder().masterWaybillNo("SF7444473356235").build()))
//                .version("2.0")
//                .fileType("pdf")
//                .sync(true)
//                .build();
//        BaseResult label = expressShipperService.getLabel(CLIENT_CODE, CHECK_WORD, orderLabelRequest);
//        System.out.println("label:" + label);
        /**
         * BaseResult(success=true, errorCode=null, errorMsg=null, errorMessage=null, requestId=9feba81ca6fc4af78070a720055b2ec0,
         * obj={"clientCode":"Yg4Zf06w_sxZs3A5D","fileType":"pdf",
         * "files":[{"areaNo":1,"documentSize":0,"pageCount":0,"pageNo":1,"seqNo":1,
         * "token":"AUTH_tkv12_f146d1855480549d262b5c46ab0ab597ff20a97d9d0db45c16bedeb4fabd112b012deadd477ee524b1d690ce01baa3cdffbb125a6ccf69b73778dba2eb5157eb71f5f4711bf3551ed50de6e92ac3a8ea0313a861c1098a0421f61b3ded7dbfb406a9d538d75efc7a67401084540990da07119a7f5441b7ee908108438fcc0cffed9fc6133877fb3832b0bb3be9072decd553a9dd7c08f62c142463fa3c490f565434a1677773627f3a6df1bf4ffb9615174670f3250bb22e7492da552b5e9ab6",
         * "url":"https://eos-scp-core-shenzhen-futian1-oss.sf-express.com:443/v1.2/AUTH_EOS-SCP-CORE/print-file-sbox/AAABi8dnok_ieKDG95hAW5I5Mm4FrNXa_SF7444473356235_fm_210_standard_Yg4Zf06w_sxZs3A5D_1_1.pdf",
         * "waybillNo":"SF7444473356235"}],
         */

        String urlString = "https://eos-scp-core-shenzhen-futian1-oss.sf-express.com:443/v1.2/AUTH_EOS-SCP-CORE/print-file-sbox/AAABi8dnok_ieKDG95hAW5I5Mm4FrNXa_SF7444473356235_fm_210_standard_Yg4Zf06w_sxZs3A5D_1_1.pdf";
        String token = "AUTH_tkv12_f146d1855480549d262b5c46ab0ab597ff20a97d9d0db45c16bedeb4fabd112b012deadd477ee524b1d690ce01baa3cdffbb125a6ccf69b73778dba2eb5157eb71f5f4711bf3551ed50de6e92ac3a8ea0313a861c1098a0421f61b3ded7dbfb406a9d538d75efc7a67401084540990da07119a7f5441b7ee908108438fcc0cffed9fc6133877fb3832b0bb3be9072decd553a9dd7c08f62c142463fa3c490f565434a1677773627f3a6df1bf4ffb9615174670f3250bb22e7492da552b5e9ab6";
        Map<String, Object> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Auth-token", token);

//        File file = null;
//        OutputStream outputStream = null;
//        InputStream inputStream = null;
//        try {
//            String fileName = urlString.substring(urlString.lastIndexOf("."),urlString.length());
//            file = File.createTempFile("lable_image", fileName);
//            URL url = new URL(urlString);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("X-Auth-token", token);
//            inputStream = connection.getInputStream();
//            outputStream = Files.newOutputStream(file.toPath());
////            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
//            byte[] buffer = new byte[8192];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//            connection.disconnect();
//            System.out.println("File downloaded successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (null != outputStream){
//                    outputStream.close();
//                }
//                if (null != inputStream){
//                    inputStream.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            String base64 = FileUtil.getBase64(file);
//            System.out.println("base64:" + base64);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
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
     * @param authMap
     * @param orderRequest
     * @return OrderResponse
     * @throws UnsupportedEncodingException
     */
    public BaseResult createOrder(Map<String, String> authMap, OrderRequest orderRequest) throws UnsupportedEncodingException {
        String partnerId = authMap.get("clientId");
        String md5Key = authMap.get("clientSecret");
        validate(partnerId, md5Key);
        IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_CREATE_ORDER; //下订单
        return doPost(PathConstants.BASE_URL, partnerId, md5Key, JSONUtil.toJsonStr(orderRequest), standardService.getCode());
    }

    /**
     * 订单确认/取消接口
     * <p>
     * 接口用于以下场景:
     * (1) 客户在确定将货物交付给顺丰托运后，将运单上的一些重要信息，如快件重量通过此接口发送给顺丰。(2) 客户在发货前取消订单。
     * 注意：订单取消之后，订单号也是不能重复利用的。
     *
     * @param authMap
     * @param orderUpdateRequest
     * @return OrderUpdateResponse
     * @throws UnsupportedEncodingException
     */
    public BaseResult updateOrder(Map<String, String> authMap, OrderUpdateRequest orderUpdateRequest) throws UnsupportedEncodingException {
        String partnerId = authMap.get("clientId");
        String md5Key = authMap.get("clientSecret");
        validate(partnerId, md5Key);
        IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_UPDATE_ORDER; //订单确认/取消接口
        return doPost(PathConstants.BASE_URL, partnerId, md5Key, JSONUtil.toJsonStr(orderUpdateRequest), standardService.getCode());
    }

    /**
     * 查询订单结果
     *
     * @param authMap
     * @param orderQueryRequest
     * @return OrderSearchRespDto
     * @throws UnsupportedEncodingException
     */
    public BaseResult queryOrder(Map<String, String> authMap, OrderQueryRequest orderQueryRequest) throws UnsupportedEncodingException {
        String partnerId = authMap.get("clientId");
        String md5Key = authMap.get("clientSecret");
        validate(partnerId, md5Key);
        IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_SEARCH_ORDER_RESP; //查询订单结果
        return doPost(PathConstants.BASE_URL, partnerId, md5Key, JSONUtil.toJsonStr(orderQueryRequest), standardService.getCode());
    }

    /**
     * 获取标签
     *
     * @param authMap
     * @param orderLabelRequest
     * @return
     * @throws UnsupportedEncodingException
     */
    public BaseResult getLabel(Map<String, String> authMap, OrderLabelRequest orderLabelRequest) throws UnsupportedEncodingException {
        String partnerId = authMap.get("clientId");
        String md5Key = authMap.get("clientSecret");
        validate(partnerId, md5Key);
        IServiceCodeStandard standardService = ExpressServiceCodeEnum.COM_RECE_CLOUD_PRINT_WAYBILLS; //面单打印
        return doPost(PathConstants.BASE_URL, partnerId, md5Key, JSONUtil.toJsonStr(orderLabelRequest), standardService.getCode());
    }
    /**
     * 校验运单号合法性
     *
     * @param authMap
     * @param waybillNo
     * @return
     * @throws UnsupportedEncodingException
     */
    public BaseResult validateWaybillNo(Map<String, String> authMap, String waybillNo) throws UnsupportedEncodingException {
        String partnerId = authMap.get("clientId");
        String md5Key = authMap.get("clientSecret");
        validate(partnerId, md5Key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("waybillNo", waybillNo);
        IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_VALIDATE_WAYBILLNO; //提供顺丰运单号合法性校验功能。
        return doPost(PathConstants.BASE_URL, partnerId, md5Key, JSONUtil.toJsonStr(jsonObject), standardService.getCode());
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
        log.info("====调用实际请求：{}", params);
        String result = HttpClientUtil.post(host, params);
        log.info("====返回结果：{}", params);
        BaseResponse baseResponse = JSONUtil.toBean(result, BaseResponse.class);
        BaseResult baseResult = JSONUtil.toBean(baseResponse.getApiResultData(), BaseResult.class);
        return baseResult;
    }
    private void validate(String partnerId,String md5Key){
        assert StringUtils.isNotEmpty(partnerId);
        assert StringUtils.isNotEmpty(md5Key);
    }
}
