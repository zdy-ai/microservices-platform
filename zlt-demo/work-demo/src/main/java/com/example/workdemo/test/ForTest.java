package com.example.workdemo.test;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zdy
 * @ClassName ForTest
 * @description: TODO
 * @date 2024年05月09日
 * @version: 1.0
 */
public class ForTest {
    public static void main(String[] args) {
        // 创建一个ExpressionParser对象
        ExpressionParser parser = new SpelExpressionParser();
        Map<String, Object> map = new HashMap<>();
        map.put("dictPlatformList", "Amazon");
        // 创建一个EvaluationContext对象
        StandardEvaluationContext context = new StandardEvaluationContext(map);

        // 待比较的值
        String valueToCheck = "apple";

        // 定义SpEL表达式
//        String spelExpression = "['dictPlatformList'] .contains( 'Amazon','Walmart','PDD','Tmall','RedBook','TikTokCn','TaoBao')";
        List<String> list = new ArrayList<>();
        String spelExpression1 = "['dictPlatformList'] .contains( 'Amazon')";
        list.add(spelExpression1);
        String spelExpression2 = "['dictPlatformList'] .contains( 'Walmart')";
        list.add(spelExpression2);
        String spelExpression3 = "['dictPlatformList'] .contains( 'PDD')";
        list.add(spelExpression3);
        String spelExpression4 = "['dictPlatformList'] .contains( 'Tmall')";
        list.add(spelExpression4);
        String spelExpression5 = "['dictPlatformList'] .contains( 'RedBook')";
        list.add(spelExpression5);
        String spelExpression6 = "['dictPlatformList'] .contains( 'TikTokCn')";
        list.add(spelExpression6);
        String spelExpression7 = "['dictPlatformList'] .contains( 'TaoBao')";
        list.add(spelExpression7);
        for (int i = 0; i < list.size(); i++) {
            String spelExpression = list.get(i);
            boolean result = parser.parseExpression(spelExpression).getValue(context, Boolean.class);
            // 输出结果
            if (result) {
                System.out.println("在Map中找到了包含目标值的列表");
                return;
            } else {
                System.out.println("在Map中未找到包含目标值的列表");
            }
        }
    }
}
