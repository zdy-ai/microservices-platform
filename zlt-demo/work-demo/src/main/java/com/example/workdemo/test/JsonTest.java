package com.example.workdemo.test;

import cn.hutool.json.JSONUtil;
import com.example.workdemo.model.PersonDTO;

import java.util.Objects;

/**
 * @author zdy
 * @ClassName JsonTest
 * @description: TODO
 * @date 2024年05月27日
 * @version: 1.0
 */
public class JsonTest {
    public static void main(String[] args) {
        String a = "{}";
        PersonDTO labelJsonDTO = JSONUtil.toBean(a, PersonDTO.class);
        if (Objects.nonNull(labelJsonDTO) && Objects.nonNull(labelJsonDTO.getIsPlatformWarehouseOrder()) && labelJsonDTO.getIsPlatformWarehouseOrder()){
            System.out.println("判断方式");
        }else {
            System.out.println("else");
        }
        System.out.println(labelJsonDTO.getId());
    }
}
