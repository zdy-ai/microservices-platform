package com.sdk.oms.shopee.service;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sdk.oms.shopee.dto.base.ShopeeResponse;
import com.sdk.oms.shopee.dto.product.request.ProductRequest;
import com.sdk.oms.shopee.dto.product.response.Item;
import com.sdk.oms.shopee.dto.product.response.ItemInfo;
import com.sdk.oms.shopee.utils.ShopeeApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.sdk.oms.shopee.constants.ShopeeConstants.*;

/**
 * @author zdy
 * @ClassName ShopeeProductService
 * @description: TODO
 * @date 2023年10月20日
 * @version: 1.0
 */
@Slf4j
@Component
@Service
public class ShopeeProductService {

    public static void main(String[] args) {
        ShopeeProductService shopeeProductService = new ShopeeProductService();
        //产品列表
        ProductRequest productRequest = ProductRequest.builder()
                .host(host)
                .offset(0)
                .token(shop_access_token)
                .shopId(shop_id)
                .partnerId(partner_id)
                .tmpPartnerKey(tmp_partner_key)
                .timeTo(null)
                .timeFrom(null)
                .build();
        List<ItemInfo> productList = new ArrayList<>(0);
        shopeeProductService.getAllProduct(productRequest, productList);
//        JSONObject response = productList.getResponse();
//        JSONArray list = (JSONArray) response.get("item");
//        List<Item> items = JSONObject.parseArray(list.toJSONString(), Item.class);
//        ShopeeProduct shopeeProduct = ShopeeProduct.builder().build();
//        int total_count = (int) response.get("total_count");
//        Boolean has_next_page = (Boolean) response.get("has_next_page");
//        String next = (String) response.get("next");
        System.out.println(productList.size());
//        System.out.println(total_count);
//        System.out.println(has_next_page);
//        System.out.println(next);

//        ShopeeResponse productItemBaseInfo = shopeeProductService.getProductItemBaseInfo(host, shop_access_token, shop_id, partner_id, tmp_partner_key, "22982747521");
//        ShopeeResponse productItemExtraInfo = shopeeProductService.getProductItemExtraInfo(host, shop_access_token, shop_id, partner_id, tmp_partner_key, "22982747521");

    }

    public void getAllProduct(ProductRequest productRequest, List<ItemInfo> itemInfos) {
        log.info("获取产品订单：{}", productRequest);
        ShopeeResponse productList = this.getProductList(productRequest);
        if (Objects.isNull(productList) || Objects.isNull(productList.getResponse())) {
            return;
        }
        JSONObject response = productList.getResponse();

        String error = response.getString("error");
        if (StrUtil.isNotEmpty(error)) {
            return;
        }
        JSONArray jsonArray = (JSONArray) response.get("item");
        //目录列表
        List<Item> items = JSONObject.parseArray(jsonArray.toJSONString(), Item.class);
        //获取item明细
        List<Long> itemIds = items.stream().map(Item::getItemId).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(itemIds)) {
            productRequest.setItemIdList(StrUtil.join(",", itemIds));
            ShopeeResponse productItemBaseInfo = this.getProductItemBaseInfo(productRequest);
            JSONObject responseBaseInfo = productItemBaseInfo.getResponse();
            if (Objects.nonNull(responseBaseInfo)) {
                //循环填充
                JSONArray listBase = responseBaseInfo.getJSONArray("item_list");
                List<ItemInfo> list = JSONObject.parseArray(listBase.toJSONString(), ItemInfo.class);
                if (CollectionUtils.isNotEmpty(list)) {
                    itemInfos.addAll(list);
                }
            }
        }
        //是否还有数据
        boolean hasNextPage = response.getBoolean("has_next_page");
        if (hasNextPage) {
            Integer next_offset = response.getInteger("next_offset");
            productRequest.setOffset(next_offset);
            getAllProduct(productRequest, itemInfos);
        }
//        System.out.println(responseBaseInfo);
//        ShopeeResponse productItemExtraInfo = this.getProductItemExtraInfo(host, token, shopId, partner_id, tmp_partner_key, StringUtils.join(itemIds, ","));
//        JSONObject responseExtraInfo = productItemExtraInfo.getResponse();
//        System.out.println(responseExtraInfo);
    }

    public ShopeeResponse getProductList(ProductRequest productRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        String path = "/api/v2/product/get_item_list";
        long timestamp = System.currentTimeMillis() / 1000L;
        paramMap.put("timestamp", timestamp);
        paramMap.put("sign", ShopeeApiUtils.getOrderSign(path, productRequest.getToken(), productRequest.getPartnerId(),
                productRequest.getTmpPartnerKey(), productRequest.getShopId()));
        paramMap.put("shop_id", productRequest.getShopId());
        paramMap.put("partner_id", productRequest.getPartnerId());
        paramMap.put("access_token", productRequest.getToken());
        paramMap.put("offset", productRequest.getOffset());
        paramMap.put("page_size", pageSize);
        if (Objects.nonNull(productRequest.getTimeFrom())) {
            paramMap.put("update_time_from", productRequest.getTimeFrom());
        }
        if (Objects.nonNull(productRequest.getTimeTo())) {
            paramMap.put("update_time_to", productRequest.getTimeTo());
        }
        paramMap.put("item_status", "NORMAL");
        return ShopeeApiUtils.sendGet(productRequest.getHost() + path, paramMap);
    }

    public ShopeeResponse getProductItemBaseInfo(ProductRequest productRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        String path = "/api/v2/product/get_item_base_info";
        paramMap.put("timestamp", new Long(System.currentTimeMillis() / 1000).toString());
        paramMap.put("sign", ShopeeApiUtils.getOrderSign(path, productRequest.getToken(), productRequest.getPartnerId(),
                productRequest.getTmpPartnerKey(), productRequest.getShopId()));
        paramMap.put("shop_id", productRequest.getShopId());
        paramMap.put("partner_id", productRequest.getPartnerId());
        paramMap.put("access_token", productRequest.getToken());
        paramMap.put("item_id_list", productRequest.getItemIdList());
        paramMap.put("need_complaint_policy", true);
        paramMap.put("need_tax_info", true);
        return ShopeeApiUtils.sendGet(productRequest.getHost() + path, paramMap);
    }

    public ShopeeResponse getProductItemExtraInfo(String host, String token, long shopId, long partner_id, String tmp_partner_key, String itemIdList) {
        HashMap<String, Object> paramMap = new HashMap<>();
        String path = "/api/v2/product/get_item_extra_info";
        paramMap.put("timestamp", new Long(System.currentTimeMillis() / 1000).toString());
        paramMap.put("sign", ShopeeApiUtils.getOrderSign(path, token, partner_id, tmp_partner_key, shopId));
        paramMap.put("shop_id", shopId);
        paramMap.put("partner_id", partner_id);
        paramMap.put("access_token", token);
        paramMap.put("item_id_list", itemIdList);
        return ShopeeApiUtils.sendGet(host + path, paramMap);
    }

}
