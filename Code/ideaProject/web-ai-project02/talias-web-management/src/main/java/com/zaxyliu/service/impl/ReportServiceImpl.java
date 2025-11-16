package com.zaxyliu.service.impl;

import com.zaxyliu.mapper.EmpMapper;
import com.zaxyliu.mapper.StudentMapper;
import com.zaxyliu.pojo.ClazzOption;
import com.zaxyliu.pojo.JobOption;
import com.zaxyliu.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> empJobData = empMapper.countEmpJobData();
        return new JobOption(empJobData.stream().map(dataMap -> dataMap.get("pos")).toList(),
                empJobData.stream().map(dataMap -> dataMap.get("num")).toList());
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    @Override
    public ClazzOption getStudentCountData() {
        List<Map<String, Object>> studentCountData = studentMapper.countStudentClazz();
        return new ClazzOption(studentCountData.stream().map(clazzMap -> clazzMap.get("clazz")).toList(),
                studentCountData.stream().map(clazzMap -> clazzMap.get("num")).toList());
    }
}
