package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admin/dish")
@Slf4j
public class DishController {

    private static final String DISH_KEY = "dish_";

    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("save dish: {}", dishDTO);
        dishService.save(dishDTO);
        clearCache(DISH_KEY + dishDTO.getCategoryId());
        return Result.success();
    }

    @GetMapping("/page")
    public Result<PageResult> query(DishPageQueryDTO dishPageQueryDTO) {
        log.info("query dish: {}", dishPageQueryDTO);
        PageResult pageResult = dishService.query(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    public Result deleteBatch(@RequestParam List<Long> ids) {
        log.info("delete dish: {}", ids);
        dishService.deleteBatch(ids);
        clearCache(DISH_KEY + "*");
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<DishVO> getById(@PathVariable Long id) {
        log.info("get dish by id: {}", id);
        DishVO dishVO = dishService.getById(id);
        return Result.success(dishVO);
    }

    @PostMapping("/status/{status}")
    public Result updateStatus(@PathVariable Integer status, @RequestParam Long id) {
        log.info("update dish status: {}, {}", status, id);
        dishService.updateStatus(status, id);
        clearCache(DISH_KEY + "*");
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody DishDTO dishDTO) {
        log.info("update dish: {}", dishDTO);
        dishService.update(dishDTO);
        clearCache(DISH_KEY + "*");
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Dish>> listByCategoryId(Long categoryId) {
        log.info("list by categoryId: {}", categoryId);
        List<Dish> list = dishService.listByCategoriId(categoryId);
        return Result.success(list);
    }

    private void clearCache(String pattern) {
        log.info("clear cache pattern: {}", pattern);
        Set<String> keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }
}
