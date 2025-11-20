package com.zaxyliu.controller;

import com.zaxyliu.pojo.Result;
import com.zaxyliu.pojo.Student;
import com.zaxyliu.pojo.StudentQueryParam;
import com.zaxyliu.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result queryStudents(StudentQueryParam studentQueryParam) {
        log.info("Query student {}", studentQueryParam);
        return Result.success(studentService.queryStudents(studentQueryParam));
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("Delete student {}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Student student) {
        log.info("Add student {}", student);
        studentService.add(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        log.info("Query student {}", id);
        return Result.success(studentService.queryById(id));
    }

    @PutMapping
    public Result alter(@RequestBody Student student) {
        log.info("Alter student {}", student);
        studentService.alter(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violationManage(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("Manage violation of student {} with {} score", id, score);
        studentService.violationManage(id, score);
        return Result.success();
    }
}
