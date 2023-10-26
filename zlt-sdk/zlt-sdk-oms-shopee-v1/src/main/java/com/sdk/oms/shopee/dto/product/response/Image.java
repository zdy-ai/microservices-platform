package com.sdk.oms.shopee.dto.product.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Image implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * image url
     */
    @JSONField(name = "image_url_list")
    private List<String> urls;

    /**
     * image url
     */
    @JSONField(name = "image_id_list")
    private List<String> ids;
}
