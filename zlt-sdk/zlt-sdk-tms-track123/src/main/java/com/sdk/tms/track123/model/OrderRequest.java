package com.sdk.tms.track123.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderRequest
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
@Builder
public class OrderRequest implements Serializable {
    private List<String> trackNos;
    private List<String> orderNos;
    private String createTimeStart;
    private String createTimeEnd;
    private String cursor;
    private Integer queryPageSize;
}
