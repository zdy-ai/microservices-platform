package com.sdk.tms.weishi.server;


import com.erp.model.tms.entity.LogisticsAuthEntity;
import com.sdk.tms.weishi.dto.request.*;
import com.sdk.tms.weishi.dto.response.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WeiShiService.class)
class WeiShiServiceTest {

    @Resource
    private WeiShiService weiShiService;

    private Map<String, String> authMap = new HashMap<>();

    public WeiShiServiceTest(){
        authMap.put("clientId","dcfe81e2059c1f0e6e6263dbcb764885");
        authMap.put("clientSecret","dcfe81e2059c1f0e6e6263dbcb7648850d0c1386bae3caf82229e7cf472d7b53");
    }

    @Test
    void getAllChannel() {
        WeiShiResponse<List<WeiShiChannel>> channel= weiShiService.getAllChannel(authMap);
        System.out.println(channel);
    }

    @Test
    void createOrder() {
        WeiShiCreateOrderRequest weiShiCreateOrderRequest = WeiShiCreateOrderRequest.builder()
                .referenceNo("wj1234516779")
                .shippingMethod("MX1001")
                .countryCode("MX")
                .orderWeight(new BigDecimal("0.123"))
                .orderPieces(12)
                .consignee(WeiShiCreateOrderRequest.Consignee.builder()
                        .consigneeStreet("纽约")
                        .consigneeName("mark")
                        .consigneePostcode("11510")
                        .consigneeCity("shenzhen")
                        .consigneeMobile("123456789")
                        .consigneeProvince("state")
                        .build())
                .shipper(WeiShiCreateOrderRequest.Shipper.builder()
                        .shipperCountrycode("CN")
                        .shipperProvince("shenzhen")
                        .shipperCity("newyork")
                        .shipperStreet("address")
                        .shipperPostcode("515800")
                        .shipperName("亚瑟")
                        .shipperTelephone("321423135")
                        .shipperMobile("123456789")
                        .build())
                .itemArr(Arrays.asList(WeiShiCreateOrderRequest.ItemArr.builder()
                        .invoiceEnname("mta")
//                        .invoiceCnname("物流")
                        .invoiceWeight(new BigDecimal("1.999"))
                        .invoiceQuantity(10)
                        .invoiceUnitcharge(12.0F)
                        .build()))
                .build();
        WeiShiCreateOrder response = weiShiService.createOrder(weiShiCreateOrderRequest,authMap);
        System.out.println(response);
    }

    @Test
    void getLabelUrl() {
        WeiShiGetLabelUrlRequest weiShiGetLabelUrlRequest = WeiShiGetLabelUrlRequest.builder()
                .referenceNo("WSHMX3123400544YQ")
                .lableType("2")
                .build()
                ;
        WeiShiGetLabelUrl weiShiGetLabelUrl = weiShiService.getLabelUrl(weiShiGetLabelUrlRequest,authMap);
        System.out.println(weiShiGetLabelUrl);
    }

    @Test
    void interceptOrder() {
        WeiShiInterceptOrderRequest weiShiGetLabelUrlRequest = WeiShiInterceptOrderRequest.builder()
                .referenceNo("TEST2019102800132")
                .build()
                ;
        WeiShiResponse response = weiShiService.interceptOrder(weiShiGetLabelUrlRequest,authMap);
        System.out.println(response);
    }

    @Test
    void cancelOrder() {
        WeiShiCancelOrderRequest weiShiCancelOrderRequest = WeiShiCancelOrderRequest.builder()
                .referenceNo("TEST2019102800132")
                .build()
                ;
        WeiShiResponse response = weiShiService.cancelOrder(weiShiCancelOrderRequest,authMap);
        System.out.println(response);
    }

    @Test
    void getTrackNumber() {
        WeiShiGetTrackNumberRequest weiShiCancelOrderRequest = WeiShiGetTrackNumberRequest.builder()
                .referenceNoList(Arrays.asList("wj12345167710"))
                .build()
                ;
        WeiShiResponse<List<WeiShiGetTrackNumber>> response = weiShiService.getTrackNumber(weiShiCancelOrderRequest,authMap);
        System.out.println(response);
    }
}