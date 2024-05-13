package com.example.workdemo.test;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zdy
 * @ClassName Test01
 * @description: TODO
 * @date 2024年05月13日
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        // 创建 SpEL 表达式解析器
        ExpressionParser parser = new SpelExpressionParser();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "John");

        // 创建 SpEL 表达式上下文
        StandardEvaluationContext context = new StandardEvaluationContext(map);

        // 定义模糊匹配的正则表达式
//        String pattern = ".*oh.*";
//        context.setVariable("pattern", pattern);
        String name = "John";
//        List<String> nameList = Arrays.asList("John", "Alice", "Bob");
        context.setVariable("nameList", Arrays.asList(name.split(",")));
        context.setVariable("name", "John");
        // 使用 SpEL 进行模糊匹配
        boolean isInList = parser.parseExpression("#nameList.contains(#name)").getValue(context, Boolean.class);

        // 输出结果
        System.out.println("Name matches pattern: " + isInList);
    }
}
