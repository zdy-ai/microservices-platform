package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zdy
 * @ClassName ShopeeProdcut
 * @description: TODO
 * @date 2023年10月20日
 * @version: 1.0
 */
@Data
@Builder
public class ShopeeProduct implements Serializable {
    @JSONField(name = "total_count")
    private Integer totalCount;
    @JSONField(name = "has_next_page")
    private Boolean hasNextPage;
    private String next;

    private List<Item> items = new LinkedList<>();
}
