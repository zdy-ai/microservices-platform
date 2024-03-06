package com.sdk.tms.ubi.model.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 任务信息实体类
 * @author Cloud
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DmpSyncTaskIdDTO {

    /**
     * dmp sync task id
     */
    private String dmpSyncTaskId;

}
