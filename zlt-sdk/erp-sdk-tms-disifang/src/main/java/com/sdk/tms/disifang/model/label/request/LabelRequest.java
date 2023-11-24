package com.sdk.tms.disifang.model.label.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName LabelRequest
 * @description: 标签请求类
 * @date 2023年11月01日
 * @version: 1.0
 */
@Data
@Builder
public class LabelRequest implements Serializable {
    /**
     * 请求单号（支持4PX单号、客户单号和面单号）
     */
    @NotBlank(message = "请求单号不能为空")
    @JSONField(name = "request_no")
    private List<String> requestNo;
    /**
     * 物流产品代码
     */
    @NotBlank(message = "物流产品代码不能为空")
    @JSONField(name = "logistics_product_code")
    private String logisticsProductCode;

    @JSONField(name = "label_size")
    private String labelSize;
    /**
     * 是否打印当前时间（Y：打印；N：不打印） 默认为N；
     */
    @JSONField(name = "is_print_time")
    private String isPrintTime= "N";
    /**
     * 是否打印买家ID（Y：打印；N：不打印） 默认为N；
     */
    @JSONField(name = "is_print_buyer_id")
    private String isPrintBuyerId= "N";
    /**
     * 是否在标签上打印配货信息（Y：打印；N：不打印）；默认为N。 注：只对4PX通用标签/普通标签的控制有效；这里的配货信息指是否在标签上打印配货信息。若需单独打印配货单，使用create_package_label字段控制。
     */
    @JSONField(name = "is_print_pick_info")
    private String isPrintPickInfo= "N";
    /**
     * 是否打印报关单（Y：打印；N：不打印） 默认为N；
     */
    @JSONField(name = "is_print_declaration_list")
    private String isPrintDeclarationList= "N";
    /**
     * 报关单上是否打印客户预报重（Y：打印；N：不打印） 默认为N。 注：针对单独打印报关单功能；
     */
    @JSONField(name = "is_print_customer_weight")
    private String isPrintCustomerWeight= "N";
    /**
     * 是否单独打印配货单（Y：打印；N：不打印） 默认为N。
     */
    @JSONField(name = "create_package_label")
    private String createPackageLabel = "N";
    /**
     * 配货单上是否打印配货条形码（Y：打印；N：不打印） 默认为N。 注：针对单独打印配货单功能；
     */
    @JSONField(name = "is_print_pick_barcode")
    private String isPrintPickBarcode= "N";
}
