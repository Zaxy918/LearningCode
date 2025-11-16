package com.zaxyliu.controller;

import com.zaxyliu.pojo.Result;
import com.zaxyliu.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("Count emp job data");
        return Result.success(reportService.getEmpJobData());
    }

    @GetMapping("/empGenderData")
    public  Result getEmpGenderData() {
        log.info("Count emp gender");
        return Result.success(reportService.getEmpGenderData());
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        log.info("Get student degree data");
        return Result.success(reportService.getStudentDegreeData());
    }

    @GetMapping("studentCountData")
    public Result getStudentCountData() {
        log.info("Get student count data");
        return Result.success(reportService.getStudentCountData());
    }
}
