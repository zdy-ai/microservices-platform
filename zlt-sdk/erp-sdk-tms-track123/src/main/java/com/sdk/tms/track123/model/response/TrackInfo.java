package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName TrackInfo
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class TrackInfo implements Serializable {
    /**
     * 详情
     */
    private List<TrackDetail> content;
    private Integer totalElements;
    private Integer totalPages;
    private Integer currentPage;
    private String cursor;
}
