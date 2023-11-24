package com.sdk.tms.shopee.service;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.sdk.tms.shopee.constant.PathConstants;
import com.sdk.tms.shopee.model.base.BaseRequest;
import com.sdk.tms.shopee.model.base.BaseResponse;
import com.sdk.tms.shopee.model.logistics.request.TrackRequest;
import com.sdk.tms.shopee.model.logistics.response.TrackNumber;
import com.sdk.tms.shopee.utils.ShopeeApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author zdy
 * @ClassName ShopeeShipperService
 * @description: 物流供应商接口对接
 * @date 2023年10月30日
 * @version: 1.0
 */
@Slf4j
@Component
public class ShopeeShipperService {
    public static void main(String[] args) {
        TrackRequest trackRequest = TrackRequest.builder().build();
    }


    /**
     * 获取渠道列表
     *
     * @param baseRequest
     * @return
     */
    public BaseResponse getChannelList(BaseRequest baseRequest) {
        long timestamp = System.currentTimeMillis() / 1000L;
        baseRequest.setPath(PathConstants.GET_CHANNEL_LIST_URL);
        baseRequest.setTimestamp(timestamp);
        HashMap<String, Object> paramMap = getOrderCommonParam(baseRequest);
        return ShopeeApiUtils.sendGet(PathConstants.HOST + baseRequest.getPath(), paramMap);
    }

    /**
     * 获取跟踪号（单个接口）
     *
     * @param trackRequest
     * @return
     */
    public BaseResponse getTrackNumber(TrackRequest trackRequest) {
        trackRequest.setPath(PathConstants.GET_TRACK_NUMBER_URL);
        long timestamp = System.currentTimeMillis() / 1000L;
        trackRequest.setTimestamp(timestamp);
        BaseRequest baseRequest = BaseRequest.builder()
                .timestamp(trackRequest.getTimestamp())
                .path(trackRequest.getPath())
                .accessToken(trackRequest.getAccessToken())
                .partnerId(trackRequest.getPartnerId())
                .partnerKey(trackRequest.getPartnerKey())
                .shopId(trackRequest.getShopId())
                .build();
        HashMap<String, Object> paramMap = getOrderCommonParam(baseRequest);
        paramMap.put("order_sn", trackRequest.getOrderSn());
        return ShopeeApiUtils.sendGet(PathConstants.HOST + baseRequest.getPath(), paramMap);
    }

    /**
     * 获取跟踪号列表
     *
     * @param trackRequest
     * @return
     */
    public TrackNumber getTrackNumberList(TrackRequest trackRequest) {
        trackRequest.setPath(PathConstants.GET_TRACK_NUMBER_LIST_URL);
        long timestamp = System.currentTimeMillis() / 1000L;
        trackRequest.setTimestamp(timestamp);
        BaseRequest baseRequest = BaseRequest.builder()
                .timestamp(trackRequest.getTimestamp())
                .path(trackRequest.getPath())
                .accessToken(trackRequest.getAccessToken())
                .partnerId(trackRequest.getPartnerId())
                .partnerKey(trackRequest.getPartnerKey())
                .shopId(trackRequest.getShopId())
                .build();
        HashMap<String, Object> paramMap = getOrderCommonParam(baseRequest);
        paramMap.put("from_date", trackRequest.getFromDate());
        paramMap.put("to_date", trackRequest.getToDate());
        paramMap.put("page_size", trackRequest.getPageSize());
        paramMap.put("cursor", trackRequest.getCursor());
        BaseResponse baseResponse = ShopeeApiUtils.sendGet(PathConstants.HOST + baseRequest.getPath(), paramMap);
        if (Objects.isNull(baseResponse) || Objects.isNull(baseResponse.getResponse())) {
            return null;
        }
        JSONObject response = baseResponse.getResponse();
        String error = response.getString("error");
        if (StrUtil.isNotEmpty(error)) {
            log.error("获取追踪号异常：{}", error);
            return null;
        }
        //追踪号列表
        return JSONObject.parseObject(response.toJSONString(), TrackNumber.class);
    }

    private HashMap<String, Object> getOrderCommonParam(BaseRequest baseRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("timestamp", baseRequest.getTimestamp());
        paramMap.put("sign", ShopeeApiUtils.getOrderSign(baseRequest.getPath(), baseRequest.getAccessToken(), baseRequest.getPartnerId(),
                baseRequest.getPartnerKey(), baseRequest.getShopId()));
        paramMap.put("shop_id", baseRequest.getShopId());
        paramMap.put("partner_id", baseRequest.getPartnerId());
        paramMap.put("access_token", baseRequest.getAccessToken());
        return paramMap;
    }
}
