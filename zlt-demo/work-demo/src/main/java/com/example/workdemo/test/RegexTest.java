package com.example.workdemo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zdy
 * @ClassName RegexTest
 * @description: TODO
 * @date 2024年07月23日
 * @version: 1.0
 */
public class RegexTest {

    public static void main(String[] args) {
        String input = "系统已经重新路由，旧单号[CNG00665032598857]暂无法使用，请使用新单号[UN055958577MU]声明发货";

        // 正则表达式，匹配方括号及其内部的内容
        String regex = "\\[(.*?)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // 提取第一个方括号内的内容
        if (matcher.find()) {
            String firstContent = matcher.group(1); // 获取第一个方括号内部的内容
            System.out.println("第一个[]内的内容: " + firstContent);
        }

        // 提取第二个方括号内的内容
        if (matcher.find()) {
            String secondContent = matcher.group(1); // 获取第二个方括号内部的内容
            System.out.println("第二个[]内的内容: " + secondContent);
        }
    }
}
