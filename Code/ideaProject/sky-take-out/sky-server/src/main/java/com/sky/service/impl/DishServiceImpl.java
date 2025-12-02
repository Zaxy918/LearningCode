package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishMapper;
import com.sky.mapper.FlavorMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private FlavorMapper flavorMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;
    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.insert(dish);
        Long dishId = dish.getId();
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && !flavors.isEmpty()) {
            flavors.forEach(flavor -> {
                flavor.setDishId(dishId);
            });
            flavorMapper.insertBach(flavors);
        }
    }

    @Override
    public PageResult query(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
        Page<DishVO> dishPage = dishMapper.query(dishPageQueryDTO);
        return new PageResult(dishPage.getTotal(), dishPage.getResult());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(List<Long> ids) {
        List<Long> dishIds = setmealDishMapper.querySetmealIdsByDishIds(ids);
        ids.forEach(dishId -> {
            //如果要删除的菜品id在套餐关联的菜品id列表中，抛出业务异常
            if (dishIds.contains(dishId)) {
                throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
                //如果菜品处于启售状态，抛出业务异常
            } else if (dishMapper.getById(dishId).getStatus().equals(StatusConstant.ENABLE)) {
                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
            }
        });
        dishMapper.deleteBatch(ids);
        flavorMapper.deleteBatchByDishIds(ids);
    }

    @Override
    public DishVO getById(Long id) {
        Dish dish = dishMapper.getById(id);
        List<DishFlavor> flavors = flavorMapper.queryByDishId(id);
        DishVO dishVO = new DishVO();
        BeanUtils.copyProperties(dish, dishVO);
        dishVO.setFlavors(flavors);
        return dishVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.update(dish);
        flavorMapper.deleteByDishId(dish.getId());
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && !flavors.isEmpty()) {
            flavors.forEach(flavor -> {
                flavor.setDishId(dish.getId());
            });
            flavorMapper.insertBach(flavors);
        }
    }

    /**
     * 条件查询菜品和口味
     *
     * @param dish
     * @return
     */
    public List<DishVO> listWithFlavor(Dish dish) {
        List<Dish> dishList = dishMapper.list(dish);


//        long start = System.currentTimeMillis();
        // 通过一次性查询以及map映射减少数据库访问次数
        List<Long> dishIds = dishList.stream().mapToLong(Dish::getId).boxed().collect(Collectors.toList());
        Map<Long, List<DishFlavor>> dishFlavors = flavorMapper.queryByDishIds(dishIds).stream().collect(Collectors.groupingBy(DishFlavor::getDishId));
        List<DishVO> dishVOList = new ArrayList<>();
        for (Dish d : dishList) {
            DishVO dishVO = new DishVO();
            BeanUtils.copyProperties(d, dishVO);
            dishVO.setFlavors(dishFlavors.get(d.getId()));
            dishVOList.add(dishVO);
        }
//        List<DishVO> dishVOList = new ArrayList<>();
//        for (Dish d : dishList) {
//            DishVO dishVO = new DishVO();
//            BeanUtils.copyProperties(d, dishVO);
//            List<DishFlavor> flavors = flavorMapper.queryByDishId(d.getId());
//            dishVO.setFlavors(flavors);
//            dishVOList.add(dishVO);
//        }
//        long end = System.currentTimeMillis();
//        log.info("listWithFlavor方法总耗时：{}毫秒", (end - start));
        return dishVOList;
    }

    @Override
    public List<Dish> listByCategoriId(Long categoryId) {
        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        dish.setStatus(StatusConstant.ENABLE);
        return dishMapper.list(dish);
    }

    @Override
    public void updateStatus(Integer status, Long id) {
        if (status.equals(StatusConstant.DISABLE)) {
            //停售菜品时，判断是否关联套餐
            List<Long> setmealIds = setmealDishMapper.querySetmealIdsByDishId(id);
            if (!setmealIds.isEmpty()) {
                setmealIds.forEach(setmealId -> {
                    setmealMapper.updateStatus(status, setmealId);
                });
            }
        }
        dishMapper.update(Dish.builder().id(id).status(status).build());
    }

}
