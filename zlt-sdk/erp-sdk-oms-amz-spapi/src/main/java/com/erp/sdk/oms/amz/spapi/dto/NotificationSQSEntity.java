package com.erp.sdk.oms.amz.spapi.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * 亚马逊SQS消息通知体
 */
@Data
public class NotificationSQSEntity implements Serializable {
    private String id;
    private String notificationVersion;
    private String notificationType;
    private String payloadVersion;
    private String eventTime;
    private Payload payload;
    private NotificationMetadata notificationMetadata;


    @Data
    public static class Payload {
        private ReportProcessingFinishedNotification reportProcessingFinishedNotification;
    }


    @Data
    public static class ReportProcessingFinishedNotification {
        private String sellerId;
        private String reportId;
        private String reportType;
        private String processingStatus;
        private String reportDocumentId;
    }


    @Data
    public static class NotificationMetadata {
        private String applicationId;
        private String subscriptionId;
        private String publishTime;
        private String notificationId;
    }

}