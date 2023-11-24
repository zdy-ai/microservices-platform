package com.erp.tms.aliexpress.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderRequest
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest implements Serializable {
    /**
     *是否同意升级逆向高货值保险
     */
    @JSONField(name = "is_agree_upgrade_reverse_parcel_insure")
    private Boolean is_agree_upgrade_reverse_parcel_insure;
    /**
     *订单对应收货地址OAID
     */
    @JSONField(name = "oaid")
    private String oaid;
    /**
     *发货方式：上门揽收DOOR_PICKUP, 自寄SELF_POST, 自送SELF_SEND
     */
    @JSONField(name = "pickup_type")
    private String pickup_type;

    /**
     *addresses
     */
    @JSONField(name = "address_d_t_os")
    private AddressDTO address_d_t_os;

    /**
     *国内快递公司名称,物流公司Id为-1时,必填
     */
    @NotNull(message = "申报产品信息为空")
    @JSONField(name = "declare_product_d_t_os")
    private List<DeclareProduct> declareProducts;
    /**
     *国内快递公司名称,物流公司Id为-1时,必填
     */
    @JSONField(name = "domestic_logistics_company")
    private String domestic_logistics_company;
    /**
     *国内快递ID(物流公司是other时,ID为-1)
     * 是
     */
    @NotNull(message = "国内快递ID不能为空")
    @JSONField(name = "domestic_logistics_company_id")
    private Long domestic_logistics_company_id;
    /**
     *
     */
    @JSONField(name = "domestic_tracking_no")
    private String domestic_tracking_no;
    /**
     * 包裹数量： 创建国家小包订单时非必填，创建国家快递订单时必填
     *是
     */
    @JSONField(name = "package_num")
    private Integer package_num;
    /**
     *订单来源
     * 是
     */
    @NotNull(message = "订单来源不能为空")
    @JSONField(name = "trade_order_from")
    private String trade_order_from;
    /**
     *交易订单号
     * 是
     */
    @NotNull(message = "交易订单号不能为空")
    @JSONField(name = "trade_order_id")
    private String trade_order_id;
    /**
     *不可达处理(退回:0/销毁:1) 。详情请参考：http://bbs.seller.aliexpress.com/bbs/read.php?tid=514111
     */
    @JSONField(name = "undeliverable_decision")
    private String undeliverable_decision;
    /**
     *”根据订单号获取线上发货物流方案“API获取用户选择的实际发货物流服务（物流服务key,即仓库服务名称)例如：HRB_WLB_ZTOGZ是 中俄航空 Ruston广州仓库； HRB_WLB_RUSTONHEB为哈尔滨备货仓暂不支持，该渠道请做忽略。
     * 是
     */
    @NotNull(message = "发货物流方案不能为空")
    @JSONField(name = "warehouse_carrier_service")
    private String warehouse_carrier_service;

    /**
     *发票号（可空）
     */
    @JSONField(name = "invoice_number")
    private String invoice_number;
    /**
     *ISV用户唯一标识，一般为userId,最大长度为16个字符
     */
    @JSONField(name = "top_user_key")
    private String top_user_key;
    /**
     *
     * 包裹保额
     */
    @JSONField(name = "insurance_coverage")
    private InsuranceCoverage insuranceCoverage;

}
