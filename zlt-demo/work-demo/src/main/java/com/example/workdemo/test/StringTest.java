package com.example.workdemo.test;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zdy
 * @ClassName StringTest
 * @description: TODO
 * @date 2024年06月05日
 * @version: 1.0
 */
public class StringTest {
    public static void main(String[] args) {
//        String fieldStr = "2287,";
//        String[] split1 = fieldStr.split(",");
//        System.out.println(split1.length);
//        System.out.println("".equals(null));

//        String streetAddress = "1234 Elm Street";
//        String maskedAddress = maskLastEightChars(streetAddress);
//        System.out.println(maskedAddress); // 输出：1234 Elm Stree****
//
//        String shortAddress = "Short";
//        String maskedShortAddress = maskLastEightChars(shortAddress);
//        System.out.println(maskedShortAddress); // 输出：Short，因为长度不足8
//
//
//        String originalString = "1234567890abcdef";
//        String maskedString = maskLastFourBeforeFour(originalString);
//        System.out.println(maskedString); // 输出示例（取决于字符串长度）：1234****7890abcdef 或 对于较短的字符串则保持原样或尽可能隐藏
//
//
        String originalString2 = "hello";
        String maskedString2 = maskExceptFirstChar(originalString2);
        System.out.println(maskedString2); // 输出：h****
        String originalString3 = "hel";
        String maskedString3 = maskExceptFirstChar(originalString3);
        System.out.println(maskedString3); // 输出：h****

    }
    public static String maskExceptFirstChar(String str) {
        if (StringUtils.isBlank(str)) {
            // 如果字符串为空或只有一个字符，直接返回原字符串
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (str.length() <= 3){
            // 添加第一个字符
            sb.append(str.charAt(0));
            // 从第二个字符开始，全部替换为'*'
            for (int i = 1; i < str.length(); i++) {
                sb.append('*');
            }
            return sb.toString();
        }
        // 添加前三个字符
        sb.append(str, 0, 3); // 添加前缀
        // 从第二个字符开始，全部替换为'*'
        for (int i = 3; i < str.length(); i++) {
            sb.append('*');
        }
        // 将StringBuilder转换回String
        return sb.toString();
    }

    public static String maskLastEightChars(String address) {
        if (address == null || address.length() < 8) {
            // 如果字符串为空或长度小于8，直接返回原字符串
            return address;
        }

        // 使用StringBuilder来构建结果字符串
        StringBuilder sb = new StringBuilder(address);

        // 从后向前替换最后8个字符为*
        for (int i = address.length() - 1; i >= address.length() - 8 && i >= 0; i--) {
            sb.setCharAt(i, '*');
        }

        // 将StringBuilder转换回String
        return sb.toString();
    }

    public static String maskLastFourBeforeFour(String str) {
        int length = str.length();

        // 如果字符串长度小于8，则无法隐藏后四位之前的四个字符，直接返回原字符串
        if (length < 8) {
            return str;
        }

        // 计算需要隐藏字符的起始位置
        // 如果字符串长度减去8小于4，则从字符串开头隐藏到可能的最大位置
        int start = Math.max(0, length - 8);

        // 使用StringBuilder来构建结果字符串
        StringBuilder sb = new StringBuilder();
        sb.append(str, 0, start); // 添加前缀
        if (length - 4 > start) { // 如果还有空间可以隐藏字符
            for (int i = 0; i < 4; i++) {
                sb.append('*'); // 添加四个*
            }
        }
        sb.append(str, length - 4, length); // 添加最后四位

        return sb.toString();
    }

}
