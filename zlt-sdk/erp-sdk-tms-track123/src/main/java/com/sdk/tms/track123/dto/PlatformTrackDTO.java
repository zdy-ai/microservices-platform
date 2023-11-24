package com.sdk.tms.track123.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.common.business.dto.PlatformFbaShipmentReceiveDTO;
import com.common.business.dto.UniqueDto;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * FBA货件DTO 所有平台订单通用数据，转换为此类后发送mq统一消费处理
 *
 * @author Jim
 * @date 2023/11/1
 **/
@Slf4j
@Setter
@Getter
@NoArgsConstructor
public class PlatformTrackDTO extends UniqueDto {
    /**
     * 运单号
     */
    private String trackNo;

    private List<PlatformTrackDetail> details;
    @Override
    public String toString() {
        return "PlatformTrackDTO{" +
                "trackNo='" + trackNo + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
