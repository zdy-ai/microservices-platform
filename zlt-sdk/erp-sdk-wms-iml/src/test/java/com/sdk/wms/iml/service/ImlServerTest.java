package com.sdk.wms.iml.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.common.business.threadlocal.ThirdWarehouseContext;
import com.sdk.wms.iml.dto.request.*;
import com.sdk.wms.iml.dto.response.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ImlService.class)
public class ImlServerTest {

    @Resource
    private ImlService imlServer;

    public ImlServerTest(){
        Map<String,Object> authMap = new HashMap<>();
        authMap.put("appToken","44ac3ae1211d416a080858e57833cc14");
        authMap.put("appKey","fa0c90d7dbb434fa2160209756db677c");
        ThirdWarehouseContext.setAuthMap(authMap);
    }


    @Test
    public void getSkuList() {
        ImlGetProductReq imlProductReq = ImlGetProductReq.builder()
                .page(1)
                .pageSize(50)
//                .productSku("0044")
//                .productSkuArr(Arrays.asList("0044"))
                .updateStartTime("2023-05-01 11:11:11")
                .updateEndTime("2024-01-01 11:11:11")
                .build();
        ImlResponse<List<ImlProductResp>> response = imlServer.getSkuList(imlProductReq);
        System.out.println(response);
    }

    @Test
    public void getWarehouseTest() {
        ImlGetProductReq imlProductReq = ImlGetProductReq.builder()
//                .page(1)
//                .pageSize(50)
                .build();
        ImlResponse<List<ImlWarehouseResp>> response = imlServer.getWarehouse(imlProductReq);
        System.out.println(response);
    }

    @Test
    public void getReceivingRegionTest() {
        ImlResponse<List<ImlRegionResp>> response = imlServer.getReceivingRegion();
        System.out.println(response);
    }

    @Test
    public void getReceiptBatchTest() {
        ImlGetReceiptReq imlGetReceiptReq = ImlGetReceiptReq.builder()
                .page(3)
                .pageSize(100)
//                .receivingCode("RV86526-230919-0005")
//                .receivingCodeArr(Arrays.asList("RV86526-230919-0005","RV86526-231107-0001"))
                .build();
        ImlResponse<List<ImlReceiptResp>> response = imlServer.getReceiptBatch(imlGetReceiptReq);
        System.out.println(response);
    }

    @Test
    public void getProductInventoryTest() {
        ImlGetInventoryReq imlGetInventoryReq = ImlGetInventoryReq.builder()
                .page(1)
                .pageSize(1000)
//                .receivingCode("RV86526-230919-0005")
                .build();
        ImlResponse<List<ImlInventoryResp>> response = imlServer.getProductInventory(imlGetInventoryReq);
        System.out.println(response);
    }

    @Test
    public void createInboundBillTest() {
        ImlCreateInboundReq imlGetReceiptReq = ImlCreateInboundReq.builder()
                .referenceNo("wjtest20231116001")
                .warehouseCode("UAW1")
                .verify(0)
                .items(Arrays.asList(ImlCreateInboundReq.Item.builder()
                                .productSku("2898")
                                .boxNo(1)
                                .quantity(1)
                        .build()))
                .build();
        ImlResponse<String> response = imlServer.createInboundBill(imlGetReceiptReq);
        System.out.println(response);
    }

    @Test
    public void cancelInboundBillTest() {
        ImlResponse<String> response = imlServer.cancelInboundBill("RV86526-231116-0006");
        System.out.println(response);
    }

    @Test
    public void createOutboundBillTest() {
        ImlCreateOutboundReq imlCreateOutboundReq;
        String json = " {\n" +
                "                    \"platform\":\"OTHER\",\n" +
                "                    \"allocated_auto\":\"0\",\n" +
                "                    \"warehouse_code\":\"RUS2\",\n" +
                "                    \"shipping_method\":\"AE-HUB-3000566871\",\n" +
                "                    \"reference_no\":\"wjtest20231116001\",\n" +
                "                    \"aliexpress_order_no\":\"8000777788889999\",\n" +
                "                    \"order_desc\":\"\\u8ba2\\u5355\\u63cf\\u8ff0\",\n" +
                "                    \"country_code\":\"RU\",\n" +
                "                    \"province\":\"province\",\n" +
                "                    \"city\":\"city\",\n" +
                "                    \"address1\":\"address1\",\n" +
                "                    \"address2\":\"address2\",\n" +
                "                    \"address3\":\"address3\",\n" +
                "                    \"zipcode\":\"142970\",\n" +
                "                    \"doorplate\":\"doorplate\",\n" +
                "                    \"company\":\"company\",\n" +
                "                    \"name\":\"name\",\n" +
                "                    \"phone\":\"123456789124\",\n" +
                "                    \"cell_phone\":\"cell_phone\",\n" +
                "                    \"email\":\"email\",\n" +
                "                    \"is_order_cod\":\"1\",\n" +
                "                    \"order_cod_price\":\"99\",\n" +
                "                    \"order_cod_currency\":\"RMB\",\n" +
                "                    \"order_age_limit\":\"22\",\n" +
                "                    \"is_signature\":\"0\",\n" +
                "                    \"is_insurance\":\"0\",\n" +
                "                    \"insurance_value\":\"0\",\n" +
                "                    \"items\":[\n" +
                "                        {\n" +
                "                            \"product_sku\":2898\"\",\n" +
                "                            \"product_name_en\":\"Product Name\",\n" +
                "                            \"product_declared_value\":\"5.000\",\n" +
                "                            \"quantity\":\"1\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"tracking_no\":\"123\",\n" +
                "                    \"label\":{\n" +
                "                        \"file_type\":\"png\",\n" +
                "                        \"file_data\":\"hVJPjUP4+yHjvKErt5PuFfvRhd...\"\n" +
                "                    },\n" +
                "                    \"lp_code\":\"AEOWH000034596\"\n" +
                "                }";
        imlCreateOutboundReq = JSONObject.parseObject(json,new TypeReference<ImlCreateOutboundReq>() {}.getType());
        ImlResponse<String> response = imlServer.createOutboundBill(imlCreateOutboundReq);
        System.out.println(response);
    }

    @Test
    public void cancelOutboundBillTest() {
        ImlResponse<String> response = imlServer.cancelOutboundBill("86526-231116-2374",null);
        System.out.println(response);
    }

}