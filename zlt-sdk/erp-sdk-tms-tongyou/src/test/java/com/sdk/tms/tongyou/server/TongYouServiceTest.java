package com.sdk.tms.tongyou.server;


import com.common.core.utils.FileUtil;
import com.erp.model.tms.entity.LogisticsAuthEntity;
import com.sdk.tms.tongyou.dto.request.TongYouCreateOrderRequest;
import com.sdk.tms.tongyou.dto.request.TongYouCallBackOrderRequest;
import com.sdk.tms.tongyou.dto.request.TongYouGetOrderRequest;
import com.sdk.tms.tongyou.dto.request.TongYouPrintLabelRequest;
import com.sdk.tms.tongyou.dto.response.TongYouCreateOrder;
import com.sdk.tms.tongyou.dto.response.TongYouCallBackOrder;
import com.sdk.tms.tongyou.dto.response.TongYouOrderInfo;
import com.sdk.tms.tongyou.dto.response.TongYouPrintLabel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TongYouService.class)
public class TongYouServiceTest {

    @Resource
    private TongYouService tongYouService;
    private Map<String, String> authMap = new HashMap<>();

    public TongYouServiceTest(){
        //注意！！通邮没有测试环境，用正式环境测试创建订单记得在客户端将订单删除！！！
        authMap.put("clientSecret", "DADDC4078D2B7D38391A8D3F78C037BF");
    }
    @Test
    public void getAllChannel() {
        System.out.println(tongYouService.getAllChannel(authMap).getData());
    }

    @Test
    public void createOrder() {
        TongYouCreateOrderRequest request = TongYouCreateOrderRequest.builder()
                .bNo("String")
                .charged(0)
                .itemType(0)
                .logisticsId("FZXXRKVP705")
                .material("string")
                .note("note")
                .orderNo("WJ20231102001")
                .weight(1.1)
                .declareInfos(Arrays.asList(TongYouCreateOrderRequest.DeclareInfo.builder()
                                .currency("USD")
                                .des("goods")
                                .nameCN("物品")
                                .nameEN("wuping")
                                .price(10.2)
                                .qty(10)
                                .weight(1.1)
                        .build()))
                .recipient(TongYouCreateOrderRequest.Recipient.builder()
                        .actId("string")
                        .address("address")
                        .address2("address2")
                        .address3("address3")
                        .city("SCHENECTADY")
                        .contactPerson("mark")
                        .countryCode("US")
                        .mobileNo("123456789")
                        .telNo("123456789")
                        .province("New York,NY")
                        .zip("12345")
                        .build())
                .sender(TongYouCreateOrderRequest.Sender.builder()
                        .address1("addres")
                        .city("北京")
                        .country("CN")
                        .mobile("123456789")
                        .name("wj")
                        .postcode("12345")
                        .province("d")
                        .tel("123456789")
                        .build())
                .build();

        TongYouCreateOrder createOrder = tongYouService.createOrder(request,authMap);
        System.out.println(createOrder);
    }

    @Test
    public void callBackOrderInfo() {
        TongYouCallBackOrderRequest request = TongYouCallBackOrderRequest.builder()
                .logisticsId("FZXXRKVP705")
                .orderNo("WJ20231102001")
                .build();
        TongYouCallBackOrder orderInfo = tongYouService.callBackOrderInfo(request,authMap);
        System.out.println(orderInfo);
    }

    @Test
    public void printLabel() {
        TongYouPrintLabelRequest request = TongYouPrintLabelRequest.builder()
                .logisticsId("FZXXRKVP705")
                .orderNo("XM1AWJJ028110,WJ20231102001")
                .trackNo("TYZPH0022783888YQ,AT139756425CN")
                .build();
        TongYouPrintLabel printLabel = tongYouService.printLabel(request,authMap);

        FileUtil.base64ToFile(printLabel.getBase64(),"wayBillA4.pdf","C:\\Users\\Administrator\\Desktop");
        System.out.println(printLabel);
    }


    @Test
    public void getOrderInfo() {
        TongYouGetOrderRequest request = TongYouGetOrderRequest.builder()
                .orderNo("WJ20231102001")
                .build();
        TongYouOrderInfo orderInfo = tongYouService.getOrderInfo(request,authMap);
        System.out.println(orderInfo);
    }
}