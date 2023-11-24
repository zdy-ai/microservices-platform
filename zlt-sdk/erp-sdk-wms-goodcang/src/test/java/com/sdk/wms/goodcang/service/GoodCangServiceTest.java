package com.sdk.wms.goodcang.service;


import com.common.business.threadlocal.ThirdWarehouseContext;
import com.sdk.wms.goodcang.dto.request.*;
import com.sdk.wms.goodcang.dto.response.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=GoodCangService.class)
public class GoodCangServiceTest {

    @Resource
    private GoodCangService goodCangService;

    public GoodCangServiceTest(){
        Map<String,Object> authMap = new HashMap<>();
        //a39ab99c1437c991ec07fad4e1f78f8f
        authMap.put("appToken","7013991264f611e98ea200e01b680258");
        //f7e4102f9b0b983e58bed3140dc22f1a
        authMap.put("appKey","6ff50abf64f611e98ea200e01b680258");
        ThirdWarehouseContext.setAuthMap(authMap);
    }

    @Test
    public void authorizationTest() {
    }

    @Test
    public void getSkuListTest() {
        GoodCangGetSkuReq goodCangGetSkuReq = GoodCangGetSkuReq.builder()
                .page(1)
                .pageSize(200)
                .productUpdateTimeFrom("2020-10-01 00:00:00")
                .build();
        GoodCangResponse<List<GoodCangSkuResp>> response = goodCangService.getSkuList(goodCangGetSkuReq);
        System.out.println(response);
    }

    @Test
    public void getWarehouseTest() {
        GoodCangResponse<List<GoodCangWarehouseResp>> response = goodCangService.getWarehouse();
        System.out.println(response);
    }
    @Test
    public void getReceiptBatchTest() {
        GoodCangResponse<GoodCangReceiptBatchResp> response = goodCangService.getReceiptBatch("RVG1149-231113-000");
        System.out.println(response);
    }
    @Test
    public void getReceiptTest() {
        GoodCangBaseRequest goodCangBaseRequest = new GoodCangGetSkuReq();
        goodCangBaseRequest.setPage(1);
        goodCangBaseRequest.setPageSize(20);
        String response = goodCangService.getReceipt(goodCangBaseRequest);
        System.out.println(response);
    }
    @Test
    public void getSmCodeTwcToWarehouseTest() {
        GoodCangResponse<GoodCangLogisticsAndWarehouseResp> response = goodCangService.getSmCodeTwcToWarehouse();
        System.out.println(response);
    }


    @Test
    public void getProductInventoryTest() {
        GoodCangGetInventoryReq goodCangGetSkuReq = GoodCangGetInventoryReq.builder()
                .page(1)
                .pageSize(200)
//                .productSkuArr(Arrays.asList("TEST180717"))
//                .warehouseCode("USEA")
                .build();
        GoodCangResponse<List<GoodCangInventoryResp>> response = goodCangService.getProductInventory(goodCangGetSkuReq);
        System.out.println(response);
        System.out.println(response.getData());
    }

    @Test
    public void createInboundBillTest() {
        GoodCangCreateInboundReq goodCangCreateInboundReq = GoodCangCreateInboundReq.builder()
                .transitType(0)
                .receivingShippingType(0)
                .warehouseCode("USEA")
                .etaDate(LocalDate.parse("2023-11-20", DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .trackingNumber("123")
                .verify(1)
                .items(Arrays.asList(GoodCangCreateInboundReq.Item.builder()
                        .boxNo("1")
                        .box_detailList(Arrays.asList(GoodCangCreateInboundReq.Item.BoxDetail.builder()
                                .productSku("QC6SHR-031500US")
                                .quantity(10)
                                .build()))
                        .build()))
                .build();
        GoodCangResponse<String> response = goodCangService.createInboundBill(goodCangCreateInboundReq);
        System.out.println(response);
        System.out.println(response.getData());
    }

    @Test
    public void cancelInboundBillTest() {
        GoodCangResponse<String> response = goodCangService.cancelInboundBill("RVG1149-231116-0004");
        System.out.println(response);
        System.out.println(response.getData());
    }

    @Test
    public void createOutboundBillTest() {
        GoodCangCreateOutboundReq goodCangCreateOutboundReq = GoodCangCreateOutboundReq.builder()
                .name("mark")
                .city("newyork")
                .warehouseCode("USWE")
                .shippingMethod("MORKRM-DUOBOX")
                .address1("address")
                .countryCode("US")
                .zipcode("22162")
                .province("ca")
                .verify(1)
                .itemList(Arrays.asList(GoodCangCreateOutboundReq.Item.builder()
                                .productSku("USWR410242")
                                .quantity(1)
                        .build()))
                .build();
        GoodCangResponse<String> response = goodCangService.createOutboundBill(goodCangCreateOutboundReq);
        System.out.println(response);
        System.out.println(response.getData());
    }

    @Test
    public void cancelOutboundBillTest() {
        GoodCangResponse<String> response = goodCangService.cancelOutboundBill("G1149-231116-0005",null);
        System.out.println(response);
        System.out.println(response.getData());
    }
}