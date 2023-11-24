package com.sdk.tms.disifang.model.order.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zdy
 * @ClassName OrderAttachmentInfo
 * @description: 订单附件列表
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class OrderAttachmentInfo implements Serializable {
    /**
     * base64文件数据	base64文件数据
     */
    @JSONField(name = "file_data")
    private String file_data;
    /**
     * 文件url	文件url
     */
    @JSONField(name = "file_url")
    private String file_url;
    /**
     * pdf、jpg、png、jpeg	文件类型
     */
    @JSONField(name = "file_type")
    private String file_type;
    /**
     * url、base64	附件格式
     */
    @JSONField(name = "attachment_format")
    private String attachment_format;
    /**
     * 1:商业发票   2:交易图片
     */
    @JSONField(name = "attachment_type")
    private String attachment_type;
}
