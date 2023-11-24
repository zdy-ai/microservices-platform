package com.sdk.tms.express.model.order.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName LabelResponse
 * @description: TODO
 * @date 2023年11月10日
 * @version: 1.0
 */
@Data
public class LabelResponse implements Serializable {
    /*
        pdf文件集合,不保证顺序，自行通过seqNo排序
     */
    private List<PrintFile> files;
    /*
        客户编码
     */
    private String clientCode;
    /*
	    模板编码
     */
    private String templateCode;
    /*
        文件类型(pdf)
     */
    private String fileType;
}
