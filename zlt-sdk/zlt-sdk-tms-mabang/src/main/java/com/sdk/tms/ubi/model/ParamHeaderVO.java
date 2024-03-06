package com.sdk.tms.ubi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 *
 *
 * @Author Cloud
 * @Date 2023/2/1 16:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamHeaderVO {

    private String paramsStr;

    private Map<String, String> headerMap;
}
