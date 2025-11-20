package com.zaxyliu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zaxyliu.mapper.StudentMapper;
import com.zaxyliu.pojo.PageResult;
import com.zaxyliu.pojo.Student;
import com.zaxyliu.pojo.StudentQueryParam;
import com.zaxyliu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> queryStudents(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        Page<Student> studentPage = studentMapper.queryStudent(studentQueryParam);
        Long total = studentPage.getTotal();
        List<Student> studentList = studentPage.getResult();
        return new PageResult<Student>(total, studentList);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDate.now());
        student.setUpdateTime(LocalDate.now());
        studentMapper.add(student);
    }

    @Override
    public Student queryById(Integer id) {
        return studentMapper.queryById(id);
    }

    @Override
    public void alter(Student student) {
        studentMapper.queryById(student.getId());
        studentMapper.alter(student);
    }

    @Override
    public void violationManage(Integer id, Integer score) {
        Student student = studentMapper.queryById(id);
        student.setViolationCount(student.getViolationCount() + 1);
        student.setViolationScore(student.getViolationScore() + score);
        studentMapper.alter(student);
    }
}
