package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("save dish: {}", dishDTO);
        dishService.save(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    public Result<PageResult> query( DishPageQueryDTO dishPageQueryDTO) {
        log.info("query dish: {}", dishPageQueryDTO);
        PageResult pageResult = dishService.query(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    public Result deleteBatch(@RequestParam List<Long> ids) {
        log.info("delete dish: {}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<DishVO> getById(@PathVariable Long id) {
        log.info("get dish by id: {}", id);
        DishVO dishVO = dishService.getById(id);
        return Result.success(dishVO);
    }

    @PutMapping
    public Result update(@RequestBody DishDTO dishDTO) {
        log.info("update dish: {}", dishDTO);
        dishService.update(dishDTO);
        return Result.success();
    }
}
