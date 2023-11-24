package com.sdk.tms.express.model.order.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName OrderUpdateRequest
 * @description: 面签
 * @date 2023年10月31日
 * @version: 1.0
 */
@Data
@Builder
public class OrderLabelRequest implements Serializable {
    /**
     * 关联云打印接口后，点击查看，可在接口详情页获取模板编码，类似：fm_76130_standard_{partnerId}
     * 是
     */
    @NotBlank(message = "模板编码不能为空")
    private String templateCode;
    /**
     * 一批不要超过20个运单，字段定义参考 2.3.1 模板固定字段
     * 是
     */
    @NotNull(message = "运单号不能为空")
    private List<Document> documents;
    /**
     * 版本号，传固定值:2.0
     * 是
     */
    @NotBlank(message = "版本号不能为空")
    private String version = "2.0";
    /**
     * 生成面单文件格式 pdf格式
     */
    private String fileType;
    /**
     * true: 同步,false: 异步,默认异步
     */
    private boolean sync;
    /**
     * 自定义模板编码，当需要使用模板编辑器编辑自定义区时，将自定义模板编码赋值该字段
     */
    private String customTemplateCode;
    /**
     * 扩展字段
     */
    private ExtLabel extJson;
}
