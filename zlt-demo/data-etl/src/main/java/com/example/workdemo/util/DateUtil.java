package com.example.workdemo.util;

import cn.hutool.core.date.DateTime;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

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
//        String md5 = "df3fa7b4dcc566d298b9be258423df10";
//
//        System.out.println("md5:" + md5);
//        String  salt ="ozlYzHYDGZ";
//        String encryptPassword = Md5Util.md5(Md5Util.md5(md5) + salt);
//        System.out.println("encryptPassword:" + encryptPassword);
//        System.out.println("salt:" + salt);

//        String fmt_quarter = "yyyy-M";
//        String dateName = "2024-2";
//        SimpleDateFormat format = new SimpleDateFormat(fmt_quarter);
//        Date date = null;
//        try {
//            date = format.parse(dateName);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
//        String format1 = new SimpleDateFormat(fmt_quarter).format(calendar.getTime());
//        System.out.println(format1);

//        DateTime dateTime = cn.hutool.core.date.DateUtil.offsetMonth(cn.hutool.core.date.DateUtil.date(), -3);
//        System.out.println(cn.hutool.core.date.DateUtil.date());
//        System.out.println(dateTime);
        getDay();
    }

    private static void getDay() {
        //判断 周期类型
        LocalDate startTime = null;
        LocalDate endTime = null;
        String endDate = "23";
        int end = Integer.parseInt(endDate);
        LocalDate currentDate = LocalDate.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        String nowMonth = currentDate.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (dayOfMonth > end) {
            //23-下月
            // 获取上个月的日期
            LocalDate beforeMonthDate = currentDate.minusMonths(-1);
            String formattedMonth = beforeMonthDate.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM"));
            startTime = LocalDate.parse(nowMonth + "-" + end, formatter);
            endTime = LocalDate.parse(formattedMonth + "-" + end, formatter);
        } else {
            //上月 -23
            // 获取上个月的日期
            LocalDate lastMonthDate = currentDate.minusMonths(1);
            String formattedMonth = lastMonthDate.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM"));
            startTime = LocalDate.parse(formattedMonth + "-" + end, formatter);
            endTime = LocalDate.parse(nowMonth + "-" + end, formatter);
        }
        System.out.println(startTime);
        System.out.println(endTime);
    }
}
