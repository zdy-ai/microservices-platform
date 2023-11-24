package com.sdk.tms.track123.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zdy
 * @ClassName PlatformTrackDetail
 * @description: TODO
 * @date 2023年11月23日
 * @version: 1.0
 */
@Data
public class PlatformTrackDetail implements Serializable {
    /**
     * 运单号
     */
    private String trackNo;
    /**
     * 运单时间
     */
    private LocalDateTime trackTime;
    /**
     * 状态  运输状态 状态 notFind  查询不到 waitCollect 等待揽收
     * trackIng 运输途中 arriveWaitTake 到达待取
     * deliveryIng 派送途中 deliveryFail 投递失败
     * sign 成功签收 maybeException 可能异常
     * transportLong  运输过久
     */
    private String status;
    /**
     * 内容
     */
    private String content;
}
