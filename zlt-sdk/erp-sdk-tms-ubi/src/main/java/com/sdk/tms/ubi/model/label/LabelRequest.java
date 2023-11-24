package com.sdk.tms.ubi.model.label;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName LabelRequest
 * @description: 打印标签
 * @date 2023年11月09日
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabelRequest implements Serializable {
    /**
     * 我们支持用户使用Tracking Number / Ref No.查询
     */
    @NotNull(message = "客户单号不能为空")
    private List<String> orderIds;
    /**
     * 我们支持用户使用Master Ref No. 查询
     */
    private List<String> masterIds;
    /**
     * labelType:
     *
     * 0表示默认值10cm * 15cm，
     *
     * 1表示10cm * 15cm，
     *
     * 2表示A4，
     *
     * 4表示10cm * 10cm，目前API只支持这三种格式；
     */
    private String labelType;
    /**
     * 是否打印拣货清单
     */
    private Boolean packinglist;
    /**
     * 指定是否需要合并为一个PDF文件，默认拆分；
     *
     * 若选择合并，则只会合并打印出成功的订单，并且按照请求参数中订单的顺序进行合并。
     */
    private Boolean merged;
    /**
     * 标签格式，可选JPG格式，不填默认为PDF格式。JPG格式面单不支持合并，当同时选择打印packinglist时，会返回多个文件。
     *
     * 可选ZPL格式。选择ZPL时，字段值为“ZPL”。
     */
    private String labelFormat;
    /**
     * 当标签格式为ZPL时，支持填写此字段，“300”和“203”是支持的。如不填写，默认为“300”
     */
    private String dpi;
}
