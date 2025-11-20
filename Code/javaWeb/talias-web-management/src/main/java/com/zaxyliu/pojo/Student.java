package com.zaxyliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String no;
    private Integer gender;
    private String phone;
    private String idCard;
    private Integer isCollege;
    private String address;
    private Integer degree;
    private Integer clazzId;
    private Integer violationCount;
    private Integer violationScore;
    private String clazzName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate graduationDate;
    private LocalDate createTime;
    private LocalDate updateTime;
}
