package com.zaxyliu.controller;

import com.zaxyliu.pojo.Clazz;
import com.zaxyliu.pojo.ClazzQueryParam;
import com.zaxyliu.pojo.Result;
import com.zaxyliu.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    @GetMapping
    public Result queryClazz(ClazzQueryParam clazzQueryParam) {
        log.info("Query calzz {}", clazzQueryParam);
        return Result.success(clazzService.queryClazz(clazzQueryParam));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("Delete clazz {}", id);
        clazzService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("Add clazz");
        clazzService.add(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        log.info("Query clazz {}", id);
        return Result.success(clazzService.queryById(id));
    }

    @PutMapping
    public Result alter(@RequestBody Clazz clazz) {
        log.info("Alter clazz {}", clazz);
        clazzService.alter(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result queryAll() {
        log.info("Query all");
        return Result.success(clazzService.list());
    }
}
