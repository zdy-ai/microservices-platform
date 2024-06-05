package com.example.workdemo.test;

/**
 * @author zdy
 * @ClassName StringTest
 * @description: TODO
 * @date 2024年06月05日
 * @version: 1.0
 */
public class StringTest {
    public static void main(String[] args) {
        String fieldStr = "2287,";
        String[] split1 = fieldStr.split(",");
        System.out.println(split1.length);
    }
}
