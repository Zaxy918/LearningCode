package com;

public class DateUtil {
    public static boolean isLeapYear(int year) {
        if (year > 0 && year < 10000) {// Valid year range.
            return year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
        }
        return false;
    }
}
