package com.sdk.tms.express.constants;

/**
 * @author zdy
 * @ClassName PathConstants
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
public interface PathConstants {
    /**
     * 丰桥新沙箱测试顾客编码  Yg4Zf06w_sxZs3A5D
     * 校验码  3Xdk1jqeG1Xod9nUXus8Op7DNOkchTnw
     **/
    String CLIENT_CODE = "Yg4Zf06w_sxZs3A5D";  //此处替换为您在丰桥平台获取的顾客编码
    String CHECK_WORD = "3Xdk1jqeG1Xod9nUXus8Op7DNOkchTnw";//此处替换为您在丰桥平台获取的校验码


    //沙箱环境的地址 -PRO
    String BASE_URL = "https://sfapi-sbox.sf-express.com/std/service";
    //正式环境
//    String BASE_URL = "https://bspgw.sf-express.com/std/service";
    String filePath = "D:\\project\\microservices-platform\\zlt-sdk\\zlt-sdk-tms-express\\src\\main\\resources\\";
}
