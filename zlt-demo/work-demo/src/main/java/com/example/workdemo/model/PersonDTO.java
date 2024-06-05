package com.example.workdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zdy
 * @ClassName PersonDTO
 * @description: TODO
 * @date 2024年01月26日
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {

    private String id;
    private String name;
    private String age;
    private BigDecimal price;
    private int qty;
    private Boolean isPlatformWarehouseOrder;
}
