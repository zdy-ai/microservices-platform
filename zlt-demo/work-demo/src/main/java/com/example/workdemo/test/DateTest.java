package com.example.workdemo.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zdy
 * @ClassName DateTest
 * @description: TODO
 * @date 2024年06月26日
 * @version: 1.0
 */
public class DateTest {
    private static DateTimeFormatter TIME_FORMAT2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 用于补充月份和日期中缺少的零的正则表达式
    private static final Pattern pattern2 = Pattern.compile("(\\d{4})-(\\d{1,2})-(\\d{1,2})");
    private static final Pattern pattern = Pattern.compile("(\\d{4})/(\\d{1,2})/(\\d{1,2})");

    public static LocalDate parseDate(String dateString, String splitStr,Pattern pattern, DateTimeFormatter TIME_FORMAT) {
        // 使用正则表达式补充零
        Matcher matcher = pattern.matcher(dateString);
        if (matcher.matches()) {
            String year = matcher.group(1);
            String month = matcher.group(2).length() == 1 ? "0" + matcher.group(2) : matcher.group(2);
            String day = matcher.group(3).length() == 1 ? "0" + matcher.group(3) : matcher.group(3);
            dateString = year + splitStr + month + splitStr + day;
        }
        // 使用补充后的字符串进行解析
        return LocalDate.parse(dateString, TIME_FORMAT);
    }
    public static void main(String[] args) {
        String dateStr = "2024-6-7";
        LocalDate parse = parseDate(dateStr,"-",pattern, TIME_FORMAT2);
        System.out.println(parse);
        String dateStr2 = "2024/6/7";
        LocalDate parse1 = parseDate(dateStr2,"/",pattern2, TIME_FORMAT);
        System.out.println(parse1);
    }
}
