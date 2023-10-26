package com.sdk.oms.shopee.model.globalProduct;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName Brand
 * @description: TODO
 * @date 2023年10月19日
 * @version: 1.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class DescriptionInfo implements Serializable {
    private List<FieldList> field_list;
    private List<ImageInfo> image_info;
    private Object description_type;
    class FieldList{
        private String field_type;
        private String text;
    }
    class ImageInfo{
        private String image_id;
        private String image_url;
    }
}
