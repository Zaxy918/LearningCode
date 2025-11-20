package com.zaxyliu.service;

import com.github.pagehelper.Page;
import com.zaxyliu.pojo.PageResult;
import com.zaxyliu.pojo.Student;
import com.zaxyliu.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> queryStudents(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    void add(Student student);

    Student queryById(Integer id);

    void alter(Student student);

    void violationManage(Integer id, Integer score);
}
