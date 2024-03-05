package com.example.workdemo.util;

import java.math.BigDecimal;

/**
 * @author zdy
 * @ClassName StrUtil
 * @description: TODO
 * @date 2024年01月29日
 * @version: 1.0
 */
public class StrUtil {
    public static void main(String[] args) {
        String s = "";
        System.out.println(s.length());
        System.out.println(cn.hutool.core.util.StrUtil.isBlank(s));
        System.out.println(cn.hutool.core.util.StrUtil.isEmpty(s));

        BigDecimal a = new BigDecimal("0.0000");
        System.out.println("a:"+ a.compareTo(BigDecimal.ZERO));
    }
}
