package com.sdk.oms.shopify.api.rest.model;


import com.erp.model.oms.enums.SoB2cBillStatusEnum;
import com.erp.model.oms.enums.SoB2cPayStatusEnum;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.enums.ShopifyOrderFinancialStatusEnum;
import com.sdk.oms.shopify.api.rest.model.serializer.CurrencyDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.CurrencySerializer;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
public class ShopifyOrder {

    private String id;
    private String email;
    @JsonProperty("closed_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime closedAt;
    @JsonProperty("created_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;
    private int number;
    private String note;
    private String token;
    @JsonProperty("total_price")
    private BigDecimal totalPrice;
    @JsonProperty("subtotal_price")
    private BigDecimal subtotalPrice;
    @JsonProperty("total_weight")
    private long totalWeight;
    @JsonProperty("total_tax")
    private BigDecimal totalTax;
    @JsonProperty("taxes_included")
    private boolean taxesIncluded;
    @JsonSerialize(using = CurrencySerializer.class)
    @JsonDeserialize(using = CurrencyDeserializer.class)
    private Currency currency;
    @JsonProperty("financial_status")
    private String financialStatus;
    @JsonProperty("total_discounts")
    private BigDecimal totalDiscounts;
    @JsonProperty("total_line_items_price")
    private BigDecimal totaLineItemsPrice;
    @JsonProperty("cart_token")
    private String cartToken;
    @JsonProperty("buyer_accepts_marketing")
    private boolean buyerAcceptsMarketing;
    private String name;
    @JsonProperty("referring_site")
    private String referringSite;
    @JsonProperty("landing_site")
    private String landingSite;
    @JsonProperty("cancelled_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime cancelledAt;
    @JsonProperty("cancel_reason")
    private String cancelReason;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("processed_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime processedAt;
    @JsonProperty("browser_ip")
    private String browserIp;
    @JsonProperty("order_number")
    private String orderNumber;
    @JsonProperty("processing_method")
    private String processingMethod;
    @JsonProperty("source_name")
    private String sourceName;
    @JsonProperty("fulfillment_status")
    private String fulfillmentStatus;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("order_status_url")
    private String orderStatusUrl;
    @JsonProperty("line_items")
    private List<ShopifyLineItem> lineItems = new LinkedList<>();
    private List<ShopifyFulfillment> fulfillments = new LinkedList<>();
    @JsonProperty("billing_address")
    private ShopifyAddress billingAddress = new ShopifyAddress();
    @JsonProperty("shipping_address")
    private ShopifyAddress shippingAddress = new ShopifyAddress();
    private ShopifyCustomer customer = new ShopifyCustomer();
    @JsonProperty("shipping_lines")
    private List<ShopifyShippingLine> shippingLines = new LinkedList<>();
    @JsonProperty("tax_lines")
    private List<ShopifyTaxLine> taxLines = new LinkedList<>();
    @JsonProperty("note_attributes")
    private List<ShopifyAttribute> noteAttributes = new LinkedList<>();
    private List<ShopifyRefund> refunds = new LinkedList<>();
    private List<Metafield> metafields = new LinkedList<>();
    @JsonProperty("payment_terms")
    private ShopifyPaymentTerms paymentTerms;



    /**
     * @param name
     * @param value
     */
    @JsonAnySetter
    public void ignored(String name, Object value) {
        log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
    }

    /**
     * shopify 订单状态转换ERP订单状态
     * soB2cBillStatus字典类型
     *
     * shipped: Show orders that have been shipped. Returns orders with fulfillment_status of fulfilled.
     * partial: Show partially shipped orders.
     * unshipped: Show orders that have not yet been shipped. Returns orders with fulfillment_status of null.
     * any: Show orders of any fulfillment status.
     * unfulfilled: Returns orders with fulfillment_status of null or partial
     *
     */
    public String convertBillStatus() {
        if (null == this.fulfillmentStatus || StringUtils.isBlank(this.fulfillmentStatus)){
            // 配货中
            return SoB2cBillStatusEnum.ENUM_IN_DISTRIBUTION.getCode();
        }
        // 已发货
        if ("fulfilled".equalsIgnoreCase(this.fulfillmentStatus)){
            return SoB2cBillStatusEnum.ENUM_SHIPPED.getCode();
        }
        // 待发货
        return SoB2cBillStatusEnum.ENUM_WAIT_SHIPPED.getCode();
    }

    private final static String PAYMENT_STATUS = "payment";

    private final static String PAY_STATUS = "paid";

    /**
     * shopify 订单付款状态转换ERP订单付款状态
     * <a href="https://shopify.dev/docs/api/admin-rest/2023-07/resources/order#get-orders?status=any">信息来源</a>}
     * authorized: Show only authorized orders
     * pending: Show only pending orders
     * paid: Show only paid orders
     * partially_paid: Show only partially paid orders
     * refunded: Show only refunded orders
     * voided: Show only voided orders
     * partially_refunded: Show only partially refunded orders
     * any: Show orders of any financial status.
     * unpaid: Show authorized and partially paid orders.
     * <p>
     * SoB2cPayStatusEnum字典类型
     */
    public String convertPayStatus() {
        String code = this.financialStatus;
        ShopifyOrderFinancialStatusEnum statusEnum = ShopifyOrderFinancialStatusEnum.getByCode(code);
        if (null == statusEnum) {
            //待付款
            return SoB2cPayStatusEnum.ENUM_PAYMENT.getCode();
        }
        // 已付款
        if (ShopifyOrderFinancialStatusEnum.PAID.equals(statusEnum)) {
            return SoB2cPayStatusEnum.ENUM_PAYMENT.getCode();
        }
        // 待付款
        if (ShopifyOrderFinancialStatusEnum.PENDING.equals(statusEnum) ||
            ShopifyOrderFinancialStatusEnum.UNPAID.equals(statusEnum)||
            ShopifyOrderFinancialStatusEnum.PARTIALLY_PAID.equals(statusEnum)
        ) {
            return SoB2cPayStatusEnum.ENUM_PAYMENT.getCode();
        }
        return "unknow";
    }

    /**
     * 转换支付时间
     */
    public LocalDateTime convertPayTime() {
        if (null == this.getPaymentTerms()){
            return null;
        }
        List<ShopifyPaymentSchedules> paymentSchedules = this.getPaymentTerms().getPaymentSchedules();
        if (CollectionUtils.isEmpty(paymentSchedules)){
            return null;
        }
        return paymentSchedules.get(0).getCompletedAt();
    }

    public String convertPayMethod() {
        if (null == this.getPaymentTerms()){
            return "";
        }
        List<ShopifyPaymentSchedules> paymentSchedules = this.getPaymentTerms().getPaymentSchedules();
        if (CollectionUtils.isEmpty(paymentSchedules)){
            return "";
        }
        return paymentSchedules.get(0).getExpectedPaymentMethod();
    }
}
