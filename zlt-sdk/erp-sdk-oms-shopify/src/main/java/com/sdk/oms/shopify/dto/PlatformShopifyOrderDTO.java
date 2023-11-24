package com.sdk.oms.shopify.dto;

import com.common.business.dto.*;
import com.common.business.enums.PlatformDictEnum;
import com.sdk.oms.shopify.api.rest.model.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 平台Shopify订单DTO
 *
 * @Author Jim
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PlatformShopifyOrderDTO extends CleanBaseDTO {
    /**
     * Shopify SDK 订单信息
     */
    private ShopifyOrder shopifyOrder;

    /**
     * Shopify SDK 订单信息
     */
    private ShopifyShopInfoDTO shopInfoDTO;


    public PlatformShopifyOrderDTO(JobTaskDTO dto, ShopifyOrder shopifyOrder, ShopifyShopInfoDTO shopInfoDTO) {
        this.shopifyOrder = shopifyOrder;
        this.setIsClean(0);
        this.setPlatform(PlatformDictEnum.SHOPIFY.getCode());
        this.setUniqueId(shopifyOrder.getId());
//        this.setLastPushTime(dto.getNextTime());
        this.shopInfoDTO = shopInfoDTO;
        this.setDownloadTime(LocalDateTime.now(ZoneId.systemDefault()).toString());
        this.setLastPushTime(dto.getNextTime().toString());
    }

    /**
     * 转换目标实体:PlatformProductDTO
     */
    public static PlatformOrderDTO convertDTO(PlatformShopifyOrderDTO dto) {
        // 原订单信息
        ShopifyOrder sourceOrder = dto.getShopifyOrder();
        // 本ERP店铺信息
        ShopifyShopInfoDTO shopInfoDTO = dto.getShopInfoDTO();

        PlatformOrderDTO orderDTO = new PlatformOrderDTO();
        // 订单日期
        orderDTO.setBillDate(sourceOrder.getCreatedAt().toLocalDate());
        // 平台订单号
        orderDTO.setPlatformCode(sourceOrder.getId());
        // 销售平台
        orderDTO.setDictPlatform(PlatformDictEnum.SHOPIFY.getCode());
        // 店铺ID
        orderDTO.setShopId(shopInfoDTO.getId());
        // 作废状态（false未作废，true已作废）
        orderDTO.setInvalidStatus(false);
        // 作废类型（manual手动作废，automatic自动作废）
        orderDTO.setInvalidType("");
        // 作废原因
        orderDTO.setInvalidRemark("");
        // 订单状态
        // （soB2cBillStatus字典类型）
        orderDTO.setBillStatus(sourceOrder.convertBillStatus());
        // 付款状态（待付款、已付款）
        // （soB2cPayStatus字典类型）
        orderDTO.setPayStatus(sourceOrder.convertPayStatus());
        // 订单金额
        orderDTO.setAmount(sourceOrder.getTotalPrice());
        // 币别（原币）
        orderDTO.setCurrency(sourceOrder.getCurrency().getCurrencyCode());
        // 汇率
        orderDTO.setExchangeRate(BigDecimal.ONE);
        // 运费收入
        BigDecimal shippingFee = sourceOrder.getShippingLines().stream()
                .map(ShopifyShippingLine::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        orderDTO.setShippingFee(shippingFee);
        // 付款时间
        orderDTO.setPayTime(sourceOrder.convertPayTime());
        // 付款金额
        orderDTO.setPayAmount(sourceOrder.getSubtotalPrice());
        // 付款方式
        orderDTO.setDictPayMethod(sourceOrder.convertPayMethod());
        // 买家备注
        orderDTO.setBuyerRemark("");
        // 订单备注
        orderDTO.setRemark(sourceOrder.getNote());
        // 销售组织id
        orderDTO.setOrgId("");
        // 销售组织名称
        orderDTO.setOrgName("");
        // 是否拦截
        orderDTO.setIsIntercept(false);
        // 拦截备注
        orderDTO.setInterceptRemark("");
        // 来源类型
        orderDTO.setSourceType("soB2c");
        // 来源id
        orderDTO.setSourceId(sourceOrder.getId());
        // 来源编码
        orderDTO.setSourceCode("");
        // 标签json
        orderDTO.setLabelJson("{}");
        // 异常原因（1、订单规则审核不通过；2、配货规则匹配失败；3、人工审核不通过）
        orderDTO.setAbnormalType("");
        // 同步金蝶状态（默认0无需同步,1待同步,2同步中,3同步成功,4同步失败）
        orderDTO.setSyncKingdeeStatus("0");
        // 订单明细
        List<PlatformOrderDetailDTO> details = parseDetailDto(sourceOrder);
        orderDTO.setDetails(details);

        // 订单买家信息
        List<PlatformOrderReceiverDTO> receiverList = new LinkedList<>();
        ShopifyCustomer customer = dto.getShopifyOrder().getCustomer();
        ShopifyAddress shippingAddress = dto.getShopifyOrder().getShippingAddress();
        if (null != customer) {
            PlatformOrderReceiverDTO receiverDTO = new PlatformOrderReceiverDTO();
            receiverDTO.setName(
                    (StringUtils.isBlank(customer.getFirstName()) ? "" : customer.getFirstName()) +
                            (StringUtils.isBlank(customer.getFirstName()) ? "" : customer.getLastname())
            );
            receiverDTO.setEmail(StringUtils.isBlank(customer.getEmail()) ? "" : customer.getEmail());

            receiverDTO.setFirstAddress(StringUtils.isBlank(shippingAddress.getAddress1()) ? "" : shippingAddress.getAddress1());
            receiverDTO.setSecondAddress(
                    StringUtils.isBlank(shippingAddress.getAddress2()) ? "" : shippingAddress.getAddress2()
            );

            receiverDTO.setCityName(StringUtils.isBlank(shippingAddress.getCity()) ? "" : shippingAddress.getCity());
            receiverDTO.setCountryName(StringUtils.isBlank(shippingAddress.getCountry()) ? "" : shippingAddress.getCountry());
            receiverDTO.setReceiverName(StringUtils.isBlank(shippingAddress.getName()) ? "" : shippingAddress.getName());
            receiverDTO.setFullAddress("");
            receiverDTO.setPostCode(shippingAddress.getZip());
            receiverList.add(receiverDTO);
        }
        orderDTO.setReceiverList(receiverList);

        // 订单财务信息
        List<PlatformOrderFinanceDTO> financesList = new LinkedList<>();
        List<ShopifyShippingLine> shippingLines = dto.getShopifyOrder().getShippingLines();
        if (!CollectionUtils.isEmpty(shippingLines)){
            PlatformOrderFinanceDTO financeDTO = new PlatformOrderFinanceDTO();
            // 合计
            BigDecimal totalShippingPrice = dto.getShopifyOrder().getShippingLines()
                    .stream()
                    .map(ShopifyShippingLine::getPrice)
                    .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            financeDTO.setShippingCost(totalShippingPrice);
        }
        return orderDTO;

    }

    /**
     * 批量转换明细
     */
    public static List<PlatformOrderDetailDTO> parseDetailDto(ShopifyOrder sourceOrder) {
        return sourceOrder.getLineItems().stream()
                .map(e -> intPlatformOrderDetailDTO(e, sourceOrder))
                .collect(Collectors.toList());
    }

    /**
     * 转换明细
     */
    private static PlatformOrderDetailDTO intPlatformOrderDetailDTO(ShopifyLineItem item, ShopifyOrder sourceOrder) {
        PlatformOrderDetailDTO detailDTO = new PlatformOrderDetailDTO();
        // 图片URL
        detailDTO.setImageUrl("");
        // skuId
        detailDTO.setSkuId("");
        // skuNo
        detailDTO.setSkuNo("");
        // 卖家sku编号
        detailDTO.setSellerSkuNo("");
        // 平台sku编号
        detailDTO.setPlatformSkuNo(item.getVariantId());
        // 库存sku编号
        detailDTO.setWarehouseName("");
        // 仓库名称
        // 库存是否扣除
        detailDTO.setWarehouseId("");
        // 数量
        detailDTO.setQty(item.getQuantity().intValue());
        // 单价
        detailDTO.setPrice(item.getPrice());
        // 金额
        BigDecimal amount = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
        detailDTO.setAmount(amount);
        // 币别（原币）
        detailDTO.setCurrency(sourceOrder.getCurrency().getCurrencyCode());
        // 汇率
        detailDTO.setExchangeRate(BigDecimal.ONE);
        // 建议售价（本位币）
        detailDTO.setAdvicePrice(BigDecimal.ZERO);
        // 含税成本（本位币）
        detailDTO.setTaxCost(BigDecimal.ZERO);
        // 来源明细id
        detailDTO.setSourceDetailId(item.getId());
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
}
