package com.sdk.oms.shopee.dto;

import com.common.business.dto.*;
import com.common.business.enums.LogisticsPlatformEnum;
import com.common.business.enums.PlatformDictEnum;
import com.erp.model.oms.enums.SoB2cBillStatusEnum;
import com.erp.model.oms.enums.SoB2cPayStatusEnum;
import com.sdk.oms.shopee.dto.order.response.OrderDetail;
import com.sdk.oms.shopee.dto.order.response.OrderItemDetail;
import com.sdk.oms.shopee.dto.order.response.Package;
import com.sdk.oms.shopee.dto.order.response.RecipientAddress;
import com.sdk.oms.shopee.dto.product.response.ImageInfo;
import com.sdk.oms.shopee.enums.OrderStatusEnum;
import io.seata.common.util.CollectionUtils;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 平台亚马逊订单DTO
 *
 * @Author Cloud
 * @Date 2023/8/31 16:01
 **/
@Slf4j
@Setter
@Getter
@NoArgsConstructor
public class PlatformShopeeOrderDTO extends CleanBaseDTO {

    private OrderDetail orderDetail;

    private String shopId;

    public PlatformShopeeOrderDTO(OrderDetail orderDetail, JobTaskDTO dto) {
        this.orderDetail = orderDetail;
        this.shopId = dto.getShopId();
        this.setIsClean(0);
        this.setPlatform(PlatformDictEnum.SHOPEE.getCode());
        this.setUniqueId(orderDetail.getOrdersn());
        this.setDownloadTime(LocalDateTime.now(ZoneId.systemDefault()).toString());
        this.setLastPushTime(dto.getNextTime().toString());
    }

    /**
     * 转换目标实体:PlatformProductDTO
     */
    public static PlatformOrderDTO convertDTO(PlatformShopeeOrderDTO dto) {
        PlatformOrderDTO orderDTO = new PlatformOrderDTO();
        OrderDetail orderDetail = dto.getOrderDetail();
        String shopId = dto.getShopId();

        Long createTime = orderDetail.getCreateTime();
        Instant instant = Instant.ofEpochSecond(createTime);
        ZoneId zone = ZoneId.systemDefault();

        // 订单日期
        orderDTO.setBillDate(LocalDateTime.ofInstant(instant, zone).toLocalDate());
        // 平台订单号
        orderDTO.setPlatformCode(orderDetail.getOrdersn());
        // 销售平台
        orderDTO.setDictPlatform(PlatformDictEnum.SHOPEE.getCode());
        // 店铺ID
        orderDTO.setShopId(shopId);

        // 作废类型（manual手动作废，automatic自动作废）
        orderDTO.setInvalidType("");
        // 作废原因
        orderDTO.setInvalidRemark("");
        // 作废状态（false未作废，true已作废）
        orderDTO.setInvalidStatus(false);
        // 订单状态
        // （soB2cBillStatus字典类型）  SoB2cBillStatusEnum
        //UNPAID/READY_TO_SHIP/PROCESSED/SHIPPED/COMPLETED/IN_CANCEL/CANCELLED/INVOICE_PENDING
//        orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_WAIT_SHIPPED.getCode());
        String orderStatus = orderDetail.getStatus();
        if (OrderStatusEnum.UNPAID.getCode().equals(orderStatus)) {
            orderDTO.setPayStatus(SoB2cPayStatusEnum.ENUM_PAYMENT.getCode());
            orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_WAIT_SHIPPED.getCode());
        } else if (OrderStatusEnum.READY_TO_SHIP.getCode().equals(orderStatus)) {
            orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_WAIT_SHIPPED.getCode());
        } else if (OrderStatusEnum.PROCESSED.getCode().equals(orderStatus)) {
            orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_WAIT_SHIPPED.getCode());
        } //已完成之前 全为待发货
        else if (OrderStatusEnum.SHIPPED.getCode().equals(orderStatus)) {
            orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_SHIPPED.getCode());
        } else if (OrderStatusEnum.COMPLETED.getCode().equals(orderStatus)) {
            orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_SHIPPED.getCode());
        } else if (OrderStatusEnum.IN_CANCEL.getCode().equals(orderStatus)) {
            orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_FROZEN.getCode());
        } else if (OrderStatusEnum.CANCELLED.getCode().equals(orderStatus)) {
            orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_INVALID.getCode());
            // 作废状态（false未作废，true已作废）
            orderDTO.setInvalidStatus(true);
        } else if (OrderStatusEnum.INVOICE_PENDING.getCode().equals(orderStatus)) {
            orderDTO.setBillStatus(SoB2cBillStatusEnum.ENUM_SHIPPED.getCode());
        }

        // 付款状态（待付款、已付款）
        // （soB2cPayStatus字典类型）
        Long paytime = orderDetail.getPayTime();
        if (Objects.isNull(paytime)) {
            orderDTO.setPayStatus(SoB2cPayStatusEnum.ENUM_PAYMENT.getCode());
        } else {
            orderDTO.setPayStatus(SoB2cPayStatusEnum.ENUM_PAID.getCode());
            Instant instant2 = Instant.ofEpochSecond(paytime);
            // 付款时间
            orderDTO.setPayTime(LocalDateTime.ofInstant(instant2, zone));
        }
        // 订单金额
        orderDTO.setAmount(BigDecimal.valueOf(orderDetail.getTotalAmount()));
        // 币别（原币）
        orderDTO.setCurrency(orderDetail.getCurrency());
        // 汇率
        orderDTO.setExchangeRate(BigDecimal.ONE);
        // 运费收入
        orderDTO.setShippingFee(BigDecimal.valueOf(orderDetail.getActualShippingFee()));
        // 付款金额
        orderDTO.setPayAmount(null);
        // 付款方式
        orderDTO.setDictPayMethod(orderDetail.getPaymentMethod());
        // 买家备注
        orderDTO.setBuyerRemark(orderDetail.getNote());
        // 订单备注
        orderDTO.setRemark(null);
        // 销售组织id
        Long buyerUserId = orderDetail.getBuyerUserId();
        if (Objects.nonNull(buyerUserId)) {
            orderDTO.setOrgId(String.valueOf(buyerUserId));
        }
        // 销售组织名称
        orderDTO.setOrgName(orderDetail.getBuyerUsername());
        // 是否拦截
        orderDTO.setIsIntercept(false);
        // 拦截备注
        orderDTO.setInterceptRemark("");
        // 来源类型
        orderDTO.setSourceType("soB2c");
        // 来源id
        orderDTO.setSourceId(orderDetail.getOrdersn());
        // 来源编码
        orderDTO.setSourceCode(orderDetail.getOrdersn());
        // 标签json
        orderDTO.setLabelJson(null);
        // 异常原因（1、订单规则审核不通过；2、配货规则匹配失败；3、人工审核不通过）
        orderDTO.setAbnormalType("");
        // 同步金蝶状态（默认0无需同步,1待同步,2同步中,3同步成功,4同步失败）
        orderDTO.setSyncKingdeeStatus("0");
        //明细
        orderDTO.setDetails(parseDetailDto(orderDetail));
        //B2C销售订单买家信息表
        orderDTO.setReceiverList(parseReceiverList(orderDetail));
        //B2C销售订单物流信息表
        orderDTO.setLogisticsList(parseLogisticsList(orderDetail));
        //B2C销售订单财务信息表
        orderDTO.setFinancesList(parseFinancesList(orderDetail));
        return orderDTO;
    }

    /**
     * 批量转换明细
     */
    public static List<PlatformOrderDetailDTO> parseDetailDto(OrderDetail orderDetail) {
        if (Objects.isNull(orderDetail) || CollectionUtils.isEmpty(orderDetail.getItems())) {
            return Collections.emptyList();
        }
        return orderDetail.getItems().stream()
                .map(e -> intPlatformOrderDetailDTO(e, orderDetail))
                .collect(Collectors.toList());
    }

    public static List<PlatformOrderReceiverDTO> parseReceiverList(OrderDetail orderDetail) {
        if (Objects.isNull(orderDetail) || Objects.isNull(orderDetail.getRecipientAddress())) {
            return Collections.emptyList();
        }
        RecipientAddress recipientAddress = orderDetail.getRecipientAddress();
        List<PlatformOrderReceiverDTO> receiverDTOS = new ArrayList<>();
        receiverDTOS.add(PlatformOrderReceiverDTO.builder()
                .loginId(String.valueOf(orderDetail.getBuyerUserId()))
                .customerId(String.valueOf(orderDetail.getBuyerUserId()))
                .name(recipientAddress.getName())
                .telNumber(recipientAddress.getPhone())
                .receiverTelNumber(recipientAddress.getPhone())
                .email("")
                .country(recipientAddress.getRegion())
                .provinceName(recipientAddress.getState())
                .cityName(recipientAddress.getCity())
                .districtName(recipientAddress.getDistrict())
                .postCode(recipientAddress.getZipcode())
                .firstAddress(recipientAddress.getFullAddress())
                .fullAddress(recipientAddress.getFullAddress())
                .build());
        return receiverDTOS;
    }

    public static List<PlatformOrderLogisticsDTO> parseLogisticsList(OrderDetail orderDetail) {
        if (Objects.isNull(orderDetail) || CollectionUtils.isEmpty(orderDetail.getPackages())) {
            return Collections.emptyList();
        }
        List<PlatformOrderLogisticsDTO> logisticsDTOS = new ArrayList<>();
        List<Package> packages = orderDetail.getPackages();
        packages.forEach(p->{
            Instant instant = Instant.ofEpochSecond(orderDetail.getShipByDate());
            ZoneId zone = ZoneId.systemDefault();
            PlatformOrderLogisticsDTO dto = PlatformOrderLogisticsDTO.builder()
                    .code(p.getPackageNumber())
                    .name(LogisticsPlatformEnum.SHOPEE.getName())
                    .deliveryTime(LocalDateTime.ofInstant(instant, zone))
                    .dictLogisticsMethod(p.getShippingCarrier())
                    .estimatedShippingCost(BigDecimal.valueOf(orderDetail.getEstimatedShippingFee()))
                    .actualShippingCost(BigDecimal.valueOf(orderDetail.getActualShippingFee()))
                    .accessoriesCostCurrency(orderDetail.getCurrency())
                    .actualShippingCurrency(orderDetail.getCurrency())
                    .estimatedShippingCurrency(orderDetail.getCurrency())
                    .build();
            logisticsDTOS.add(dto);
        });
        return logisticsDTOS;
    }

    public static List<PlatformOrderFinanceDTO> parseFinancesList(OrderDetail orderDetail) {
        if (Objects.isNull(orderDetail) || Objects.isNull(orderDetail.getInvoice())) {
            return Collections.emptyList();
        }
        List<PlatformOrderFinanceDTO> financeDTOList = new ArrayList<>();
        PlatformOrderFinanceDTO dto = PlatformOrderFinanceDTO.builder()
                .currency(orderDetail.getCurrency())
                .logisticsCost(BigDecimal.valueOf(orderDetail.getActualShippingFee()))
                .build();
        return financeDTOList;
    }

    /**
     * 转换明细
     */
    private static PlatformOrderDetailDTO intPlatformOrderDetailDTO(OrderItemDetail item, OrderDetail orderDetail) {
        PlatformOrderDetailDTO detailDTO = new PlatformOrderDetailDTO();
        // 图片URL
        ImageInfo image = item.getImageInfo();
        if (Objects.nonNull(image)) {
            detailDTO.setImageUrl(image.getImageUrl());
        }
        // skuId
        detailDTO.setSkuId(String.valueOf(item.getItemId()));
        // skuNo
        detailDTO.setSkuNo(item.getItemSku());
        // 卖家sku编号
        detailDTO.setSellerSkuNo("");
        // 平台sku编号
        detailDTO.setPlatformSkuNo(item.getModelSku());
        // 库存sku编号
        detailDTO.setWarehouseName("");
        // 仓库名称
        // 库存是否扣除
        detailDTO.setWarehouseId("");
        // 数量
        detailDTO.setQty(item.getModelQuantityPurchased());
        // 单价
        detailDTO.setPrice(BigDecimal.valueOf(item.getModelOriginalPrice()));
        // 金额
        try {
            BigDecimal amount = BigDecimal.valueOf(item.getModelDiscountedPrice()).multiply(BigDecimal.valueOf(item.getModelQuantityPurchased()));
            detailDTO.setAmount(amount);
        } catch (Exception e) {
            log.error("计算金额异常：打折后金额：{},数量{}", item.getModelDiscountedPrice(), item.getModelQuantityPurchased());
        }

        // 币别（原币）
        detailDTO.setCurrency(orderDetail.getCurrency());
        // 汇率
        detailDTO.setExchangeRate(BigDecimal.ONE);
        // 建议售价（本位币）
        detailDTO.setAdvicePrice(BigDecimal.ZERO);
        // 含税成本（本位币）
        detailDTO.setTaxCost(BigDecimal.ZERO);
        // 来源明细id
        detailDTO.setSourceDetailId(String.valueOf(item.getItemId()));
        // 标签json
        detailDTO.setLabelJson("");
        // 库存组织id
        detailDTO.setWarehouseOrgId("");
        // 库存组织名称
        detailDTO.setWarehouseOrgName("");
        // 库位
        detailDTO.setWarehouseLocation("");
        return detailDTO;
    }

    @Override
    public String toString() {
        return "PlatformShopeeOrderDTO{" +
                "orderDetail=" + orderDetail +
                ", shopId='" + shopId + '\'' +
                '}';
    }
}
