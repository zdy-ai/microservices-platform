package com.example.workdemo.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zdy
 * @ClassName ArrayTest
 * @description: 排序要求 先根据第二个值排序 然后相同第一个值放在一起
 * @date 2024年11月28日
 * @version: 1.0
 */
public class ArrayTest {

    public static void main(String[] args) {
        // 初始化原始集合
        List<List<String>> list = Arrays.asList(
                Arrays.asList("e", "a"),
                Arrays.asList("f", "b"),
                Arrays.asList("g", "c"),
                Arrays.asList("e", "d")
        );

        // 执行分组操作，并依据第二个字段进行排序
        Map<String, List<List<String>>> groupedAndSorted = list.stream()
                .collect(Collectors.groupingBy(
                        l -> l.get(0), // 依据第一个字段进行分组
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                sublist -> sublist.stream()
                                        .sorted(Comparator.comparing(l -> l.get(1))) // 对每组依据第二个字段排序
                                        .collect(Collectors.toList())
                        )
                ));

        // 打印分组并排序后的结果
        groupedAndSorted.forEach((key, value) -> {
            System.out.println("Key: " + key);
            value.forEach(System.out::println);
        });

        // 若您需要将结果转换回List<List<String>>形式
        List<List<String>> sortedList = new ArrayList<>(groupedAndSorted.values())
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // 打印转换后的结果
        System.out.println("Sorted List:");
        sortedList.forEach(System.out::println);
    }


}
