package com.sdk.tms.ubi.model.catalog.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Label
 * @description: 标签
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class Label implements Serializable {
    private static final long serialVersionUID = 2801814838883246461L;
    private String orderId;
    private String referenceNo;
    private String trackingNo;
    private String labelType;
    private String consignmentId;
    private String articleId;
    private String barCode;
    private String lodgement;
    private String account;
    private String barCodeEx;
    private String barCodeFnc;
    private String barCodeEx2;
    private String barCodeEx2Fnc;
    private String recipientName;
    private String recipientPhone;
    private String recipientCompany;
    private String recipientAddressLine1;
    private String recipientAddressLine2;
    private String recipientAddressLine3;
    private String recipientCity;
    private String recipientState;
    private String recipientCountry;
    private String recipientPostcode;
    private String returnName;
    private String returnAddressLine1;
    private String returnAddressLine2;
    private String returnAddressLine3;
    private String returnCity;
    private String returnState;
    private String returnCountry;
    private String returnPostcode;
    private Double weight;
    private String goodsDescription;
    private String barCode2D;
    private String sku;
    private String barCodeImage;
    private String barCode2DImage;
    private String errors;
    private String status;
}
