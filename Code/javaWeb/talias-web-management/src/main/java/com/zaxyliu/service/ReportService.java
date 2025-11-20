package com.zaxyliu.service;

import com.zaxyliu.pojo.ClazzOption;
import com.zaxyliu.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<Map<String, Object>> getStudentDegreeData();

    ClazzOption getStudentCountData();
}
