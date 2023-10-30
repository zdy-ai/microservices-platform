package com.sdk.tms.shopee.model.logistics.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName TrackResponse
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class TrackResponse implements Serializable {
    private Boolean more;
    @JSONField(name = "next_cursor")
    private String nextCursor;

}
