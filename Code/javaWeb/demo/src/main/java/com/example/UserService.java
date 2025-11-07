package com.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserService {
    public int getUserAgeFromId(String idCard) {
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("Invalid ID card number");
        }
        String birthDateStr = idCard.substring(6, 14);
        LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getGenderFromId(String idCard) {
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("Invalid ID card number");
        }
        char genderCode = idCard.charAt(16);
        return (genderCode % 2 == 0) ? "Female" : "Male";
    }
}
