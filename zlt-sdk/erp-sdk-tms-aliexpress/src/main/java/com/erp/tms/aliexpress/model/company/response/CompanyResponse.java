package com.erp.tms.aliexpress.model.company.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName CompanyResponse
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class CompanyResponse implements Serializable {
    /**
     * 物流公司
     */
    @JSONField(name = "name")
    private String name;
    /**
     * 物流公司
     */
    @JSONField(name = "company_id")
    private String company_id;
    /**
     * 物流公司
     */
    @JSONField(name = "company_code")
    private String company_code;

}
