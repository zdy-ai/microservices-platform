package com.sdk.tms.ubi.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.central.common.exception.BusinessException;
import com.central.common.utils.OkHttpUtils;
import com.sdk.tms.ubi.constant.PathConstants;
import com.sdk.tms.ubi.constant.UbiConstants;
import com.sdk.tms.ubi.model.BaseResult;
import com.sdk.tms.ubi.model.catalog.response.Label;
import com.sdk.tms.ubi.model.catalog.response.ServiceCataLog;
import com.sdk.tms.ubi.model.order.request.UbiOrder;
import com.sdk.tms.ubi.model.order.response.OrderResponse;
import com.sdk.tms.ubi.model.order.response.TrackBase;
import com.sdk.tms.ubi.utils.IntegrationHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zdy
 * @ClassName UbiShipperService
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Slf4j
@Component
public class UbiShipperService {

    static String host = "http://cn.etowertech.com";
    static String token = "pcloTVPCXZCD5G-RRlhBfR";
    static String key = "N1S3O3OlKKRDRfcfYFONqg";

    public static void main(String[] args) {
        List<ServiceCataLog> serviceCataLogList = getServiceCatalog();
        System.out.println("列表数:" + serviceCataLogList.size());
    }

    /**
     * 创建订单
     *
     * @param ubiOrder
     * @return
     */
    public static OrderResponse createOrder(UbiOrder ubiOrder) {
        String url = host + PathConstants.POST_CREATE_ORDERS_URL;
        System.out.println(url);
        Map<String, Object> params = BeanUtil.beanToMap(ubiOrder);
        Map<String, String> headers = IntegrationHelper.buildHeader(UbiConstants.POST_REQUEST_METHOD, url, token, key);
        String res = OkHttpUtils.doPostJson(url, params, headers);
        System.out.println(res);
        BaseResult result = JSONUtil.toBean(res, BaseResult.class);
        if (UbiConstants.SUCCESS.equalsIgnoreCase(result.getStatus())) {
            return JSONUtil.toBean(JSON.toJSONString(result.getData()), OrderResponse.class);
        } else {
            throw new BusinessException(result.getErrors());
        }
    }

    /**
     * 获取标签
     * 一个JSON格式的订单序列，可以用客户端订单号(referenceNo)或服务端订单号(orderId)或跟踪号(trackingNo)，一次最多300个。
     *
     * @param referenceNo
     * @param orderId
     * @param trackingNo
     */
    public static List<Label> getLabelSpecs(String referenceNo, String orderId, String trackingNo) {
        String url = host + PathConstants.POST_LABEL_SPECS_URL;
        System.out.println(url);
        Map<String, Object> params = new LinkedHashMap<>();
        if (StrUtil.isNotBlank(referenceNo)) {
            params.put("referenceNo", referenceNo);
        } else if (StrUtil.isNotBlank(orderId)) {
            params.put("orderId", orderId);
        } else if (StrUtil.isNotBlank(trackingNo)) {
            params.put("trackingNo", trackingNo);
        } else {
            throw new BusinessException("参数不能为空");
        }
        Map<String, String> headers = IntegrationHelper.buildHeader(UbiConstants.POST_REQUEST_METHOD, url, token, key);
        String res = OkHttpUtils.doPostJson(url, params, headers);
        System.out.println(res);
        BaseResult result = JSONUtil.toBean(res, BaseResult.class);
        if (UbiConstants.SUCCESS.equalsIgnoreCase(result.getStatus())) {
            return JSONUtil.toList((JSONArray) result.getData(), Label.class);
        } else {
            throw new BusinessException(result.getErrors());
        }
    }

    /**
     * 单件删除
     * URL支持用客户端订单号(referenceNo)或服务端订单号(orderId)来进行删除，如果为一票多件订单需要同时删除，
     * 则将客户端订单号(referenceNo)或服务端订单号(orderId)传值主单对应的值
     *
     * @param code
     */
    public static OrderResponse deleteShipperOrder(String code) {
        String url = host + StrUtil.format(PathConstants.DELETE_LABEL_SPECS_URL, code);
        System.out.println(url);
        java.util.Map<String, Object> params = new LinkedHashMap<>();
        Map<String, String> headers = IntegrationHelper.buildHeader(UbiConstants.GET_REQUEST_METHOD, url, token, key);
        String res = OkHttpUtils.doPost(url, params, headers);
        System.out.println(res);
        BaseResult result = JSONUtil.toBean(res, BaseResult.class);
        if (UbiConstants.SUCCESS.equalsIgnoreCase(result.getStatus())) {
            return JSONUtil.toBean(JSON.toJSONString(result.getData()), OrderResponse.class);
        } else {
            throw new BusinessException(result.getErrors());
        }
    }

    /**
     * 获取开通的服务
     */
    public static List<ServiceCataLog> getServiceCatalog() {
        String url = host + PathConstants.GET_SERVICE_CATALOG_URL;
        System.out.println(url);
        java.util.Map<String, Object> params = new LinkedHashMap<>();
        Map<String, String> headers = IntegrationHelper.buildHeader(UbiConstants.GET_REQUEST_METHOD, url, token, key);
        String res = OkHttpUtils.doGet(url, params, headers);
        System.out.println(res);
        BaseResult result = JSONUtil.toBean(res, BaseResult.class);
        if (UbiConstants.SUCCESS.equalsIgnoreCase(result.getStatus())) {
            return JSONUtil.toList((JSONArray) result.getData(), ServiceCataLog.class);
        } else {
            throw new BusinessException(result.getErrors());
        }
    }

    /**
     * 获取跟踪号
     * 客户使用 参考号 查询跟踪号，最多获取300条记录
     *
     * @param referenceNo
     * @param orderId
     */
    public static List<TrackBase> getTrackNumber(String referenceNo, String orderId) {
        String url = host + PathConstants.POST_TRACK_NUMBER_URL;
        System.out.println(url);
        Map<String, Object> params = new LinkedHashMap<>();
        if (StrUtil.isNotBlank(referenceNo)) {
            params.put("referenceNo", referenceNo);
        } else if (StrUtil.isNotBlank(orderId)) {
            params.put("orderId", orderId);
        } else {
            throw new BusinessException("参数不能为空");
        }
        Map<String, String> headers = IntegrationHelper.buildHeader(UbiConstants.POST_REQUEST_METHOD, url, token, key);
        String res = OkHttpUtils.doPostJson(url, params, headers);
        System.out.println(res);
        BaseResult result = JSONUtil.toBean(res, BaseResult.class);
        if (UbiConstants.SUCCESS.equalsIgnoreCase(result.getStatus())) {
            return JSONUtil.toList((JSONArray) result.getData(), TrackBase.class);
        } else {
            throw new BusinessException(result.getErrors());
        }
    }
}
