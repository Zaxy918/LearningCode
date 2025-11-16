package com.zaxyliu.service;

import com.zaxyliu.pojo.*;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> queryClazz(ClazzQueryParam clazzQueryParam);

    void delete(Integer id);

    void add(Clazz clazz);

    Clazz queryById(Integer id);

    void alter(Clazz clazz);

    List<Clazz> list();
}
