package com.sdk.tms.express.service;


public class TestCallExpressNewAPIService {

    /**
     * 丰桥新沙箱测试顾客编码  Yg4Zf06w_sxZs3A5D
     * 校验码  3Xdk1jqeG1Xod9nUXus8Op7DNOkchTnw
     **/
    private static final String CLIENT_CODE = "Yg4Zf06w_sxZs3A5D";  //此处替换为您在丰桥平台获取的顾客编码
    private static final String CHECK_WORD = "3Xdk1jqeG1Xod9nUXus8Op7DNOkchTnw";//此处替换为您在丰桥平台获取的校验码


    //沙箱环境的地址 -PRO
    private static final String CALL_URL_BOX = "https://sfapi-sbox.sf-express.com/std/service";
    //生产环境的地址 -PRO
    private static final String CALL_URL_PROD = "https://sfapi.sf-express.com/std/service";

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        /**ExpressServiceCodeEnum     对应速运类-快递APIs
//         POSTServiceCodeEnum        对应速运类-驿站APIs
//         YJTServiceCodeEnum         对应解决方案-医寄通APIs
//         EPSServiceCodeEnum         对应解决方案-快递管家APIs
//         HZTServiceCodeEnum         对应解决方案-函证通APIs    2022-2-24 新增
//         详情见code目录下枚举类，客户可自行修改引用的该类
//         **/
//
////        IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_CREATE_ORDER; //下订单
//        //	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_SEARCH_ORDER_RESP; //查订单
//        //  IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_UPDATE_ORDER;//订单取消
//        // 	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_FILTER_ORDER_BSP;//订单筛选
//        //  IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_SEARCH_ROUTES;//查路由
//        //	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_GET_SUB_MAILNO;//子单号
//        //	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_QUERY_SFWAYBILL;//查运费
//        //	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_REGISTER_ROUTE;//注册路由
//        //	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_CREATE_REVERSE_ORDER;//退货下单
//        //	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_CANCEL_REVERSE_ORDER;//退货消单
//        //	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_WANTED_INTERCEPT;//截单转寄
//        // 	IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_QUERY_DELIVERTM;//时效标准及价格查询
//        //  IServiceCodeStandard standardService = ExpressServiceCodeEnum.COM_RECE_CLOUD_PRINT_WAYBILLS;//面单打印
//        //  IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_UPLOAD_ROUTE;//路由上传
//        //   IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_SEARCH_PROMITM;//预计派送时间查询
//        //  IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_EXCE_CHECK_PICKUP_TIME;//揽件服务时间查询
//        //  IServiceCodeStandard standardService = ExpressServiceCodeEnum.EXP_RECE_VALIDATE_WAYBILLNO;//运单号合法性校验
//
//
//        CallExpressServiceTools tools = CallExpressServiceTools.getInstance();
//
//        // set common header
//        Map<String, String> params = new HashMap<String, String>();
//
//        String timeStamp = String.valueOf(System.currentTimeMillis());
//        String msgData = tools.packageMsgData(standardService);
//
//        params.put("partnerID", CLIENT_CODE);  // 顾客编码 ，对应丰桥上获取的clientCode
//        params.put("requestID", UUID.randomUUID().toString().replace("-", ""));
//        params.put("serviceCode", standardService.getCode());// 接口服务码
//        params.put("timestamp", timeStamp);
//        params.put("msgData", msgData);
//        params.put("msgDigest", tools.getMsgDigest(msgData, timeStamp, CHECK_WORD));
//
//        // System.out.println(params.get("requestID"));
//        long startTime = System.currentTimeMillis();
//
//        //  System.out.println("====调用请求：" + params.get("msgData"));
//        System.out.println("====调用实际请求：" + params);
//        String result = HttpClientUtil.post(CALL_URL_BOX, params);
//
//        System.out.println("====调用丰桥的接口服务代码：" + String.valueOf(standardService.getCode()) + " 接口耗时：" + String.valueOf(System.currentTimeMillis() - startTime) + "====");
//        System.out.println("===调用地址 ===" + CALL_URL_BOX);
//        System.out.println("===顾客编码 ===" + CLIENT_CODE);
//        System.out.println("===返回结果：" + result);
//
//    }


}
