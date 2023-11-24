package com.sdk.tms.express.model.order.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName Service
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
@Data
public class Service implements Serializable {
    /**
     * 增值服务名，如COD等。
     * 是
     */
    private String name;
    /**
     * 增值服务扩展属性，参考增值服务传值说明。
     *
     */
    private String value;
    /**
     *增值服务扩展属性1
     */
    private String value1;
    /**
     *增值服务扩展属性2
     */
    private String value2;
    /**
     *增值服务扩展属性3
     */
    private String value3;
    /**
     *增值服务扩展属性4
     */
    private String value4;
}
