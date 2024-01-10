package com.example.workdemo.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDateTime;

/**
 * @author zdy
 * @ClassName DateUtil
 * @description: TODO
 * @date 2023年11月28日
 * @version: 1.0
 */
public class DateUtil {

//    @Cacheable(key = )
    public static void main(String[] args) {
        String pwd = "admin12345";
        System.out.println("pwd:" + pwd);
        String md5 = Md5Util.md5(pwd);
        System.out.println("md5:" + md5);
        String  salt ="qrKhzJdztX";
        String encryptPassword = Md5Util.md5(Md5Util.md5(md5) + salt);
        System.out.println("encryptPassword:" + encryptPassword);
    }
}
