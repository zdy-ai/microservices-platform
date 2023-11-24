package com.sdk.oms.shopee.dto.order.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDetail implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * Return by default. Shopee's unique identifier for an order.
     */
    @JSONField(name = "order_sn")
    private String ordersn;

    /**
     * The two-digit code representing the country where the order was made.
     */
    @JSONField(name = "region")
    private String region;

    /**
     * The three-digit code representing the currency unit for which the order was paid.
     */
    @JSONField(name = "currency")
    private String currency;

    /**
     * This value indicates whether the order was a COD (cash on delivery) order.
     */
    @JSONField(name = "cod")
    private boolean cod;

    /**
     * The total amount paid by the buyer for the order. This amount includes the total sale price of items, shipping cost beared by buyer;
     * and offset by Shopee promotions if applicable.
     * This value will only return after the buyer has completed payment for the order.
     */
    @JSONField(name = "total_amount")
    private float totalAmount;

    /**
     * Enumerated type that defines the current status of the order.
     */
    @JSONField(name = "order_status")
    private String status;
    /**
     *
     * The list of pending terms, possible values: SYSTEM_PENDING for order under Shopee internal processing, KYC_PENDING for order under KYC checking(TW CB orders only)
     */
    @JSONField(name = "pending_terms")
    private List<String> pendingTerms;

    /**
     * The logistics META-INF provider that the buyer selected for the order to deliver items.
     */
    @JSONField(name = "shippingCarrier")
    private String shipping_carrier;

    /**
     * The payment method that the buyer selected to pay for the order.
     */
    @JSONField(name = "payment_method")
    private String paymentMethod;

    /**
     * The estimated shipping fee paid by buyer when placing order with selected logistics META-INF provider.
     */
    @JSONField(name = "estimated_shipping_fee")
    private float estimatedShippingFee;

    /**
     * Message to seller.
     */
    @JSONField(name = "message_to_seller")
    private String messageToSeller;

    /**
     * The time when discount activity start.
     */
    @JSONField(name = "create_time")
    private Long createTime;

    /**
     * The time when discount activity end. The end time must be 1 hour later than start time.
     */
    @JSONField(name = "update_time")
    private Long updateTime;

    /**
     * Shipping preparation time set by the seller when listing item on Shopee.
     */
    @JSONField(name = "days_to_ship")
    private Long daysToShip;

    @JSONField(name = "ship_by_date")
    private Long shipByDate;

    @JSONField(name = "buyer_user_id")
    private Long buyerUserId;

    @JSONField(name = "buyer_username")
    private String buyerUsername;

    @JSONField(name = "actual_shipping_fee")
    private float actualShippingFee;

    /**
     * Only work for cross-border order.This value indicates whether
     * the order contains goods that are required to declare at customs.
     */
    @JSONField(name = "goods_to_declare")
    private boolean goodsToDeclare;
    /**
     * The note seller made for own reference.
     */
    private String note;

    /**
     * Update time for the note.
     */
    @JSONField(name = "note_update_time")
    private Long noteUpdateTime;

    @JSONField(name = "pay_time")
    private Long payTime;

    /**
     * For Indonesia orders only. The name of the dropshipper.
     */
    @JSONField(name = "dropshipper")
    private String dropshipper;

    /**
     * The phone number of dropshipper, could be empty.
     */
    @JSONField(name = "dropshipper_phone")
    private String dropshipperPhone;

    @JSONField(name = "split_up")
    private boolean splitUp;
    /**
     * Cancel reason from buyer, could be empty.
     */
    @JSONField(name = "buyer_cancel_reason")
    private String buyerCancelReason;
    /**
     * Could be one of buyer, seller, system or Ops.
     */
    @JSONField(name = "cancel_by")
    private String cancelBy;
    /**
     * BACKEND_LOGISTICS_NOT_STARTED
     */
    @JSONField(name = "cancel_reason")
    private String cancelReason;

    @JSONField(name = "actual_shipping_fee_confirmed")
    private boolean actualShippingFeeConfirmed;
    @JSONField(name = "buyer_cpf_id")
    private String buyerCpfId;
    @JSONField(name = "fulfillment_flag")
    private String fulfillmentFlag;

    @JSONField(name = "pickup_done_time")
    private Long pickupDoneTime;
    @JSONField(name = "checkout_shipping_carrier")
    private String checkoutShippingCarrier;

    @JSONField(name = "reverse_shipping_fee")
    private String reverseShippingFee;
    @JSONField(name = "order_chargeable_weight_gram")
    private Integer orderChargeableWeightGram;

    @JSONField(name = "edt_from")
    private Long edtFrom;

    @JSONField(name = "edt_to")
    private Long edtTo;

    @JSONField(name = "prescription_images")
    private List<String> prescriptionImages;
    /**
     * Return prescription check status of this order enum OrderPrescriptionCheckStatus: NONE = 0; PASSED = 1; FAILED = 2; only for ID and PH whitelist user.
     */
    @JSONField(name = "prescription_check_status")
    private Integer prescriptionCheckStatus;

    /**
     * This object contains detailed breakdown for the recipient address. 收货人信息
     */
    @JSONField(name = "recipient_address")
    private RecipientAddress recipientAddress;

    /**
     * This object contains the detailed breakdown for all the items in this order,
     * including regular items(non-activity) and activity items.
     */
    @JSONField(name = "item_list")
    private List<OrderItemDetail> items;

    @JSONField(name = "package_list")
    private List<Package> packages;

    @JSONField(name = "invoice_data")
    private Invoice invoice;

}
