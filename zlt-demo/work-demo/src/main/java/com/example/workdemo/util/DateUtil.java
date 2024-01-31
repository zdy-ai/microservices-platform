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
//        String pwd = "wqb@NyFI33NWy7nw";
//        System.out.println("pwd:" + pwd);
//        String md5 = Md5Util.md5(pwd);
        String md5 = "df3fa7b4dcc566d298b9be258423df10";

        System.out.println("md5:" + md5);
        String  salt ="ozlYzHYDGZ";
        String encryptPassword = Md5Util.md5(Md5Util.md5(md5) + salt);
        System.out.println("encryptPassword:" + encryptPassword);
        System.out.println("salt:" + salt);
    }
}
