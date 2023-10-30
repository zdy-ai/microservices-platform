package com.sdk.tms.shopee.model.logistics.request;

import com.sdk.tms.shopee.model.base.BaseRequest;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName TrackRequest
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
@Builder
public class TrackRequest implements Serializable {
    private String fromDate;
    private String toDate;
    private Long partnerId;
    private Long timestamp;
    private String accessToken;
    private Long shopId;
    private String sign;
    private String path;
    private String host;
    private String partnerKey;
    private Integer pageSize;
    private String cursor;
}
