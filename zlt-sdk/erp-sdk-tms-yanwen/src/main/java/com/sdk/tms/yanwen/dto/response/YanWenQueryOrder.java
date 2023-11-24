package com.sdk.tms.yanwen.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author liuruipeng
 */
@Data
@NoArgsConstructor
@ToString
public class YanWenQueryOrder {

    //运单号
    private String waybillNumber;

    //订单号
    private String orderNumber;

    //转单号
    private String referenceNumber;

    //燕文参考单号
    private String yanwenNumber;

    //发货账号
    private String userId;

    //产品编号(产品 id)
    private String channelId;

    //产品中文名称
    private String channelName;

    //收款到账日期
    private Date dateOfReceipt;

    //下单时间
    private Date createTime;

    //运单状态:0 已制单 1 已确认发货 2 已收货3 运输途中 4 已妥投 5 已取消 6 已截留 7派送异常 8 异常 9 退件;
    private Integer status;

    //是否打印 1:是 0:否
    private Integer isPrint;

    //拣货单信息
    private String remark;

    //收件人信息
    private ReceiverInfo receiverInfo;

    @Data
    public static class ReceiverInfo {

        //收件人姓名
        private String name;

        //收件人电话
        private String phone;

        //收件人公司
        private String company;

        //收件人邮箱
        private String email;

        //收件人国家 Id
        private String countryId;

        //收件人国家
        private String countryName;

        //收件人所属州(省)
        private String state;

        //收件人城市
        private String city;

        //收件人邮编
        private String zipCode;

        //收件人门牌号
        private String houseNumber;

        //收件人地址
        private String address;

        //收件人税号
        private String taxNumber;
    }

    //发件人信息
    private SenderInfo senderInfo;

    @Data
    public static class SenderInfo {

        //发件人姓名
        private String name;

        //发件人电话
        private String phone;

        //发件人公司
        private String company;

        //发件人邮箱
        private String email;

        //发件人国家 Id
        private String countryId;

        //发件人国家
        private String countryName;

        //发件人所属州(省)
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
    private ParcelInfo parcelInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ParcelInfo {

        //是否带电 1:是 0:否
        private Integer hasBattery;

        //币种代码传 USD,EUR,GBP,CNY,AUD,CAD;
        private String currency;

        //申报总价值
        private BigDecimal totalPrice;

        //申报总数量
        private Integer totalQuantity;

        //总重量(单位:g)
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
        private List<Product> productList;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Product {

            //中文品名
            private String goodsNameCh;

            private String goodsNameEn;

            //申报单价
            private BigDecimal price;

            //数量
            private Integer quantity;

            //单件重量(单位:g)
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
