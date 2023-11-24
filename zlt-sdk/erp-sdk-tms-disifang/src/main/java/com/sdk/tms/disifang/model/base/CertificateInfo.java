package com.sdk.tms.disifang.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName CertificateInfo
 * @description: 证件信息
 * @date 2023年11月07日
 * @version: 1.0
 */
@Data
public class CertificateInfo implements Serializable {
    /**
     *证件类型（点击查看详情）
     */
    @JSONField(name = "id_type")
    private String id_type;
    /**
     *3.62432199412121e+17	证件号
     */
    @JSONField(name = "id_no")
    private String id_no;
    /**
     *https://ju.taobao.com/jusp/other/mingpin/tp.htm?spm=875.7931836/B.2017039.4.5ff54265S5IEz9&pos=2&acm=201708280-2.1003.2.3116407&scm=1003.2.201708280-2.OTHER_1519569914238_3116407
     * 证件正面照URL
     */
    @JSONField(name = "id_front_url")
    private String id_front_url;
    /**
     * https://ju.taobao.com/jusp/other/mingpin/tp.htm?spm=875.7931836/B.2017039.4.5ff54265S5IEz9&pos=2&acm=201708280-2.1003.2.3116407&scm=1003.2.201708280-2.OTHER_1519569914238_3116407
     *证件背面照URL
     */
    @JSONField(name = "id_back_url")
    private String id_back_url;
}
