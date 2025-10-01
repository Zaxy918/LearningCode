package com.XII;
public class Solution {
    public static final char[] ROME_NUMBER_BIT = { 'I', 'X', 'C', 'M' };
    public static final char[] ROME_NUMBER_FIVE = { 'V', 'L', 'D' };

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String strNum = Integer.toString(num);
        int len = strNum.length();
        for (char ch : strNum.toCharArray()){
            if (ch != '9' && ch != '4') {
                if (ch >= '5') {
                    sb.append(ROME_NUMBER_FIVE[len - 1]);
                    ch -= 5;
                }
                for (int i = 0; i < ch - '0'; i++) {
                    sb.append(ROME_NUMBER_BIT[len - 1]);
                }
            } else if (ch == '9') {
                sb.append(ROME_NUMBER_BIT[len - 1]);
                sb.append(ROME_NUMBER_BIT[len]);
            } else {
                sb.append(ROME_NUMBER_BIT[len - 1]);
                sb.append(ROME_NUMBER_FIVE[len - 1]);
            }
            len--;
        }
        return sb.toString();
    }
    public static final int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] ROME_NUMBER = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= val[i]){
                sb.append(ROME_NUMBER[i]);
                num -= val[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}