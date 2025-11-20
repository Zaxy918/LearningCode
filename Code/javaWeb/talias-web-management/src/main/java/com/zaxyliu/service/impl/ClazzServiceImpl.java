package com.zaxyliu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zaxyliu.mapper.ClazzMapper;
import com.zaxyliu.mapper.EmpMapper;
import com.zaxyliu.pojo.*;
import com.zaxyliu.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    ClazzMapper clazzMapper;
    EmpMapper empMapper;

    @Override
    public PageResult<Clazz> queryClazz(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        Page<Clazz> clazzPage = clazzMapper.queryClazz(clazzQueryParam);
        LocalDate now = LocalDate.now();
        Long total = clazzPage.getTotal();
        List<Clazz> result = clazzPage.getResult();
        if (!CollectionUtils.isEmpty(result)) {
            result.forEach(clazz -> {
                clazz.setStatus(clazz.getBeginDate().isBefore(now) && clazz.getEndDate().isAfter(now) ? "已开班" : clazz.getEndDate().isBefore(now) ? "已结课" : "未开班");
            });
        }
        return new PageResult<Clazz>(total, result);
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void add(Clazz clazz) {
        LocalDate now = LocalDate.now();
        clazz.setCreateTime(now);
        clazz.setUpdateTime(now);
        clazz.setStatus(clazz.getBeginDate().isBefore(now) && clazz.getEndDate().isAfter(now) ? "已开班" : clazz.getEndDate().isBefore(now) ? "已结课" : "未开班");
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz queryById(Integer id) {
        LocalDate now = LocalDate.now();
        Clazz clazz = clazzMapper.queryById(id);
        clazz.setStatus(clazz.getBeginDate().isBefore(now) && clazz.getEndDate().isAfter(now) ? "已开班" : clazz.getEndDate().isBefore(now) ? "已结课" : "未开班");
        return clazz;
    }

    @Override
    public void alter(Clazz clazz) {
        clazzMapper.queryById(clazz.getId());
        clazzMapper.alter(clazz);
    }

    @Override
    public List<Clazz> list() {
        List<Clazz> result = clazzMapper.list();
        LocalDate now = LocalDate.now();
        if (!CollectionUtils.isEmpty(result)) {
            result.forEach(clazz -> {
                clazz.setStatus(clazz.getBeginDate().isBefore(now) && clazz.getEndDate().isAfter(now) ? "已开班" : clazz.getEndDate().isBefore(now) ? "已结课" : "未开班");
            });
        }
        return result;
    }
}
