package com.example.workdemo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zdy
 * @ClassName RegexTest02
 * @description: TODO
 * @date 2024年07月31日
 * @version: 1.0
 */
public class RegexTest02 {
    public static void main(String[] args) {
//        String originalString = "check_fail VO202407230003  商家编码：F011锁定库存比释放量少;释放量:1.0000;锁定库存：0.0000";
        String originalString = "VO202407230003";

        // 正则表达式匹配模式
        String pattern = "\\bVO\\d{12}\\b";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 创建 Matcher 对象
        Matcher m = r.matcher(originalString);

        // 查找匹配的子串
        if (m.find()) {
            String extractedString = m.group(0);
            System.out.println("提取的字符串: " + extractedString);
        } else {
            System.out.println("未找到匹配的字符串");
        }
    }
}
