package com.sdk.tms.ubi.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.central.common.enums.EnumTimePattern;
import com.sdk.tms.ubi.constant.UrlContant;
import com.sdk.tms.ubi.model.ParamHeaderVO;
import com.sdk.tms.ubi.model.order.OrderEntity;
import com.sdk.tms.ubi.utils.HmacSHA256Utils;
import com.sdk.tms.ubi.utils.HttpCommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author zdy
 * @ClassName MabangOrderService
 * @description: TODO
 * @date 2024年03月05日
 * @version: 1.0
 */
@Slf4j
@Component
public class MabangOrderService {
    private static final Integer NOT_SHIPPED_STATUS = 6;
    private static final Integer NOT_UNSHIPPED_STATUS = 7;
    private static Integer APP_KEY = 0;

    private static String SECRET_KEY = "";

    public static void main(String[] args) {
        LocalDateTime startDate = LocalDateTime.of(2024, 3, 1, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 3, 1, 23, 59, 59);
        MabangOrderService service = new MabangOrderService();
        List<OrderEntity> orderEntities = service.querySalesList("order-get-order-list-new", startDate, endDate);
        System.out.println(orderEntities);
    }
    /**
     * 查询马帮销售订单列表
     * @param method
     * @param startDate
     * @param endDate
     * @return
     *
     * @throws Exception
     */
    public static List<OrderEntity> querySalesList(String method, LocalDateTime startDate, LocalDateTime endDate) {
        String pageSize = "1000";
        String pageIndex = "";
        //总页数
        Integer status = NOT_SHIPPED_STATUS;
        Boolean hasNext = false;
        List<OrderEntity> infoArrayList = new ArrayList<>();
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern(EnumTimePattern.y_m_dhms.toTimePattern());
        while (hasNext || NOT_SHIPPED_STATUS.equals(status)) {
            HashMap<String, Object> params = new HashMap<>(10);
            params.put("status", status);
            params.put("canSend", "3");
            if (StrUtil.isNotBlank(pageIndex)){
                params.put("cursor", pageIndex);
            }
            params.put("updateTimeStart", sdf.format(startDate));
            params.put("updateTimeEnd", sdf.format(endDate));
            params.put("maxRows", pageSize);
            ParamHeaderVO paramVo = getParamMap(method, 0, params);
            JSONObject responseMap = HttpCommonUtil.sendOkhttp(UrlContant.MABANG_HOST, paramVo.getParamsStr(), null, paramVo.getHeaderMap(), RequestMethod.POST);
            if (!Objects.equals(responseMap.getInteger("code"), 200)) {
                log.error("调用url={} param={} {}马帮销售订单数据失败 responseMap={}", UrlContant.MABANG_HOST, paramVo.getParamsStr(), JSONUtil.toJsonStr(responseMap));
                throw new RuntimeException(StrUtil.format("调用url={} param={} {}马帮销售订单数据失败 responseMap={}",
                        UrlContant.MABANG_HOST, paramVo.getParamsStr(), JSONUtil.toJsonStr(responseMap)));
            }
            JSONObject dataJson = JSONObject.parseObject(responseMap.getString("data"));
            List<OrderEntity> dataList = JSONObject.parseArray(dataJson.getString("data"), OrderEntity.class);
            hasNext = dataJson.getBoolean("hasNext");
            pageIndex = dataJson.getString("nextCursor");
            if(CollectionUtil.isNotEmpty(dataList)){
                infoArrayList.addAll(dataList);
            }
            if (!hasNext && NOT_SHIPPED_STATUS.equals(status)) {
                status = NOT_UNSHIPPED_STATUS;
                pageIndex = "";
                hasNext = true;
            }
        }
        return infoArrayList;
    }

    private static ParamHeaderVO getParamMap(String method,Integer pageIndex, Map<String,Object> params) {
        params.put("page", pageIndex);
        Map<String, Object> paramMap = new HashMap(16);
        paramMap.put("api", method);
        paramMap.put("appkey", APP_KEY);
        paramMap.put("version", 1);
        paramMap.put("timestamp", new Long(System.currentTimeMillis() / 1000).toString());
        paramMap.put("data",params);
        String paramStr = JSONUtil.toJsonStr(paramMap);
        String sign = HmacSHA256Utils.hmacSHA256(paramStr, SECRET_KEY);
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", sign);
        return new ParamHeaderVO(paramStr, headerMap);
    }

}
