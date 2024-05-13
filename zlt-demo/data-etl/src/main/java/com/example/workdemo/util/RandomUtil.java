package com.example.workdemo.util;

import java.security.SecureRandom;

/**
 * @author zdy
 * @ClassName RandomUtil
 * @description: TODO
 * @date 2024年02月22日
 * @version: 1.0
 */
public class RandomUtil {
    private static final String NUMBERS = "0123456789";
    private static final String CHARACTERS = NUMBERS + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int LENGTH = 16;

    public static void main(String[] args) {
        String randomString = generateRandomString();
        System.out.println(randomString);
    }

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            // 随机生成一个数字或字符
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            builder.append(randomChar);
        }

        return builder.toString();
    }
}
