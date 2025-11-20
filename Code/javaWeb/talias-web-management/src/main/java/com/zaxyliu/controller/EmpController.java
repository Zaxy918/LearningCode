package com.zaxyliu.controller;

import com.zaxyliu.pojo.Emp;
import com.zaxyliu.pojo.EmpQueryParam;
import com.zaxyliu.pojo.Result;
import com.zaxyliu.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("Query {}", empQueryParam);
        return Result.success(empService.page(empQueryParam));
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("Save {}", emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("Delete emps {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("Query info of emp {}", id);
        return Result.success(empService.getInfo(id));
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("Alter emp {}", emp);
        empService.update(emp);
        return Result.success();
    }

}
