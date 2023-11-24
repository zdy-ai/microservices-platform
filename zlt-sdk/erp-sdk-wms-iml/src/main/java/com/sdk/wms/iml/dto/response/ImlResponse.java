package com.sdk.wms.iml.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor
public class ImlResponse<T> implements Serializable {

    //Success 表示成功。
    private String ask;

    private String message;

    private Pagination pagination;

    private String nextPage;

    @JSONField(name = "unit_weight")
    private String unitWeight;

    @JSONField(name = "unit_size")
    private String unitSize;

    @JSONField(name = "receiving_code")
    private String receivingCode;

    @JSONField(name = "order_code")
    private String orderCode;

    //取消状态
    @JSONField(name = "cancel_status")
    private Integer cancelStatus;

    //总数
    private Integer count;

    @Data
    @ToString
    public static class Pagination {

        private Integer page;

        private Integer pageSize;
    }

    private T data;
}
