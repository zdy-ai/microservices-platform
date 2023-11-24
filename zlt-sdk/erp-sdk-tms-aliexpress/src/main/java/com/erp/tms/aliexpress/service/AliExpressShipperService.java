package com.erp.tms.aliexpress.service;

import cn.hutool.core.collection.ListUtil;
import com.alibaba.fastjson.JSONObject;
import com.common.core.utils.UUID;
import com.erp.tms.aliexpress.api.IopClient;
import com.erp.tms.aliexpress.api.IopClientImpl;
import com.erp.tms.aliexpress.api.IopRequest;
import com.erp.tms.aliexpress.api.IopResponse;
import com.erp.tms.aliexpress.constants.PathConstants;
import com.erp.tms.aliexpress.domain.Protocol;
import com.erp.tms.aliexpress.model.channel.response.ChannelResult;
import com.erp.tms.aliexpress.model.label.request.LabelRequest;
import com.erp.tms.aliexpress.model.label.response.LabelResult;
import com.erp.tms.aliexpress.model.order.request.OrderRequest;
import com.erp.tms.aliexpress.model.order.request.QueryOrderRequest;
import com.erp.tms.aliexpress.model.order.response.BaseResult;
import com.erp.tms.aliexpress.model.order.response.OrderResult;
import com.erp.tms.aliexpress.util.ApiException;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zdy
 * @ClassName AliExpressShipperService
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Slf4j
@Component
public class AliExpressShipperService {
    private void validate(String appKey,String appSecret,String token,String url){
        assert StringUtils.isNotEmpty(appKey);
        assert StringUtils.isNotEmpty(appSecret);
        assert StringUtils.isNotEmpty(token);
        assert StringUtils.isNotEmpty(url);
    }
    public ChannelResult getChanelList(Map<String, String> authMap) throws ApiException, InterruptedException {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String token = authMap.get("token");
        String url = authMap.get("url");
        validate(appKey,appSecret,token,url);
        IopClient client = new IopClientImpl(url, appKey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.logistics.redefining.listlogisticsservice");
        request.addApiParameter("simplify", "true");
        IopResponse response = client.execute(request, token, Protocol.TOP);
        return JSONObject.parseObject(response.getBody(), ChannelResult.class);
    }

    public OrderResult createOrder(Map<String, String> authMap, OrderRequest orderRequest) throws ApiException, InterruptedException {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String token = authMap.get("token");
        String url = authMap.get("url");
        validate(appKey,appSecret,token,url);
        IopClient client = new IopClientImpl(url, appKey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.logistics.order.createorder");
        request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", String.valueOf(orderRequest.getIs_agree_upgrade_reverse_parcel_insure()));
        request.addApiParameter("oaid", orderRequest.getOaid());
        request.addApiParameter("pickup_type", orderRequest.getPickup_type());
        request.addApiParameter("address_d_t_os", JSONObject.toJSONString(orderRequest.getAddress_d_t_os()));
        request.addApiParameter("declare_product_d_t_os", JSONObject.toJSONString(orderRequest.getDeclareProducts()));
        request.addApiParameter("domestic_logistics_company", orderRequest.getDomestic_logistics_company());
        request.addApiParameter("domestic_logistics_company_id", String.valueOf(orderRequest.getDomestic_logistics_company_id()));
        request.addApiParameter("domestic_tracking_no", orderRequest.getDomestic_tracking_no());
        request.addApiParameter("package_num", String.valueOf(orderRequest.getPackage_num()));
        request.addApiParameter("trade_order_from", orderRequest.getTrade_order_from());
        request.addApiParameter("trade_order_id", orderRequest.getTrade_order_id());
        request.addApiParameter("undeliverable_decision", orderRequest.getUndeliverable_decision());
        request.addApiParameter("warehouse_carrier_service", orderRequest.getWarehouse_carrier_service());
        request.addApiParameter("invoice_number", orderRequest.getInvoice_number());
        request.addApiParameter("top_user_key", orderRequest.getTop_user_key());
        request.addApiParameter("insurance_coverage", JSONObject.toJSONString(orderRequest.getInsuranceCoverage()));
        request.addApiParameter("simplify", "true");
        IopResponse response = client.execute(request, token, Protocol.TOP);
        return JSONObject.parseObject(response.getBody(), OrderResult.class);
    }
    public OrderResult createWareHouseOrder(Map<String, String> authMap, OrderRequest orderRequest) throws ApiException, InterruptedException {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String token = authMap.get("token");
        String url = authMap.get("url");
        validate(appKey,appSecret,token,url);
        IopClient client = new IopClientImpl(url, appKey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.logistics.createwarehouseorder");
        request.addApiParameter("declare_product_d_t_os", JSONObject.toJSONString(orderRequest.getDeclareProducts()));
        request.addApiParameter("domestic_logistics_company", orderRequest.getDomestic_logistics_company());
        request.addApiParameter("domestic_logistics_company_id", String.valueOf(orderRequest.getDomestic_logistics_company_id()));
        request.addApiParameter("domestic_tracking_no", orderRequest.getDomestic_tracking_no());
        request.addApiParameter("package_num", String.valueOf(orderRequest.getPackage_num()));
        request.addApiParameter("trade_order_from", orderRequest.getTrade_order_from());
        request.addApiParameter("trade_order_id", orderRequest.getTrade_order_id());
        request.addApiParameter("undeliverable_decision", orderRequest.getUndeliverable_decision());
        request.addApiParameter("warehouse_carrier_service", orderRequest.getWarehouse_carrier_service());
        request.addApiParameter("address_d_t_os", JSONObject.toJSONString(orderRequest.getAddress_d_t_os()));
        request.addApiParameter("top_user_key", orderRequest.getTop_user_key());
        request.addApiParameter("insurance_coverage", JSONObject.toJSONString(orderRequest.getInsuranceCoverage()));
        request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", String.valueOf(orderRequest.getIs_agree_upgrade_reverse_parcel_insure()));
        request.addApiParameter("simplify", "true");
        IopResponse response = client.execute(request, token, Protocol.TOP);
        return JSONObject.parseObject(response.getBody(), OrderResult.class);
    }

    public IopResponse logisticsCompany(Map<String, String> authMap) throws ApiException {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String token = authMap.get("token");
        String url = authMap.get("url");
        validate(appKey,appSecret,token,url);
        IopClient client = new IopClientImpl(url, appKey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.logistics.redefining.qureywlbdomesticlogisticscompany");
        request.addApiParameter("simplify", "true");
        IopResponse response = client.execute(request, token, Protocol.TOP);
        return response;
    }

    public LabelResult getLabelList(Map<String, String> authMap, LabelRequest labelRequest) throws ApiException {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String token = authMap.get("token");
        String url = authMap.get("url");
        validate(appKey,appSecret,token,url);
        IopClient client = new IopClientImpl(url, appKey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.logistics.redefining.getprintinfos");
        request.addApiParameter("simplify", "true");
        request.addApiParameter("print_detail", String.valueOf(labelRequest.getPrint_detail()));
        request.addApiParameter("warehouse_order_query_d_t_os", JSONObject.toJSONString(labelRequest.getWarehouseOrderQueries()));
        IopResponse response = client.execute(request, token, Protocol.TOP);
        return JSONObject.parseObject(response.getBody(), LabelResult.class);
    }

    public BaseResult queryLogisticsOrder(Map<String, String> authMap, QueryOrderRequest queryOrderRequest) throws ApiException {
        String appKey = authMap.get("clientId");
        String appSecret = authMap.get("clientSecret");
        String token = authMap.get("token");
        String url = authMap.get("url");
        validate(appKey,appSecret,token,url);
        IopClient client = new IopClientImpl(url, appKey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.logistics.querylogisticsorderdetail");
        request.addApiParameter("current_page", String.valueOf(queryOrderRequest.getCurrent_page()));
        request.addApiParameter("domestic_logistics_num", queryOrderRequest.getDomestic_logistics_num());
        request.addApiParameter("gmt_create_end_str", queryOrderRequest.getGmt_create_end_str());
        request.addApiParameter("gmt_create_start_str", queryOrderRequest.getGmt_create_start_str());
        request.addApiParameter("international_logistics_num", queryOrderRequest.getInternational_logistics_num());
        request.addApiParameter("logistics_status", queryOrderRequest.getLogistics_status());
        request.addApiParameter("page_size", String.valueOf(queryOrderRequest.getPage_size()));
        request.addApiParameter("trade_order_id", queryOrderRequest.getTrade_order_id());
        request.addApiParameter("warehouse_carrier_service", queryOrderRequest.getWarehouse_carrier_service());
        request.addApiParameter("simplify", "true");
        IopResponse response = client.execute(request, token, Protocol.TOP);
        return JSONObject.parseObject(response.getBody(), BaseResult.class);
    }
    public void generateToken(String code) throws ApiException {
        IopClient client = new IopClientImpl(PathConstants.BASE_URL, PathConstants.APP_KEY, PathConstants.APP_SECRET);
        IopRequest request = new IopRequest();
        request.setApiName("/auth/token/create");
        request.addApiParameter("code", code);
        IopResponse response = client.execute(request, Protocol.GOP);
    }

    public static void main(String[] args) throws ApiException {
        AliExpressShipperService service = new AliExpressShipperService();
        String code = "3_502978_F2ZeTUjueN7NNh6uow4mU1365978";
        service.generateToken(code);
    }
}
