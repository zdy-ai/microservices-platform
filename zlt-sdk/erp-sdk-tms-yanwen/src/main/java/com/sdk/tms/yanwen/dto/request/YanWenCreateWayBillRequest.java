package com.sdk.tms.yanwen.dto.request;

import com.common.core.anno.StateEnumValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author liuruipeng
 * @date 2023年10月30日 11:44
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YanWenCreateWayBillRequest {

    //渠道id
    @NotBlank(message = "渠道id不能为空")
    private String channelId;

    //订单来源
    @NotBlank(message = "订单来源不能为空")
    private String orderSource;

    //订单号
    @NotBlank(message = "订单号不能为空")
    private String orderNumber;

    //收款到账日期 格式 yyyy-MM-dd
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfReceipt;

    //交货仓/仓库代码，详细参考公共服务(查询交货仓列表)。若不传则默认取客户号所属仓库代码；
    private String companyCode;

    //拣货单信息/备注（打印标签选择打印拣货单显示此字段信息）
    private String remark;

    //收件人信息
    @Valid
    @NotNull
    private ReceiverInfo receiverInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReceiverInfo {

        //收件人姓名
        @NotBlank(message = "收件人姓名不能为空")
        private String name;

        //目的国 id 或目的国二字码
        @NotBlank(message = "目的国 id 或目的国二字码不能为空")
        private String country;

        //收件人地址
        @NotBlank(message = "收件人地址不能为空")
        private String address;

        //收件人电话
        @NotBlank(message = "收件人电话不能为空")
        private String phone;

        //收件人州(省)
        @NotBlank(message = "收件人州(省)不能为空")
        private String state;

        //收件人城市
        @NotBlank(message = "收件人城市不能为空")
        private String city;

        //邮编
        @NotBlank(message = "邮编不能为空")
        private String zipCode;

        //收件人邮箱
        private String email;
        //收件人公司
        private String company;


        //收件人门牌号
        private String houseNumber;

        //收件人税号
        private String taxNumber;
    }

    //发件人信息
    @Valid
    private SenderInfo senderInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SenderInfo {

        //发件人姓名
        private String name;

        //发件人电话
        private String phone;

        //发件人公司
        private String company;

        //发件人邮箱
        private String email;

        //发件人国家
        private String country;

        //发件人州(省)
        private String state;

        //发件人城市
        private String city;

        //发件人邮编
        private String zipCode;

        //发件人门牌号
        private String houseNumber;

        //发件人地址
        private String address;

        //发件人税号
        private String taxNumber;
    }

    //包裹信息
    @Valid
    @NotNull
    private ParcelInfo parcelInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ParcelInfo {

        //是否带电 1:是 0:否
        @NotNull(message = "是否带电标识不能为空")
        private Integer hasBattery;

        //币种代码传 USD,EUR,GBP,CNY,AUD,CAD;
        @NotNull(message = "币种代码不能为空")
        @StateEnumValue(strValues = {"USD", "EUR","GBP","CNY","AUD","CAD"}, message = "币种代码有误")
        private String currency;

        //申报总价值
        @NotNull(message = "申报总价值不能为空")
        private BigDecimal totalPrice;

        //申报总数量
        @NotNull(message = "申报总数量不能为空")
        private Integer totalQuantity;

        //总重量(单位:g)
        @NotNull(message = "总重量不能为空")
        private Integer totalWeight;

        //包裹高(单位:cm)
        private Integer height;

        //包裹宽(单位:cm)
        private Integer width;

        //包裹长(单位:cm)
        private Integer length;

        //IOSS 税号
        private String ioss;

        //商品信息（支持 5 组）
        @Valid
        @NotNull(message = "商品信息不能为空")
        private List<Product> productList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Product {

            //中文品名
            @NotNull(message = "中文品名不能为空")
            private String goodsNameCh;

            @NotNull(message = "英文品名不能为空")
            private String goodsNameEn;

            //申报单价
            @NotNull(message = "申报单价不能为空")
            private BigDecimal price;

            //数量
            @NotNull(message = "数量不能为空")
            private Integer quantity;

            //单件重量(单位:g)
            @NotNull(message = "单件重量(单位:g)不能为空")
            private Integer weight;

            //海关编码
            private String hscode;

            //商品链接
            private String url;

            //商品材质
            private String material;
        }
    }
}
