package com.ui;

import java.util.Random;

public class CodeUtil {

    public static String getCode() {
        char[] charArr = new char[52];
        for (int i = 0; i < 26; i++) {
            charArr[i] = (char) ('a' + i);
            charArr[i + 26] = (char) ('A' + i);
        }
        Random r = new Random();
        StringBuilder code = new StringBuilder(Integer.toString(r.nextInt(10)));
        for (int i = 0; i < 4; i++) {
            code.append(charArr[r.nextInt(52)]);
        }
        int rInt = r.nextInt(5);
        char rChar = code.charAt(rInt);
        code.setCharAt(rInt, code.charAt(0));
        code.setCharAt(0, rChar);
        return code.toString();
    }
}
