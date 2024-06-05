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
        map.put("dictPlatform", "Web");
        map.put("shop", "1729456380676411394");
        map.put("isCombinationOrder", Boolean.FALSE);
//        map.put("name", "L032GBB1,2031");

        // 创建 SpEL 表达式上下文
        StandardEvaluationContext context = new StandardEvaluationContext(map);
        List<String> nameList = Arrays.asList("2031","L032GBB1");
        context.setVariable("nameList", nameList);
        List<String> name = Arrays.asList("L032GBB1","2031");
        context.setVariable("name", name);
        context.setVariable("categoryList", name);
        List<String> skuNoList = Arrays.asList("L032GBB1","");
        context.setVariable("skuNoList", skuNoList);
//        context.setVariable("dictPlatform", "Web");
        // 使用 SpEL 进行模糊匹配
//        boolean isInList = parser.parseExpression("#nameList.contains(#name) or 'Web' == 'Web'").getValue(context, Boolean.class);
//        boolean isInList = parser.parseExpression("#nameList.stream().anyMatch(it -> #name.contains(it)) and #dictPlatform == 'Web'").getValue(context, Boolean.class);
        boolean isInList0 = parser.parseExpression("( ['shop'] == '1729456380676411394' ) and (#categoryList.contains('尚未确认子分类') or #categoryList.contains('镜头')) ").getValue(context, Boolean.class);
        boolean isInList1 = parser.parseExpression("((#nameList.contains('2031') or #nameList.contains('L032GBB12'))) and ['isCombinationOrder'] == false").getValue(context, Boolean.class);
        boolean isInList2 = parser.parseExpression("'Web' == 'Web' and ['isCombinationOrder'] == false").getValue(context, Boolean.class);
        boolean isInList3 = parser.parseExpression("['isCombinationOrder'] == FALSE").getValue(context, Boolean.class);
        boolean isInList4 = parser.parseExpression("( (#skuNoList.contains('2287') or #skuNoList.contains('')) ) ").getValue(context, Boolean.class);
        System.out.println("nameList: " + nameList);
        System.out.println("name: " + name);
        System.out.println("dictPlatform: " + map.get("dictPlatform"));
        System.out.println("isCombinationOrder: " + map.get("isCombinationOrder"));
        // 输出结果
//        System.out.println("Name matches pattern: " + isInList);
        System.out.println("Name matches pattern1: " + isInList1);
        System.out.println("Name matches pattern2: " + isInList2);
        System.out.println("Name matches pattern3: " + isInList3);
        System.out.println("Name matches pattern4: " + isInList4);
    }
}
