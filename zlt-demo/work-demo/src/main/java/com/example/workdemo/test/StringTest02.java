package com.example.workdemo.test;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author zdy
 * @ClassName StringTest02
 * @description: TODO
 * @date 2024年09月27日
 * @version: 1.0
 */
public class StringTest02 {

//    public static void main(String[] args) {
//        String trackNo = "CNG00667452563581";
//        LocalDateTime trackTime = LocalDateTime.of(2024,8,17,10,10,17);
//        DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String format = trackTime.format(TIME_FORMAT);
//        String content = "Shipment cancelled,Shipment cancelled";
//
//        String md5Hex = DigestUtil.md5Hex(trackNo+content+format);
//        System.out.println(md5Hex);
//
//        int hash = Objects.hash("CNG00667452563581", "Shipment cancelled,Shipment cancelled");
//        System.out.println(hash);
//        String md5 = "00338f7be58106689293dd9d0acd54f4";
//        System.out.println(md5.length());
//        System.out.println(Objects.equals(null,null));
//    }

    /**
     * 去掉前后空格 以及逗号前后空格
     * @param value
     * @return
     */
    private static String removeSpace(String value) {
        if (StrUtil.isBlank(value)){
            return value;
        }
        //去掉前后空格
        value = value.trim();
        // 使用正则表达式去掉逗号前后的空格
        // 英文逗号前后的空格
        value = value.replaceAll("\\s*,\\s*", ",");
        // 中文逗号前后的空格
        value = value.replaceAll("\\s*，\\s*", "，");
        return value;
    }

    public static void main(String[] args) {
        String example = "  ,  示例字符串  ，   带有  空格  ，和中文逗号   ，   英文逗号 ,  ";
        String result = removeSpace(example);
        System.out.println("处理前: \"" + example + "\"");
        System.out.println("处理后: \"" + result + "\"");
    }
}
