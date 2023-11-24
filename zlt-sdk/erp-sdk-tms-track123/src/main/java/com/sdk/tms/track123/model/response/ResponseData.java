package com.sdk.tms.track123.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zdy
 * @ClassName Data
 * @description: TODO
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class ResponseData implements Serializable {
    //查询成功的单号
    private TrackInfo accepted;
    //查询失败的单号
    private List<Rejected> rejected;
}
