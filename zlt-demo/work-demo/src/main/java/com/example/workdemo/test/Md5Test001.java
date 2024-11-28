package com.example.workdemo.test;

import cn.hutool.crypto.digest.DigestUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zdy
 * @ClassName Md5Test001
 * @description: TODO
 * @date 2024年11月13日
 * @version: 1.0
 */
public class Md5Test001 {
    public static void main(String[] args) {

        String trackNo = "CNG00667452563581";
        LocalDateTime trackTime = LocalDateTime.of(2024,8,17,10,10,17);
        DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = trackTime.format(TIME_FORMAT);
        String content = "Shipment cancelled,Shipment cancelled";

        String md5Hex = DigestUtil.md5Hex(trackNo+"-"+content+"-"+format);
        System.out.println(md5Hex);

    }
}
